// fichier par josué et Thibaut

package command;

import entity.Container;
import entity.Player;
import entity.StaticContainer;
import entity.item.Item;
import entity.place.Place;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;

public interface Take {
    static void take(Player player, Place currentPlace, String containerName, String itemName) {

        Container container = currentPlace.getContainerByName(containerName);

        if (container == null) {
            printErr(containerName + " is not in this Place");
            return;
        }

        if (container instanceof StaticContainer) {
            takeItemAddPlayer(player, ((StaticContainer) container), itemName);
        } else {
            printErr("You can't take items from " + container.getName());
        }
    }

    /**
     * Takes an item from a container and add it to the player
     * if the player can't carry it, then
     *
     * @param player    the player to add the item to
     * @param container the container to take the item from
     * @param itemName  the name of the item
     */
    static void takeItemAddPlayer(Player player, StaticContainer container, String itemName) {

        Item item = container.getItem(itemName);

        if (item == null) {
            printErr(itemName + " is not in this Place");
            return;
        }

        if (player.canAddItem(item)) {
            player.addItem(item);
            container.removeItem(item);
            printMsg("You added " + item.getName() + " to your inventory");
        } else {
            printMsg("You can't take " +
                     item.getName() +
                     ". You can't carry it. \n " +
                     "Try discarding some items (DROP <item>)");
        }
    }


    static void take(Player player, Place currentPlace, String itemName) {

        StaticContainer placeContainer = currentPlace.getPlaceContainer();

        takeItemAddPlayer(player, placeContainer, itemName);
    }
}
