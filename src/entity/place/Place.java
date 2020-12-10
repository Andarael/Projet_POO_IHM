package entity.place;

import entity.Container;
import entity.Entity;
import entity.Player;
import entity.StaticContainer;
import utils.Col;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class Place extends Entity {
    private final String name;
    private final int exitMax = 4;
    private final int containerMax = 4;
    private final List<Exit> listExits;
    private final List<Container> listContainers;
    private final StaticContainer placeContainer;
    private Player player;


    public Place(String name) {
        super(name);
        this.name = name;
        this.listExits = new ArrayList<>(this.exitMax);  //position dans la liste 0:top  1:left  2:right  3:bottom
        this.listContainers = new ArrayList<>(this.containerMax);
        this.placeContainer = new StaticContainer(name);
    }

    /* ------ méthodes ------*/

    /* ------ le player ------*/

    public boolean hasPlayer() {
        return this.player != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addPlayer(Player player1) {
        if (!this.hasPlayer()) {
            this.player = player1;
        }
    }

    public void rmPlayer() {
        if (this.hasPlayer()) {
            this.player = null;
        }
    }



    /* ------ les Exits ------*/

    public void addExit(Place place, int position) { //position dans la list = sa position dans la salle))
        if (this.nbExit() < this.exitMax) {
            Exit exit = new Exit(place);
            this.listExits.add(position, exit);
        }
    }

    public void addLockedExit(Place place, int position, Col color) {
        if (this.nbExit() < this.exitMax) {
            Exit exit = new LockedExit(place, color);
            this.listExits.add(position, exit);
        }
    }

    public void rmExit(int numExit) {
        this.listExits.remove(numExit);

    }

    public Boolean exitExistName(String name) {
        for (Exit exit : this.listExits) {
            if (exit.getName().equals(name)) return true;
        }
        return false;
    }

    public Boolean exitExistIndex(int index) {
        return this.listExits.get(index) != null;
    }

    public Exit getExitByIndex(int index) {
        return this.listExits.get(index);
    }

    public Exit getExitByName(String name) {
        for (Exit exit : this.listExits) {
            if (exit.getName().equals(name)) return exit;
        }
        return null;
    }

    public int GetIndexExit(String name) {
        int index = listExits.indexOf(name);
        return index;
    }

    public int nbExit() {
        return this.listExits.size();
    }

    public void displayExit() {
        for (int i = 0; i < this.nbExit(); i++) {
            //System.out.println("- " + this.listExits.get(i).destination.getName());
        }
    }


    /* ------ les containers ------*/

    public void addContainer(Container container) {
        if (this.nbContainer() < this.containerMax) {
            this.listContainers.add(container);
        }

    }

    public Container rmContainer(Container container) {
        if (!this.isEmptyContainer()) {
            this.listContainers.remove(container);
        }
        return container;
    }

    public boolean isEmptyContainer() {
        return this.listContainers.isEmpty();
    }

    public Boolean containerExists(String name) {
        for (Container container : this.listContainers) {
            if (container.getName().equals(name)) return true;
        }
        return false;
    }

    public Container getContainerByString(String name) {
        for (Container container : this.listContainers) {
            if (container.getName().equals(name)) return container;
        }
        return null;
    }
    public Container getContainerByIndex(int index) {
        return this.listContainers.get(index);
    }

    public int nbContainer() {
        return this.listContainers.size();
    }

    public void displayContainer() {
        for (int i = 0; i < this.nbContainer(); i++) {
            //System.out.println("- " + this.listContainers.get(i).getName());
        }
    }





    public String displayExitTopLine(){
        String lineTop ="";

        if (this.exitExistIndex(0)){
            String str;
            if (this.getExitByIndex(1) instanceof LockedExit)
                str = "XX";
            else
                str = "@@";
            String line1 = StringUtils.leftPad(this.getExitByIndex(0).draw(), 5, ' ');
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad(str, 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineTop = line1 + "\n" + line2;
        }else{
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad("##", 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineTop = line2;
        }
        return lineTop;
    }

    public String displayExitMiddleLine(){
        String lineMiddle ="";
        if (this.exitExistIndex(1)) {
            String str;
            if (this.getExitByIndex(1) instanceof LockedExit)
                str = "X";
            else
                str = "@";
            String line1 = StringUtils.leftPad(this.getExitByIndex(0).draw(), 0, ' ');
            lineMiddle = line1;
        }else{
            String line1 = StringUtils.leftPad("#", 5, ' ');
            lineMiddle = line1;
        }

            if (this.exitExistIndex(2)){
                String str;
                if (this.getExitByIndex(2) instanceof LockedExit)
                    str = "X";
                else
                    str = "@";
            String line2 = StringUtils.leftPad(str, 12, ' ') +
            StringUtils.leftPad(this.getExitByIndex(2).draw(), 0, ' ');
            lineMiddle = lineMiddle + line2;

        }else{
                String line2 = StringUtils.leftPad("#", 12, ' ');
                lineMiddle = lineMiddle + line2;
            }

        return lineMiddle;
    }

    public String displayExitBotLine(){
        String lineBot ="";

        if (this.exitExistIndex(3)){
            String str;
            if (this.getExitByIndex(3) instanceof LockedExit)
                str = "XX";
            else
                str = "@@";
            String line1 = StringUtils.leftPad(this.getExitByIndex(3).draw(), 5, ' ');
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad(str, 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineBot = line1 + "\n" + line2;
        }else{
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad("##", 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineBot = line2;
        }
        return lineBot;
    }



    public void testDisplay() {
        /*if (this.nbContainer() < 2) {

        } else {
            if (this.nbContainer() < 4) {

            }
        }*/
        String top = this.displayExitTopLine();
        String middle = this.displayExitMiddleLine();
        String bot = this.displayExitBotLine();

        System.out.println(top + "\n" + middle + "\n" + bot);
    }

    //todo ajouter de quoi récupérer une exit par son nom
    // pour la méthode use(Exit) de Key et pour Player qui l'appel


    public void display() {

    }


}