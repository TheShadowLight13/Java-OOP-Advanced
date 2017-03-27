package pr10.io.commands;

import pr10.interfaces.repository.Repository;
import pr10.io.OutputWriter;

public class DisplayInvalidCommandMessage extends Command{

    public DisplayInvalidCommandMessage(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        String output = String.format("The command '%s' is invalid", this.getInput());
        OutputWriter.displayException(output);
    }
}
