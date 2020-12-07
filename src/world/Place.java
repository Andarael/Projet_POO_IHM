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

    public void addExit(Exit exit){
        this.listExits.add(exit);
    }

    public Boolean exitExists(String name){
        for(Exit exit : this.listExits){
            if (exit.destination.getName().equals(name)) return true;
        }
        return false;
    }

    public void addContainer(Container container){
        this.listContainers.add(container);
    }


    public String getName() {
        return name;
    }

    public boolean hasPlayer() {
        return this.player != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void display() {
    }


}
