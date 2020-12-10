package command;

import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;
import inventory.Inventory;

import java.util.List;

public interface Take {

    static being

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

    public void execute(Item item, Exit exit){
        System.out.println("Mauvaise utilisation de la commande \"take\"");
        System.out.println("Essayez plutot : take <objet>");
    }


    being.talk

}
