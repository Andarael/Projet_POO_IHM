// Fichier par Josué Raad

package shadowLair.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static shadowLair.model.utils.Shortener.shorten;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    Entity e1;
    Entity e2;
    Entity e3;

    @BeforeEach
    void setUp() {
        e1 = new Entity("apple", null, "a red apple") {
        };
        e2 = new Entity(null) {
        };
        e3 = new Entity("pog", null, "a nice Pog") {
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

        e = new Entity("un pog", "pog pog") {
        };
        System.out.println(e);
        assertEquals("un_pog", e.getName());
        assertEquals("pog_p", e.getShortName());

        e = new Entity("") {
        };
        System.out.println(e);
        assertSame(Entity.DEFAULT_NAME, e.getName());
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
    void isSame() {

        assertEquals(e1, e1);
        assertNotEquals(null, e1);

        Object o = new Object();
        assertNotEquals(e1, o);

        e1 = new Entity("NaME") {
        };
        e2 = new Entity("name") {
        };

        assertTrue(e1.isSame(e2));
        assertTrue(e1.isSameStr("name"));

        e1 = new Entity("name") {
        };

        e2 = new Entity("newName") {
        };

        assertNotEquals(e1, e2);
        assertNotEquals(e3, e1);
    }

    @Test
    void isSame2() {
        assertFalse(e1.isSame(e2));
        assertFalse(e1.isSame(null));
        assertFalse(e1.isSameStr("pog"));
        assertFalse(e1.isSameStr(null));
    }

    @Test
    void look() {
        assertTrue(e1.look().contains(e1.getDisplay()));
        e1.look();
    }

    @Test
    void getDescription() {
        assertTrue(e1.getDisplay().contains("red"));

        e1.updateDescription(null);
        assertNull(e1.getDescription());
    }

    @Test
    void testHashCode() {
        assertNotEquals(e1.hashCode(), e2.hashCode());

        Entity e = new Entity(e1.getName()) {
        };
        assertEquals(e.hashCode(), e1.hashCode());
    }

}