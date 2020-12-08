package command;

import entity.Being;
import entity.item.Item;
import world.Main;
import world.Place;
import entity.Entity;

public class Inv implements Command {
    private Being enti;

    public Inv(Being player) {
        this.enti = player;
    }

    @Override
    public void execute() {
        Main.cleanScreen();
        System.out.println("PV : "+this.enti.getHP());
        System.out.println("PO : "+this.enti.getGold());
        System.out.print("Weapon : ");
/*        this.enti.getWeapon().getDisplay();
        enti.getInventory().getInvDisplayDetails();*/
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
