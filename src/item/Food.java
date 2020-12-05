package item;

import item.Item;

public class Food extends Item {

    private static final int DEFAULT_RESTORE = 1;
    private final int restore;

    public Food(String name, float weight, int value, int restore) {
        super(name, weight, value);
        this.restore = restore;
    }

    public Food(String name, float weight, int value) {
        this(name, weight, value, DEFAULT_RESTORE);
    }

    public Food(String name) {
        super(name);
        this.restore = DEFAULT_RESTORE;
    }

    public int getRestore() {
        return restore;
    }
}
