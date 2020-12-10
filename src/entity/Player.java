// Fichier par Josué Raad

package entity;

import entity.item.Food;
import entity.item.Hand;
import entity.item.Item;
import entity.place.Exit;
import interfaces.Equipable;
import interfaces.Usable;
import interfaces.UsableOnItem;
import inventory.LimitedInventory;

import static utils.Printer.printMsg;

/**
 * A player is a being that can equip items
 * and have an inventory limited in capacity
 * A player can also use items it have equipped or in his inventory
 * If the item is not usable nothing happens.
 * If the item is used then it is removed from the inventory
 * <p>
 * <p>
 * the game should end on player's death
 */
public class Player extends Being {

    private static final Hand HANDS = new Hand();
    private final LimitedInventory limitedInventory;
    private Item equipped;

    public Player(int hp) {
        super("player", null, hp, 1);
        limitedInventory = new LimitedInventory();
        this.inventory = limitedInventory;
        equipped = HANDS;
    }

    public Player() {
        this(DEFAULT_HEALTH);
    }

    /**
     * @return the current equipped item
     */
    public Item getEquipped() {
        return equipped;
    }

    /**
     * Equips the new item instead of the old item in the equip slot.
     * If the old item was not unequipped then nothing happens.
     * If the new item is null then nothing happens.
     * If the new item is not an equippable then nothing happens.
     *
     * @param newItem the new item to equip
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

    /**
     * Equips an item present in the player inventory
     *
     * @param itemName the name of the item to equip
     * @return true if the item was equipped
     */
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

    /**
     * gets the power of the player taking int account its equipped item
     *
     * @return the power of the player
     */
    @Override
    public int getPower() {
        if (equipped == null || (!(equipped instanceof Equipable))) return 1;

        return ((Equipable) equipped).getPower();
    }

    /**
     * Same as removeItem from upper classes, but checks for the equip slot too
     *
     * @param item the item to remove
     * @return true if the item was present
     */
    @Override
    public boolean removeItem(Item item) {
        if (!super.removeItem(item)) {
            if (equipped.equals(item)) {
                equipped = HANDS;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getSimpleDisplay() {
        return "Player" + ", lvl : " + getLevel() +
               ", hp : " + getHp() + "/" + getMaxHp() +
               ", pow : " + getPower() + "\n" +
               "equipped : " + equipped.getSimpleDisplay();
    }

    public boolean haveItem(Item item) {
        Item newItem = getItem(item);

        // also check if item is equipped
        if (newItem == null)
            if (equipped.equals(item))
                newItem = equipped;

        return newItem != null;
    }

    /**
     * Use an item (simple use with only 1 arg)
     * Displays its own messages
     * remove the item if successful use
     *
     * @param item the item to use
     * @return the message to display upon use
     */
    public boolean use(Item item) {

        Item newItem = getItem(item);

        if (!haveItem(newItem)) {
            printMsg("You don't have " + item.getName() + " in your inventory");
            return false;
        }

        // check if item is usable
        if (!(newItem instanceof Usable)) {
            printMsg("This (" + item.getName() + ") is not usable");
            return false;
        }

        boolean output;

        if (newItem instanceof Food)
            output = ((Food) newItem).use(this);
        else
            output = ((Usable) newItem).use();

        // remove only if item was used
        if (output)
            removeItem(newItem);

        return output;

    }

    /**
     * Allows the player to use an item with its name.
     * Displays its own messages
     * remove the item if successful use
     *
     * @param itemName of used item
     * @return true if the item was used correctly
     */
    public boolean use(String itemName) {
        return use(new Item(itemName));
    }

    /**
     * Allow the player to use one item on another
     * Displays its own messages
     * remove the item if successful use
     *
     * @param item1 the used item
     * @param item2 the item used on
     * @return true if the item was used correctly
     */
    public boolean use(Item item1, Item item2) {

        if (!haveItem(item1)) {
            printMsg("You don't have " + item1.getName() + " in your inventory");
            return false;
        }

        if (!haveItem(item2)) {
            printMsg("You don't have " + item2.getName() + " in your inventory");
            return false;
        }

        if (!(item1 instanceof UsableOnItem)) {
            printMsg("This (" + item1.getName() + ") is not usable on another item");
            return false;
        }

        boolean output = ((UsableOnItem) item1).use(item2);

        // remove only if item was used
        if (output)
            removeItem(item1);

        return output;
    }

    /**
     * use an item on another
     * Displays its own messages
     * remove the item if successful use
     *
     * @param itemName1 name of used item
     * @param itemName2 name of used on item
     * @return true if the item1 was used correctly
     */
    public boolean use(String itemName1, String itemName2) {
        return use(new Item(itemName1), new Item(itemName2));
    }

    /**
     * Use an item on an exit
     * Displays its own messages
     * remove the item if successful use
     *
     * @param item the item to use (Key)
     * @param exit the exit you want to unlock
     * @return true if the item was used correctly
     */
    public boolean use(Item item, Exit exit) {
        // todo check si item.use() a marché
        // todo use(Item, Exit)
        // todo faire en sorte de pouvoir récup les exit pour les passer au joueur
        return false;
    }

}
