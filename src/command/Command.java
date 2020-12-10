package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import world.World;

import java.util.List;

public interface Command extends Erreur, Go, Help, Inv, Look, Quit, Take, Use, Attack, Buy, Sell{

    static void execute(World world, List<String> args) {
        //todo
    }

    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);

    public void execute(Item item, Exit exit);

}


