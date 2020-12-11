// Fichier par Josué Raad

package entity.item;

import interfaces.Equipable;

/**
 * A weapon is an item that can be equipped
 * It have a damage value that is 1 at least
 */
public class Weapon extends Item implements Equipable {

    private static final int DEFAULT_DAMAGE = 1;
    private final int damage;

    public Weapon(String name,
                  String shortName,
                  String description,
                  double weight,
                  int value,
                  int damage) {
        super(name, shortName, description, weight, value);
        if (damage < 1)
            damage = DEFAULT_DAMAGE;
        this.damage = damage;
    }

    @Override
    public String getPrefix() {
        return "WEAP : ";
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

}
