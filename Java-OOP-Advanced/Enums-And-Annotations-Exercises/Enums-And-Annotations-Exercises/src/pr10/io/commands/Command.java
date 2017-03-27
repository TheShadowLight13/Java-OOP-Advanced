package pr10.io.commands;

import pr10.interfaces.Executable;
import pr10.interfaces.repository.Repository;
import sun.plugin.dom.exception.InvalidStateException;

public abstract class Command implements Executable{

    private String input;
    private String[] data;
    private Repository weaponRepository;

    protected Command(
            String input,
            String[] data,
            Repository weaponRepository) {

        this.setInput(input);
        this.setData(data);
        this.setWeaponRepository(weaponRepository);
    }

    public String getInput() {
        return this.input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidStateException("Invalid input");
        }

        this.input = input;
    }

    public String[] getData() {
        return this.data;
    }

    private void setData(String[] data) {
        if (data == null || data.length == 0) {
            throw new InvalidStateException("Invalid input");
        }

        this.data = data;
    }

    public Repository getWeaponRepository() {
        return this.weaponRepository;
    }

    private void setWeaponRepository(Repository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public abstract void execute() throws Exception;
}
