// Fichier par Josué Raad

package model.entity;

import model.interfaces.Fightable;

/**
 * A being is a living container.
 * All beings have health value and a level and a power
 * Begins are comparable by their levels.
 * Beings are equals by their name (or shortName), level and health
 * Being can level up, it does heal them, and give them a higher maximum health and level
 */
public class Being extends Container implements Fightable, Comparable<Being> {

    public static final int DEFAULT_HEALTH = 20;
    private final int BASE_HEALTH;
    private final int power;
    private int maxHp;
    private int hp;
    private int level;

    public Being(String name, String shortName, String description, int hp, int power) {
        super(name, shortName, description);

        if (hp < 0)
            hp = DEFAULT_HEALTH;

        if (power < 1)
            power = 1;

        this.level = 1;
        this.maxHp = hp;
        this.hp = hp;
        this.power = power;
        this.BASE_HEALTH = hp;
    }

    public Being(String name, int hp) {
        this(name, name, null, hp, 1);
    }

    public Being(String name) {
        this(name, DEFAULT_HEALTH);
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        if (hp < 0)
            this.hp = 0;

        else if (hp > getMaxHp())
            this.hp = getMaxHp();

        else
            this.hp = hp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getPower() {
        return power;
    }

    public int getLevel() {
        return level;
    }

    /**
     * Compute new max Health from base Health an current level
     */
    private void updateMAX_HP() {
        // HP levelUP formula
        this.maxHp = BASE_HEALTH + (BASE_HEALTH * level / 2);
    }

    /**
     * Levels up : increase level, increase max health and heals
     */
    public void levelUP() {
        level++;
        updateMAX_HP();
        healMax();
    }

    /**
     * @param levels numbers of levels to levelUP
     */
    public void levelUP(int levels) {
        level += levels;
        updateMAX_HP();
        healMax();
    }

    @Override
    public String getSimpleDisplay() {
        return super.getSimpleDisplay() +
               ", lvl : " + level +
               ", hp : " + hp + "/" + maxHp +
               ", pow : " + getPower();
    }

    @Override
    public int compareTo(Being being) {
        return this.level - being.level;
    }

}
