package interfaces;

import entity.item.Item;

public interface UsableOnItem extends Usable{

    String use(Item item);

}
