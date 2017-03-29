package pr03.core.commands;

import pr03.contracts.Executable;

public abstract class Command implements Executable{

    private String commandName;
    private String[] data;

    protected Command(String[] data, String commandName) {
        this.setData(data);
        this.setCommandName(commandName);
    }

    public String[] getData() {
        return this.data;
    }

    private void setData(String[] data) {
        this.data = data;
    }

    public String getCommandName() {
        return this.commandName;
    }

    private void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public abstract String execute();
}
