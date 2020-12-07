package command;

import entity.item.Item;
import world.Place;
import inventory.Inventory;

public class Take implements Command {

    private Inventory inv;

    public Take(Inventory inv){
        this.inv = inv;
    }

    @Override
    public void execute() {
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }

    @Override
    public void execute(Item i) {
        this.inv.addItem(i);
        System.out.println("Vous avez recupere un/une "+i.getName());
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }
}
