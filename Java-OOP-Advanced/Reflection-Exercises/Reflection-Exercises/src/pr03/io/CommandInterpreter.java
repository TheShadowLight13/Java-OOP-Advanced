package pr03.io;

import pr03.annotations.Alias;
import pr03.annotations.Inject;
import pr03.contracts.*;
import pr03.core.commands.DisplayInvalidMessageCommand;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PACKAGE =
            "pr03.core.commands.";
    private static final String COMMANDS_LOCATION =
            "src/pr03/core/commands";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.setRepository(repository);
        this.setUnitFactory(unitFactory);
    }

    public Repository getRepository() {
        return this.repository;
    }

    private void setRepository(Repository repository) {
        this.repository = repository;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    private void setUnitFactory(UnitFactory unitFactory) {
        this.unitFactory = unitFactory;
    }

    @SuppressWarnings("unchecked")
    public Executable parseCommand(String[] data, String commandName) {
        File commandsFile = new File(COMMANDS_LOCATION);
        Executable executable = null;
        boolean isCommandExist = false;

        for (File commandFile: commandsFile.listFiles()) {
            if (!commandFile.isFile() || !commandFile.getName().endsWith(".java")) {
                continue;
            }

            String className = commandFile.getName()
                    .substring(0, commandFile.getName().lastIndexOf("."));
            try {
                Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);

                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!commandName.equalsIgnoreCase(value)) {
                    continue;
                }

                isCommandExist = true;

                Constructor exeCtor = exeClass.getConstructor(String[].class, String.class);
                executable = (Executable) exeCtor.newInstance(data, commandName);
                this.injectDependencies(executable, exeClass);

            } catch (ClassNotFoundException |
                    NoSuchMethodException |
                    InstantiationException |
                    IllegalAccessException |
                    InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (!isCommandExist) {
            executable = new DisplayInvalidMessageCommand(data, commandName);
        }

        return executable;
    }

    private void injectDependencies(Executable executable, Class<Executable> exeClass) {
        Field[] exeFields = exeClass.getDeclaredFields();

        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)) {
                continue;
            }

            fieldToSet.setAccessible(true);
            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();

            for (Field theseField : theseFields) {
                if (!theseField.getType().equals(fieldToSet.getType())) {
                    continue;
                }

                theseField.setAccessible(true);
                try {
                    fieldToSet.set(executable, theseField.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String commandName = data[0];

        Executable exeCommand = this.parseCommand(data, commandName);
        String result = exeCommand.execute();
        return result;
    }
}
