// Fichier par Josué Raad

package entity;

import entity.item.Item;
import entity.item.Key;
import entity.item.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.RED;

class HostileTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void Hostile() {
        Hostile h = new Hostile("spider",
                                "spid",
                                "qui fait peur",
                                5,
                                3);

        h.addGold(5);
        h.addItem(new Item("book"));
        h.addItem(new Weapon("axe", null,null, 3.0, 2, 3));
        h.addItem(new Key(RED,null));

        System.out.println(h.getSimpleDisplay());
        System.out.println(h.getDisplay());
        System.out.println(h);

        assertEquals(5, h.getHp());
        assertEquals(3, h.getPower());
        assertTrue(h.isAgressive());
    }

    @Test
    void Hostile2() {
        Hostile h = new Hostile("monster",
                                "monst",
                                null,
                                12,
                                5,
                                true);

        assertTrue(h.isAgressive());

        h = new Hostile("monster",
                                "monst",
                                null,
                                12,
                                5,
                                false);

        assertFalse(h.isAgressive());
    }
}