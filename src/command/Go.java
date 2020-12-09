package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import world.World;
import game.Interpreter;

public abstract class Go implements Command {
    private final World world;

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

    public void execute(Item item, Exit exit){
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }

    @Override
    public void execute(Place p) {
        this.world.setCurrentPlace(p);
            p.display();
        }
    }
