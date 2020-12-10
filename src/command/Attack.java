package command;

import entity.Being;
import entity.Player;
import entity.place.Place;
import interfaces.Fightable;

public interface Attack {
    static void attack(Player player, Place currentPlace, String arg1) {
        // Being opponent = currentPlace.getBeing
        // todo avec check null
        Fightable.fight(player, new Being(arg1));
    }
}
