package pr10.io.commands;

import pr10.annotations.annotationsInfo.CustomAnnotationInfo;
import pr10.interfaces.repository.Repository;
import pr10.io.OutputWriter;

public class PrintRevisionCommand extends Command{

    public PrintRevisionCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        OutputWriter.printRevisionOnNewLine(CustomAnnotationInfo.getRevision());
    }
}
