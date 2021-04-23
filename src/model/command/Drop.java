// fichier par josué Raad

package model.command;

import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Place;

import static model.utils.Printer.printErr;
import static model.utils.Printer.printMsg;

public interface Drop {

    static void drop(Player player, Place currentPlace, String arg1) {
        if (player == null || currentPlace == null) {
            printErr("This does not exist");
            return;
        }

        Item item = player.getItem(arg1);
        if (item == null) {
            printErr(arg1 + " does not exist");
            return;
        }

        player.removeItem(item);
        currentPlace.addItemToPlace(item);

        printMsg("You dropped " + item.getName() + " in the room");
    }
}
