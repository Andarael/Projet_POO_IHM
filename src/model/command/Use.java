// fichier par josué et Thibaut

package model.command;

import model.entity.Player;
import model.entity.place.Exit;
import model.world.World;

import static model.utils.Printer.printErr;
import static model.world.WorldContains.isAPlace;

public interface Use {
    static void use(Player player, String item) {
        player.use(item);
    }

    static void use(World world, Player player, String item1, String arg2) {

        // if arg2 is a place we can reach, we call use(Item, Exit)
        // else we call the default use(item, item)
        if (isAPlace(world, arg2)) {
            Exit exit = world.currentPlace.getExitByName(arg2);
            if (exit != null)
                player.use(item1, exit);
            else
                printErr(arg2 + " is not reachable from here");
        } else {
            player.use(item1, arg2);
        }
    }
}
