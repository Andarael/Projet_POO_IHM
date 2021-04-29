// Fichier par Josué Raad

package model.entity.item;

import model.entity.Entity;
import model.entity.Player;
import model.interfaces.Usable;
import model.utils.Printer;

/**
 * Food is a special item that have a restore value that can be negative (poisoned food)
 */
public class Food extends Item implements Usable {

    private static final String USAGE = "try 'USE [Food]";

    private final int restoreValue;

    public Food(String name,
                String shortName,
                String description,
                double weight,
                int value,
                int restoreValue) {
        super(name, shortName, description, weight, value);

        this.restoreValue = restoreValue;
    }

    public Food(String name, String shortName, String description, int restoreValue) {
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
    public String use() {
        String message = "Try using it on a Being";
        Printer.printErr(message);
        return message;
    }

    /**
     * use the item to feed
     * Displays its own messages
     *
     * @param entity the entity to feed (player)
     */
    @Override
    public String use(Entity entity) {
        String message;
        if (entity == null) {
            message = "This Being does not exist";
            Printer.printErr(message + getUsage());
            return message;
        }

        if (entity instanceof Player) {
            return use((Player) entity);
        }


        message = "This can only be used on the Player";
        Printer.printErr(message);
        return message;
    }

    /**
     * use the item to feed
     * Displays its own messages
     *
     * @param player the Player of the game
     */
    protected String use(Player player) {
        String message = restoreValue + " hp";
        if (restoreValue > 0) {
            player.heal(restoreValue);
            message = "You healed " + message;
            Printer.printMsg(message);
        } else {
            player.hurt(-restoreValue);
            message = "You got poisoned by " + message;
            Printer.printMsg(message);
        }
        return message;
    }

}
