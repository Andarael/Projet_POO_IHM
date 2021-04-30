// Fichier par Florian Portrait

package shadowLair.model.entity.place;

import shadowLair.model.entity.*;
import shadowLair.model.entity.item.Item;
import shadowLair.model.utils.Col;
import shadowLair.model.utils.Printer;
import shadowLair.model.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Place extends Entity {

    private final int exitMax = 4;
    private final int containerMax = 3;
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


    /* ------ les Exits ------*/

    /**
     * this add an exit to another place in the curent place
     *
     * @param place    the place to add an exit to
     * @param position the position in the place to add the exit
     */
    public void addExit(Place place, int position) {
        Exit exitToAdd = new Exit(place);

        // here List.contains() is okay because an exit must have the same shortname as its destination
        if (listExits.contains(exitToAdd))
            return;

        if (this.nbExit() < this.exitMax)
            this.listExits.set(position, exitToAdd);
    }

    /**
     * this add an locked exit to another place in the curent place
     *
     * @param place    the place to add an exit to
     * @param position the position in the place to add the exit
     * @param color    the color of the locked exit (which requires a key of the same color to be unlocked)
     */
    public void addLockedExit(Place place, int position, Col color) {
        if (this.nbExit() < this.exitMax) {
            Exit exit = new LockedExit(place, color);
            this.listExits.set(position, exit);
        }
    }

    /**
     * this remove an exit from the curent place
     *
     * @param position the desired exit position in the list (0:top  1:left  2:right  3:bottom)
     */
    public void rmExit(int position) {
        this.listExits.set(position, null);

    }

    /**
     * checks if an exit is in curent place
     *
     * @param name the name of the desired exit
     * @return true if exit is in curent place
     */
    public Boolean exitExistName(String name) {
        return this.listExits.stream()
                             .anyMatch(exit -> exit != null &&
                                               exit.getDestination().isSameStr(name));
    }

    /**
     * checks if at a certain position in the curent place there is an exit
     *
     * @param index the desired exit position in the list (0:top  1:left  2:right  3:bottom)
     * @return true if there is an exit at the given position
     */
    public Boolean exitExistIndex(int index) {
        return this.listExits.get(index) != null;
    }

    /**
     * this retrieve exit  by its position in the curent place
     *
     * @param index the desired exit position in the list (0:top  1:left  2:right  3:bottom)
     * @return the obj exit if there is
     */
    public Exit getExitByIndex(int index) {
        return this.listExits.get(index);
    }

    /**
     * this retrieve exit in the curent place by its name
     *
     * @param name the name of the desired exit
     * @return the obj exit if there is
     */
    public Exit getExitByName(String name) {
        return this.listExits.stream()
                             .filter(exit -> exit != null &&
                                             exit.getDestination().isSameStr(name))
                             .findFirst()
                             .orElse(null);
    }

    /**
     * this retrieve the exit position in the curent place
     *
     * @param name the name of the desired exit
     * @return int (the exit position in the list)
     */
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

    /**
     * this retrieve the quantity of exit in the curent place
     *
     * @return int quantity of exit
     */
    public int nbExit() {
        return (int) listExits.stream()
                              .filter(Objects::nonNull)
                              .count();
    }

    public void displayExit() {
        Printer.printMsg("= The exits in this place = \n");
        for (int i = 0; i < this.exitMax; i++) {
            if (this.getExitByIndex(i) != null) {
                Printer.printMsg(this.getExitByIndex(i).getDisplay() + "\n");
            }
        }


    }

    public List<Exit> getListExits() {
        return this.listExits;
    }

    /* ------ les containers ------*/

    /**
     * check if there are particular containers in the curent place
     *
     * @param container the desired container (obj)
     * @return true if the container is in curent place
     */
    public boolean containsContainer(Container container) {
        return listContainers.stream()
                             .anyMatch(x -> x.isSame(container));
    }

    /**
     * this add a container in the curent place
     *
     * @param container the container you want to add
     */
    public void addContainer(Container container) {
        if (!this.listContainers.isEmpty()) {
            if (containsContainer(container))
                return;
        }
        if (this.nbContainer() < this.containerMax){
            this.listContainers.add(container);
        }
    }

    /**
     * this remove container from curent place
     *
     * @param container the container you want to remove
     */
    public void removeContainer(Container container) {
        if (!this.isEmptyListContainer()) {
            this.listContainers.remove(container);
        }
    }

    /**
     * check if there are containers in the curent place
     *
     * @return true if there are no containers
     */
    public boolean isEmptyListContainer() {
        return this.listContainers.isEmpty();
    }

    /**
     * checks if your container is in the curent place
     *
     * @param name the name of container you want to check
     * @return true if your container is in the place
     */
    public Boolean containerExists(String name) {
        for (Container container : this.listContainers) {
            if (container.isSameStr(name)) return true;
        }
        return false;
    }

    /**
     * this retrieve the container you want in the curent place
     *
     * @param container the container you want to retrieve
     * @return the container you want to retrieve
     */
    public Container getContainer(Container container) {
        return listContainers.stream()
                             .filter(x -> x.isSame(container))
                             .findFirst()
                             .orElse(null);
    }

    /**
     * this retrieve the container you want in the curent place
     *
     * @param name the name of the container you want
     * @return the container you want
     */
    public Container getContainerByName(String name) {
        return getContainer(new Container(name) {
        });
    }

    /**
     * this retrieve the container you want in the curent place
     *
     * @param index the position in the list of your container
     * @return the container at this position
     */
    public Container getContainerByIndex(int index) {
        return this.listContainers.get(index);
    }

    /**
     * this retrieve the quantity of container in the curent place
     *
     * @return int quantity of container
     */
    public int nbContainer() {
        return this.listContainers.size();
    }

    public void displayDescContainer() {
        Printer.printMsg("= You see in the place = \n");
        for (Container container : this.listContainers) {
            if (container instanceof Hostile) {
                Printer.printMsg("Hostil :");
                Printer.printMsg(container.getSimpleDisplay());
            }
            if (container instanceof Passive) {
                Printer.printMsg("Passive:");
                Printer.printMsg(container.getSimpleDisplay());
            }
        }
    }

    public List<Container> getListContainers() {
        return listContainers;
    }

    /* ------ le place container ------*/

    /**
     * this retrieve the static container associated with the curent place
     *
     * @return the static container
     */
    public StaticContainer getPlaceContainer() {
        return placeContainer;
    }

    /**
     * this add an item to the placeContainer of the curent place
     *
     * @param item the item you want to add at the placeContainer
     */
    public void addItemToPlace(Item item) {
        if (item == null)
            return;
        this.placeContainer.addItem(item);
    }

    public void addGoldToPlace(int nbGold) {
        if (nbGold < 0)
            return;
        placeContainer.addGold(nbGold);
    }

    public void displayPlaceContainer() {
        if (!this.getPlaceContainer().isEmpty()) {
            Printer.printMsg("\n= And on the ground = \n");
            Printer.printMsg(this.getPlaceContainer().getInventoryDisplay());
        }
    }


    public Hostile getAgressive() {
        return (Hostile) this.listContainers.stream()
                                            .filter(actualElement -> actualElement instanceof Hostile)
                                            .filter(actualElement -> ((Hostile) actualElement).isAgressive())
                                            .findFirst()
                                            .orElse(null);
    }

    // Display
    // =============================================================================================

    /**
     * this form the top wall and the exit of the curent place
     *
     * @return the drawing in string
     */
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

    /**
     * this form the middle wall and exit of the curent place
     *
     * @return the drawing  in string
     */
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

    /**
     * this form the bottom wall and exit of the curent place
     *
     * @return the drawing  in string
     */
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

    /**
     * this form the container (with middle line) of the curent place
     *
     * @return the drawing  in string
     */
    public String displayContainers() {
        String lineContainers = "";
        if (this.isEmptyListContainer()) {
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

    /**
     * it displays all the drawing of the curent place and descriptions
     *
     * @return all the drawing in string
     */
    @Override
    public String draw() {

        String top = this.displayExitTopLine();
        String middle = this.displayContainers();
        String bot = this.displayExitBotLine();

        Printer.printMsg("---> " + this.getName() + "\n");
        Printer.printMsg(top + middle + bot);

        this.displayDescContainer();
        this.displayPlaceContainer();
        this.displayExit();
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