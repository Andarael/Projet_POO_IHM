// Fichier par Josué Raad

package entity;

import entity.item.Item;
import inventory.Inventory;
import inventory.InventoryManagement;

/**
 * A container is an entity with an inventory.
 * All inventory methods are available via a container
 * <p>
 * <p>
 * Such containers could be chests, monsters for example.
 */
public abstract class Container extends Entity implements InventoryManagement {

    protected Inventory inventory;

    public Container(String name, String shortName, String description) {
        super(name, shortName, description);

        this.inventory = new Inventory();
    }

    public Container(String name) {
        this(name, name, null);
    }

    public boolean canAddItem(Item item) {
        return item != null;
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
    public Item getItem(String str) {
        return inventory.getItem(str);
    }

    @Override
    public Item getFirstItem() {
        return inventory.getFirstItem();
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
    public boolean removeItem(String str) {
        return inventory.removeItem(str);
    }

    @Override
    public void removeAllItems() {
        inventory.removeAllItems();
    }

    @Override
    public boolean contains(Item item) {
        return getItem(item) != null;
    }

    @Override
    public boolean contains(String str) {
        return contains(new Item(str));
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
    public boolean canPay(int nb) {
        return inventory.canPay(nb);
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
    public int getQuantity(String str) {
        return inventory.getQuantity(str);
    }

    public String getInventoryDisplay() {
        return inventory.getInvDisplayDetails();
    }

    @Override
    public String getDisplay() {
        return getSimpleDisplay() + "\n" +
               inventory.getInvDisplayDetails();
    }
}
