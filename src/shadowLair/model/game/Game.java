// Fichier par Josué Raad

package shadowLair.model.game;

import shadowLair.model.command.Attack;
import shadowLair.model.entity.Player;
import shadowLair.model.utils.Printer;
import shadowLair.model.world.World;

import java.util.List;

import static shadowLair.model.command.Execute.execute;
import static shadowLair.model.command.Inputer.getUserInput;
import static shadowLair.model.utils.Printer.printErr;
import static shadowLair.model.utils.Printer.printMsg;


public class Game {

    /**
     * Execute the game in the terminal
     * Please use a terminal that supports escape codes
     * Difficulty ranges from 0 to 3
     *
     * @param difficulty difficulty of the game (0 is easy and 3 is hard)
     * @return true if the use won the game
     */
    public static boolean play(int difficulty) {
        return play(difficulty, true);
    }

    public static boolean play(int difficulty, boolean console) {
        List<String> userInput;
        boolean victory = false;
        boolean death = false;
        boolean end = false;
        World world = new World(difficulty);


        displayWelcome(world);

        while (!(victory || death || end)) {

            try {

                Attack.checkFight(world);
                displayWaitingInput();

                if (console) {
                    userInput = getUserInput();
                    execute(world, userInput);
                }

                // Update variables
                end = world.isEnd();
                victory = world.hasWin();
                death = world.getPlayer().isDead();

                // if world is incorrectly initialized
            } catch (NullPointerException nullException) {
                printErr("This world is corrupted by some dark computer magic, \n" +
                         "your adventure must stop now !");
                Printer.printErr("The devil comes from : " + nullException);
                nullException.printStackTrace();
                break;
            }

        }

        // display when game ends
        if (victory)
            displayVictory();

        if (death)
            displayDeath();

        displayStats(world.getPlayer());

        return (victory);
    }

    private static void displayStats(Player player) {
        printMsg("\n=====================\n");
        printMsg("Some stats on your adventure : ");
        printMsg("You got to level " + player.getLevel());
        printMsg("You killed a total of " + player.getKills() + " Beings !");
        printMsg("and got " + player.getGold() + " golds ");
        printMsg("In your inventory you had :");
        printMsg(player.getInventoryDisplay());
    }

    private static void displayWelcome(World world) {
        printMsg("Prepare to enter Xak Tsaroth!");
        printMsg("You awake in a room, here is your inventory");
        world.getPlayer().getInventoryDisplay();
        world.currentPlace.draw();
    }

    private static void displayWaitingInput() {
        printMsg("What will be your next move ?");
        System.out.print(">");
    }

    private static void displayDeath() {
        printMsg("Your wounds led you to a slow and painful death");
    }

    private static void displayVictory() {
        printMsg("You defeated the dragon and saved the princess ! " +
                 "Now with this jewel, everyone will finally know that you are true hero");

    }
}
