package command;

import entity.Being;
import entity.Container;
import entity.Hostile;
import entity.Player;
import entity.place.Place;
import interfaces.Fightable;
import world.World;

import static utils.Printer.printErr;
import static utils.Printer.printMsg;

public interface Attack {

    /**
     * Attacks a valid opponent in the current room
     * Displays its own messages
     *
     * @param player       the player of tha game
     * @param currentPlace the place the fight occurs in
     * @param arg1         the first arg of userinput (opponent name)
     */
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

        printMsg("You attack " + opponent.getName() + " !");
        Fightable.fight(player, (Fightable) opponent);


        if (((Fightable) opponent).isDead()) {
            updatedPlayerKills(player);
            addLootToPlace(currentPlace, opponent);
        }

    }

    /**
     * Checks if an agressive Being can attack the player and initiate battle
     *
     * @param world the world of the game.
     */
    static void checkFight(World world) {
        Place currentPlace = world.getCurrentPlace();
        Player player = world.getPlayer();
        Hostile aggressiveEntity;

        aggressiveEntity = currentPlace.getAgressive();

        if (aggressiveEntity != null) {
            printMsg(aggressiveEntity.getName() + " Attacks You !");
            Fightable.fight(player, aggressiveEntity);
            if (aggressiveEntity.isDead())
                addLootToPlace(currentPlace, aggressiveEntity);
        }
    }

    /**
     * removes a being from the room and adds its loot to the room
     *
     * @param currentPlace the current place
     * @param opponent     the dead opponent to add loot to the place
     */
    static void addLootToPlace(Place currentPlace, Container opponent) {
        printMsg(opponent.getName() + " is dead and its loots fall on the ground");
        currentPlace.getPlaceContainer().addAllItems((opponent));
        currentPlace.removeContainer(opponent);
    }

    /**
     * Called when a player kills a being.
     * Increment the player kill counter
     * And levelUP the player if right number of kills
     *
     * @param player the player
     */
    static void updatedPlayerKills(Player player) {
        player.addKill();

        if (player.getKills()/5 > (player.getLevel() - 1)) {
            player.levelUP();

            printMsg("Congratulation you killed " +
                     player.getKills() +
                     " opponents, You are now level " +
                     player.getLevel());

            printMsg("You now have " + player.getMaxHp() + " hp, and do 1 more damage");
        }
    }
}
