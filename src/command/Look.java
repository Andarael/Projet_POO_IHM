package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import world.World;

import java.util.List;


public abstract class Look implements Command {
    private final World world;

    public Look(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        this.world.getCurrentPlace().display();
    }

    @Override
    public void execute(Place p) {
        this.world.getPlace(p).display();
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"look\"");
        System.out.println("Essayez plutot : look [objet]");
    }

    public void execute(Item item, Exit exit){
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }

}
