package item;

import item.Item;

public class Key extends Item {

    private static final int DEFAULT_ID = 1;
    private final int id;

    public Key(String name, float weight, int value, int id) {
        super(name, 0, value);
        this.id = id;
    }

    public Key(String name, float weight, int value) {
        this(name, 0, value, DEFAULT_ID);
    }

    public Key(String name) {
        super(name);
        this.id = DEFAULT_ID;
    }

    public int getId() {
        return id;
    }
}
