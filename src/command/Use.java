package command;

import entity.Player;
import entity.place.Exit;
import world.World;

import static utils.Printer.printErr;
import static world.WorldContains.isPlace;

public interface Use {
    static void use(Player player, String item) {
        player.use(item);
    }

    static void use(World world, Player player, String item1, String arg2) {

        // if arg2 is a place we can reach, we call use(Item, Exit)
        // else we call the default use(item, item)
        if (isPlace(world, arg2)) {
            Exit exit = world.getCurrentPlace().getExitByName(arg2);
            if (exit != null)
                player.use(item1, exit);
            else
                printErr(arg2 + " is not reachable from here");
        } else {
            player.use(item1, arg2);
        }
    }
}
