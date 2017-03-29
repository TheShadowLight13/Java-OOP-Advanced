package pr03.core.commands;

import pr03.annotations.Alias;
import pr03.annotations.Inject;
import pr03.contracts.Repository;

@Alias(value = "report")
public class ReportCommand extends Command{

    @Inject
    private Repository repository;

    public ReportCommand(String[] data, String commandName) {
        super(data, commandName);
    }

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
