package command;

import entity.Player;
import entity.item.Item;
import entity.place.Place;
import world.World;

import java.util.List;

import static command.Command.USE;
import static command.Command.getCommandFromString;

public interface Execute {

    static void execute(World world, List<String> args) {

        //todo prends une commande en STR et execute l'action

        Command command = getCommandFromString(args.get(0));

        switch (command) {
            case USE:
                //if ()
                break;
            case GO:
                // todo
                break;
            case DROP:
                // todo
                break;
            case HELP:
                // todo
                break;
            case LOOK:
                // todo
                break;
            case QUIT:
                // todo
                break;
            case SELL:
                // todo
                break;
            case BUY:
                // todo
                break;
            case TAKE:
                // todo
                break;
            case ATTACK:
                // todo
                break;
            case INVENTORY:
                // todo
                break;
        }

        // help : help();

        // help [Commande] : help(Command c)

        // use [item] : player.use(item1)

        // use [item] [exit] :  player.use(item1, exit)

        // use [item1] [item2] : player.use(item1, item2)

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
        //               player.removeItem(item)

        // attack [being] : fight(player, being)

        // Buy // todo

        // Sell // todo
    }

    static void execute(World world, Command c, Item item1) {
        Player player = world.getPlayer();
        Place currentPlace = world.getCurrentPlace();

        switch (c) {
            case USE:
                break;
            case GO:
        }

        if (c == USE)
            player.use(item1);
        // else if (c ==)

    }

}


