package item;

public class Food extends Item {

    private static final int DEFAULT_RESTORE_VALUE = 1;
    private final int restoreValue;

    public Food(String name, String description, double weight, int value, int restoreValue) {
        super(name, description, weight, value);
        if (restoreValue < 1)
            restoreValue = DEFAULT_RESTORE_VALUE;
        this.restoreValue = restoreValue;
    }

    public Food(String name, String description, int restoreValue){
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE, restoreValue);
    }

    public int getRestoreValue() {
        return restoreValue;
    }

    @Override
    public String getDisplay() {
        return super.getDisplay() + ", restoration : " + restoreValue;
    }
}
