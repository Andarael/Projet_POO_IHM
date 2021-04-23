// fichier par josué et Thibaut

package model.command;

import model.entity.place.Exit;
import model.entity.place.Place;
import model.world.World;

import static model.utils.Printer.printErr;
import static model.utils.Printer.printMsg;
import static model.world.WorldContains.isAPlace;

public interface Go {
    static void go(World world, Place currentPlace, String arg1) {

        if (!isAPlace(world, arg1)) {
            printErr(arg1 + " is not a place");
            return;
        }

        Exit destination = currentPlace.getExitByName(arg1);

        if (destination == null) {
            printErr("You can't access " + arg1 + " from here");
            return;
        }

        if (destination.goIn() == null) {
            printMsg("This door is locked");
            return;
        }

        world.setCurrentPlace(destination.getDestination());
        printMsg("You enter " + destination.getName());
        printMsg("\n");

        destination.getDestination().draw();

        Attack.checkFight(world);
    }
}
