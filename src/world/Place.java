package world;

import java.util.List;

import entity.Container;
import entity.Player;


public class Place {
    private final String name;
    private List<Exit> listExits;
    private List<Container> listContainers;
    private Player player;

    public Place(String name){
        this.name = name;
    }

    /* ------ méthodes ------*/

    public String getName() {
        return this.name;
    }

    public boolean hasPlayer() {
        return this.player != null;
    }

    public Player getPlayer() {
        return this.player;
    }



    /* ------ les Exits ------*/

    public void addExit(Exit exit){
        this.listExits.add(exit);
    }

    public Exit rmExit(Exit exit){
        this.listExits.remove(exit);
        return exit;
    }

    public boolean isEmptyExit(){
        return this.listExits.isEmpty();
    }

    public Boolean exitExists(String name){
        for(Exit exit : this.listExits){
            if (exit.destination.getName().equals(name)) return true;
        }
        return false;
    }

    public int nbExit(){
        return this.listExits.size();
    }

    public void displayExit() {
        for (int i = 0; i < this.nbExit(); i++) {
            System.out.println("- " + this.listExits.get(i).destination.getName());
        }
    }


    /* ------ les containers ------*/

    public void addContainer(Container container){
        this.listContainers.add(container);
    }

    public Container rmContainer(Container container){
        this.listContainers.remove(container);
        return container;
    }

    public boolean isEmptyContainer(){
        return this.listContainers.isEmpty();
    }

    public Boolean containerExists(String name){
        for(Container container : this.listContainers){
            if (container.getName().equals(name)) return true;
        }
        return false;
    }

    public int nbContainer(){
        return this.listContainers.size();
    }

    public void displayContainer() {
        for (int i = 0; i < this.nbContainer(); i++) {
            System.out.println("- " + this.listContainers.get(i).getName());
        }
    }



    public void display(){

    }







}
