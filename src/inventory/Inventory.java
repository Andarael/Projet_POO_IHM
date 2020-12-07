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
    public Item getItem(Item item) {
        // on stream la liste d'items
        // en recherchant in item identique à celui demandé
            // (identique selon la méthode equals() de item
            // donc juste le nom ou le shortname d'identique)
        return itemList.stream()
                .filter(x -> x.equals(item))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Item getItem(String s) {
        // on crée un nouvel item à partir du nom de l'item cherché
        return getItem(new Item(s));
    }

    @Override
    public boolean addItem(Item item) {
        if (item == null)
            return false;

        itemList.add(item);
        return true;
    }

    @Override
    public boolean removeItem(Item item) {
        return itemList.remove(item);
    }

    @Override
    public boolean removeItem(String s) {
        return removeItem(getItem(s));
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
    public boolean contains(String s) {
        return contains(new Item(s));
    }

    @Override
    public void sortInventory() {
        itemList.sort(Item::compareTo);
    }

    @Override
    public int getNbItems() {
        return itemList.size();
    }

    @Override
    public int getQuantity(Item item) {
        return (int) itemList.stream()
                             .filter(x -> x.equals(item))
                             .count();
    }

    @Override
    public int getQuantity(String s) {
        return getQuantity(new Item(s));
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

    public boolean canPay(int nb) {
        if (nb < 0)
            return false;

        return gold - nb >= 0;
    }

    @Override
    public boolean removeGold(int nb) {
        if (!canPay(nb))
            return false;

        gold -= nb;
        return true;
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
               "nbItems : " + itemList.size() + "\n";
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

    public Item getFirstItem() {
        if (isEmpty())
            return null;
        return itemList.get(0);
    }
}
