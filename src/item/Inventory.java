package item;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements ItemManagement {

    private static final double DEFAULT_CAPACITY = 10.0;

    private int nbItems;
    private final double capacity;
    private final List<Item> itemList;

    public Inventory(double capacity) {
        this.nbItems = 0;
        this.capacity = capacity;
        this.itemList = new ArrayList<>();
    }

    public Inventory() {
        this(DEFAULT_CAPACITY);
    }

    public double getUsedCapacity() {

        // return this.itemList.stream().mapToDouble(item -> (item.getWeight() * item.getQuantity())).sum();
        return 0.0;
    }

    public double getCapacity() {
        return 0;
    }

    public int getNbItems() {
        return nbItems;
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

    public boolean addItem(Item itm) {
        return false;
    }

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


    public boolean canAddItem(Item itm, double usedCapacity) {
        return false;
    }

    public boolean canAddItem(Item item) {
        return false;
    }

}
