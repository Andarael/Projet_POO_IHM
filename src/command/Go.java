package command;

import entity.place.Exit;
import entity.place.Place;
import world.World;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;
import static world.WorldContains.isAPlace;

public interface Go {
    static void go(World world, Place currPlace, String arg1) {

        if (!isAPlace(world, arg1)) {
            printErr(arg1 + " is not a place");
            return;
        }

        Exit destination = currPlace.getExitByName(arg1);

        if (destination == null) {
            printErr("You can't access " + arg1 + " from here");
            return;
        }

        world.setCurrentPlace(destination.getDestination());
        printMsg("You enter " + destination.getName());
        printMsg("\n");

        destination.draw();

        Attack.checkFight(world);
    }
}
