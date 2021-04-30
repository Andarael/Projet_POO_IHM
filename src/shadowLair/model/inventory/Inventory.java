// Fichier par Josué Raad

package shadowLair.model.inventory;

import shadowLair.model.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

import static shadowLair.model.utils.Col.YELLOW;
import static shadowLair.model.utils.Col.colorize;

/**
 * An inventory is a List of items with its own display (but not Describable nor Lookable)
 */
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
        // (identique selon la méthode isSameNameShortName() de item
        // donc juste le nom ou le shortname d'identique)
        return itemList.stream()
                       .filter(x -> x.isSame(item))
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public Item getItem(String str) {
        // on crée un nouvel item à partir du nom de l'item cherché
        return getItem(new Item(str));
    }

    public Item getFirstItem() {
        if (isEmpty())
            return null;
        return itemList.get(0);
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
        return itemList.remove(getItem(item));
    }

    @Override
    public boolean removeItem(String str) {
        return removeItem(getItem(str));
    }

    @Override
    public void addAllItems(Inventory inventoryToAdd) {
        if (inventoryToAdd == null)
            return;

        this.gold += inventoryToAdd.getGold();

        List<Item> itemListToAdd = inventoryToAdd.getItemList();
        itemListToAdd.forEach(this::addItem);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public void removeAllItems() {
        itemList.clear();
    }

    @Override
    public boolean contains(Item item) {
        return itemList.stream()
                       .anyMatch(x -> (x.isSame(item)));
    }

    @Override
    public boolean contains(String str) {
        return contains(new Item(str));
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
                             .filter(x -> x.isSame(item))
                             .count();
    }

    @Override
    public int getQuantity(String str) {
        return getQuantity(new Item(str));
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

    /**
     * Creates a list of all items in the inventory,
     * the list is intend to the right by one tab
     *
     * @param detailed details in the items if true
     * @return a string containing the list of all items in the inventory
     */
    public String getItemListDisplay(boolean detailed) {
        String output = "";

        for (Item item : itemList) {
            if (detailed)
                output = output + "    " + item.getDisplay() + "\n";
            else
                output = output + item.getSimpleDisplay() + "\n";
        }

        return output;
    }

    /**
     * Creates a string containing the inventory informations
     *
     * @return a String with the inventory header
     */
    public String getHeaderDisplay() {
        return colorize("gold : " + gold, YELLOW) + "\n" +
               "nbItems : " + itemList.size() + "\n";
    }

    /**
     * @return A string of a whole detailed inventory
     */
    public String getInvDisplayDetails() {
        return getHeaderDisplay() + getItemListDisplay(true);
    }

    /**
     * @return a String of the whole inventory without the item details
     */
    public String getInvDisplayNoDetails() {
        return getHeaderDisplay() + getItemListDisplay(false);
    }

    @Override
    public String toString() {
        return getInvDisplayDetails();
    }
}
