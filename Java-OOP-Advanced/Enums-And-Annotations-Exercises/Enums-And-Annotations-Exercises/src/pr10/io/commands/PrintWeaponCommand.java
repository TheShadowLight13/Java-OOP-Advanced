package pr10.io.commands;

import pr10.interfaces.repository.Repository;
import pr10.io.OutputWriter;
import pr10.models.weapons.Weapon;

public class PrintWeaponCommand extends Command{

    public PrintWeaponCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        String weaponName = this.getData()[1];
        Weapon weapon = this.getWeaponRepository().getWeaponByName(weaponName);
        OutputWriter.printWeaponOnNewLine(weapon);
    }
}
