package inventory;

import item.Item;

public interface ItemManagement {

    boolean isEmpty();

    Item getItem(String s);

    boolean addItem(Item itm);

    boolean removeItem(Item item);

    boolean removeItem(String s);

    boolean contains(Item item);

    boolean contains(String item);
}
