package model;

import model.game.Game;

public class Main {

    public static void main(String[] args) {
        int difficulty = 1;

        // getting difficulty from args
        if (args.length == 1) {
            try {
                difficulty = Integer.parseInt(args[0]);

            } catch (NumberFormatException exception) {
                System.err.println("Error, '" + args[0] + "' is not a valid difficulty");
            }
        }

        Game.play(difficulty);
    }
}
