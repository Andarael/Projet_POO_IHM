package entity.item;

import interfaces.UsableOnItem;

/**
 * An arrow is a weightLess Item
 * of value and damage 3
 * It can be used on a Bow to charge it
 */
public class Arrow extends Weapon implements UsableOnItem {

    public Arrow() {
        super("Arrow", null,0.0, 3, 3);
    }

    @Override
    public void use() {
        System.out.println("Invalid use of Arrow, try 'USE Arrow Bow'");
    }

    @Override
    public boolean use(Item item) {
        if (item == null)
            return false;

        if (!(item instanceof Bow))
            return false;

        ((Bow) item).addArrow();
        return true;
    }
}
