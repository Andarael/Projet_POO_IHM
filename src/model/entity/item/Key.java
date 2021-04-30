// Fichier par Josué Raad

package model.entity.item;

import javafx.util.Pair;
import model.entity.Entity;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.interfaces.Usable;
import model.utils.Col;
import model.utils.Printer;

import static model.utils.Col.*;

/**
 * Key is a special kind of Item that can open a locked exit
 * Keys are defined by theirs colors
 * <p>
 * Keys are displayed in their respective color in the terminal
 */
public class Key extends Item implements Usable {

    private static final String USAGE = "try 'USE [Key] [Place]'";
    private final Col color;

    private Key(String name, String shortName, String description, Col color) {
        super(name, shortName, description, 0, 0);

        if (color == null || color == BLACK || color == RESET)
            color = WHITE;

        this.color = color;
    }

    public Key(Col color, String description) {
        this("Key" + color.getColorName(),
             "Key" + color.getColorName().charAt(0),
             description,
             color);
    }

    public Key(Col color) {
        this(color, null);
    }

    public static String generateKeyName(Col color) {
        return new Key(color).getName();
    }

    /**
     * @return the color of the Key
     */
    public Col getColor() {
        return color;
    }

    /**
     * Checks whether two keys are the same color
     *
     * @param k the key to check color with
     * @return true if the two keys are the same color
     */
    public boolean isSameColor(Key k) {
        if (k == null)
            return false;
        return color == k.getColor();
    }

    @Override
    public String getPrefix() {
        return "KEY  : ";
    }

    @Override
    public String getSimpleDisplay() {
        return colorize(super.getSimpleDisplay(), color);
    }

    @Override
    public String getDisplay() {
        return colorize(super.getDisplay(), color);
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    /**
     * Invalid use of a Key, it needs an Exit
     * Displays its own messages
     *
     * @return false, invalid use of Key
     */
    @Override
    public Pair<Boolean, String> use() {
        String message = "Keys must be used on a locked Door";
        Printer.printErr(message + ", " + getUsage());
        return new Pair<>(false, message);
    }

    /**
     * Use a Key on another entity (only valid on an Exit)
     * Displays its own messages
     *
     * @param entity the entity the key should be used on (Exit)
     * @return true if the Entity accepted the Key and unlocked
     */
    @Override
    public Pair<Boolean, String> use(Entity entity) {
        if (entity instanceof Exit) {
            return use((Exit) entity);
        }
        String message = "This is not an exit";
        Printer.printErr(message);
        return new Pair<>(false, message);
    }

    /**
     * Use a Key on an Exit
     * Displays its own messages
     *
     * @param exit the Exit the key should be used on
     * @return true if the Exit accepted the Key and unlocked
     */
    public Pair<Boolean, String> use(Exit exit) {
        String message;
        if (exit == null) {
            message = "This Exit does not exist";
            Printer.printErr(message + ", " + getUsage());
            return new Pair<>(false, message);
        }

        if (!(exit instanceof LockedExit)) {
            message = "Keys must be used on a locked Door";
            Printer.printErr(message + ", " + getUsage() + "on a Locked Exit");
            return new Pair<>(false, message);
        }

        LockedExit lockedExit = (LockedExit) exit;
        if (!lockedExit.isLocked()) {
            message = "This Exit is not Locked";
            Printer.printErr(message);
            return new Pair<>(false, message);
        }

        lockedExit.unLock(this);

        if (lockedExit.isLocked()) {
            message = "You can't unlock " + exit + " with " + this.getName();
            Printer.printErr(message);
            return new Pair<>(false, message);
        }

        message = "You unlocked " + exit + " with " + this.getName();
        Printer.printMsg(message);
        return new Pair<>(true, message);
    }
}
