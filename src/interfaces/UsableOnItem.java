package interfaces;

import entity.item.Item;

public interface UsableOnItem extends Usable{

    boolean use(Item item);

}
