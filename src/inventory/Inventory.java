package inventory;

import item.Item;

import java.util.*;

public class Inventory implements ItemManagement {

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
    public Item getItem(String s) {
        return itemList.stream()                            // stream de la liste d'items
                       .filter(x -> x.getName().equals(s))  // on filtre les items du même nom
                       .findAny()                           // on en retourne un
                       .orElse(null);                 // si rien alors null
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
    public boolean removeItem(String s) {
        return this.removeItem(this.getItem(s));
    }

    public void removeAllItems() {
        itemList.clear();
    }

    @Override
    public boolean contains(Item item) {
        return itemList.contains(item);
    }

    @Override
    public boolean contains(String s) {
        return contains(getItem(s));
    }

    public void sortInventory() {
        itemList.sort(Item::compareTo);
    }

    public int getNbItems() {
        return itemList.size();
    }

    public Item getFirstItem() {
        return itemList.stream()
                       .findFirst()
                       .orElse(null);
    }

    public void addGold(int nb) {
        if (nb >= 0)
            gold += nb;
    }

    public int getGold() {
        return gold;
    }

    public boolean removeGold(int nb) {
        if (nb < 0)
            return false;

        if (gold - nb < 0)
            return false;

        gold -= nb;
        return true;
    }

    public int getQuantity(Item item) {
        return (int) itemList.stream()
                             .filter(x -> x.equals(item))
                             .count();
    }

    public int getQuantity(String s) {
        return getQuantity(getItem(s));
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

    public String getDisplay() {
        return "gold : " + gold + "\n" +
               "nbItems=" + itemList.size() + "\n" +
               getItemListDisplay(true);
    }

    public String getSimpleDisplay() {
        return "gold : " + gold + "\n" +
               "nbItems : " + itemList.size() + "\n" +
               getItemListDisplay(false);
    }

    @Override
    public String toString() {
        return "Inventory{ \n" +
               getDisplay() +
               "}\n";
    }
}
