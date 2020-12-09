package entity;

import entity.item.Hand;
import entity.item.Item;
import interfaces.Equipable;
import interfaces.Usable;
import interfaces.UsableOnItem;
import inventory.LimitedInventory;
import entity.place.Exit;

public class Player extends Being {

    private static final Hand HANDS = new Hand();

    private Item equipped;

    private final LimitedInventory limitedInventory;

    public Player(int hp) {
        super("player", null, hp,1);
        limitedInventory = new LimitedInventory();
        this.inventory = limitedInventory;
        equipped = HANDS;
    }

    public Player() {
        this(DEFAULT_HEALTH);
    }

    @Override
    public int getPower() {
        if (equipped == null || (!(equipped instanceof Equipable))) return 1;

        return ((Equipable) equipped).getPower();
    }

    public Item getEquipped() {
        return equipped;
    }

    /**
     * Equips the new item instead of the old item in the equip slot.
     * If the old item was not unequipped then nothing happens.
     * If the new item is null then nothing happens.
     * If the new item is not an equippable then nothing happens.
     *
     * @param newItem  the new item to equip
     * @return true if the new item was equipped
     */
    public boolean equip(Item newItem) {
        // on récupère l'item équivalent dans l'inventaire du joueur
        newItem = getItem(newItem);

        if (newItem == null)
            return false;

        // si l'item n'est pas équipable alors on ne fait rien
        if (!(newItem instanceof Equipable))
            return false;

        // on déséquipe et si le slot n'est pas bien vide alors on ne fait rien
        if (!unequip())
            return false;

        equipped = newItem;
        removeItem(newItem);

        return true;
    }

    public boolean equip(String itemName) {
        return equip(new Item(itemName));
    }

    /**
     * Unequip the actually equipped item and equip hands instead.
     * Unequipped item is stored int the player inventory
     * If the inventory cannot store the equipped item then the item stays equipped
     * If no item is equipped at the time then nothing changes
     *
     * @return true if the equip slot is empty after the operation
     */
    public boolean unequip() {
        // si l'item actuellement équipé ne peut pas être rangé dans l'inventaire
        if (!(limitedInventory.canAddItem(equipped)))
            return false;

        // si les mains du player sont l'item actuellement équipé
        if (equipped.equals(HANDS))
            return true;

        limitedInventory.addItem(equipped);
        equipped = HANDS;

        return true;
    }

    public String use(Item item) {

        Item newItem = getItem(item);

        if (newItem == null) {
            if (equipped.equals(item))
                newItem = equipped;
            else
                return "You don't have this item in your inventory";
        }

        String output;
        if (newItem instanceof Usable) {
            output = ((Usable) newItem).use();
            removeItem(newItem);
            return output;
        }
        return "This (" + item.getName() + ") is not usable";

        // todo add usage with Food.use(Player)
    }

    public String use(Item item1, Item item2) {

        if (! (item1 instanceof UsableOnItem))
            return "This (" + item1.getName() + ") is not usable on another item";

        String output;
        output = ((UsableOnItem) item1).use(item2);
        removeItem(item1);
        return output;
    }

    public String use(String itemName) {
        return use(new Item(itemName));
    }

    public void use(Item item, Exit exit) {
        //todo use(Item, Exit)
    }

    @Override
    public String getSimpleDisplay() {
        return "Player" + ", lvl : " + getLevel() +
               ", hp : " + getHp() + "/" + getMaxHp() +
               ", pow : " + getPower() + "\n" +
               "equipped : " + equipped.getSimpleDisplay();
    }

}
