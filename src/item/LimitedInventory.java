package item;

import java.util.List;

public class LimitedInventory extends Inventory {

    private static final double DEFAULT_CAPACITY = 15.0;
    private final double capacity;

    public LimitedInventory() {
        this(DEFAULT_CAPACITY);
    }

    public LimitedInventory(double capacity) {
        super();
        this.capacity = capacity;
    }

    public double getUsedCapacity() {
        return itemList.stream()
                       .mapToDouble(Item::getWeight)
                       .sum();
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean canAddItem(Item item) {
        double d = item.getWeight();
        return capacity > (d + getUsedCapacity());
    }

    @Override
    public boolean addItem(Item item) {
        if (canAddItem(item))
            return super.addItem(item);
        return false;
    }
}
