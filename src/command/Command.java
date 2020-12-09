package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;

public interface Command {
    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);

    public void execute(Exit ex);
}


