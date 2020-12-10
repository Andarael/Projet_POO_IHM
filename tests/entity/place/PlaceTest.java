package entity.place;

import entity.Container;
import entity.Player;
import entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    private Place place1;
    private Place place2;
    private Place place3;

    private Container cont1;
    private Container cont2;
    private Container cont3;

    private Exit exit1;
    private Exit exit2;
    private Exit exit3;
    private Exit exit4;

    private Player player;

    @BeforeEach
    void setUp() {

        place1 = new Place("Tavern");
        place2 = new Place("Cave");
        place3 = new Place("Laboratory");

        cont1 = new Container("Skeleton") {
        };
        cont2 = new Container("Monster"){
        };
        cont3 = new Container("Merchant"){
        };

        player = new Player(20);


        place2.addContainer(cont1);
        place3.addContainer(cont1);
        place3.addContainer(cont2);
        place3.addPlayer(player);


        place2.addExit(place1,0);
        place3.addExit(place2,1);
        place3.addExit(place1,3);

    }

    @Test
    void hasPlayer() {
        assertFalse(place1.hasPlayer());
        assertFalse(place2.hasPlayer());
        assertTrue(place3.hasPlayer());
    }

    @Test
    void getPlayer() {
        assertSame(null,place1.getPlayer());
        assertSame(null,place2.getPlayer());
        assertSame(player,place3.getPlayer());
    }

    @Test
    void addPlayer() {
        assertSame(null,place1.getPlayer());
        place1.addPlayer(player);
        assertSame(player,place1.getPlayer());
    }

    @Test
    void rmPlayer() {
        assertSame(player,place3.getPlayer());
        place3.rmPlayer();
        assertSame(null,place3.getPlayer());
    }

    @Test
    void addExit() {
        assertSame(null,place1.getExitByIndex(1));
        place1.addExit(place3,1);
        place1.addExit(place2,3);

        System.out.println(place1);

        assertEquals(new Exit(place3),place1.getExitByName("Laboratory"));
        assertEquals(new Exit(place2),place1.getExitByIndex(3));
    }

    @Test
    void addLockedExit() {
    }

    @Test
    void rmExit() {
    }

    @Test
    void exitExistName() {
    }

    @Test
    void exitExistIndex() {
    }

    @Test
    void getExitByIndex() {
    }

    @Test
    void getExitByName() {
    }

    @Test
    void getIndexExit() {
    }

    @Test
    void nbExit() {
    }

    @Test
    void displayExit() {
    }

    @Test
    void addContainer() {
    }

    @Test
    void rmContainer() {
    }

    @Test
    void isEmptyContainer() {
    }

    @Test
    void containerExists() {
    }

    @Test
    void getContainerByString() {
    }

    @Test
    void getContainerByIndex() {
    }

    @Test
    void nbContainer() {
    }

    @Test
    void displayContainer() {
    }

    @Test
    void displayExitTopLine() {
    }

    @Test
    void displayExitMiddleLine() {
    }

    @Test
    void displayExitBotLine() {
    }

    @Test
    void displayContainers() {
    }

    @Test
    void testDisplay() {
    }

    @Test
    void display() {
    }
}