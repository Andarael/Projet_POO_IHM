package entity;

import entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeingTest {

    private Being b1;
    private Being b2;
    private Being b3;

    @BeforeEach
    void setUp() {
        b1 = new Being(null, null, -5);
        b2 = new Being("vieux_marchand", "un vieux marchand");
        b3 = new Being("spider", 5);
    }

    @Test
    void getHP() {
        assertEquals(5, b3.getHp());
        assertEquals(20, b2.getHp());
        assertEquals(20, b1.getHp());
    }

    @Test
    void getMAX_HP() {
        assertEquals(5, b3.getMaxHp());
        assertEquals(20, b2.getMaxHp());
        assertEquals(20, b1.getMaxHp());
    }

    @Test
    void healMax() {
        b1.hurt(b1.getMaxHp() - 5);
        assertNotEquals(b1.getMaxHp(), b1.getHp());
        b1.healMax();
        assertEquals(b1.getMaxHp(), b1.getHp());
    }

    @Test
    void heal() {
        int healthTemp = b1.getHp();

        b1.hurt(10);
        b1.heal(5);

        assertEquals(healthTemp - 10 + 5, b1.getHp());
    }

    @Test
    void heal2() {
        int healthTemp = b1.getHp();
        b1.heal(15);
        assertEquals(healthTemp, b1.getHp());

        b1.hurt(5);
        healthTemp = b1.getHp();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHp());

        b1.hurt(5);
        healthTemp = b1.getHp();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHp());

        b1.hurt(5);
        healthTemp = b1.getHp();
        b1.heal(-15);
        assertEquals(healthTemp, b1.getHp());
    }

    @Test
    void hurt() {
        b2.hurt(999);
        assertEquals(0, b2.getHp());

        b1.hurt(5);
        assertEquals(b1.getMaxHp() - 5, b1.getHp());
    }

    @Test
    void isDead() {
        b3.kill();
        assertTrue(b3.isDead());

        b3.healMax();
        assertFalse(b3.isDead());

        b2.hurt(999);
        assertTrue(b2.isDead());
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
        int expectedMaxHp = b3.getMaxHp();
        b3.levelUP();
        assertEquals(2, b3.getLevel());

        expectedMaxHp = (expectedMaxHp + (expectedMaxHp *3 / 2));
        b3.levelUP();
        assertEquals(expectedMaxHp, b3.getMaxHp());
        assertEquals(b3.getMaxHp(), b3.getHp());
    }


    @Test
    void levelUP2() {


        int expectedMaxHp = b3.getMaxHp();
        expectedMaxHp = expectedMaxHp + (expectedMaxHp * 10 /2);


        b3.levelUP(9);
        assertEquals(expectedMaxHp, b3.getHp());
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
        assertEquals(b2, b2);
        assertNotEquals(b1, null);

        Object o = new Object();
        assertNotEquals(b1, o);


        Being being = new Being("Spider", "silky beauty", 5);
        assertEquals(being, b3);

        being.levelUP(5);
        assertNotEquals(being, b3);

        being = new Being("pog");
        assertNotEquals(being, b3);
    }

    @Test
    void Display() {

        Item item1 = new Item("apple", "a red apple", 1.0, 1);
        Item item2 = new Item("apple");
        Item item3 = new Item("shield");

        b1.addItem(item1);
        b1.addItem(item1);
        b1.addItem(item1);
        b1.addItem(item2);
        b1.addItem(item3);

        b2.addItem(new Item("pog"));
        System.out.println(b2.getSimpleDisplay());


        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}