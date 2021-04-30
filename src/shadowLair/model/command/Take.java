// fichier par josué et Thibaut

package shadowLair.model.command;

import shadowLair.model.entity.Container;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.StaticContainer;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.place.Place;

import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.utils.Printer.printMsg;

public interface Take {

    static String take(Player player, Place currentPlace, String containerName, String itemName) {

        Container container = currentPlace.getContainerByName(containerName);


        if (container == null) {

            StaticContainer placeContainer = currentPlace.getPlaceContainer();
            if (placeContainer.isSameStr(containerName)) {
                container = placeContainer;
            } else {
                return printErr(containerName + " is not in this Place");
            }
        }

        if (container instanceof StaticContainer) {
            return takeItemAddPlayer(player, ((StaticContainer) container), itemName);
        } else {
            return printErr("You can't take items from " + container.getName());
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
    static String takeItemAddPlayer(Player player, StaticContainer container, String itemName) {

        Item item = container.getItem(itemName);

        if (item == null) {
            return printErr(itemName + " is not in this Place");
        }

        if (player.canAddItem(item)) {
            player.addItem(item);
            container.removeItem(item);
            return printMsg("You added " + item.getName() + " to your inventory");
        } else {
            return printMsg("You can't take " +
                            item.getName() +
                            ". You can't carry it. \n " +
                            "Try discarding some items");
        }
    }


    /**
     * Automatically takes the golds present in the room
     */
    static String take(Player player, Place currentPlace) {

        StaticContainer placeContainer = currentPlace.getPlaceContainer();

        int gold = placeContainer.getGold();
        placeContainer.removeGold(gold);
        player.addGold(gold);

        return printMsg("You took " + gold + " gold(s)");
    }


    static String take(Player player, Place currentPlace, String itemName) {

        StaticContainer placeContainer = currentPlace.getPlaceContainer();

        return takeItemAddPlayer(player, placeContainer, itemName);
    }
}
