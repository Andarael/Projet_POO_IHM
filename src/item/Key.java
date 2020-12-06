package item;

import utils.Col;
import static utils.Col.*;

public class Key extends Item {

    private final Col color;

    public Key(String name, String description, Col color) {
        super(name, description);

        if (color == null)
            color = RESET;

        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        return color == key.color;
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
    public int hashCode() {
        return color.hashCode();
    }
}
