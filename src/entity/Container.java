package entity;

import entity.item.Item;
import inventory.Inventory;
import inventory.InventoryManagement;

public class Container extends Entity implements InventoryManagement {

    private final Inventory inventory;

    public Container(String name, String description) {
        super(name, description);

        this.inventory = new Inventory();
    }

    public Container(String name) {
        this(name, null);
    }


    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    @Override
    public Item getItem(Item item) {
        return inventory.getItem(item);
    }

    @Override
    public Item getItem(String s) {
        return inventory.getItem(s);
    }

    @Override
    public boolean addItem(Item item) {
        return inventory.addItem(item);
    }

    @Override
    public boolean removeItem(Item item) {
        return inventory.removeItem(item);
    }

    @Override
    public boolean removeItem(String s) {
        return inventory.removeItem(s);
    }

    @Override
    public void removeAllItems() {
        inventory.removeAllItems();
    }

    @Override
    public boolean contains(Item item) {
        return inventory.contains(item);
    }

    @Override
    public boolean contains(String s) {
        return inventory.contains(s);
    }

    @Override
    public void sortInventory() {
        inventory.sortInventory();
    }

    @Override
    public int getNbItems() {
        return inventory.getNbItems();
    }

    @Override
    public void addGold(int nb) {
        inventory.addGold(nb);
    }

    @Override
    public int getGold() {
        return inventory.getGold();
    }

    @Override
    public boolean removeGold(int nb) {
        return inventory.removeGold(nb);
    }

    @Override
    public int getQuantity(Item item) {
        return inventory.getQuantity(item);
    }

    @Override
    public int getQuantity(String s) {
        return inventory.getQuantity(s);
    }
}
