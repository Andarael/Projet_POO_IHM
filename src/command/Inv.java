package command;

import entity.Being;
import entity.Player;
import entity.item.Item;
import entity.place.Place;
import world.Main;
import entity.item.Weapon;
import inventory.Inventory;

import java.util.List;

public abstract class Inv implements Command {
    private final Being enti;
    private Inventory inven;
    private Player joueur;

    public Inv(Being player) {
        this.enti = player;
    }

    @Override
    public void execute() {
        joueur.getDisplay();
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"inv\"");
        System.out.println("Essayez plutot : inv");
    }

    @Override
    public void execute(Item i) {
        System.out.println("Mauvaise utilisation de la commande \"inv\"");
        System.out.println("Essayez plutot : inv");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"inv\"");
        System.out.println("Essayez plutot : inv");
    }


}
