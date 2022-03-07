// Fichier par Josué Raad

package shadowLair.model.entity;

import javafx.util.Pair;
import shadowLair.model.entity.item.Food;
import shadowLair.model.entity.item.Hand;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.place.Exit;
import shadowLair.model.interfaces.Equipable;
import shadowLair.model.interfaces.Usable;
import shadowLair.model.interfaces.UsableOnItem;
import shadowLair.model.inventory.LimitedInventory;

import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.utils.Printer.printMsg;

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
    private final LimitedInventory limitedInventory = new LimitedInventory();
    private Item equipped;
    private int killCounter;

    public Player(int hp) {
        super("player", "ME", null, hp, 1);

        killCounter = 0;
        equipped = HANDS;

        this.inventory = limitedInventory;
    }

    public Player() {
        this(DEFAULT_HEALTH);
    }

    /**
     * @param item the item to check
     * @return true if the player have enough space in his inventory to add the item
     */
    @Override
    public boolean canAddItem(Item item) {
        return ((LimitedInventory) inventory).canAddItem(item);
    }

    /**
     * @return the current equipped item
     */
    public Item getEquipped() {
        return equipped;
    }

    /**
     * This method also checks if the item is in the equip slot
     *
     * @param item a copy of the item to get
     * @return the actual item from the player's inventory
     */
    @Override
    public Item getItem(Item item) {
        Item newItem = super.getItem(item);

        if (newItem == null)
            if (equipped.isSame(item))
                newItem = equipped;

        return newItem;
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
        if (equipped.isSame(HANDS))
            return true;

        limitedInventory.addItem(equipped);
        equipped = HANDS;

        return true;
    }

    /**
     * Gets the power of the player taking int account its equipped item and its current level
     *
     * @return the power of the player
     */
    @Override
    public int getPower() {
        if (equipped == null || (!(equipped instanceof Equipable))) return 1;

        return ((Equipable) equipped).getPower() + getLevel() - 1;
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
            if (equipped.isSame(item)) {
                equipped = HANDS;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(String str) {
        return removeItem(new Item(str));
    }

    @Override
    public String getSimpleDisplay() {
        return "Player" + ", lvl : " + getLevel() + "\n" +
               " hp : " + getHp() + "/" + getMaxHp() + "\n" +
               " equipped : " + equipped.getDisplay();
    }

    /**
     * Use an item (simple use with only 1 arg)
     * Displays its own messages
     * remove the item if successful use
     *
     * @param item the item to use
     * @return the message to display upon use
     */
    public String use(Item item) {

        if (item == null) {
            String message = "This item does not exist";
            printErr(message);
            return message;
        }

        if (!contains(item)) {
            String message = "You don't have " + item.getName() + " in your inventory";
            printMsg(message);
            return message;
        }

        // getting the actual item from the player's inventory
        Item newItem = getItem(item);

        // check if item is usable
        if (!(newItem instanceof Usable)) {
            String message = "This (" + item.getName() + ") is not usable";
            printMsg(message);
            return message;
        }

        Pair<Boolean, String> output;

        if (newItem instanceof Food)
            output = ((Food) newItem).use(this);
        else
            output = ((Usable) newItem).use();

        // remove only if item was used
        if (output.getKey())
            removeItem(newItem);

        return output.getValue();
    }

    /**
     * Allows the player to use an item with its name.
     * Displays its own messages
     * remove the item if successful use
     *
     * @param itemName of used item
     * @return true if the item was used correctly
     */
    public String use(String itemName) {
        if (itemName == null) {
            String message = "This item does not exist";
            printErr(message);
            return message;
        }

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
    public String use(Item item1, Item item2) {

        if (item1 == null || item2 == null) {
            return printErr("This item does not exist");
//            return false;
        }

        if (!contains(item1)) {
            return printErr("You don't have " + item1.getName() + " in your inventory");
//            return false;
        }

        if (!contains(item2)) {
            return printErr("You don't have " + item2.getName() + " in your inventory");
//            return false;
        }

        // getting the actual items from the player's inventory
        Item newItem1 = getItem(item1);
        Item newItem2 = getItem(item2);

        if (!(newItem1 instanceof UsableOnItem)) {
            return printErr("This (" + newItem1.getName() + ") is not usable on another item");
//            return false;
        }

        Pair<Boolean, String> output = ((UsableOnItem) newItem1).use(newItem2);

        // remove only if item was used
        if (output.getKey())
            removeItem(newItem1);

        return output.getValue();
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
    public String use(String itemName1, String itemName2) {
        if (itemName1 == null || itemName2 == null) {
            return printErr("This item does not exist");
//            return false;
        }

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
    public String use(Item item, Exit exit) {
        String message;

        if (item == null || exit == null) {
            message = "This does not exist";
            printErr(message);
            return message;
        }

        if (!contains(item)) {
            message = "You don't have " + item.getName() + " in your inventory";
            printMsg(message);
            return message;
        }

        // getting the actual item from the player's inventory
        Item newItem = getItem(item);

        // check if item is usable
        if (!(newItem instanceof Usable)) {
            message = "This (" + item.getName() + ") is not usable";
            printMsg(message);
            return message;
        }


        Pair<Boolean, String> output = ((Usable) newItem).use(exit);

        if (output.getKey())
            removeItem(newItem);

        return output.getValue();
    }

    public String use(String itemName, Exit exit) {
        if (itemName == null || exit == null) {
            String message = "This does not exist";
            printErr(message);
            return message;
        }
        return use(new Item(itemName), exit);
    }

    public void addKill() {
        killCounter++;
    }

    public int getKills() {
        return killCounter;
    }

    public double getCapacity() {
        return limitedInventory.getCapacity();
    }

    public double getUsedCapacity() {
        return limitedInventory.getUsedCapacity();
    }
}
