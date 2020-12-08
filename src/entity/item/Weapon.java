package entity.item;

import interfaces.Equipable;

/**
 * A weapon is an item that can be equipped
 * It have a damage value that is 1 at least
 */
public class Weapon extends Item implements Equipable {

    private static final int DEFAULT_DAMAGE = 1;
    private final int damage;

    public Weapon(String name, String description, double weight, int value, int damage) {
        super(name, description, weight, value);
        if (damage < 1)
            damage = DEFAULT_DAMAGE;
        this.damage = damage;

        PREFIX = "WEAP  : ";
    }

    public Weapon(String name, String description, int damage) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE, damage);
    }

    @Override
    public String getDisplay() {
        return super.getDisplay() + ", damage : " + damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int getPower() {
        return getDamage();
    }

    // faire le use(UsableOnAnotherItem) ici
}
