package entity.place;

import java.util.ArrayList;
import java.util.List;

import entity.Container;
import entity.Entity;
import entity.Player;
import entity.StaticContainer;
import utils.Col;
import utils.StringUtils;


public class Place extends Entity {
    private final String name;
    private List<Exit> listExits;
    private final int exitMax = 4;
    private List<Container> listContainers;
    private final int containerMax = 4;
    private StaticContainer placeContainer;
    private Player player;


    public Place(String name){
        super(name);
        this.name = name;
        this.listExits = new ArrayList<>(this.exitMax);  //position dans la liste 0:top  1:left  2:right  3:bottom
        this.listContainers = new ArrayList<>(this.containerMax);
        this.placeContainer = new StaticContainer(name);
    }

    /* ------ méthodes ------*/

    public String getName() {
        return this.name;
    }


    /* ------ le player ------*/

    public boolean hasPlayer() {
        return this.player != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addPlayer(Player player1){
        if (!this.hasPlayer()) {
            this.player = player1;
        }
    }

    public void rmPlayer(){
        if(this.hasPlayer()){
            this.player = null;
        }
    }



    /* ------ les Exits ------*/

    public void addExit(Place place,int position){ //position dans la list = sa position dans la salle))
        if(this.nbExit()<this.exitMax) {
            Exit exit = new Exit(place);
            this.listExits.add(position,exit);
        }
    }

    public void addLockedExit(Place place,int position, Col color){
        if(this.nbExit()<this.exitMax) {
            Exit exit = new LockedExit(place,color);
            this.listExits.add(position,exit);
        }
    }

    public void rmExit(int numExit){
        this.listExits.remove(numExit);

    }

    public Boolean exitExistName(String name){
        for(Exit exit : this.listExits){
            if (exit.getName().equals(name)) return true;
        }
        return false;
    }

    public Boolean exitExistIndex(int index){
        if (this.listExits.get(index) != null) return true;

        return false;
    }

    public Exit getExitByIndex(int index){
        return this.listExits.get(index);
    }

    public Exit getExitByName(String name){
        for(Exit exit : this.listExits){
            if (exit.getName().equals(name)) return exit;
        }
        return null;
    }

    public int GetIndexExit(String name){
        int index = listExits.indexOf(name);
        return index;
    }

    public int nbExit(){
        return this.listExits.size();
    }

    public void displayExit() {
        for (int i = 0; i < this.nbExit(); i++) {
            //System.out.println("- " + this.listExits.get(i).destination.getName());
        }
    }


    /* ------ les containers ------*/

    public void addContainer(Container container){
        if(this.nbContainer()<this.containerMax) {
            this.listContainers.add(container);
        }

    }

    public Container rmContainer(Container container){
        if (!this.isEmptyContainer()) {
            this.listContainers.remove(container);
        }
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

    public Container getContainer(String name){
        for(Container container : this.listContainers){
            if (container.getName().equals(name)) return container;
        }
        return null;
    }

    public int nbContainer(){
        return this.listContainers.size();
    }

    public void displayContainer() {
        for (int i = 0; i < this.nbContainer(); i++) {
            //System.out.println("- " + this.listContainers.get(i).getName());
        }
    }

    //todo


    public String displayTopExitLine(){
        /* for(Container container : this.listContainers){
            if (container.getName().equals(name)) return true;
        }*/
        String line1 = StringUtils.leftPad("#",5,' ')+StringUtils.leftPad("..",5,'#')+StringUtils.leftPad("#",5,'#');
        return line1;
    }

    public String displayFirstLine(){
        //en cour de test
        String line1 = StringUtils.leftPad("#",5,' ')+StringUtils.leftPad("..",5,'#')+StringUtils.leftPad("#",5,'#');
        return line1;
    }

    public void draw(int nbContainer){
        if(this.nbContainer()<2){

        }else{
            if(this.nbContainer()<4){

            }
        }
    }




    public void display(){

    }







}