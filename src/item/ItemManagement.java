package item;

public interface ItemManagement {

    boolean addItem(Item item);
    boolean addItem(String string);

    boolean removeItem(Item item);
    boolean removeItem(String item);

    boolean contains(Item item);
    boolean contains(String item);

    int getQuantity(Item item);
    int getQuantity(String s);

    int getNbItems();

    boolean isEmpty();

    Item getRandomItem();

    void removeAllItems();
}
