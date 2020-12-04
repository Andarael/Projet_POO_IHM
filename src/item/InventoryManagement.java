package item;

public interface InventoryManagement {
    double getUsedCapacity();

    double getCapacity();

    int getNbItems();

    boolean isEmpty();

    Item getRandomItem();

    void removeAllItems();

    boolean addItem(Item itm);
    boolean addItem(String s);

    boolean removeItem(Item item);
    boolean removeItem(String s);

    boolean contains(Item item);
    boolean contains(String item);

    int getQuantity(Item item);
    int getQuantity(String s);

    boolean canAddItem(Item item);
    boolean canAddItem(Item itm, double usedCapacity);
}
