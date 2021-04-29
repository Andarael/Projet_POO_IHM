// fichier par Josué Raad

package model.entity.item;

import model.entity.Entity;
import model.interfaces.UsableOnItem;
import model.utils.Printer;

/**
 * An arrow is a weightLess Item
 * of value 3 and damage 3
 * It can be used on a Bow to charge it
 */
public class Arrow extends Weapon implements UsableOnItem {

    private static final String USAGE = "try 'USE [Arrow] [Bow]'";

    public Arrow() {
        super("Arrow", "arrow", "a slender arrow with an iron tip", 0.0, 3, 3);
    }

    @Override
    public String getPrefix() {
        return "ARROW: ";
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    /**
     * invalid use of the arrow, it needs a bow too
     * displays its own messages
     *
     * @return false, invalid use
     */
    @Override
    public String use() {
        String message = "Arrows can only be used on a Bow";
        Printer.printErr(message + ", " + getUsage());
        return message;
    }

    /**
     * Use an arrow on another entity (only valid on a Bow)
     * displays its own messages
     *
     * @param entity the entity to use the arrow on (bow)
     * @return true if the entity accepted the arrow
     */
    @Override
    public String use(Entity entity) {
        String message = "Arrows can only be used on a Bow";
        Printer.printErr(message + ", " + getUsage());
        return message;
    }

    /**
     * Use an arrow on another item (only valid on a Bow)
     * displays its own messages
     *
     * @param item the item to use the arrow on (bow)
     * @return true if the arrow was accepted by the item
     */
    @Override
    public boolean use(Item item) {
        if (item == null) {
            Printer.printErr("This item does not exist, " + getUsage());
            return false;
        }
        if (!(item instanceof Bow)) {
            Printer.printErr("This is not a Bow, " + getUsage());
            return false;
        }
        ((Bow) item).addArrow();
        Printer.printMsg("Added an Arrow to " + item.getName());
        return true;
    }

}
