package command;

import entity.item.Item;
import entity.place.Place;
import world.World;

public abstract class Use implements Command {
    private World world;

    public Use(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        System.out.println("Mauvaise utilisation de la commande \"use\"");
        System.out.println("Essayez plutot : use <objet> [objet]");
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"use\"");
        System.out.println("Essayez plutot : use <objet> [objet]");
    }

    /*
    @Override
    public void execute(Item i) {
        i.use(this.world);
    }
    */

    @Override
    public void execute(Item i, Item i2) {

    }
}