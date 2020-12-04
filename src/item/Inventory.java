package item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

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
        return this.itemList.stream().mapToDouble(item -> (item.getWeight() * item.getQuantity())).sum();
    }

    public double getCapacity() {
        return capacity;
    }

    public int getNbItems() {
        return nbItems;
    }

    public boolean addItem(Item itm) {
        double usedCapacity = getUsedCapacity();
        if (canAddItem(itm, usedCapacity)) {
            this.itemList.add(itm);
            this.nbItems += itm.getQuantity();
            return true;
        }
        return false;
    }

    private void addItemBypass(Item item, int quantity){
        this.itemList.add(item);
        this.nbItems += item.getQuantity();
    }

    public boolean canAddItem(Item itm, double usedCapacity) {
        return (usedCapacity + (itm.getWeight() * itm.getQuantity())) < this.capacity;
    }

}
