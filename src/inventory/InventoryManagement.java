package inventory;

import entity.item.Item;

public interface InventoryManagement {
    boolean isEmpty();

    Item getItem(Item item);

    Item getItem(String s);

    boolean addItem(Item item);

    boolean removeItem(Item item);

    boolean removeItem(String s);

    void removeAllItems();

    boolean contains(Item item);

    boolean contains(String s);

    void sortInventory();

    int getNbItems();

    int getQuantity(Item item);

    int getQuantity(String s);

    void addGold(int nb);

    int getGold();

    boolean removeGold(int nb);
}
