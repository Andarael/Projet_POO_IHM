// fichier par josué Raad

package shadowLair.model.command;

import shadowLair.model.entity.Player;

import static shadowLair.model.utils.Printer.printMsg;

public interface Inv {
    static void inventory(Player player) {
        printMsg(player.getDisplay());
    }
}
