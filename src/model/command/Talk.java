// fichier par josué et Thibaut

package model.command;

import model.entity.Container;
import model.entity.place.Place;
import model.interfaces.Talkable;

import static controller.utils.Utils.capitalize;
import static controller.utils.Utils.readable;
import static model.utils.Printer.*;

public interface Talk {
    static String talk(Place currentPlace, String arg1) {

        Container npc = currentPlace.getContainerByName(arg1);



        if (npc == null) {
            return printErr(arg1 + " is not here");
        }

        if (!(npc instanceof Talkable)) {
            String str = "You can't talk to " + arg1;
            return printErr(str);
        }

        String says = capitalize(readable(npc.getName())) + " says : ";
        String talk = ((Talkable) npc).talk();

        printMsg(says);
        printDialogue(talk);

        String executionResult = says + "\n" + talk;

        if (!npc.isEmpty()) {
            String str = "\nHere are the goods I may trade with you :";
            printDialogue(str);
            printMsg(npc.getInventoryDisplay());
            executionResult += str;
        }

        return executionResult;
    }
}
