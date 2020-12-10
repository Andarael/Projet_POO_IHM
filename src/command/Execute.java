package command;

import entity.Being;
import entity.Player;
import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import interfaces.Fightable;
import world.World;

import java.util.List;

import static command.Command.getCommandFromString;
import static utils.Printer.printErr;
import static utils.Printer.printMsg;
import static world.WorldContains.haveEntity;
import static world.WorldContains.isPlace;

public interface Execute {

    static void execute(World world, List<String> args) {

        if (world == null || args == null) {
            printErr("World or command arguments are null, stopping Now !");
            throw new NullPointerException("World or command arguments are null, stopping !");
        }

        Command command = getCommandFromString(args.get(0));
        Place currentPlace = world.getCurrentPlace();
        Player player = world.getPlayer();

        String arg1 = null;
        String arg2 = null;

        if (player == null) {
            printErr("Fatal error, there is no player in the game !");
            throw new NullPointerException("Fatal error, there is no player in the game , stopping !");
        }

        if (currentPlace == null) {
            printErr("Fatal error, there is no current Place, stopping! ");
            throw new NullPointerException("Fatal error, there is no current Place, stopping !");
        }

        int nbArgs = args.size() - 1;


        if (nbArgs > 0) {
            arg1 = args.get(1);
            if (!haveEntity(world, arg1)) {
                printErr(arg1 + " does not exist");
                return ;
            }
        }

        if (nbArgs > 1) {
            arg2 = args.get(2);
            if (!haveEntity(world, arg2)) {
                printErr(arg2 + "does not exist");
                return ;
            }
        }

        switch (command) {
            case USE:
                if (nbArgs == 1)
                    use(player, arg1);
                else if (nbArgs == 2)
                    use(player, arg1, arg2);
                break;
            case GO:
                go(world, currentPlace, arg1);
                break;
            case DROP:
                drop(player, currentPlace, arg1);
                break;
            case HELP:
                help(command);
                break;
            case LOOK:
                if (nbArgs == 1)
                    look(currentPlace, arg1);
                if (nbArgs == 0)
                    look(currentPlace);
                break;
            case QUIT:
                quit(world);
                break;
            case SELL:
                buy(player, arg1, arg2);
                break;
            case BUY:
                sell(player, arg1, arg2);
                break;
            case TAKE:
                take(player, currentPlace, arg1);
                break;
            case ATTACK:
                attack(player, currentPlace, arg1);
                break;
            case INVENTORY:
                inventory(player);
                break;
        }

        // use [item] : player.use(item1)

        // use [item] [exit] :  player.use(item1, exit)

        // use [item1] [item2] : player.use(item1, item2)

        // help : help();

        // help [Commande] : help(Command c)

        // take [item] : player.take(getContainer(default).getItem(item))

        // take [container] [item] : player.take(container.getItem(item2))
        // take : player.addItem(currentPlace.getContainer.getItem(item)))

        // look : currentPlace.look()

        // look [arg1] : currentPlace.getEntity.look()

        // Inventory : player.look() / ou player.getDisplay() / ou player.draw()

        // GO [place] :
        // if currentPlace.canGo(getExit(place))
        //      world.setCurrentPlace(currentPlace.getExit(place))
        // else rien

        // drop [item] : getContainer.addItem(item)
        //             : player.removeItem(item)

        // attack [being] : fight(player, being)

        // Buy // todo

        // Sell // todo
    }

    static void use(Player player, String item) {
        player.use(player.getItem(item));
    }

    static void use(Player player, String item1, String item2) {
        player.use(item2, item2);
    }

    static void attack(Player player, Place currentPlace, String arg1) {
        // Being opponent = currentPlace
        // todo avec check null
        Fightable.fight(player, (Fightable) new Being(arg1));
    }

    static void take(Player player, Place currentPlace, String arg1) {
        // todo
    }

    static void quit(World  world) {
        world.end();
    }

    static void look(Place currentPlace) {
        currentPlace.look();
    }

    static void look(Place currentPlace, String arg1) {

        // todo avec check null
    }

    static void help(Command command) {
        // todo
    }

    static void drop(Player player, Place currentPlace, String arg1) {
        Item itemToDrop = player.getItem(arg1);
        player.removeItem(arg1);
        // currentPlace.addItemToPlace(itemToDrop);
        // todo check
    }

    static void go(World world, Place currPlace, String arg1) {

        if (!isPlace(world, arg1)) {
            printErr(arg1 + " is not a place");
            return;
        }

        Exit destination = currPlace.getExitByName(arg1);

        if (destination == null) {
            printErr("You can't access " + arg1 +" from here");
            return;
        }

        world.setCurrentPlace(destination.getDestination());
        printMsg("You enter " + destination.getName());
    }

    static void inventory(Player player) {
        printMsg(player.getDisplay());
    }

    static void sell(Player player, String arg1, String arg2) {
        // todo
    }

    static void buy(Player player, String arg1, String arg2) {
        // todo
    }


}


