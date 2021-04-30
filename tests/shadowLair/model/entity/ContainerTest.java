// Fichier par Josué Raad

package shadowLair.model.entity;

import shadowLair.model.entity.item.Item;
import shadowLair.model.inventory.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container cont1;
    private Container cont2;

    private Item item1;
    private Item item2;
    private Item item3;

    @BeforeEach
    void setUp() {
        cont1 = new Container("coffre") {
        };
        cont2 = new Container("Monster") {
        };

        item1 = new Item("apple", "a", "a red apple", 1.0, 1);
        item2 = new Item("apple");
        item3 = new Item("shield");

        cont2.addItem(item1);
        cont2.addItem(item2);
        cont2.addItem(item3);

        cont2.addGold(10);
    }

    @Test
    void isEmpty() {
        assertTrue(cont1.isEmpty());
        assertFalse(cont2.isEmpty());
    }

    @Test
    void getItem() {
        assertSame(item1, cont2.getItem(item1));
        assertSame(item1, cont2.getItem(new Item("apple")));
        assertSame(item3, cont2.getItem(item3));

        assertNull(cont1.getItem(item1));
        assertNull(cont2.getItem(new Item("toto")));
    }

    @Test
    void getItem2() {
        assertSame(item1, cont2.getItem("apple"));
        assertSame(item1, cont2.getItem("APPLE"));
        assertSame(item3, cont2.getItem("shiel"));

        assertNull(cont1.getItem("toto"));
        assertNull(cont2.getItem("toto"));
    }

    @Test
    void addItem() {
        assertTrue(cont1.addItem(item1));
        assertFalse(cont1.addItem(null));
        assertEquals(1, cont1.getQuantity(item1));

        cont2.addItem(item2);
        assertEquals(4, cont2.getNbItems());
        assertEquals(3, cont2.getQuantity(item2));

    }

    @Test
    void removeItem() {
        assertFalse(cont1.removeItem(new Item("clarinette")));
        assertFalse(cont2.removeItem(new Item("clarinette")));

        assertFalse(cont1.removeItem(item1));

        assertTrue(cont2.removeItem(item1));
        assertEquals(2, cont2.getNbItems());
    }

    @Test
    void removeItem2() {
        assertFalse(cont1.removeItem("clarinette"));
        assertFalse(cont2.removeItem("clarinette"));

        assertFalse(cont1.removeItem("apple"));

        assertTrue(cont2.removeItem("apple"));
        assertEquals(2, cont2.getNbItems());
    }


    @Test
    void removeAllItems() {
        cont2.removeAllItems();
        assertTrue(cont2.isEmpty());
    }

    @Test
    void removeAllItems2() {
        for (int i = 0; i < 64; i++)
            cont1.addItem(new Item("clarinette"));
        cont1.removeAllItems();
        assertTrue(cont1.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(cont1.contains("apple"));
        assertFalse(cont1.contains("clarinette"));

        assertTrue(cont2.contains("apple"));
        assertFalse(cont2.contains("clarinette"));
    }

    @Test
    void contains2() {
        assertFalse(cont1.contains(item1));
        assertFalse(cont1.contains(new Item("a")));

        assertTrue(cont2.contains(item1));
    }


    @Test
    void sortInventory() {
        cont1.addItem(item3);
        cont1.addItem(item1);
        cont1.addItem(new Item("aaa"));
        cont1.addItem(new Item("baa"));
        cont1.addItem(new Item("abb"));
        cont1.addItem(new Item("000"));
        cont1.addItem(new Item("100"));
        cont1.addItem(new Item("1"));

        cont1.sortInventory();
        assertEquals(cont1.getFirstItem(), new Item("000"));
        System.out.println(cont1);
    }

    @Test
    void getNbItems() {
        assertEquals(0, cont1.getNbItems());
        assertEquals(3, cont2.getNbItems());

        cont2.addItem(item1);
        assertEquals(4, cont2.getNbItems());
    }

    @Test
    void getQuantity() {
        assertEquals(2, cont2.getQuantity(item1));
        assertEquals(2, cont2.getQuantity("apple"));

        cont2.addItem(item1);
        assertEquals(3, cont2.getQuantity("apple"));

        assertEquals(0, cont1.getQuantity("apple"));
    }

    @Test
    void getFirstItem() {
        assertEquals(item1, cont2.getFirstItem());
        assertNull(cont1.getFirstItem());
    }

    @Test
    void addGold() {
        cont1.addGold(10);
        assertEquals(10, cont1.getGold());

        cont1.addGold(-10);
        assertEquals(10, cont1.getGold());
    }

    @Test
    void getGold() {
        assertEquals(0, cont1.getGold());
        assertEquals(10, cont2.getGold());
    }

    @Test
    void canPay() {
        assertFalse(cont2.canPay(100));
        assertFalse(cont2.canPay(-1));
        assertTrue(cont2.canPay(1));
    }

    @Test
    void removeGold() {
        assertFalse(cont2.removeGold(100));
        assertFalse(cont2.removeGold(-5));
        assertTrue(cont2.removeGold(5));

        assertSame(5, cont2.getGold());
    }

    @Test
    void testToString() {
        System.out.println(cont1);
        System.out.println(cont2);
    }

    @Test
    void canAddItem() {
        assertTrue(cont1.canAddItem(item1));
        assertFalse(cont1.canAddItem(null));
    }

    @Test
    void getInventoryDisplay() {
        System.out.println(cont2.getInventoryDisplay());
    }

    @Test
    void addAllItems() {
        cont1.addAllItems(cont2);
        cont1.addAllItems((Container) null);
        cont1.addAllItems((Inventory) null);
        System.out.println(cont2);

        assertFalse(cont1.isEmpty());
        assertEquals(cont2.getNbItems(), cont1.getNbItems());
        assertEquals(cont2.getGold(), cont1.getGold());

    }
}