// Fichier par Josué Raad

package entity;

import entity.item.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.RED;

class PlayerTest {

    private Player p;
    private Item lourd;
    private Item lourd2;
    private Item heavy2;
    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private Item item6;

    @BeforeEach
    void setUp() {
        p = new Player();

        item1 = new Item("pog");
        item2 = new Hand();
        item3 = new Bow("Bow", "a wooden bow", 4);
        item4 = new Arrow();
        item5 = new Weapon("Axe", null, 3.0, 13, 5);
        item6 = new Key(RED);

        lourd = new Item("lrd1", 8.8, 0);
        lourd2 = new Item("lrd2", 11.8, 0);
        heavy2 = new Item("heavy2", 10000, 1000);

        p.addItem(item1);
        p.addItem(item2);
        p.addItem(item3);
        p.addItem(item4);
        p.addItem(item5);
        p.addItem(item6);
    }

    @Test
    void addItem() {
        assertFalse(p.addItem(heavy2));
        p.addItem(lourd);
        System.out.println(p);
        assertFalse(p.addItem(item5));
    }

    @Test
    void getPower() {
        assertEquals(1, p.getPower());

        Item item = p.getItem("Axe");
        p.equip(item);
        assertEquals(5, p.getPower());
    }

    @Test
    void getEquipped() {
        assertEquals(new Hand(), p.getEquipped());

        p.equip("axe");
        assertEquals(item5, p.getEquipped());
    }

    @Test
    void equip() {
        p.equip("axe");
        assertEquals(item5, p.getEquipped());
        assertEquals(13, p.getEquipped().getValue());

        assertFalse(p.contains("axe"));

        assertFalse(p.equip((Item) null));
        assertEquals(item5, p.getEquipped());

        assertFalse(p.equip("crayon"));
        assertEquals(item5, p.getEquipped());
    }

    @Test
    void equip2() {
        assertFalse(p.equip("pog"));
        p.equip("axe");

        p.addItem(lourd2);

        assertFalse(p.equip("bow"));
    }

    @Test
    void unequip() {
        System.out.println(p);
        assertTrue(p.unequip());
        assertEquals(new Hand(), p.getEquipped());

        p.equip("axe");


        p.addItem(lourd2);
        assertFalse(p.unequip());

        p.removeItem(lourd2);
        assertTrue(p.unequip());

        System.out.println(p);
    }

    @Test
    void use() {
        System.out.println(p.use("axe"));
        System.out.println(p.use("keyR"));
        System.out.println(p.use("poug"));

        p.equip("axe");
        System.out.println(p.use("axe"));
        System.out.println(p.use("poug"));

        System.out.println(p.use("h"));
    }

    @Test
    void use2() {
        System.out.println(p.use(item1, item2));
        System.out.println(p.use(item4, item3));
        System.out.println(p);
        assertEquals(1, ((Bow) p.getItem("bow")).getArrows());
        assertFalse(p.contains("arrow"));
    }

    @Test
    void display() {
        System.out.println(p);
    }
}