package interfaces;

/**
 * An interface to get objects fighting and access their health
 * A Fightable is dead when its health is at 0 or less
 * A Fightable cannot have a negative amount of health nor can it exceed its maximum Hp
 */
public interface Fightable {

    /**
     * @return the current health
     */
    int getHp();

    /**
     * Health can't be set to strictly negative numbers, if so it should be 0 instead
     * Nor can it be above maxHp, if so it is maxHp instead
     *
     * @param hp the health to set
     */
    void setHp(int hp);

    /**
     * @return the maximum health of a Fightable
     */
    int getMaxHp();

    /**
     * Heals by a given quantity
     * The heal amount can't be negative (use hurt methode)
     * The hp amount cannot exceed the maxHp amount
     *
     * @param amount the quantity of hp to heal
     */
    default void heal(int amount) {
        if (amount > 0)
            setHp(getHp() + amount);
    }

    /**
     * Heals to its maximum Health
     */
    default void healMax() {
        setHp(getMaxHp());
    }

    /**
     * Hurt a being with a given quantity of damage
     * The Being hp can not go under 0
     * The amount can not be negative
     *
     * @param amount the quantity of damages
     */
    default void hurt(int amount) {
        if (amount > 0)
        setHp(getHp() - amount);
    }

    /**
     * @return true if being have 0 or less
     */
    default boolean isDead() {
        return getHp() <= 0;
    }

    /**
     * The fighting power is used to know how much to hurt the opponent
     * It can't be negative or 0
     * @return the fighting power of the Fightable
     */
    int getPower();

    /**
     * Attacks an opponent's health
     *
     * @param opponent the opponent to attack
     */
    default void attack(Fightable opponent) {
        if (!isDead())
            opponent.hurt(getPower());
    }

    /**
     * Kills the Being
     */
    default void kill() {
        setHp(0);
    }
}
