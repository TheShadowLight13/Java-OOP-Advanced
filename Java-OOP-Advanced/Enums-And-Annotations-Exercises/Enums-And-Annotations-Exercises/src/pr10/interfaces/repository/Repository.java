package pr10.interfaces.repository;

import pr10.models.weapons.Weapon;

import java.util.List;

public interface Repository {
    void addWeapon(Weapon weapon);
    List<Weapon> getWeapons();
    Weapon getGreaterWeapon(Weapon weapon1, Weapon weapon2);
    Weapon getWeaponByName(String name);
}
