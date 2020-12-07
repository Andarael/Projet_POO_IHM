package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class KeyTest {

    private Item k1;
    private Item k2;
    private Item k3;

    @BeforeEach
    void setUp() {
        k1 = new Key("blue_key", "a finely crafted blue key", BLUE);
        k2 = new Key("red_key", "the  R E D  key", RED);
        k3 = new Key(null, null, null);
    }

    @Test
    void testEquals() {
        assertEquals(k1,k1);

        Item k = new Key("not a blue key !", "definitely not blue", BLUE);
        assertEquals(k,k1);
        // en réalité la clé k est bleu

        assertNotEquals(k1,k2);

        Object o = new Object();
        assertNotEquals(k1,o);

        assertNotEquals(null, k1);
    }

    @Test
    void Display() {
        System.out.println(k1.getDisplay());
        System.out.println(k2.getDisplay());
        System.out.println(k3.getDisplay());

        assertTrue(k1.getDisplay().contains(BLUE.toString()));
    }
}