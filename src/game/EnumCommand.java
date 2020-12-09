package game;

public enum EnumCommand {
    DROP("Drops an item from your inventory in the room \n" +
         "For example : Drop pog -> you dropped a pog on the floor",
         "DROP",
         1,
         1
    ),
    GO("Allows you to go from a Room to another \n" +
       "For example : GO Labo -> Enters into the Laboratory if possible",
       "Go",
       1,
       1
    ),
    HELP("HELP help",
         "HELP",
         0,
         0
    ),
    INVENTORY("Displays the content of your inventory",
              "INVENTORY",
              0,
              0
    ),
    LOOK("Allows you to look at any entity in the Room, \n" +
         "Such as Monsters, NPCs, Containers, Exits, or the room itself \n" +
         "For example : Look -> looks a the room \n" +
         "              Look Chest -> show content of the chest",
         "LOOK",
         0,
         1
    ),
    QUIT("Quits the game",
         "QUIT",
         0,
         0
    ),
    TAKE("Takes an item from a Container, \n" +
         "For example : Take Chest Chicken -> add the chicken from the chest to your inv if possible" ,
         "TAKE",
         1,
         2
    ),
    USE("Use an Item (possibly on another Item) \n" +
        "For example : Use Chicken -> You eat the chicken it gives you back 5 hp \n" +
        "            : Use Arrow Bow -> You add 1 arrow to the Bow",
        "USE",
        1,
        2
    );

    private final String usage;
    private final String commandStr;
    private final int minArgs;
    private final int maxArgs;

    EnumCommand(String usage, String commandStr, int minArgs, int maxArgs) {
        this.usage = usage;
        this.commandStr = commandStr;
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;
    }

}
