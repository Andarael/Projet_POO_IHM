// fichier par Josué Raad

package shadowLair.model.entity.item;

import javafx.util.Pair;
import shadowLair.model.entity.Entity;
import shadowLair.model.interfaces.UsableOnItem;
import shadowLair.model.utils.Printer;

/**
 * An arrow is a weightLess Item
 * of value 3 and damage 3
 * It can be used on a Bow to charge it
 */
public class Arrow extends Weapon implements UsableOnItem {

    private static final String USAGE = "try 'USE [Arrow] [Bow]'";

    public Arrow() {
        super("Arrow", "arrow", "a slender arrow with an iron tip", 0.0, 1, 2);
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
    public Pair<Boolean, String> use() {
        String message = "Arrows can only be used on a Bow";
        Printer.printErr(message + ", " + getUsage());
        return new Pair<>(false, message);
    }

    /**
     * Use an arrow on another entity (only valid on a Bow)
     * displays its own messages
     *
     * @param entity the entity to use the arrow on (bow)
     * @return true if the entity accepted the arrow
     */
    @Override
    public Pair<Boolean, String> use(Entity entity) {
        String message = "Arrows can only be used on a Bow";
        Printer.printErr(message + ", " + getUsage());
        return new Pair<>(false, message);
    }

    /**
     * Use an arrow on another item (only valid on a Bow)
     * displays its own messages
     *
     * @param item the item to use the arrow on (bow)
     * @return true if the arrow was accepted by the item
     */
    @Override
    public Pair<Boolean, String> use(Item item) {
        String message;
        if (item == null) {
            message = "This item does not exist";
            Printer.printErr(message + ", " + getUsage());
            return new Pair<>(false,message);
        }
        if (!(item instanceof Bow)) {
            message = "This is not a Bow";
            Printer.printErr(message + ", " + getUsage());
            return new Pair<>(false, message);
        }
        ((Bow) item).addArrow();
        return new Pair<>(true,Printer.printMsg("Added an Arrow to " + item.getName()));
    }

}
