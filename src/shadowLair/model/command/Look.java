// fichier par josué Raad

package shadowLair.model.command;

import shadowLair.model.entity.Entity;
import shadowLair.model.entity.place.Place;

import static shadowLair.model.utils.Printer.printErr;

public interface Look {

    static String look(Place currentPlace) {
        currentPlace.look();
        return currentPlace.getSimpleLook();
    }

    static String look(Place currentPlace, String arg1) {
        Entity entity = currentPlace.getContainerByName(arg1);
        if (entity != null) {
            entity.look();
            return entity.getSimpleLook();
        }

        printErr("You can't look at " + arg1 + " from here");
        return null;

    }
}
