package item;

import java.util.List;

public class Inventory implements InventoryManagement {

    private static final double DEFAULT_CAPACITY = 10.0;

    private int nbItems;
    private final double capacity;
    private final List<Item> itemList;

    public Inventory(double capacity) {
        this.capacity = 0;
        itemList = null;
    }

    public Inventory() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public double getUsedCapacity() {
        return 0.0;
    }

    @Override
    public double getCapacity() {
        return 0;
    }

    @Override
    public int getNbItems() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Item getRandomItem() {
        return null;
    }

    @Override
    public void removeAllItems() {
    }

    @Override
    public boolean addItem(Item itm) {
        return false;
    }

    @Override
    public boolean addItem(String string) {
        return false;
    }

    @Override
    public boolean removeItem(Item item) {
        return false;
    }

    @Override
    public boolean removeItem(String item) {
        return false;
    }

    @Override
    public boolean contains(Item item) {
        return false;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int getQuantity(Item item) {
        return 0;
    }

    @Override
    public int getQuantity(String s) {
        return 0;
    }

    @Override
    public boolean canAddItem(Item itm, double usedCapacity) {
        return false;
    }

    @Override
    public boolean canAddItem(Item item) {
        return false;
    }

}
