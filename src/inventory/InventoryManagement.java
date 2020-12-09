// Fichier par Josué Raad

package inventory;

import entity.item.Item;

/**
 * An interface to with an inventory of items
 * And to perform operation on gold stored int said inventory
 *
 * (Remember that items are equal if their name or shortname are equals as specified in Entity )
 */
public interface InventoryManagement {


    /**
     * @return true if the inventory contains no items
     */
    boolean isEmpty();

    /**
     *
     * @param item the item to search for in the inventory
     * @return an item from the inventory equal to the one given
     */
    Item getItem(Item item);

    /**
     * @param str the name or shortName of the item to search for
     * @return an item from the inventory with the same name or Shortname to the one given
     */
    Item getItem(String str);

    /**
     * @return the first item of the inventory
     */
    Item getFirstItem();

    /**
     * Add an item to an inventory
     * @param item the item to add
     * @return true if the item was added to the inventory
     */
    boolean addItem(Item item);

    /**
     * removes an item from the inventory with the same name or shortname as the one given
     * @param item the item to remove
     * @return true if the item was present in the inventory
     */
    boolean removeItem(Item item);

    /**
     * @param str the name or shortname of the item to remove
     * @return true if the item was present in the inventory
     */
    boolean removeItem(String str);

    /**
     * removes all items contained in the inventory
     */
    void removeAllItems();

    /**
     * Checks if the inventory contains at least one item with the same name as the specified item
     * @param item the item to check ofr
     * @return true if the item was present
     */
    boolean contains(Item item);

    /**
     * @param str name or shortname of the item to remove
     * @return true if the item was present
     */
    boolean contains(String str);

    /**
     * Sorts the inventory in item lexicographical order
     */
    void sortInventory();

    /**
     * @return the number of items in the inventory
     */
    int getNbItems();

    /**
     * @param item the item to check quantity for
     * @return the quantity of this item in the inventory
     */
    int getQuantity(Item item);

    /**
     * @param str the name or shortName of the item to check quantity for
     * @return the quantity of this item in the inventory
     */
    int getQuantity(String str);

    /**
     * @param nb the quantityu of gold to add
     */
    void addGold(int nb);

    /**
     * @return the quantity of gold in the inventory
     */
    int getGold();

    /**
     * Checks weather an amount of gold can be taken from an inventory
     *
     * @param nb quantity of gold to check for
     * @return true if the inventory have more gold than nb
     */
    boolean canPay(int nb);

    /**
     * Removes an mount of gold from an inventory if possible
     *
     * @param nb the amount to remove
     * @return true if the inventory had enough gold for the transaction
     */
    boolean removeGold(int nb);
}
