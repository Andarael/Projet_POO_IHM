package entity.item;

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
        assertTrue(a.use().contains("Invalid"));
    }

    @Test
    void testUse() {
        Bow bow = new Bow("Bow", null, 5);

        a.use(bow);
        a.use(bow);
        a.use(bow);

        assertEquals(3, bow.getArrows());

        a.use(null);
        assertEquals(3, bow.getArrows());

        a.use(new Item("pog"));
        assertEquals(3, bow.getArrows());

    }
}