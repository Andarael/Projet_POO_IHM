// Fichier par Josué Raad

package game;

import command.Command;
import world.World;

import java.util.List;

import static game.Interpreter.*;

import static command.Command.execute;

public class Game {

    public static boolean play(int difficulty) {

        List<String> userInput;
        boolean victory = false;
        boolean death = false;

        while (! (victory ||death)) {

            World world = new World(difficulty);

            displayWelcome();

            world.getCurrentPlace().draw();

            displayWaitingInput();

            userInput = getUserInput();

            Command.execute(world, userInput);

            victory = world.hasWin();
            death = world.getPlayer().isDead();

            if (victory) {
                displayVictory();
            }
            if (death) {
                displayDeath();
            }

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
