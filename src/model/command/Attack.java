// fichier par josué et Thibaut

package model.command;

import model.entity.Container;
import model.entity.Hostile;
import model.entity.Player;
import model.entity.place.Place;
import model.interfaces.Fightable;
import model.world.World;

import static model.utils.Printer.printErr;
import static model.utils.Printer.printMsg;

public interface Attack {

    /**
     * Attacks a valid opponent in the current room
     * Displays its own messages
     *
     * @param player       the player of tha game
     * @param currentPlace the place the fight occurs in
     * @param arg1         the first arg of user input (opponent name)
     */
    static String attack(Player player, Place currentPlace, String arg1) {
        Container opponent = currentPlace.getContainerByName(arg1);

        if (opponent == null) {
            return printErr(arg1 + " is not here");
        }

        if (!(opponent instanceof Fightable)) {
            return printErr("You can't fight with" + arg1);
        }

        String output = printMsg("You attack " + opponent.getName() + " !");
        output += Fightable.fight(player, (Fightable) opponent);


        if (((Fightable) opponent).isDead()) {
            updatedPlayerKills(player);
            addLootToPlace(currentPlace, opponent);
        }

        return output;

    }

    /**
     * Checks if an agressive Being can attack the player and initiate battle
     *
     * @param world the world of the game.
     */
    static String checkFight(World world) {
        Place currentPlace = world.currentPlace;
        Player player = world.getPlayer();
        Hostile aggressiveEntity;

        aggressiveEntity = currentPlace.getAgressive();

        String output = null;

        if (aggressiveEntity != null) {
            output = printMsg(aggressiveEntity.getName() + " Attacks You !");

            output += Fightable.fight(player, aggressiveEntity);

            if (aggressiveEntity.isDead()) {
                updatedPlayerKills(player);
                addLootToPlace(currentPlace, aggressiveEntity);
            }
        }
        return output;
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

        if (player.getKills() / 5 > (player.getLevel() - 1)) {
            player.levelUP();

            printMsg("Congratulation you killed " +
                     player.getKills() +
                     " opponents, You are now level " +
                     player.getLevel());

            printMsg("You now have " + player.getMaxHp() + " hp, and do 1 more damage");
        }
    }
}
