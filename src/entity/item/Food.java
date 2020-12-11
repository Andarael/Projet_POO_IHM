// Fichier par Josué Raad

package entity.item;

import entity.Entity;
import entity.Player;
import interfaces.Usable;

/**
 * Food is a special item that have a restore value that can be negative (poisoned food)
 */
public class Food extends Item implements Usable {

    private static final String USAGE = "try 'USE [Food]";

    private final int restoreValue;

    public Food(String name, String shortName, String description, double weight, int value, int restoreValue) {
        super(name, shortName, description, weight, value);

        this.restoreValue = restoreValue;
    }

    public Food(String name,String shortName, String description, int restoreValue) {
        this(name, shortName, description, DEFAULT_WEIGHT, DEFAULT_VALUE, restoreValue);
    }

    /**
     * @return the restore value of the food.
     */
    public int getRestoreValue() {
        return restoreValue;
    }

    @Override
    public String getPrefix() {
        return "FOOD : ";
    }

    @Override
    public String getDisplay() {
        return super.getDisplay() + ", restoration : " + restoreValue;
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    /**
     * Use the item to feed
     * Displays its own messages
     *
     * @return false, invalid use all the time
     */
    @Override
    public boolean use() {
        System.out.println("Try using it on a Being");
        return false;
    }

    /**
     * use the item to feed
     * Displays its own messages
     *
     * @param entity the entity to feed (player)
     * @return true if the entity was fed
     */
    @Override
    public boolean use(Entity entity) {
        if (entity == null) {
            System.out.println("This Being does not exist" + getUsage());
            return false;
        }

        if (entity instanceof Player) {
            return use((Player) entity);
        }
        System.out.println("This can only be used on the Player");
        return false;
    }

    /**
     * use the item to feed
     * Displays its own messages
     *
     * @param player the Player of the game
     * @return true if the player was fed
     */
    protected boolean use(Player player) {
        String message = restoreValue + " hp";
        if (restoreValue > 0) {
            player.heal(restoreValue);
            System.out.println("You healed " + message);
        } else {
            player.hurt(-restoreValue);
            System.out.println("You got poisoned by " + message);
        }
        return true;
    }

}
