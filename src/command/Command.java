package command;

import world.Place;
import entity.item.Item;

public interface Command {
    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);
}


