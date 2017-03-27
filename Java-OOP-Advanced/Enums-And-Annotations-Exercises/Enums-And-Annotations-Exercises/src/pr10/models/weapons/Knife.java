package pr10.models.weapons;

public class Knife extends Weapon{

    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DAMAGE = 4;
    private static final int SOCKETS_COUNT = 2;

    public Knife(String name, int minDamage, int maxDamage, int numberOfSockets) {
        super(name, minDamage, maxDamage, numberOfSockets);
    }

    public Knife(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKETS_COUNT);
    }
}
