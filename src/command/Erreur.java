package command;
import entity.item.Item;
import entity.place.Place;

import java.util.List;


public interface Erreur {



    @Override
    public void execute() {
        System.out.println("Commande non reconnue, tapez help pour voir la liste des commandes");
    }

    @Override
    public void execute(Place p) {
        System.out.println("Commande non reconnue, tapez help pour voir la liste des commandes");
    }

    @Override
    public void execute(Item i) {
        System.out.println("Commande non reconnue, tapez help pour voir la liste des commandes");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Commande non reconnue, tapez help pour voir la liste des commandes");
    }

}