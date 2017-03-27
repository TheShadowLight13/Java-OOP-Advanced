package pr10.models.weapons;

public class Axe extends Weapon{

    private static final int MIN_DAMAGE = 5;
    private static final int MAX_DAMAGE = 10;
    private static final int SOCKETS_COUNT = 4;

    public Axe(String name, int minDamage, int maxDamage, int numberOfSockets) {
        super(name, minDamage, maxDamage, numberOfSockets);
    }

    public Axe(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKETS_COUNT);
    }
}
