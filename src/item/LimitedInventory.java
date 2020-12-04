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
        return 0.0;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean canAddItem(Item item) {
        return false;
    }

    public boolean canAddItem(Item itm, double usedCapacity) {
        return false;
    }

}
