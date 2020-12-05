package item;

public class Key extends Item {

    private static final int DEFAULT_ID = 1;
    private final int id;

    public Key(String name, float weight, int value, int id) {
        super(name, 0, value);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
