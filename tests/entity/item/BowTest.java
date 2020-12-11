// Fichier par Josué Raad

package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BowTest {

    private Arrow a;
    private Bow b;

    @BeforeEach
    void setUp() {
        a = new Arrow();
        b = new Bow("IronBow",null, "a bow made of iron", 6.0, 5, 4);
    }

    @Test
    void Bow() {
        b = new Bow(4);
        assertEquals(Bow.DEFAULT_WEIGHT, b.getWeight());
        assertEquals(0, b.getArrows());
    }

    @Test
    void addArrow() {
        b.addArrow();
        assertEquals(1, b.getArrows());

        b.addArrow();
        b.addArrow();
        b.addArrow();
        assertEquals(4, b.getArrows());
    }

    @Test
    void getArrows() {
        addArrow();
    }

    @Test
    void getPower() {
        assertEquals(4, b.getPowerNoConsume());
        b.addArrow();
        assertEquals(4 + a.getPower(), b.getPower());
        assertEquals(4, b.getPowerNoConsume());


    }

    @Test
    void getDisplay() {
        for (int i = 0; i < 10; i++)
            b.addArrow();

        assertTrue(b.getDisplay().contains("10"));
    }

    @Test
    void getPowerNoConsume() {
        assertEquals(4, b.getPowerNoConsume());
        b.addArrow();

        assertEquals(4 + a.getPower(), b.getPowerNoConsume());
    }

    @Test
    void getPrefix() {
        assertTrue(b.getPrefix().contains("BOW"));
    }
}