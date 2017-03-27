package pr10.io.commands;

import pr10.annotations.annotationsInfo.CustomAnnotationInfo;
import pr10.interfaces.repository.Repository;
import pr10.io.OutputWriter;

public class PrintDescriptionCommand extends Command{

    public PrintDescriptionCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        OutputWriter.printDescriptionOnNewLine(CustomAnnotationInfo.getDescription());
    }
}
