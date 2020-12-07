package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Shortener.shorten;

class EntityTest {

    Entity e1;
    Entity e2;
    Entity e3;

    @BeforeEach
    void setUp() {
        e1 = new Entity("apple", "a red apple") {
        };
        e2 = new Entity(null) {
        };
        e3 = new Entity("pog", "a nice Pog") {
        };
    }

    @Test
    void Entity() {
        Entity e = new Entity(null) {
        };
        System.out.println(e);

        assertNotNull(e.getName());
        assertNotNull(e.getShortName());
        assertEquals(Entity.DEFAULT_NAME, e.getName());
        assertNull(e.getDescription());
    }

    @Test
    void getName() {
        assertEquals("apple", e1.getName());
        assertEquals(Entity.DEFAULT_NAME, e2.getName());
    }

    @Test
    void display() {
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println(e1.getDisplay());
        System.out.println(e1.getSimpleDisplay());

        assertTrue(e1.getSimpleDisplay().contains("apple"));
        assertTrue(e1.getDisplay().contains("a red apple"));
        assertTrue(e3.toString().contains("pog"));

        assertTrue(e2.getDisplay().contains(Entity.DEFAULT_NAME));
    }

    @Test
    void updateDescription() {
        e1.updateDescription(null);
        System.out.println(e1);
        assertNull(e1.getDescription());

        e2.updateDescription("young merchant");
        System.out.println(e2);
        assertTrue(e2.getDisplay().contains("young"));
    }

    @Test
    void getShortName() {
        assertEquals(e1.getShortName(), shorten("apple"));
        assertEquals(e2.getShortName(), shorten(Entity.DEFAULT_NAME));
        assertEquals(e3.getShortName(), shorten("pog"));
    }

    @Test
    void setShortName() {
        e1.setShortName("123");
        assertEquals(shorten("123"), e1.getShortName());

        e1.setShortName("12345");
        assertEquals(shorten("12345"), e1.getShortName());

        e1.setShortName("123456789");
        assertEquals(shorten("123456789"), e1.getShortName());
    }

    @Test
    void stetShorName2() {
        e3.setShortName("M");
        assertEquals(shorten("M"), e3.getShortName());

        e3.setShortName("MONSTRE");
        assertEquals(shorten("MONSTRE"), e3.getShortName());
    }

    @Test
    void testEquals() {
        Object o = new Object();
        assertNotEquals(e1, o);

        e1 = new Entity("NaME") {
        };
        e2 = new Entity("name") {
        };

        e2.setShortName("shortname1");

        assertEquals(e1, e2);

        assertNotEquals(null, e1);

        e1 = new Entity("name") {
        };

        e2 = new Entity("newName") {
        };

        assertNotEquals(e1, e2);
        assertNotEquals(e3, e1);
    }

    @Test
    void look() {
        assertTrue(e1.look().contains(e1.getDisplay()));
        e1.look();
    }
}