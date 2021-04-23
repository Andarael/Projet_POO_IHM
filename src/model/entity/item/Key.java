// Fichier par Josué Raad

package model.entity.item;

import model.entity.Entity;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.interfaces.Usable;
import model.utils.Col;

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
    public boolean use() {
        System.out.println("Invalid use of Key, " + getUsage());
        return false;
    }

    /**
     * Use a Key on another entity (only valid on an Exit)
     * Displays its own messages
     *
     * @param entity the entity the key should be used on (Exit)
     * @return true if the Entity accepted the Key and unlocked
     */
    @Override
    public boolean use(Entity entity) {
        if (entity instanceof Exit) {
            return use((Exit) entity);
        }
        System.out.println("This is not an exit");
        return false;
    }

    /**
     * Use a Key on an Exit
     * Displays its own messages
     *
     * @param exit the Exit the key should be used on
     * @return true if the Exit accepted the Key and unlocked
     */
    public boolean use(Exit exit) {
        if (exit == null) {
            System.out.println("This Exit does not exist, " + getUsage());
            return false;
        }

        if (!(exit instanceof LockedExit)) {
            System.out.println("This Exit is not Locked, " + getUsage() + "on a Locked Exit");
            return false;
        }

        LockedExit lockedExit = (LockedExit) exit;
        if (!lockedExit.isLocked()) {
            System.out.println("This Exit is not Locked");
            return false;
        }

        lockedExit.unLock(this);

        if (lockedExit.isLocked()) {
            System.out.println("You can't unlock " + exit + " with " + this.getName());
            return false;
        }

        System.out.println("You unlocked " + exit + " with " + this.getName());
        return true;
    }
}
