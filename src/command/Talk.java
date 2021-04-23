// fichier par josué et Thibaut

package command;

import entity.Container;
import entity.place.Place;
import interfaces.Talkable;

import static utils.Printer.*;

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
