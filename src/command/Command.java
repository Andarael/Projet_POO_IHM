// Fichier par Josué Raad

package command;

public enum Command {

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

    USE("Use an Item (possibly on another Item) \n" +
        "For example : Use Chicken -> You eat the chicken it gives you back 5 hp \n" +
        "            : Use Arrow Bow -> You add 1 arrow to the Bow",
        "U",
        1,
        2
    ),

    HELP("Displays the help, try help [COMMAND] to see specific help. \n" +
         "Available commands : \n" +
         "     Use  : (u) Use  [Item] [Item?]" + "\n" +
         "     Go   : (g) Go   [Place]" + "\n" +
         "     Help : (h) Help [Command]" + "\n" +
         "     Look : (l) Look [Entity]" + "\n" +
         "     Quit : (q) Quit " + "\n" +
         "     Sell : (s) Sell [Npc] [Item]" + "\n" +
         "     Buy  : (b) Buy  [Npc] [Item] " + "\n" +
         "     Take : (t) Take [Container] [Item]" + "\n" +
         "     Attack : (a) Attack [Npc]" + "\n" +
         "     Inventory : (i) Inventory" + "\n",
         "H",
         0,
         1
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


    ATTACK("Attack a Being in the current place\n" +
           "For example : Attack Cyclops -> You attack the Cyclops and deals him 5 damage",
           "A",
           1,
           1
    ),

    BUY("Buy an item to the Npc in the current place\n" +
        "For example : Buy Merchant sword -> You bought a sword from the merchant and gave him 5 golds",
        "B",
        2,
        2
    ),

    SELL("Sell an item to the Npc in the current place\n" +
         "For example : Sell Merchant sword -> You sold a sword from the merchant and won 5 golds",
         "S",
         2,
         2
    );

    private final String usage;
    private final String shortCommand;
    private final int minArg;
    private final int maxArg;

    Command(String usage, String shortCommand, int minArg, int maxArg) {
        this.usage = usage;
        this.minArg = minArg;
        this.maxArg = maxArg;
        this.shortCommand = shortCommand;
    }

    public static Command getCommandFromString(String str) {
        if (str == null)
            return null;

        for (Command command : Command.values()) {
            if (command.toString().equalsIgnoreCase(str) ||
                command.getShortCommand().equalsIgnoreCase(str)) {
                return command;
            }
        }
        return null;
    }

    public static boolean isACommand(String str) {
        if (str == null)
            return false;

        for (Command command : Command.values()) {
            if (command.toString().equalsIgnoreCase(str) ||
                command.getShortCommand().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidCommand(Command command, int nb) {
        if (command == null)
            return false;
        return nb >= command.minArg() && nb <= command.maxArg();
    }

    public String getCommandUsage() {
        return this +
               " (Shortcut '" + getShortCommand() + "')\n" +
               usage;
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
