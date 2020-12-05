package item;

public class Weapon extends Item {

    private static final int DEFAULT_DAMAGE = 1;
    private final int damage;

    public Weapon(String name, float weight, int value, int damage) {
        super(name, weight, value);
        this.damage = damage;
    }

    public Weapon(String name, float weight, int value) {
        this(name, weight, value, DEFAULT_DAMAGE);
    }

    public Weapon(String name) {
        super(name);
        this.damage = DEFAULT_DAMAGE;
    }

    public int getDamage() {
        return damage;
    }
}
