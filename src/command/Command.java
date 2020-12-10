package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import world.World;

import java.util.List;

public interface Command {

    static void execute(World world, List<String> args) {
        //todo
    }

    void execute();

    void execute(Place p);

    void execute(Item i);

    void execute(Item i, Item i2);

    void execute(Item item, Exit exit);

}


