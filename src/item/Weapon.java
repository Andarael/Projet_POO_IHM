package item;

public class Weapon extends Item {

    private static final int DEFAULT_DAMAGE = 1;
    private final int damage;

    public Weapon(String name, String description, double weight, int value, int damage) {
        super(name, description, weight, value);
        if (damage < 1)
            damage = DEFAULT_DAMAGE;
        this.damage = damage;
    }

    public Weapon(String name, String description, int damage) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE, damage);
    }


    public int getDamage() {
        return damage;
    }
}
