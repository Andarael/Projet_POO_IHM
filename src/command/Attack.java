package command;

import entity.Being;
import entity.Container;
import entity.Player;
import entity.place.Place;
import interfaces.Fightable;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;

public interface Attack {
    static void attack(Player player, Place currentPlace, String arg1) {
        Container opponent = currentPlace.getContainerByName(arg1);

        if (opponent == null) {
            printErr(arg1 + " is not here");
            return;
        }

        if (!(opponent instanceof Fightable)) {
            printErr("You can't fight with" + arg1);
            return;
        }

        Fightable.fight(player, new Being(arg1));

        if (((Fightable) opponent).isDead()) {
            player.addKill();
            if (player.getKills() > player.getLevel() - 1) {
                player.levelUP();
                printMsg("Congratulation you killed " +
                         player.getKills() +
                         "monsters, You are now level" +
                         player.getLevel());
                printMsg("You now have " + player.getMaxHp() + "hp, and do 1 more damage");
            }
        }
    }
}
