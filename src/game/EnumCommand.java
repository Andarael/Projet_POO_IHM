// Fichier par Josué Raad

package game;

public enum EnumCommand {
    DROP("Drops an item from your inventory in the room \n" +
         "For example : Drop pog -> you dropped a pog on the floor",
         "D",
         1,
         1
    ),
    GO("Allows you to go from a Room to another \n" +
       "For example : GO Labo -> Enters into the Laboratory if possible",
       "G",
       1,
       1
    ),
    HELP("HELP help",
         "H",
         0,
         0
    ),
    INVENTORY("Displays the content of your inventory",
              "I",
              0,
              0
    ),
    LOOK("Allows you to look at any entity in the Room, \n" +
         "Such as Monsters, NPCs, Containers, Exits, or the room itself \n" +
         "For example : Look -> looks a the room \n" +
         "              Look Chest -> show content of the chest",
         "L",
         0,
         1
    ),
    QUIT("Quits the game",
         "Q",
         0,
         0
    ),
    TAKE("Takes an item from a Container, \n" +
         "For example : Take Chest Chicken -> add the chicken from the chest to your inv if possible",
         "T",
         1,
         2
    ),
    USE("Use an Item (possibly on another Item) \n" +
        "For example : Use Chicken -> You eat the chicken it gives you back 5 hp \n" +
        "            : Use Arrow Bow -> You add 1 arrow to the Bow",
        "U",
        1,
        2
    ),
    ATTACK("Attack a monster in the current place"+
           "For example : Attack Cyclops -> You attack the Cyclops and deals him 5 damage",
           "A",
           1,
           1
    );









    ;

    private final String usage;
    private final String shortCommand;
    private final int minArg;
    private final int maxArg;

    EnumCommand(String usage, String shortCommand, int minArg, int maxArg) {
        this.usage = usage;
        this.minArg = minArg;
        this.maxArg = maxArg;
        this.shortCommand = shortCommand;
    }

    public static EnumCommand getCommandFromString(String str) {
        String temp = str.toUpperCase();

        for (EnumCommand command : EnumCommand.values()) {
            if (command.toString().equals(temp) ||
                command.getShortCommand().equals(temp)) {
                return command;
            }
        }
        return null;
    }

    public static boolean isValidCommand(EnumCommand command, int nb) {
        if (command == null)
            return false;
        return nb >= command.minArg() && nb <= command.maxArg();
    }

    public String getCommandUsage() {
        return usage;
    }

    public int minArg() {
        return minArg;
    }

    public int maxArg() {
        return maxArg;
    }

    public String getShortCommand() {
        return shortCommand;
    }
}
