package command;

import entity.Being;
import entity.Entity;
import entity.Player;
import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import interfaces.Fightable;
import world.World;

import java.util.List;

import static command.Command.*;
import static utils.Col.GREEN;
import static utils.Col.colorize;
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
            throw new NullPointerException(
                    "Fatal error, there is no player in the game , stopping !");
        }

        if (currentPlace == null) {
            printErr("Fatal error, there is no current Place, stopping! ");
            throw new NullPointerException("Fatal error, there is no current Place, stopping !");
        }

        int nbArgs = args.size() - 1;


        if (nbArgs > 0) {
            arg1 = args.get(1);
            if (!(haveEntity(world, arg1) || isACommand(arg1)) ) {
                printErr(arg1 + " does not exist");
                return;
            }
        }

        if (nbArgs > 1) {
            arg2 = args.get(2);
            if (!haveEntity(world, arg2)) {
                printErr(arg2 + " does not exist");
                return;
            }
        }

        switch (command) {
            case USE:
                if (nbArgs == 1)
                    use(player, arg1);
                else if (nbArgs == 2)
                    use(world, player, arg1, arg2);
                break;

            case GO:
                go(world, currentPlace, arg1);
                break;

            case DROP:
                drop(player, currentPlace, arg1);
                break;

            case HELP:
                if (nbArgs == 0)
                    help();
                if (nbArgs == 1)
                    help(arg1);
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
                if (nbArgs == 1)
                    take(player, currentPlace, arg1);
                if (nbArgs == 2)
                    take(player, currentPlace, arg1, arg2);
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
        player.use(item);
    }

    static void use(World world, Player player, String item1, String arg2) {

        // if arg2 is a place we can reach, we call use(Item, Exit)
        // else we call the default use(item, item)
        if (isPlace(world, arg2)) {
            Exit exit = world.getCurrentPlace().getExitByName(arg2);
            if (exit != null)
                player.use(item1, exit);
            else
                printErr(arg2 + " is not reachable from here");
        } else {
            player.use(item1, arg2);
        }
    }

    static void attack(Player player, Place currentPlace, String arg1) {
        // Being opponent = currentPlace.getBeing
        // todo avec check null
        Fightable.fight(player, new Being(arg1));
    }

    static void take(Player player, Place currentPlace, String container, String item) {
        //todo
    }

    static void take(Player player, Place currentPlace, String item) {
        // todo
    }

    static void quit(World world) {
        world.end();
    }

    static void look(Place currentPlace) {
        currentPlace.look();
    }

    static void look(Place currentPlace, String arg1) {
        Entity entity = currentPlace.getContainerByName(arg1);
        if (entity != null) {
            entity.look();
        } else {
            printErr("You can't look at" + arg1);
        }
    }

    static void help(String arg) {
        if (! isACommand(arg)) {
            printErr(arg + " is not a command");
            help("help");
        }
        else {
            printMsg(colorize(getCommandFromString(arg).getCommandUsage(), GREEN));
        }
    }

    static void help() {
        help("help");
    }

    static void drop(Player player, Place currentPlace, String arg1) {
        Item itemToDrop = player.getItem(arg1);
        player.removeItem(arg1);
        currentPlace.addItemToPlace(itemToDrop);
        // todo check & display
    }

    static void go(World world, Place currPlace, String arg1) {

        if (!isPlace(world, arg1)) {
            printErr(arg1 + " is not a place");
            return;
        }

        Exit destination = currPlace.getExitByName(arg1);

        if (destination == null) {
            printErr("You can't access " + arg1 + " from here");
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


