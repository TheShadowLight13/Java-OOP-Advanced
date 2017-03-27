package pr10.models.weapons;

public class Sword extends Weapon{

    private static final int MIN_DAMAGE = 4;
    private static final int MAX_DAMAGE = 6;
    private static final int SOCKETS_COUNT = 3;

    public Sword(String name, int minDamage, int maxDamage, int numberOfSockets) {
        super(name, minDamage, maxDamage, numberOfSockets);
    }

    public Sword(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKETS_COUNT);
    }
}
