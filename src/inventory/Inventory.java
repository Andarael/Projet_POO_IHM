package inventory;

import entity.item.Item;

import java.util.ArrayList;
import java.util.List;

import static utils.Col.YELLOW;
import static utils.Col.colorize;

public class Inventory implements InventoryManagement {

    protected final List<Item> itemList;
    protected int gold;

    public Inventory() {
        this.gold = 0;
        this.itemList = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    @Override
    public Item getItem(String item) {
        return itemList.stream()                              // stream de la liste d'items
                       .filter(x -> x.getName().equals(item)) // on filtre les items du même nom
                       .findAny()                             // on en retourne un
                       .orElse(null);                   // si rien alors null
    }

    @Override
    public boolean addItem(Item item) {
        itemList.add(item);
        return true;
    }

    @Override
    public boolean removeItem(Item item) {
        if (!this.contains(item)) {
            return false;
        }

        itemList.remove(item);
        return true;
    }

    @Override
    public boolean removeItem(String item) {
        return this.removeItem(this.getItem(item));
    }

    @Override
    public void removeAllItems() {
        itemList.clear();
    }

    @Override
    public boolean contains(Item item) {
        return itemList.contains(item);
    }

    @Override
    public boolean contains(String item) {
        return contains(getItem(item));
    }

    @Override
    public void sortInventory() {
        itemList.sort(Item::compareTo);
    }

    @Override
    public int getNbItems() {
        return itemList.size();
    }

    public Item getFirstItem() {
        return itemList.stream()
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public void addGold(int nb) {
        if (nb >= 0)
            gold += nb;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public boolean removeGold(int nb) {
        if (nb < 0)
            return false;

        if (gold - nb < 0)
            return false;

        gold -= nb;
        return true;
    }

    @Override
    public int getQuantity(Item item) {
        return (int) itemList.stream()
                             .filter(x -> x.equals(item))
                             .count();
    }

    @Override
    public int getQuantity(String item) {
        return getQuantity(getItem(item));
    }

    public String getItemListDisplay(boolean detailed) {
        String output = "";

        for (Item item : itemList) {
            if (detailed)
                output = output.concat("    " + item.getDisplay() + "\n");
            else
                output = output.concat(item.getSimpleDisplay() + "\n");
        }

        return output;
    }

    public String getHeaderDisplay() {
        return colorize("gold : " + gold, YELLOW) + "\n" +
               "nbItems=" + itemList.size() + "\n";
    }

    public String getInvDisplayDetails() {
        return getHeaderDisplay() + getItemListDisplay(true);
    }

    public String getInvDisplayNoDetails() {
        return getHeaderDisplay() + getItemListDisplay(false);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " { \n" +
               getInvDisplayDetails() +
               "}\n";
    }

}
