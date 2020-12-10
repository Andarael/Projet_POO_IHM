package command;

import entity.Player;
import entity.place.Place;
import world.World;

import java.util.List;

import static command.Attack.attack;
import static command.Command.getCommandFromString;
import static command.Command.isACommand;
import static command.Drop.drop;
import static command.Go.go;
import static command.Help.help;
import static command.Inv.inventory;
import static command.Look.look;
import static command.Quit.quit;
import static command.Take.take;
import static command.Trade.buy;
import static command.Trade.sell;
import static command.Use.use;
import static utils.Printer.printErr;
import static world.WorldContains.haveEntity;

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
            if (!(haveEntity(world, arg1) || isACommand(arg1))) {
                // todo faire marcher haveEntity avec name te ShortName
                printErr(arg1 + " does not exist(arg1)");
                return;
            }
        }

        if (nbArgs > 1) {
            arg2 = args.get(2);
            if (!haveEntity(world, arg2)) {
                printErr(arg2 + " does not exist (arg2)");
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

}


