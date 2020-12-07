package command;

import entity.item.Item;
import world.Place;
import world.World;

public class Quit implements Command {
    private World world;

    public Quit(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        this.world.end();
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"quit\"");
        System.out.println("Essayez plutot : quit");
    }

    @Override
    public void execute(Item i) {
        System.out.println("Mauvaise utilisation de la commande \"quit\"");
        System.out.println("Essayez plutot : quit");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"quit\"");
        System.out.println("Essayez plutot : quit");
    }
}