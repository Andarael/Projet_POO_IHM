package entity.item;

import interfaces.Usable;
import utils.Col;
import entity.place.Exit;
import entity.place.LockedExit;

import static utils.Col.RESET;
import static utils.Col.colorize;

/**
 * Key is a special kind of Item that can open a locked exit
 * Keys are defined by theirs colors
 * <p>
 * Keys are displayed in their respective color in the terminal
 */
public class Key extends Item  implements Usable {

    private static final String USAGE = "try 'USE [Key] [Exit]'";
    private final Col color;

    protected static final String PREFIX = "KEY  : ";

    public Key(String name, String description, Col color) {
        super(name, description, 0, 0);

        if (color == null)
            color = RESET;

        this.color = color;

    }

    public Key(Col color) {
        this(color.getColorName()+"Key", null, color);
        setShortName("Key" + color.getColorName().charAt(0));
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

    public Col getColor() {
        return color;
    }

    public boolean isSameColor(Key k) {
        if (k == null)
            return false;
        return color == k.getColor();
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

    @Override
    public String use() {
        return "Invalid use of Key, " + getUsage();
    }

    public String use(Exit exit) {
        if (exit == null)
            return "This Exit does not exist, " + getUsage();

        if ( !(exit instanceof LockedExit))
            return "This Exit is not Locked, " + getUsage() + "on a Locked Exit";

        LockedExit lockedExit = (LockedExit) exit;
        if (!lockedExit.isLocked())
            return "This Exit is not Locked";

        lockedExit.unLock(this);

        if (lockedExit.isLocked())
            return "You can't unlock " + exit + "with " + this;

        return "You unlocked " + exit + "with " + this;
    }
}
