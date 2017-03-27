package pr10.io.commands;

import pr10.enums.Gems;
import pr10.interfaces.repository.Repository;
import pr10.models.weapons.Weapon;

public class AddWeaponCommand extends Command{

    public AddWeaponCommand(
            String input,
            String[] data,
            Repository weaponRepository) {

        super(input, data, weaponRepository);
    }

    @Override
    public void execute() throws Exception {
        String weaponName = this.getData()[1];
        Weapon weapon = this.getWeaponRepository().getWeaponByName(weaponName);
        String gemType = this.getData()[3].toUpperCase();
        Gems gem = Gems.valueOf(gemType);
        int socketIndex = Integer.valueOf(this.getData()[2]);
        weapon.addGem(gem, socketIndex);
    }
}
