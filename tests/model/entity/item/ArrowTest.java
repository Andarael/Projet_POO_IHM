// Fichier par Josué Raad

package model.entity.item;

import model.entity.Entity;
import model.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrowTest {

    private Arrow a;

    @BeforeEach
    void setUp() {
        a = new Arrow();
    }


    @Test
    void getUsage() {
        assertTrue(a.getUsage().contains("try"));
    }

    @Test
    void use() {
//        assertFalse(a.use());
    }

    @Test
    void testUse() {
        Bow bow = new Bow("Bow", "null", null, 5, 10, 4);

        a.use(bow);
        a.use(bow);
        a.use(bow);

        assertEquals(3, bow.getArrows());

        a.use(null);
        assertEquals(3, bow.getArrows());

        a.use(new Item("pog"));
        assertEquals(3, bow.getArrows());

        a.use(new Player());
        a.use((new Entity("bow") {
        }));

    }

    @Test
    void getPrefix() {
        assertTrue(a.getPrefix().contains("ARR"));
    }
}