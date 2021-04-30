// fichier par josué Raad

package model.command;

import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Place;

import static model.utils.Printer.printErr;
import static model.utils.Printer.printMsg;

public interface Drop {

    static String drop(Player player, Place currentPlace, String arg1) {
        String message;
        if (player == null || currentPlace == null) {
            return printErr("This does not exist");
        }

        Item item = player.getItem(arg1);
        if (item == null) {
            return printErr(arg1 + " does not exist");
        }

        player.removeItem(item);
        currentPlace.addItemToPlace(item);

        return printMsg("You dropped " + item.getName() + " on the ground");
    }
}
