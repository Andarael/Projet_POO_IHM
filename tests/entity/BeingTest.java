package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeingTest {

    private Being b1;
    private Being b2;
    private Being b3;
    private Being b4;

    @BeforeEach
    void setUp() {
        b1 = new Being(null, null);
        b2 = new Being("vieux_marchand", "un vieux marchand");
        b3 = new Being("spider", 5);
    }

    @Test
    void getHP() {
        assertEquals(5, b3.getHP());
        assertEquals(20, b2.getHP());
        assertEquals(20, b1.getHP());
    }

    @Test
    void getMAX_HP() {
        assertEquals(5, b3.getMAX_HP());
        assertEquals(20, b2.getMAX_HP());
        assertEquals(20, b1.getMAX_HP());
    }

    @Test
    void healMax() {
        b1.hurt(b1.getMAX_HP() - 5);
        assertNotEquals(b1.getMAX_HP(), b1.getHP());
        b1.healMax();
        assertEquals(b1.getMAX_HP(), b1.getHP());
    }

    @Test
    void heal() {
        int healthTemp = b1.getHP();

        b1.hurt(10);
        b1.heal(5);

        assertEquals(healthTemp - 10 + 5, b1.getHP());
    }

    @Test
    void heal2() {
        int healthTemp = b1.getHP();
        b1.heal(15);
        assertEquals(healthTemp, b1.getHP());

        b1.hurt(5);
        healthTemp = b1.getHP();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHP());

        b1.hurt(5);
        healthTemp = b1.getHP();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHP());

        b1.hurt(5);
        healthTemp = b1.getHP();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHP());
    }

    @Test
    void hurt() {
        b2.hurt(999);
        assertEquals(0, b2.getHP());

        b1.hurt(5);
        assertEquals(b1.getMAX_HP() - 5, b1.getHP());
    }

    @Test
    void isDead() {
        b2.hurt(999);
        assertTrue(b2.isDead());

        b3.kill();
        assertTrue(b3.isDead());

        b3.healMax();
        assertFalse(b3.isDead());
    }

    @Test
    void getLevel() {
        assertEquals(1, b3.getLevel());

        b3.levelUP();

        assertEquals(2, b3.getLevel());

        b1.levelUP(9);
        assertEquals(10, b1.getLevel());
    }

    @Test
    void levelUP() {
        b3.levelUP();
        assertEquals(2, b3.getLevel());

        int expectedMAX_HEALTH = b3.getMAX_HP();
        expectedMAX_HEALTH += b3.getMAX_HP() / (b3.getLevel() + 1);

        b3.levelUP();
        assertEquals(expectedMAX_HEALTH, b3.getMAX_HP());
        assertEquals(b3.getMAX_HP(), b3.getHP());
    }

    @Test
    void levelUP2() {


        int expectedMAX_HEALTH = b3.getMAX_HP();
        for (int i = 0; i < 9; i++)
            expectedMAX_HEALTH += b3.getMAX_HP() /
                                  (b3.getLevel() + 1);

        b3.levelUP(9);
        assertEquals(expectedMAX_HEALTH, b3.getHP());
    }

    @Test
    void kill() {
        assertFalse(b3.isDead());
        b3.kill();
        assertTrue(b3.isDead());
    }

    @Test
    void getDisplay() {
        assertTrue(b2.getDisplay().contains("vieux"));
        assertTrue(b2.getDisplay().contains("vieux"));
    }

    @Test
    void compareTo() {
        b1.levelUP(13);
        b2.levelUP(7);
        assertEquals(b1.getLevel() - b2.getLevel(), b1.compareTo(b2));
    }

    @Test
    void testEquals() {
        Object o = new Object();
        assertNotEquals(b1, o);
        assertNotEquals(null, b1);


        Being being = new Being("Spider", "silky beauty", 5);
        assertEquals(being, b3);
        being.levelUP(5);
        assertNotEquals(being, b3);
    }
}