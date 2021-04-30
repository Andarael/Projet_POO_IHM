// fichier par josué et Thibaut

package shadowLair.model.command;

import shadowLair.model.entity.Player;
import shadowLair.model.entity.place.Exit;
import shadowLair.model.world.World;

import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.world.WorldContains.isAPlace;

public interface Use {

    static String use(Player player, String item) {
        return player.use(item);
    }

    static String use(World world, Player player, String item1, String arg2) {

        // if arg2 is a place we can reach, we call use(Item, Exit)
        // else we call the default use(item, item)
        if (isAPlace(world, arg2)) {
            Exit exit = world.currentPlace.getExitByName(arg2);
            if (exit != null)
                return player.use(item1, exit);
            else
                return printErr(arg2 + " is not reachable from here");
        } else {
            return player.use(item1, arg2);
        }
    }
}
