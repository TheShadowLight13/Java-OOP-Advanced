package pr10.enums;

public enum Gems{
    AMETHYST(2, 8, 4), EMERALD(1, 4, 9), RUBY(7, 2, 5);

    private int strength;
    private int agility;
    private int vitality;

    Gems(int strength, int agility, int vitality) {
        this.setStrength(strength);
        this.setAgility(agility);
        this.setVitality(vitality);
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
}
