// fichier par josué et Thibaut

package model.command;

import model.entity.Player;
import model.entity.place.Place;
import model.world.World;

import java.util.List;

import static model.command.Attack.attack;
import static model.command.Command.getCommandFromString;
import static model.command.Command.isACommand;
import static model.command.Drop.drop;
import static model.command.EquipUnequip.equip;
import static model.command.EquipUnequip.unequip;
import static model.command.Go.go;
import static model.command.Help.help;
import static model.command.Inv.inventory;
import static model.command.Look.look;
import static model.command.Quit.quit;
import static model.command.Take.take;
import static model.command.Talk.talk;
import static model.command.Trade.buy;
import static model.command.Trade.sell;
import static model.command.Use.use;
import static model.utils.Printer.printErr;
import static model.world.WorldContains.haveEntity;

public interface Execute {

    static String execute(World world, List<String> args) throws NullPointerException {

        if (world == null || args == null) {
            printErr("World or command arguments are null, stopping Now !");
            throw new NullPointerException("World or command arguments are null, stopping !");
        }

        if (args.size() == 0)
            return null;

        Command command = getCommandFromString(args.get(0));
        Place currentPlace = world.currentPlace;
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
                return printErr(arg1 + " does not exist");
            }
        }

        if (nbArgs > 1) {
            arg2 = args.get(2);
            if (!haveEntity(world, arg2)) {
                return printErr(arg2 + " does not exist");
            }
        }

        switch (command) {
            case USE:
                if (nbArgs == 1)
                    return use(player, arg1);
                else if (nbArgs == 2)
                    return use(world, player, arg1, arg2); // this does not fall through despite what the warning says

            case GO:
                return go(world, currentPlace, arg1); // nor does this

            case DROP:
                return drop(player, currentPlace, arg1);

            case HELP:
                if (nbArgs == 0)
                    help();
                if (nbArgs == 1)
                    help(arg1);
                break;

            case LOOK:
                if (nbArgs == 1)
                    return look(currentPlace, arg1);
                if (nbArgs == 0)
                    return look(currentPlace);
                break;

            case QUIT:
                quit(world);
                break;

            case SELL:
                return sell(player, currentPlace, arg1, arg2);

            case BUY:
                return buy(player, currentPlace, arg1, arg2);

            case TAKE:
                if (nbArgs == 0)
                    return take(player, currentPlace);
                if (nbArgs == 1)
                    return take(player, currentPlace, arg1);
                if (nbArgs == 2)
                    return take(player, currentPlace, arg1, arg2);
                break;

            case ATTACK:
                return attack(player, currentPlace, arg1);

            case INVENTORY:
                inventory(player);
                break;

            case TALK:
                return talk(currentPlace, arg1);

            case EQUIP:
                return equip(player, arg1);

            case UNEQUIP:
                return unequip(player);

            default:
                return printErr("this command is not implemented yet ..");
        }

        return null;
    }

}


