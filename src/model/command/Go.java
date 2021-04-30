// fichier par josué et Thibaut

package model.command;

import model.entity.place.Exit;
import model.entity.place.Place;
import model.world.World;

import static model.utils.Printer.printErr;
import static model.utils.Printer.printMsg;
import static model.world.WorldContains.isAPlace;

public interface Go {
    static String go(World world, Place currentPlace, String arg1) {

        if (!isAPlace(world, arg1)) {
            return printErr(arg1 + " is not a place");
        }

        Exit destination = currentPlace.getExitByName(arg1);

        if (destination == null) {
            return printErr("You can't access " + arg1 + " from here");
        }

        if (destination.goIn() == null) {
            return printMsg("This door is locked");
        }

        world.setCurrentPlace(destination.getDestination());

        String message = "You enter " + destination.getName();
        printMsg(message + "\n");

        destination.getDestination().draw();

        return message;
    }
}
