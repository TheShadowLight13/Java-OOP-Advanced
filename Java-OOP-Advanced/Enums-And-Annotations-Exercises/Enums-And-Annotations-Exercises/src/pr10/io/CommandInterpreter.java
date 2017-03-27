package pr10.io;

import pr10.interfaces.Executable;
import pr10.interfaces.io.Interpreter;
import pr10.interfaces.repository.Repository;
import pr10.io.commands.*;

import java.io.IOException;

public class CommandInterpreter implements Interpreter {

    private Repository weaponRepository;

    public CommandInterpreter(Repository weaponRepository) {
        this.setWeaponRepository(weaponRepository);
    }

    public Repository getWeaponRepository() {
        return this.weaponRepository;
    }

    private void setWeaponRepository(Repository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Executable parseCommand(String input, String[] data, String commandName) {
        switch (commandName) {
            case "create":
                return new CreateWeaponCommand(input, data, this.getWeaponRepository());

            case "add":
                return new AddWeaponCommand(input, data, this.getWeaponRepository());

            case "remove":
                return new RemoveWeaponCommand(input, data, this.getWeaponRepository());

            case "print":
                return new PrintWeaponCommand(input, data, this.getWeaponRepository());

            case "compare":
                return new CompareTwoWeaponsCommand(input, data, this.getWeaponRepository());

            case "author":
                return new PrintAuthorCommand(input, data, this.getWeaponRepository());

            case "revision":
                return new PrintRevisionCommand(input, data, this.getWeaponRepository());

            case "description":
                return new PrintDescriptionCommand(input, data, this.getWeaponRepository());

            case "reviewers":
                return new PrintReviewersCommand(input, data, this.getWeaponRepository());

            default:
                return new DisplayInvalidCommandMessage(input, data, this.getWeaponRepository());
        }
    }

    @Override
    public void interpretCommand(String input) throws IOException {
        String[] data = input.split(";");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Throwable t) {
           OutputWriter.printMessageOnNewLine(t.getMessage());
        }
    }
}
