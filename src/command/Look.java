package command;

import world.Place;
import entity.item.Item;
import world.World;


public abstract class Look implements Command {
    private World world;

    public Look(World world) {
        this.world = world;
    }
    @Override
    public void execute() {
        this.world.getCurrentPlace().display();
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"look\"");
        System.out.println("Essayez plutot : look [objet]");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"look\"");
        System.out.println("Essayez plutot : look [objet]");
    }

}
