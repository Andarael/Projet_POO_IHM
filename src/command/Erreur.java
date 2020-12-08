package command;



import entity.item.Item;
import world.Place;


public abstract class Erreur implements Command {

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