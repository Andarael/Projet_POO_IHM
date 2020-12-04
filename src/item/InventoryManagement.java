package item;

public interface InventoryManagement {

    int getNbItems();

    boolean isEmpty();


    Item getItem(String s);
    Item getRandomItem();
    Item getFirstItem();

    boolean addItem(Item itm);

    boolean removeItem(Item item);

    boolean removeItem(String s);
    void removeAllItems();

    boolean contains(Item item);
    boolean contains(String item);

    int getQuantity(Item item);
    int getQuantity(String s);
}
