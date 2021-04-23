// fichier par josué Raad

package model.command;

import model.entity.Player;

import static model.utils.Printer.printMsg;

public interface Inv {
    static void inventory(Player player) {
        printMsg(player.getDisplay());
    }
}
