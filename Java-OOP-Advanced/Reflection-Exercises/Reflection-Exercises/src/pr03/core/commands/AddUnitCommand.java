package pr03.core.commands;

import pr03.annotations.Alias;
import pr03.annotations.Inject;
import pr03.contracts.Repository;
import pr03.contracts.Unit;
import pr03.contracts.UnitFactory;

@Alias(value = "add")
public class AddUnitCommand extends Command {

    @Inject
    private UnitFactory unitFactory;
    @Inject
    private Repository repository;

    public AddUnitCommand(String[] data, String commandName) {
        super(data, commandName);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
