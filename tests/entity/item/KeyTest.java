package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Col;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class KeyTest {

    private Item k1;
    private Item k2;
    private Item k3;
    private Item k4;

    @BeforeEach
    void setUp() {
        k1 = new Key("blue_key", "a finely crafted blue key", BLUE);
        k2 = new Key("red_key", "the  R E D  key", RED);
        k3 = new Key("yellow_key", "a vibrant Yellow Key", YELLOW);
        k3 = new Key(null, null, null);
    }

    @Test
    void testEquals() {
        Item k = new Key("blue_key", "a finely crafted blue key", BLUE);

        assertEquals(k,k1);

        k = new Key("not_blue_key", "a finely crafted blue key", BLUE);
        assertEquals(k,k1);

        assertNotEquals(k1,k2);

        System.out.println(k1.hashCode());
    }

    @Test
    void Display() {
        System.out.println(k1.getSimpleDisplay());
        System.out.println(k1.getDisplay());
        System.out.println(k2.getDisplay());
        System.out.println(k3.getDisplay());

        assertTrue(k1.getDisplay().contains(BLUE.toString()));
    }
}