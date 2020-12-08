package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import world.Exit;
import world.LockedExit;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class KeyTest {

    private Key k1;
    private Key k2;
    private Key k3;

    @BeforeEach
    void setUp() {
        k1 = new Key("blue_key", "a finely crafted blue key", BLUE);
        k2 = new Key("red_key", "the  R E D  key", RED);
        k3 = new Key(null, null, null);
    }

    @Test
    void testEquals() {
        assertEquals(k1, k1);

        Item k = new Key("not a blue key !", "definitely not blue", BLUE);
        assertEquals(k, k1);
        // en réalité la clé k est bleu

        assertNotEquals(k1, k2);

        Object o = new Object();
        assertNotEquals(k1, o);

        assertNotEquals(null, k1);
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
        assertTrue(k1.use().contains(k1.getUsage()));
        assertTrue(k1.use(null).contains(k1.getUsage()));
    }

    @Test
    void use2() {
        LockedExit lockedExit = new LockedExit(null, null, null, BLUE);
        LockedExit lockedExit2 = new LockedExit(null, null, null, YELLOW);

        k1.use(lockedExit);
        assertFalse(lockedExit.isLocked());
        assertTrue(k1.use(lockedExit).contains("not"));

        k1.use(lockedExit2);
        assertTrue(lockedExit2.isLocked());


        Exit exit = new Exit(null, null);
        assertTrue(k1.use(exit).contains(k1.getUsage()));
    }
}