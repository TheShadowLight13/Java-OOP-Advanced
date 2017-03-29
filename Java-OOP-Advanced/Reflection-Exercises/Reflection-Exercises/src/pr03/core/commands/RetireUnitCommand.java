package pr03.core.commands;

import pr03.annotations.Alias;
import pr03.annotations.Inject;
import pr03.contracts.Repository;

@Alias(value = "retire")
public class RetireUnitCommand extends Command {

    @Inject
    private Repository repository;

    public RetireUnitCommand(String[] data, String commandName) {
        super(data, commandName);
    }

    @Override
    public String execute() {
        try {
            String unitType = this.getData()[1];
            this.repository.removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException iae) {
            return iae.getMessage();
        }
    }
}
