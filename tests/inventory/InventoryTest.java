// Fichier par Josué Raad

package inventory;

import entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inv1;
    private Inventory inv2;

    private Item item1;
    private Item item2;
    private Item item3;

    @BeforeEach
    void setUp() {
        inv1 = new Inventory();
        inv2 = new Inventory();

        item1 = new Item("apple", "a red apple", 1.0, 1);
        item2 = new Item("apple");
        item3 = new Item("shield");

        item1.setShortName("a");

        inv2.addItem(item1);
        inv2.addItem(item2);
        inv2.addItem(item3);

        inv2.addGold(10);
    }

    @Test
    void isEmpty() {
        assertTrue(inv1.isEmpty());
        assertFalse(inv2.isEmpty());
    }

    @Test
    void getItem() {
        assertSame(item1, inv2.getItem(item1));
        assertSame(item1, inv2.getItem(new Item("apple")));
        assertSame(item3, inv2.getItem(item3));

        assertNull(inv1.getItem(item1));
        assertNull(inv2.getItem(new Item("toto")));
    }

    @Test
    void getItem2() {
        assertSame(item1, inv2.getItem("apple"));
        assertSame(item1, inv2.getItem("APPLE"));
        assertSame(item3, inv2.getItem("shiel"));

        assertNull(inv1.getItem("toto"));
        assertNull(inv2.getItem("toto"));
    }

    @Test
    void addItem() {
        assertTrue(inv1.addItem(item1));
        assertFalse(inv1.addItem(null));
        assertEquals(1, inv1.getQuantity(item1));

        inv2.addItem(item2);
        assertEquals(4, inv2.getNbItems());
        assertEquals(3, inv2.getQuantity(item2));

    }

    @Test
    void removeItem() {
        assertFalse(inv1.removeItem(new Item("clarinette")));
        assertFalse(inv2.removeItem(new Item("clarinette")));

        assertFalse(inv1.removeItem(item1));

        assertTrue(inv2.removeItem(item1));
        assertEquals(2, inv2.getNbItems());
    }

    @Test
    void removeItem2() {
        assertFalse(inv1.removeItem("clarinette"));
        assertFalse(inv2.removeItem("clarinette"));

        assertFalse(inv1.removeItem("apple"));

        assertTrue(inv2.removeItem("apple"));
        assertEquals(2, inv2.getNbItems());
    }


    @Test
    void removeAllItems() {
        inv2.removeAllItems();
        assertTrue(inv2.isEmpty());
    }

    @Test
    void removeAllItems2() {
        for (int i = 0; i < 64; i++)
            inv1.addItem(new Item("clarinette"));
        inv1.removeAllItems();
        assertTrue(inv1.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(inv1.contains("apple"));
        assertFalse(inv1.contains("clarinette"));

        assertTrue(inv2.contains("apple"));
        assertFalse(inv2.contains("clarinette"));
    }

    @Test
    void contains2() {
        assertFalse(inv1.contains(item1));
        assertFalse(inv1.contains(new Item("a")));

        assertTrue(inv2.contains(item1));
    }


    @Test
    void sortInventory() {
        inv1.addItem(item3);
        inv1.addItem(item1);
        inv1.addItem(new Item("aaa"));
        inv1.addItem(new Item("baa"));
        inv1.addItem(new Item("abb"));
        inv1.addItem(new Item("000"));
        inv1.addItem(new Item("100"));
        inv1.addItem(new Item("1"));

        inv1.sortInventory();
        assertEquals(inv1.getFirstItem(), new Item("000"));
        System.out.println(inv1);
    }

    @Test
    void getNbItems() {
        assertEquals(0, inv1.getNbItems());
        assertEquals(3, inv2.getNbItems());

        inv2.addItem(item1);
        assertEquals(4, inv2.getNbItems());
    }

    @Test
    void getQuantity() {
        assertEquals(2, inv2.getQuantity(item1));
        assertEquals(2, inv2.getQuantity("apple"));

        inv2.addItem(item1);
        assertEquals(3, inv2.getQuantity("apple"));

        assertEquals(0, inv1.getQuantity("apple"));
    }

    @Test
    void getFirstItem() {
        assertEquals(item1, inv2.getFirstItem());
        assertNull(inv1.getFirstItem());
    }

    @Test
    void addGold() {
        inv1.addGold(10);
        assertEquals(10, inv1.getGold());

        inv1.addGold(-10);
        assertEquals(10, inv1.getGold());
    }

    @Test
    void getGold() {
        assertEquals(0, inv1.getGold());
        assertEquals(10, inv2.getGold());
    }

    @Test
    void canPay() {
        assertFalse(inv2.canPay(100));
        assertFalse(inv2.canPay(-1));
        assertTrue(inv2.canPay(1));
    }

    @Test
    void removeGold() {
        assertFalse(inv2.removeGold(100));
        assertFalse(inv2.removeGold(-5));
        assertTrue(inv2.removeGold(5));

        assertSame(5, inv2.getGold());
    }


    @Test
    void getItemListDisplay() {
        assertTrue(inv2.getItemListDisplay(true).contains("red"));
        assertFalse(inv2.getItemListDisplay(true).contains("clarinette"));
        assertTrue(inv2.getItemListDisplay(false).contains("apple"));
    }

    @Test
    void getHeaderDisplay() {
        assertTrue(inv2.getHeaderDisplay().contains(": 10"));
        assertTrue(inv2.getHeaderDisplay().contains(": 3"));

        assertTrue(inv1.getHeaderDisplay().contains(": 0"));
        assertFalse(inv1.getHeaderDisplay().contains(": 3"));

    }

    @Test
    void getInvDisplayDetails() {
        System.out.println(inv1.getInvDisplayDetails());
        System.out.println(inv2.getInvDisplayDetails());
    }

    @Test
    void getInvDisplayNoDetails() {
        System.out.println(inv1.getInvDisplayNoDetails());
        System.out.println(inv2.getInvDisplayNoDetails());
    }

    @Test
    void testToString() {
        System.out.println(inv1);
        System.out.println(inv2);
    }
}