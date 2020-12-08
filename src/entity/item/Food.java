package entity.item;

/**
 * Food is a special item that have a restore value that can be negative (poisoned food)
 */
public class Food extends Item {

    private final int restoreValue;

    public Food(String name, String description, double weight, int value, int restoreValue) {
        super(name, description, weight, value);

        this.restoreValue = restoreValue;
    }

    public Food(String name, String description, int restoreValue) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE, restoreValue);
    }

    @Override
    public String getPrefix() {
        return "FOOD : ";
    }

    /**
     * @return the restore value of the food.
     */
    public int getRestoreValue() {
        return restoreValue;
    }

    @Override
    public String getDisplay() {
        return super.getDisplay() + ", restoration : " + restoreValue;
    }
}
