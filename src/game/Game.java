// Fichier par Josué Raad

package game;

import world.World;

import java.util.List;

import static command.Execute.execute;
import static command.Inputer.getUserInput;
import static utils.Printer.printErr;
import static utils.Printer.printMsg;


public class Game {

    public static boolean play(int difficulty) {

        List<String> userInput;
        boolean victory = false;
        boolean death = false;
        boolean end = false;
        World world = new World(difficulty);
        displayWelcome();

        while (!(victory || death || end)) {

            // world.getCurrentPlace().draw();
            // todo check combat
            // todo faire le draw dans GO

            displayWaitingInput();

            userInput = getUserInput();

            try {
                execute(world, userInput);

            } catch (NullPointerException nullException) {
                printErr("This world is corrupted by some dark computer magic, \n" +
                         "your adventure must stop now !");
                break;
            }

            end = world.isEnd();

            victory = world.hasWin();
            death = world.getPlayer().isDead();

            if (victory)
                displayVictory();

            if (death)
                displayDeath();
        }

        printMsg("Some stats on your adventure : ");
        printMsg("You killed a total of " + world.getPlayer().getKills() + " Beings !");
        printMsg("and got " + world.getPlayer().getGold() + " golds ");

        return (victory);

    }

    private static void displayWelcome() {
        printMsg("Prepare to enter Xak Tsaroth!");
        printMsg("You awake in a room, here is your inventory");
    }

    private static void displayWaitingInput() {
        // todo
        printMsg("What will be your next move sir ?");
    }

    private static void displayDeath() {
        printMsg("Your wounds led you to a slow and painful death");
        // todo
    }

    private static void displayVictory() {
        printMsg(
                "You defeated the dragon and saved the princess ! Now with this jewel, everyone will finally know that you are true hero");
        // todo
    }

    public static void main(String[] args) {
        play(1);
    }

}
