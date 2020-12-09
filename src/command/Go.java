package command;

import entity.item.Item;
import world.World;

public abstract class Go implements Command{
    private World world;

    public Go(World world) {
        this.world = world;
    }

    @Override
    public void execute() {
        System.out.println("Mauvaise utilisation de la commande \"go\"");
        System.out.println("Essayez plutot : go <direction>");
    }


    @Override
    public void execute(Item i) {
        System.out.println("Mauvaise utilisation de la commande \"go\"");
        System.out.println("Essayez plutot : go <direction>");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"go\"");
        System.out.println("Essayez plutot : go <direction>");
    }

}