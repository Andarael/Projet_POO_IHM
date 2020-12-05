package inventory;

import item.Item;

public class LimitedInventory extends Inventory {

    private static final float DEFAULT_CAPACITY = 15.0f;
    private final float capacity;

    public LimitedInventory() {
        this(DEFAULT_CAPACITY);
    }

    public LimitedInventory(float capacity) {
        super();
        this.capacity = capacity;
    }

    public LimitedInventory(double capacity) {
        this((float) capacity);
    }

    public float getCapacity() {
        return capacity;
    }

    @Override
    public boolean addItem(Item item) {
        if (canAddItem(item)) {
            return super.addItem(item);
        }
        return false;
    }

    public boolean canAddItem(Item item) {
        double d = item.getWeight();
        return capacity > (d + getUsedCapacity());
    }

    public double getUsedCapacity() {
        return itemList.stream()
                       .mapToDouble(Item::getWeight)
                       .sum();
    }

    @Override
    public String getDisplay() {
        return "capacity=" + capacity + "\n" + super.getDisplay();
    }

    @Override
    public String toString() {
        return "LimitedInventory{ \n" +
               getDisplay() +
               "} \n";
    }
}
