// Fichier par Josué Raad

package game;

import command.Command;
import sun.launcher.LauncherHelper;
import world.World;

import java.util.Arrays;
import java.util.List;

import static command.Execute.execute;
import static command.Interpreter.getUserInput;
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

            world.getCurrentPlace().draw();

            displayWaitingInput();

            userInput = getUserInput();

            execute(world, userInput);

            end = world.isEnd();

            victory = world.hasWin();
            death = world.getPlayer().isDead();

            if (victory)
                displayVictory();

            if (death)
                displayDeath();


        }

        return (victory);

    }

    private static void displayWelcome() {
        printMsg("Hello adventurer and welcome to i QZid qzi p");
        printMsg("you awake in a room, here is your inventory");
    }

    private static void displayWaitingInput() {
        // todo
    }

    private static void displayDeath() {
        // todo
    }

    private static void displayVictory() {
        // todo
    }

    public static void main(String[] args) {
        play(1);
    }

}
