package item;

public class Food extends Item {

    private static final int DEFAULT_RESTORE = 1;
    private final int restore;

    public Food(String name) {
        super(name);
        restore = DEFAULT_RESTORE;
    }


    public int getRestore() {
        return restore;
    }

    @Override
    public String toString() {
        return "Food{" +
               "'" + name + "'" +
               ", shortName='" + shortName + '\'' +
               ", weight=" + weight +
               ", value=" + value +
               ", restore=" + restore +
               '}';
    }
}
