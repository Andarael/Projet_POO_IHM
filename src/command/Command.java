package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import game.Interpreter;
import java.util.ArrayList;
import java.util.List;

public interface Command {

    public void execute();

    public void execute(Place p);

    public void execute(Item i);

    public void execute(Item i, Item i2);

    public void execute(Item item, Exit exit);

}


