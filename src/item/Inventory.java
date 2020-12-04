package item;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryManagement {
    protected final List<Item> itemList;
    private int nbItems;

    public Inventory() {
        itemList = new ArrayList<>();
    }

    @Override
    public int getNbItems() {
        return nbItems;
    }

    @Override
    public boolean isEmpty() {
        return nbItems == 0;
    }

    @Override
    public Item getItem(String s) {
        return null;
    }

    @Override
    public Item getRandomItem() {
        return null;
    }

    @Override
    public Item getFirstItem() {
        return null;
    }

    @Override
    public void removeAllItems() {
    }

    @Override
    public boolean addItem(Item itm) {
        this.itemList.add(itm);
        nbItems += 1;
        return true;
    }


    @Override
    public boolean removeItem(Item item) {
        if (!this.contains(item))
            return false;

        this.itemList.remove(item);
        this.nbItems -= 1;
        return true;
    }

    @Override
    public boolean removeItem(String s) {
        return this.removeItem(this.getItem(s));
    }

    @Override
    public boolean contains(Item item) {
        return false;
    }

    @Override
    public boolean contains(String s) {
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

    public boolean isValid() {
        return nbItems == itemList.size();
    }
}
