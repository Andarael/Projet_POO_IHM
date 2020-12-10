package entity.place;

import entity.Container;
import entity.Entity;
import entity.Player;
import entity.StaticContainer;
import entity.item.Item;
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
        for (int i = 0; i < this.exitMax; i++) {
            this.listExits.add(null);
        }

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


    /**
     * this add an exit to another place in the curent place
     *
     * @param place    the place to add an exit to
     * @param position the position in the place to add the exit
     */
    /* ------ les Exits ------*/
    //position dans la list = sa position dans la salle))
    public void addExit(Place place, int position) {
        Exit exitToAdd = new Exit(place);

        if (listExits.contains(exitToAdd))
            return;

        if (this.nbExit() < this.exitMax)
            this.listExits.set(position, exitToAdd);
    }

    public void addLockedExit(Place place, int position, Col color) {
        if (this.nbExit() < this.exitMax) {
            Exit exit = new LockedExit(place, color);
            this.listExits.set(position, exit);
        }
    }

    public void rmExit(int position) {
        this.listExits.set(position,null);

    }

    public Boolean exitExistName(String name) {
        for (Exit exit : this.listExits) {
            if (exit != null && (exit.destination.equals(new Place(name)))) return true;
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
            if (exit != null && (exit.destination.equals(new Place(name)))) return exit; //lazy evaluation
        }
        return null;
    }

    public int getIndexExit(String name) {
        return listExits.indexOf(new Place(name));
    }

    public int nbExit() {
        return (int) listExits.stream()
                              .filter(x -> x != null)
                              .count();
    }



    /* ------ les containers ------*/

    public void addContainer(Container container) {
        if (listContainers.contains(container))
            return;
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

    public Container getContainer(Container container) {
        return listContainers.stream()
                             .filter(x -> x.equals(container))
                             .findFirst()
                             .orElse(null);
    }

    public Container getContainerByName(String name) {
        return getContainer(new Container(name) {
        });
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

    /* ------ le place container ------*/

    public void addItemToPlace(Item item){
        if(item == null) return;
        this.placeContainer.addItem(item);
    }


    public String displayExitTopLine() {
        String lineTop = "";

        if (this.exitExistIndex(0)) {
            String str;
            if (this.getExitByIndex(1) instanceof LockedExit)
                str = "XX";
            else
                str = "@@";
            String line1 = StringUtils.leftPad(this.getExitByIndex(0).draw(), 10, ' ');
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad(str, 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineTop = line1 + "\n" + line2 + "\n";
        } else {
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad("##", 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineTop = line2 + "\n";
        }
        return lineTop;
    }

    public String displayExitMiddleLine() {
        String lineMiddle = "";
        if (this.exitExistIndex(1)) {
            String str;
            if (this.getExitByIndex(1) instanceof LockedExit)
                str = "X";
            else
                str = "@";
            String line1 = StringUtils.leftPad(this.getExitByIndex(0).draw(), 0, ' ');
            lineMiddle = line1;
        } else {
            String line1 = StringUtils.leftPad("#", 5, ' ');
            lineMiddle = line1;
        }

        if (this.exitExistIndex(2)) {
            String str;
            if (this.getExitByIndex(2) instanceof LockedExit)
                str = "X";
            else
                str = "@";
            String line2 = StringUtils.leftPad(str, 12, ' ') +
                           StringUtils.leftPad(this.getExitByIndex(2).draw(), 0, ' ');
            lineMiddle = lineMiddle + line2 + "\n";

        } else {
            String line2 = StringUtils.leftPad("#", 12, ' ');
            lineMiddle = lineMiddle + line2 + "\n";
        }

        return lineMiddle;
    }

    public String displayExitBotLine() {
        String lineBot = "";

        if (this.exitExistIndex(3)) {
            String str;
            if (this.getExitByIndex(3) instanceof LockedExit)
                str = "XX";
            else
                str = "@@";
            String line1 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad(str, 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            String line2 = StringUtils.leftPad(this.getExitByIndex(3).draw(), 10, ' ');

            lineBot = line1 + "\n" + line2 + "\n";
        } else {
            String line1 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad("##", 5, '#') +
                           StringUtils.leftPad("#", 5, '#');
            lineBot = line1 + "\n";
        }
        return lineBot;
    }


    public String displayContainers() {
        String lineContainers = "";
        if (this.isEmptyContainer()) {
            String line2 = StringUtils.leftPad("#", 5, ' ') +
                           StringUtils.leftPad("#", 12, ' ');
            lineContainers = line2 + "\n";
        } else {
            int toPlaceMiddle = this.nbContainer() / 2;
            boolean cpt = true;
            for (int i = 0; i < this.nbContainer(); i++) {
                if (i == toPlaceMiddle) {
                    lineContainers = lineContainers + this.displayExitMiddleLine();
                }

                if (cpt) {
                    String line2 = StringUtils.leftPad("#", 5, ' ') +
                                   StringUtils.leftPad(this.getContainerByIndex(i).draw(), 1, ' ') +
                                   StringUtils.leftPad("#", 6, ' ');
                    lineContainers = lineContainers + line2 + "\n";
                }
            }

        }


        return lineContainers;
    }


    public void testDisplay() {

        String top = this.displayExitTopLine();
        String middle = this.displayExitMiddleLine();
        String bot = this.displayExitBotLine();

        System.out.println(top + "\n" + middle + "\n" + bot);
    }


    public void display() {

    }

    @Override
    public String look() {
        return draw();
    }

    @Override
    public String toString() {
        return "Place{" +
               "name='" + name + '\'' + "\n" +
               ", exitMax=" + exitMax + "\n" +
               ", containerMax=" + containerMax + "\n" +
               ", listExits=" + listExits + "\n" +
               ", listContainers=" + listContainers + "\n" +
               ", placeContainer=" + placeContainer + "\n" +
               ", player=" + player +
               '}';
    }
}