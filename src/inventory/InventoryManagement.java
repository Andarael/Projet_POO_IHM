package inventory;

import entity.item.Item;

public interface InventoryManagement {
    boolean isEmpty();

    Item getItem(String item);

    boolean addItem(Item item);

    boolean removeItem(Item item);

    boolean removeItem(String item);

    void removeAllItems();

    boolean contains(Item item);

    boolean contains(String item);

    void sortInventory();

    int getNbItems();

    void addGold(int nb);

    int getGold();

    boolean removeGold(int nb);

    int getQuantity(Item item);

    int getQuantity(String item);
}
