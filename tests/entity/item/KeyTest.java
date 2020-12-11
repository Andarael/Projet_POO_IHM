// Fichier par Josué Raad

package entity.item;

import entity.place.Exit;
import entity.place.LockedExit;
import entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class KeyTest {

    private Key k1;
    private Key k2;
    private Key k3;

    @BeforeEach
    void setUp() {
        k1 = new Key(BLUE,"a finely crafted blue key");
        k2 = new Key(RED, "the  R E D  key");
        k3 = new Key( RESET,null);
    }

    @Test
    void Key() {
        Key k = new Key(RED,null);
        System.out.println(k.toString());
    }

    @Test
    void Display() {
        System.out.println(k1.getDisplay());
        System.out.println(k2.getDisplay());
        System.out.println(k3.getDisplay());

        assertTrue(k1.getDisplay().contains(BLUE.toString()));
    }

    @Test
    void getColor() {
        assertSame(BLUE, k1.getColor());
        assertSame(RED, k2.getColor());
        assertSame(RESET, k3.getColor());
    }

    @Test
    void getUsage() {
        assertTrue(k1.getUsage().contains("try"));
    }

    @Test
    void use() {
        assertFalse(k1.use());
        assertFalse(k1.use(null));
    }

    @Test
    void use2() {
        Place destination = new Place("destination");
        LockedExit lockedExit = new LockedExit(destination,BLUE);
        LockedExit lockedExit2 = new LockedExit(destination,YELLOW);

        k1.use(lockedExit);
        assertFalse(lockedExit.isLocked());
        assertFalse(k1.use(lockedExit));

        k1.use(lockedExit2);
        assertTrue(lockedExit2.isLocked());

        Exit exit = new Exit(destination);
        assertFalse(k1.use(exit));
    }

    @Test
    void getPrefix() {
        assertTrue(k1.getPrefix().contains("KEY"));
    }

    @Test
    void isSameColor() {
        assertFalse(k1.isSameColor(null));
        assertFalse(k1.isSameColor(k2));
        assertTrue(k1.isSameColor(new Key(BLUE,null)));
    }
}