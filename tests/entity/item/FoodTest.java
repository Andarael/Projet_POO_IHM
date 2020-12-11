// Fichier par Josué Raad

package entity.item;

import entity.Being;
import entity.Player;
import interfaces.Usable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.RED;

class FoodTest {

    Usable f1;
    Food f2;

    @BeforeEach
    void setUp() {
        f1 = new Food("apple", null, "a red apple", 0.2, 1, 3);
        f2 = new Food("chicken", null, "a rotten chicken", -5);
    }

    @Test
    void getRestoreValue() {
        assertEquals(3, ((Food) f1).getRestoreValue());
        assertEquals(-5, f2.getRestoreValue());
    }

    @Test
    void getDisplay() {
        System.out.println(f1);
        System.out.println(f2);

        assertTrue(((Item) f1).getDisplay().contains("3"));
    }

    @Test
    void getPrefix() {
        assertTrue(((Item) f1).getPrefix().contains("FOOD"));
    }

    @Test
    void getUsage() {
        assertTrue(f2.getUsage().contains("try"));
    }

    @Test
    void use() {
        assertFalse(f1.use());
        assertFalse(f2.use());
    }

    @Test
    void testUse() {
        assertFalse(f1.use(new Key(RED)));
        assertFalse(f1.use(new Being("paul")));
        assertFalse(f1.use(null));

        Player p = null;
        assertFalse(f1.use(p));

        p = new Player();
        assertTrue(f1.use(p));

        p.hurt(10);

        assertTrue(f1.use(p));
        assertSame(13, p.getHp());

        assertTrue(f2.use(p));
        assertSame(8, p.getHp());
    }

}