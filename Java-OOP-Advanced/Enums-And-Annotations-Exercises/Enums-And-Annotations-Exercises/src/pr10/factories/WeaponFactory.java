package pr10.factories;

import pr10.models.weapons.Axe;
import pr10.models.weapons.Knife;
import pr10.models.weapons.Sword;
import pr10.models.weapons.Weapon;

public class WeaponFactory {

    public static Weapon createWeapon(String weaponType, String weaponName) {
        if (weaponType.equals("AXE")) {
           return new Axe(weaponName);
        }else if (weaponType.equals("KNIFE")) {
            return new Knife(weaponName);
        }else {
           return new Sword(weaponName);
        }
    }
}
