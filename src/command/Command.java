package command;

import entity.place.Place;
import entity.place.Exit;
import entity.item.Item;

public interface Command {
    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);

    public void execute(Exit ex);
}


