package entity;

import entity.item.Hand;
import entity.item.Item;
import interfaces.Equipable;
import interfaces.Fightable;
import inventory.LimitedInventory;

public class Player extends Being implements Fightable {

    private static final Hand HANDS = new Hand();

    private Item equipped;

    private final LimitedInventory inventory;

    public Player(int hp) {
        super("player", null, hp);
        inventory = new LimitedInventory();
        equipped = HANDS;
    }

    public Player() {
        this(DEFAULT_HEALTH);
    }

    @Override
    public int getPower() {
        if (equipped == null || (!(equipped instanceof Equipable)))
            return 0;

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
        if (newItem == null)
            return false;

        // si l'item n'est pas équipable alors on ne fait rien
        if (!(newItem instanceof Equipable))
            return false;

        // on déséquipe et si le slot n'est pas bien vide alors on ne fait rien
        if (!unequip())
            return false;

        equipped = newItem;

        return true;
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
        if (!(inventory.canAddItem(equipped)))
            return false;

        // si les mains du player sont l'item actuellement équipé
        if (equipped.equals(HANDS))
            return true;

        inventory.addItem(equipped);
        equipped = HANDS;

        return true;
    }
}
