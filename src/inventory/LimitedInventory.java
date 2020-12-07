package inventory;

import entity.item.Item;

public class LimitedInventory extends Inventory {

    public static final double DEFAULT_CAPACITY = 15.0;
    private final double capacity;

    public LimitedInventory() {
        this(DEFAULT_CAPACITY);
    }

    public LimitedInventory(double capacity) {
        super();
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public boolean canAddItem(Item item) {
        if (item == null)
            return false;

        double d = item.getWeight();
        return capacity > (d + getUsedCapacity());
    }

    public double getUsedCapacity() {
        return itemList.stream()
                       .mapToDouble(Item::getWeight)
                       .sum();
    }

    @Override
    public boolean addItem(Item item) {
        if (canAddItem(item))
            return super.addItem(item);

        return false;
    }

    @Override
    public String getHeaderDisplay() {
        return "capacity : " + capacity + "\n" +
               "used capacity : " + getUsedCapacity() + "\n" +
               super.getHeaderDisplay();
    }

}
