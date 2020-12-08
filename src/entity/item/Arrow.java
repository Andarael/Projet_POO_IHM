package entity.item;

import interfaces.UsableOnItem;

/**
 * An arrow is a weightLess Item
 * of value and damage 3
 * It can be used on a Bow to charge it
 */
public class Arrow extends Weapon implements UsableOnItem {

    private static final String USAGE = "try 'USE [Arrow] [Bow]'";

    public Arrow() {
        super("Arrow", null,0.0, 3, 3);
    }

    @Override
    public String getPrefix() {
        return "ARROW: ";
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    @Override
    public String use() {
        return ("Invalid use of Arrow, " + getUsage());
    }

    @Override
    public String use(Item item) {
        if (item == null)
            return "This item does not exist, " + getUsage();

        if (!(item instanceof Bow))
            return "This is not a Bow, " + getUsage();

        ((Bow) item).addArrow();
        return ("Added an Arrow to " + item.getName());
    }
}
