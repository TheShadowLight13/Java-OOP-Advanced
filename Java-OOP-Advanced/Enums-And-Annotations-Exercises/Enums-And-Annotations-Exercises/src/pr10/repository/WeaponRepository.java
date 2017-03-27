package pr10.repository;

import pr10.interfaces.repository.Repository;
import pr10.models.weapons.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeaponRepository implements Repository{

    private List<Weapon> weapons;

    public WeaponRepository() {
        this.weapons = new ArrayList<>();
    }

    @Override
    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    @Override
    public List<Weapon> getWeapons() {
        return Collections.unmodifiableList(this.weapons);
    }

    @Override
    public Weapon getWeaponByName(String name) {
        return weapons.stream().filter(w -> w.getName().equals(name)).findFirst().get();
    }

    @Override
    public Weapon getGreaterWeapon(Weapon weapon1, Weapon weapon2) {
        if (weapon1.compareTo(weapon2) >= 1) {
            return weapon1;
        }else {
            return weapon2;
        }
    }
}
