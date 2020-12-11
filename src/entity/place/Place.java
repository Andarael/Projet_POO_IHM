// Fichier par Florian Portrait

package entity.place;

import entity.Container;
import entity.Entity;
import entity.StaticContainer;
import entity.item.Item;
import utils.Col;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Place extends Entity {

    private final int exitMax = 4;
    private final int containerMax = 10;
    private final List<Exit> listExits;
    private final List<Container> listContainers;
    private final StaticContainer placeContainer;

    public Place(String name, String shortName, String description) {
        super(name, shortName, description);

        //position dans la liste 0:top  1:left  2:right  3:bottom
        this.listExits = new ArrayList<>(this.exitMax);

        for (int i = 0; i < this.exitMax; i++)
            this.listExits.add(null);

        this.listContainers = new ArrayList<>(this.containerMax);
        this.placeContainer = new StaticContainer(name);
    }

    public Place(String name) {
        this(name, name, null);
    }

    /* ------ méthodes ------*/

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

        // here List.contains() is okay because an exit must have the same shortname as its destination
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
        this.listExits.set(position, null);

    }

    public Boolean exitExistName(String name) {
        return this.listExits.stream()
                             .anyMatch(exit -> exit != null &&
                                               exit.getDestination().isSameStr(name));
    }

    public Boolean exitExistIndex(int index) {
        return this.listExits.get(index) != null;
    }

    public Exit getExitByIndex(int index) {
        return this.listExits.get(index);
    }

    public Exit getExitByName(String name) {
        return this.listExits.stream()
                             .filter(exit -> exit != null &&
                                             exit.getDestination().isSameStr(name))
                             .findFirst()
                             .orElse(null);
    }

    public int getIndexExit(String name) {
        Exit temp;
        for (int i = 0; i < listExits.size(); i++) {
            temp = listExits.get(i);
            if (temp != null && temp.getDestination().isSameStr(name)) {
                return i;
            }
        }
        return -1;
    }

    public int nbExit() {
        return (int) listExits.stream()
                              .filter(Objects::nonNull)
                              .count();
    }



    /* ------ les containers ------*/

    public boolean containsContainer(Container container) {
        return listContainers.stream()
                             .anyMatch(x -> x.isSame(container));
    }

    public void addContainer(Container container) {
        if (containsContainer(container))
            return;

        if (this.nbContainer() < this.containerMax)
            this.listContainers.add(container);

    }

    public void rmContainer(Container container) {
        if (!this.isEmptyContainer()) {
            this.listContainers.remove(container);
        }
    }

    public boolean isEmptyContainer() {
        return this.listContainers.isEmpty();
    }

    public Boolean containerExists(String name) {
        for (Container container : this.listContainers) {
            if (container.isSameStr(name)) return true;
        }
        return false;
    }

    public Container getContainer(Container container) {
        return listContainers.stream()
                             .filter(x -> x.isSame(container))
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


    /* ------ le place container ------*/

    public void addItemToPlace(Item item) {
        if (item == null)
            return;
        this.placeContainer.addItem(item);
    }

    // =============================================================================================

    //todo make display work


    public String displayExitTopLine() {
        String lineTop;

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
        String lineMiddle;
        if (this.exitExistIndex(1)) {
            String str;
            if (this.getExitByIndex(1) instanceof LockedExit)
                str = "X";
            else
                str = "@";
            lineMiddle = StringUtils.leftPad(this.getExitByIndex(1).draw(), 0, ' ') +
                         StringUtils.leftPad(str, 0, ' ');
        } else {
            lineMiddle = StringUtils.leftPad("#", 5, ' ');
        }

        if (this.exitExistIndex(2)) {
            String str;
            if (this.getExitByIndex(2) instanceof LockedExit)
                str = "X";
            else
                str = "@";
            String line2 = StringUtils.leftPad(str, 12, ' ') +
                           StringUtils.leftPad(this.getExitByIndex(2).draw(), 1, ' ');
            lineMiddle = lineMiddle + line2 + "\n";

        } else {
            String line2 = StringUtils.leftPad("#", 12, ' ');
            lineMiddle = lineMiddle + line2 + "\n";
        }

        return lineMiddle;
    }

    public String displayExitBotLine() {
        String lineBot;

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
                    cpt = false;
                } else {
                    String line2 = StringUtils.leftPad("#", 5, ' ') +
                                   StringUtils.leftPad(this.getContainerByIndex(i).draw(), 6, ' ') +
                                   StringUtils.leftPad("#", 1, ' ');
                    lineContainers = lineContainers + line2 + "\n";
                    cpt = true;
                }
            }

        }


        return lineContainers;
    }


    @Override
    public String draw() {

        String top = this.displayExitTopLine();
        String middle = this.displayContainers();
        String bot = this.displayExitBotLine();

        System.out.println(top + middle + bot);
        return top + middle + bot;
    }


    @Override
    public String look() {
        return draw();
    }

    @Override
    public String toString() {
        return "Place{" +
               getDisplay() +
               ", exitMax=" + exitMax + "\n" +
               ", containerMax=" + containerMax + "\n" +
               ", listExits=" + listExits + "\n" +
               ", listContainers=" + listContainers + "\n" +
               ", placeContainer=" + placeContainer + "\n" +
               '}';
    }
}