package command;

import entity.item.Item;
import world.Main;
import entity.place.Place;

public abstract class Help implements Command {

    @Override
    public void execute() {
        Main.cleanScreen();
        System.out.println("Liste des commandes :");
        System.out.println("- go <direction>      : permet de se deplacer dans une salle adjacente");
        System.out.println("- help                : affiche la liste des commandes");
        System.out.println("- look                : donne une description de la piece");
        System.out.println("- look <objet>        : donne un descriptif de l'objet");
        System.out.println("- take <objet>        : recupere l'objet et le place dans l'inventaire");
        System.out.println("- quit                : quitte la partie");
        System.out.println("- use <objet>         : utilise l'objet");
        System.out.println("- use <objet> <objet> : utilise les deux objets si une combinaison est possible");
        System.out.println("- inv                 : affiche l'inventaire du joueur");
    }

    @Override
    public void execute(Place p) {
        System.out.println("Mauvaise utilisation de la commande \"help\"");
        System.out.println("Essayez plutot : help");
    }

    @Override
    public void execute(Item i) {
        System.out.println("Mauvaise utilisation de la commande \"help\"");
        System.out.println("Essayez plutot : help");
    }

    @Override
    public void execute(Item i, Item i2) {
        System.out.println("Mauvaise utilisation de la commande \"help\"");
        System.out.println("Essayez plutot : help");
    }

}
