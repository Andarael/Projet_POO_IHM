// Fichier par Josué Raad

package game;

import world.World;

import java.util.List;

import static command.Execute.execute;
import static command.Interpreter.getUserInput;


public class Game {

    public static boolean play(int difficulty) {

        List<String> userInput;
        boolean victory = false;
        boolean death = false;
        World world = new World(difficulty);
        displayWelcome();

        while (!(victory || death)) {

            world.getCurrentPlace().draw();

            displayWaitingInput();

            userInput = getUserInput();

            execute(world, userInput);

            victory = world.hasWin();
            death = world.getPlayer().isDead();

            if (victory)
                displayVictory();

            if (death)
                displayDeath();

        }

        return (victory);

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

    private static void displayWelcome() {
        // todo
    }

}
