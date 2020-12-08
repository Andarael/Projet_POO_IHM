package command;

import world.Place;
import world.Exit;
import entity.item.Item;

public interface Command {
    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);

    public void execute(Exit ex);
}


