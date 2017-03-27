package pr10.io.commands;

import pr10.factories.WeaponFactory;
import pr10.interfaces.repository.Repository;
import pr10.models.weapons.Weapon;

public class CreateWeaponCommand extends Command{

    public CreateWeaponCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        String weaponType = this.getData()[1].toUpperCase();
        String weaponName = this.getData()[2];
        Weapon weapon = WeaponFactory.createWeapon(weaponType, weaponName);
        this.getWeaponRepository().addWeapon(weapon);
    }
}
