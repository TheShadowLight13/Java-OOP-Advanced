package pr10.io.commands;

import pr10.interfaces.repository.Repository;
import pr10.io.OutputWriter;
import pr10.models.weapons.Weapon;

public class CompareTwoWeaponsCommand extends Command{

    public CompareTwoWeaponsCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        String weapon1Name = this.getData()[1];
        String weapon2Name = this.getData()[2];
        Weapon weapon1 = this.getWeaponRepository().getWeaponByName(weapon1Name);
        Weapon weapon2 = this.getWeaponRepository().getWeaponByName(weapon2Name);
        Weapon greaterWeapon = this.getWeaponRepository().getGreaterWeapon(weapon1, weapon2);
        OutputWriter.printWeaponWithItemLevelOnNewLine(greaterWeapon);
    }
}
