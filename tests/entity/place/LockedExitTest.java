package entity.place;

import entity.item.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.BLUE;
import static utils.Col.RED;

class LockedExitTest {
    private Place place1;
    private Place place2;
    private LockedExit lockedExit1;
    private LockedExit lockedExit2;
    private Key key1;



    @BeforeEach
    void setUp() {
        place1 = new Place("Laboratory");
        place2 = new Place("Cave");

        lockedExit1 = new LockedExit(place1,RED);
        lockedExit2 = new LockedExit(place2,BLUE);

        key1 = new Key("red_key", "the  R E D  key", BLUE);
    }

    @Test
    void canGo() {

        assertFalse(lockedExit1.canGo());

        lockedExit2.unLock(key1);
        assertTrue((lockedExit2.canGo()));
    }

    @Test
    void goIn() {
        assertSame(null,lockedExit1.goIn());

        lockedExit2.unLock(key1);
        assertSame(place2,lockedExit2.goIn());

    }

    @Test
    void isLocked() {
        assertTrue(lockedExit1.isLocked());

        lockedExit2.unLock(key1);
        assertFalse(lockedExit2.isLocked());
    }

    @Test
    void getColor() {
        assertSame(RED,lockedExit1.getColor());
        assertSame(BLUE,lockedExit2.getColor());
    }

    @Test
    void unLock() {
        lockedExit1.unLock(key1);
        assertTrue(lockedExit1.isLocked());

        lockedExit2.unLock(key1);
        assertFalse(lockedExit2.isLocked());
    }

    @Test
    void lock() {
        assertTrue(lockedExit2.isLocked());
        lockedExit2.unLock(key1);
        assertFalse(lockedExit2.isLocked());

    }
}