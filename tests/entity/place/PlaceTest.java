// Fichier par Florian Portrait

package entity.place;

import entity.Container;
import entity.Hostile;
import entity.Player;
import entity.StaticContainer;
import entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class PlaceTest {

    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;

    private Container cont1;
    private Container cont2;
    private Container cont3;
    private Container cont4;
    private Container cont5;
    private Container cont6;
    private Container cont7;
    private Container cont8;
    private Container cont9;


    private Item item1;

    @BeforeEach
    void setUp() {

        place1 = new Place("Tavern");
        place2 = new Place("Cave");
        place3 = new Place("Laboratory");
        place4 = new Place("Room");

        cont1 = new Container("Skeleton"){};
        cont2 = new Container("Monster"){};
        cont3 = new Container("Spider"){};
        cont4 = new Container("Merchant"){};
        cont5 = new Container("Thief"){};
        cont6 = new Container("Murlock"){};
        cont7 = new Container("Tauren"){};
        cont8 = new Container("OldMan"){};
        cont9 = new Container("YoungMan"){};



        place2.addContainer(cont1);
        place3.addContainer(cont1);
        place3.addContainer(cont2);


        place2.addExit(place1,0);
        place3.addExit(place2,1);
        place3.addExit(place1,3);

        item1 = new Item("golden statue",
                         "gStat",
                         "a small statue with a frightful effigy",
                         1,
                         2);


    }


    @Test
    void addExit() {
        assertSame(null,place1.getExitByIndex(1));
        place1.addExit(place3,1);
        place1.addExit(place2,3);

        System.out.println(place1);

        assertEquals(new Exit(place3),place1.getExitByName("Laboratory"));
        assertEquals(new Exit(place2),place1.getExitByIndex(3));

        System.out.println(place3);
        place3.addExit(place1,0);
        System.out.println(place3);

    }

    @Test
    void addLockedExit() {
        assertSame(null,place1.getExitByIndex(1));
        place1.addLockedExit(place3,1,RED);
        place1.addLockedExit(place2,3,BLUE);

        System.out.println(place1);


        assertEquals(new LockedExit(place3,RED),place1.getExitByName("Laboratory"));
        assertEquals(new LockedExit(place3,RED),place1.getExitByIndex(1));
        assertEquals(new LockedExit(place2,BLUE),place1.getExitByIndex(3));

    }

    @Test
    void rmExit() {
        place1.addLockedExit(place3,1,RED);
        place1.addLockedExit(place2,3,BLUE);
        System.out.println(place1);

        place1.rmExit(1);
        assertNull(place1.getExitByIndex(1));
        System.out.println(place1);
    }

    @Test
    void exitExistName() {
        assertFalse(place1.exitExistName("Laboratory"));
        assertTrue(place2.exitExistName("Tavern"));
        assertTrue(place3.exitExistName("Cave"));
        assertTrue(place3.exitExistName("cave"));
    }

    @Test
    void exitExistIndex() {
        assertFalse(place1.exitExistIndex(1));
        assertTrue(place2.exitExistIndex(0));
        assertTrue(place3.exitExistIndex(1));
        assertTrue(place3.exitExistIndex(3));
    }

    @Test
    void getExitByIndex() {
        System.out.println(place2.getExitByIndex(0));
        assertEquals(new Exit(place1),place2.getExitByIndex(0));
    }

    @Test
    void getExitByName() {
        assertEquals(new Exit(place1),place2.getExitByName("Tavern"));
        System.out.println(place2.getExitByName("Tavern"));
        assertEquals(new Exit(place2),place3.getExitByName("Cave"));
        System.out.println(place3.getExitByName("Cave"));
    }

    @Test
    void getIndexExit() {
        assertEquals(1,place3.getIndexExit("Cave"));
        assertEquals(-1,place3.getIndexExit("Nop"));

    }

    @Test
    void nbExit() {
        assertEquals(2,place3.nbExit());
    }


    @Test
    void addContainer() {
        System.out.println(place1);
        place1.addContainer(cont1);
        System.out.println(place1);
        place1.addContainer(cont2);
        place1.addContainer(cont3);
        System.out.println(place1);
        assertEquals(cont1,place1.getContainer(cont1));

        assertNull(place2.getContainer(cont3));
        place2.addContainer(cont3);
        place2.addContainer(cont3);
        System.out.println(place2);
    }

    @Test
    void rmContainer() {
        place1.addContainer(cont1);
        System.out.println(place1);
        place1.removeContainer(cont1);
        System.out.println(place1);
        assertEquals(null,place1.getContainer(cont1));

    }

    @Test
    void isEmptyContainer() {
        assertTrue(place1.isEmptyContainer());
        assertFalse(place2.isEmptyContainer());
    }

    @Test
    void containerExists() {
        place1.addContainer(cont1);
        System.out.println(place1);
        assertTrue(place1.containerExists("Skeleton"));

        assertFalse(place1.containerExists("Nop"));
    }

    @Test
    void getContainer() {
        place1.addContainer(cont1);
        assertEquals(cont1,place1.getContainer(cont1));
    }

    @Test
    void getContainerByName() {
        place1.addContainer(cont1);
        assertEquals(cont1,place1.getContainerByName("Skeleton"));
    }

    @Test
    void getContainerByIndex() {
        place1.addContainer(cont1);
        assertEquals(cont1,place1.getContainerByIndex(0));
    }

    @Test
    void nbContainer() {
        assertEquals(0,place1.nbContainer());
        place1.addContainer(cont1);
        assertEquals(1,place1.nbContainer());
    }




    @Test
    void getPlaceContainer() {
        assertEquals(new Place("Tavern").getPlaceContainer(),place1.getPlaceContainer());

    }

    @Test
    void addItemToPlace() {
        System.out.println(place1);
        place1.addItemToPlace(item1);
        System.out.println(place1);
        assertTrue(place1.getPlaceContainer().contains(item1));

        place1.addItemToPlace(null);
        System.out.println(place1);

    }

    @Test
    void getAgressive(){
        Hostile orc = new Hostile("orc", "orc", "a green creature", 5, 5);
        place3.addContainer(orc);
        assertEquals(orc,place3.getAgressive());
    }


    @Test
    void displayExitTopLine() {
        System.out.println(place1.displayExitTopLine());
        System.out.println(place2.displayExitTopLine());
    }

    @Test
    void displayExitMiddleLine() {
        place1.addLockedExit(place2,2,BLUE);
        System.out.println(place1.displayExitMiddleLine());
        System.out.println(place2.displayExitMiddleLine());
        System.out.println(place3.displayExitMiddleLine());
    }

    @Test
    void displayExitBotLine() {
        System.out.println(place3.displayExitBotLine());
    }

    @Test
    void displayContainers() {
        System.out.println(place1.displayContainers());
        System.out.println(place2.displayContainers());
        System.out.println(place3.displayContainers());
    }

    @Test
    void draw() {

        place1.draw();
        place2.draw();
        place3.draw();

        place4.addLockedExit(place1,0,RED);
        place4.addLockedExit(place2,1,BLUE);
        place4.addExit(place3,2);
        place4.addLockedExit(place4,3,GREEN);

        place4.addContainer(cont1);
        place4.addContainer(cont2);
        place4.addContainer(cont3);
        place4.addContainer(cont4);
       /* place4.addContainer(cont5);
        place4.addContainer(cont6);
        place4.addContainer(cont7);
        place4.addContainer(cont8);
        place4.addContainer(cont9);*/

        place4.draw();
    }

    @Test
    void look(){
        assertEquals(place1.draw(),place1.look());
    }


}