package pr03.core.commands;

public class DisplayInvalidMessageCommand extends Command{

    public DisplayInvalidMessageCommand(String[] data, String commandName) {
        super(data, commandName);
    }

    @Override
    public String execute() {
        String output = String.format("The command '%s' is invalid", this.getData()[0]);
        return output;
    }
}
