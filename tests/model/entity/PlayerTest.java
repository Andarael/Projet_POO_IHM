// Fichier par Josué Raad

package model.entity;

import model.entity.item.*;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static model.utils.Col.RED;

class PlayerTest {

    private Player p;
    private Item lourd;
    private Item lourd2;
    private Item heavy2;
    private Item item1;
    private Item hands;
    private Item bow;
    private Item arrow;
    private Item axe;
    private Item redKey;

    @BeforeEach
    void setUp() {
        p = new Player();

        item1 = new Item("pog");
        hands = new Hand();
        bow = new Bow();
        arrow = new Arrow();
        axe = new Weapon("Axe", null, null, 3.0, 13, 5);
        redKey = new Key(RED);

        lourd = new Item("lrd1", null, null, 8.8, 0);
        lourd2 = new Item("lrd2", null, null, 11.8, 0);
        heavy2 = new Item("heavy2", null, null, 10000, 1000);

        p.addItem(item1);
        p.addItem(hands);
        p.addItem(bow);
        p.addItem(arrow);
        p.addItem(axe);
        p.addItem(redKey);
    }

    @Test
    void addItem() {
        assertFalse(p.addItem(heavy2));
        p.addItem(lourd);
        System.out.println(p);
        assertFalse(p.addItem(axe));
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
        assertEquals(axe, p.getEquipped());
    }

    @Test
    void equip() {
        p.equip("axe");
        assertEquals(axe, p.getEquipped());
        assertEquals(13, p.getEquipped().getValue());

        assertTrue(p.contains("axe"));

        assertFalse(p.equip((Item) null));
        assertEquals(axe, p.getEquipped());

        assertFalse(p.equip("crayon"));
        assertEquals(axe, p.getEquipped());
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
        assertFalse(p.use("axe"));
        assertFalse(p.use("keyR"));
        assertFalse(p.use("poug"));
        assertFalse(p.use((Item) null));
        assertFalse(p.use((String) null));

        assertFalse(p.use((Item) null));

        assertFalse(p.use((String) null));

        p.equip("axe");
        assertFalse(p.use("axe"));
        assertFalse(p.use("poug"));

        assertFalse(p.use("h"));
    }

    @Test
    void use2() {
        assertFalse(p.use(item1, hands));
        assertTrue(p.use(arrow, bow));

        System.out.println(p);

        assertEquals(1, ((Bow) p.getItem("bow")).getArrows());
        assertFalse(p.contains("arrow"));

        p.addItem(arrow);
        p.addItem(arrow);
        p.addItem(arrow);

        assertTrue(p.use("arrow", "bow"));
        assertFalse(p.use("arrow", "pog"));
        assertFalse(p.use("pog", "bow"));
        assertFalse(p.use(null, "bow"));
        assertFalse(p.use("banana", "bow"));
        assertFalse(p.use("arrow", "banana"));
    }

    @Test
    void use3() {
        p.addItem(new Food("apple", null, null, 5));
        assertTrue(p.use("apple"));

        assertFalse(p.use(null, (Item) null));
        assertFalse(p.use(null, (String) null));

        Exit exit1 = new LockedExit(new Place("tavern"), RED);
        Exit exit2 = new Exit(new Place("tavern2"));

        p.addItem(redKey);
        p.addItem(redKey);
        p.addItem(redKey);
        p.addItem(redKey);

        assertTrue(p.use("keyR", exit1));
        assertFalse(p.use("keyr", exit2));
        assertFalse(p.use((String) null, exit1));
        assertFalse(p.use((Item) null, exit1));
        assertFalse(p.use("pog", exit1));
        assertFalse(p.use("banana", exit1));

    }

    @Test
    void display() {
        System.out.println(p);
    }

    @Test
    void canAddItem() {
        assertFalse(p.canAddItem(heavy2));
        assertTrue(p.canAddItem(new Key(RED)));
    }

    @Test
    void removeItem() {
        p.removeItem("pog");
        assertFalse(p.contains(item1));


        p = new Player();
        Item equipable = new Bow();

        p.addItem(equipable);
        p.equip("bow");
        assertTrue(p.getEquipped().isSameStr("bow"));

        assertFalse(p.removeItem("pog"));
        assertTrue(p.removeItem("bow"));
        assertFalse(p.contains("bow"));

    }

    @Test
    void getKills() {
        assertEquals(0, p.getKills());
        p.addKill();
        p.addKill();
        p.addKill();
        assertEquals(3, p.getKills());
    }

}