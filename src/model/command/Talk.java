// fichier par josué et Thibaut

package model.command;

import model.entity.Container;
import model.entity.place.Place;
import model.interfaces.Talkable;

import static model.utils.Printer.*;

public interface Talk {
    static void talk(Place currentPlace, String arg1) {

        Container npc = currentPlace.getContainerByName(arg1);

        if (npc == null) {
            printErr(arg1 + " is not here");
            return;
        }

        if (!(npc instanceof Talkable)) {
            printErr("You can't talk to " + arg1);
            return;
        }

        printMsg(npc.getName() + " says : ");
        printDialogue(((Talkable) npc).talk());

        if (!npc.isEmpty()) {
            printDialogue(" Here is what I may have for you :");
            printMsg(npc.getInventoryDisplay());
        }
    }
}
