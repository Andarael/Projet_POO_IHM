package command;

import entity.Player;

import static utils.Printer.printMsg;

public interface Inv {
    static void inventory(Player player) {
        printMsg(player.getDisplay());
    }
}
