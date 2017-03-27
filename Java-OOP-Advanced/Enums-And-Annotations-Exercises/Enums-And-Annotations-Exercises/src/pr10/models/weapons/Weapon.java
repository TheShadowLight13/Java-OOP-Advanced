package pr10.models.weapons;

import pr10.annotations.CustomAnnotation;
import pr10.enums.Gems;

@CustomAnnotation(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public abstract class Weapon implements Comparable<Weapon>{

    private String name;
    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;
    private int strength;
    private int agility;
    private int vitality;
    private Gems[] gems;

    protected Weapon(String name, int minDamage, int maxDamage, int numberOfSockets) {
        this.setName(name);
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
        this.setNumberOfSockets(numberOfSockets);
        this.setStrength(0);
        this.setAgility(0);
        this.setVitality(0);
        this.gems = new Gems[this.getNumberOfSockets()];
    }

    public String getName() {
        return this.name;
    }

    private void setName(final String name) {
        this.name = name;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    private void setMinDamage(final int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    private void setMaxDamage(final int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }

    private void setNumberOfSockets(final int numberOfSockets) {
        this.numberOfSockets = numberOfSockets;
    }

    public int getStrength() {
        return this.strength;
    }

    private void setStrength(final int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return this.agility;
    }

    private void setAgility(final int agility) {
        this.agility = agility;
    }

    public int getVitality() {
        return this.vitality;
    }

    private void setVitality(final int vitality) {
        this.vitality = vitality;
    }

    private Gems[] getGems() {
        return this.gems;
    }

    public void addGem(Gems gemToAdd, int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.getNumberOfSockets()) {
            this.removeGem(socketIndex);
            this.getGems()[socketIndex] = gemToAdd;
            addPointsToWeapon(gemToAdd);
        }
    }

    public void removeGem(int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.getNumberOfSockets()) {
            if (this.getGems()[socketIndex] != null) {
                Gems gemToRemove = this.gems[socketIndex];
                removePointsFromWeapon(gemToRemove);
                this.getGems()[socketIndex] = null;
            }
        }
    }

    private void removePointsFromWeapon(Gems gemToRemove) {
        int strengthPointsToRemove = gemToRemove.getStrength();
        int agilityPointsToRemove = gemToRemove.getAgility();
        int vitalityPointsToRemove = gemToRemove.getVitality();
        int minDamagePointsToRemove = (strengthPointsToRemove * 2) + (agilityPointsToRemove);
        int maxDamagePointsToRemove = (strengthPointsToRemove * 3) + (agilityPointsToRemove * 4);

        this.strength -= strengthPointsToRemove;
        this.agility -= agilityPointsToRemove;
        this.vitality -= vitalityPointsToRemove;
        this.minDamage -= minDamagePointsToRemove;
        this.maxDamage -= maxDamagePointsToRemove;
    }

    private void addPointsToWeapon(Gems gemToAdd) {
        int strengthPointsToAdd = gemToAdd.getStrength();
        int agilityPointsToAdd = gemToAdd.getAgility();
        int vitalityPointsToAdd = gemToAdd.getVitality();
        int minDamagePointsToAdd = (strengthPointsToAdd * 2) + (agilityPointsToAdd);
        int maxDamagePointsToAdd = (strengthPointsToAdd * 3) + (agilityPointsToAdd * 4);

        this.strength += strengthPointsToAdd;
        this.agility += agilityPointsToAdd;
        this.vitality += vitalityPointsToAdd;
        this.minDamage += minDamagePointsToAdd;
        this.maxDamage += maxDamagePointsToAdd;
    }

    public double getItemLevel() {
        return this.calculateItemLevel();
    }

    private double calculateItemLevel() {
        double itemLevel = 0;

        double averageDamage = (this.getMinDamage() + this.getMaxDamage()) / 2.0;
        itemLevel = averageDamage + this.getStrength() + this.getAgility() + this.getVitality();
        return itemLevel;
    }

    @Override
    public int compareTo(Weapon other) {
        if (this.getItemLevel() >= other.getItemLevel()) {
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(),
                this.getMinDamage(),
                this.getMaxDamage(),
                this.getStrength(),
                this.getAgility(),
                this.getVitality());
    }
}
