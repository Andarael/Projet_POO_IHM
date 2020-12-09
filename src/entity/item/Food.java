package entity.item;

import entity.Being;
import entity.Player;
import interfaces.Usable;

/**
 * Food is a special item that have a restore value that can be negative (poisoned food)
 */
public class Food extends Item implements Usable {

    private static final String USAGE = "try 'USE [Food]";

    private final int restoreValue;

    public Food(String name, String description, double weight, int value, int restoreValue) {
        super(name, description, weight, value);

        this.restoreValue = restoreValue;
    }

    public Food(String name, String description, int restoreValue) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE, restoreValue);
    }

    @Override
    public String getPrefix() {
        return "FOOD : ";
    }

    /**
     * @return the restore value of the food.
     */
    public int getRestoreValue() {
        return restoreValue;
    }

    @Override
    public String getDisplay() {
        return super.getDisplay() + ", restoration : " + restoreValue;
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    @Override
    public String use() {
        return "Try using it on a Being";
    }

    public String use(Player player) {
        if (player == null)
            return "This Being does not exist" + getUsage();

        String output = restoreValue + "hp";
        if (restoreValue > 0) {
            player.heal(restoreValue);
            return "You healed " + output;
        } else {
            player.hurt(restoreValue);
            return "You got poisoned by " + output;
        }
    }

}
