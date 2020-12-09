package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import world.World;
import entity.Player;

import java.util.List;

public abstract class Use implements Command {
    private final World world;
    private Player j;


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



    @Override
    public void execute(Item i) {



    }



    @Override
    public void execute(Item i, Item i2) {

                entity.Player.use(i, i2);

    }

    public void execute(Item i, Exit exit){
        entity.Player.use(i, exit);
    }


}