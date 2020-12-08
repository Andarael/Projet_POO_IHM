package entity.item;

import utils.Col;

import static utils.Col.RESET;
import static utils.Col.colorize;

/**
 * Key is a special kind of Item that can open a locked exit
 * Keys are defined by theirs colors
 * <p>
 * Two key are equal if their color are the same, their names and shortname could be different
 * Keys are displayed in their respective color in the terminal
 */
public class Key extends Item {

    private final Col color;

    public Key(String name, String description, Col color) {
        super(name, description, 0, 0);

        if (color == null)
            color = RESET;

        this.color = color;

        PREFIX = "KEY  : ";
    }

    @Override
    public String getSimpleDisplay() {
        return colorize(super.getSimpleDisplay(), color);
    }

    @Override
    public String getDisplay() {
        return colorize(super.getDisplay(), color);
    }

    /**
     * The only way two key are equal is if they share the same color
     *
     * @param o the object to comare to.
     * @return true if o is a key of the same color as the current object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Key key = (Key) o;

        return color == key.color;
    }

    public Col getColor() {
        return color;
    }

}
