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
        item2 = new Item("sword", 3.0, 1);
        item3 = new Item("shield", 5.0, 1);
    }

    @Test
    void testGold() {
        assertEquals(0, inv1.getGold());

        inv1.addGold(100);
        assertEquals(100, inv1.getGold());

        inv1.addGold(-100);
        assertEquals(100, inv1.getGold());

        assertFalse(inv1.removeGold(101));
        assertEquals(100, inv1.getGold());

        assertFalse(inv1.removeGold(-1));
        assertEquals(100, inv1.getGold());

        assertTrue(inv1.removeGold(50));
        assertEquals(50, inv1.getGold());
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
    void Inventory() {
        Inventory inv = new Inventory();
        assertEquals(0, inv.getNbItems());
    }

    @Test
    void display() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);
        inv1.addItem(item2);

        System.out.println(inv1.getItemListDisplay(true));
        System.out.println(inv1.getSimpleDisplay());
        System.out.println(inv1);

        assertTrue(inv1.getDisplay().contains(item1.getSimpleDisplay()));
        assertTrue(inv1.getSimpleDisplay().contains(item1.getSimpleDisplay()));
    }

    @Test
    void getNbItems() {
        assertEquals(0, inv1.getNbItems());

        inv1.addItem(item1);
        assertEquals(1, inv1.getNbItems());

        inv1.addItem(item2);
        assertEquals(2, inv1.getNbItems());

        inv1.addItem(item3);
        assertEquals(3, inv1.getNbItems());

        inv1.removeItem(item1);
        assertEquals(2, inv1.getNbItems());

        assertEquals(0, inv2.getNbItems());
    }

    @Test
    void getNbItems2() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.removeItem(item1);
        assertEquals(3, inv1.getNbItems());
        inv1.removeItem(item2);
        assertEquals(2, inv1.getNbItems());
    }

    @Test
    void isEmpty() {
        assertTrue(inv1.isEmpty());

        inv1.addItem(item1);
        inv1.addItem(item2);
        assertFalse(inv1.isEmpty());

        inv1.removeItem(item1);
        assertFalse(inv1.isEmpty());
    }

    @Test
    void getFirstItem() {
        assertNull(inv1.getFirstItem());

        inv1.addItem(item1);
        inv1.addItem(item2);
        assertSame(item1, inv1.getFirstItem());

        inv2.addItem(item1);
        inv2.removeItem(item1);
        assertNull(inv2.getFirstItem());
    }

    @Test
    void removeAllItems() {
        for (int i = 0; i < 64; i++)
            inv1.addItem(item1);
        inv1.removeAllItems();
        assertTrue(inv1.isEmpty());
    }

    @Test
    void addItem() {
        assertTrue(inv1.addItem(item1));
        assertTrue(inv1.addItem(item1));
        assertTrue(inv1.addItem(item1));
        assertTrue(inv1.addItem(item3));

        assertTrue(inv1.contains(item1));
        assertTrue(inv1.contains("apple"));

        assertEquals(3, inv1.getQuantity(item1));
        assertEquals(3, inv1.getQuantity("apple"));
    }

    @Test
    void removeItem() {
        assertFalse(inv1.removeItem(item1));
        assertFalse(inv1.removeItem("apple"));

        inv1.addItem(item1);
        assertTrue(inv1.removeItem(item1));

        inv1.addItem(item1);
        assertTrue(inv1.removeItem("apple"));
    }

    @Test
    void removeItem2() {
        inv1.addItem(item1);
        assertFalse(inv1.removeItem(item2));
        inv1.addItem(item2);
        assertTrue(inv1.removeItem(item2));
    }

    @Test
    void contains() {
        assertFalse(inv1.contains(item1));
        assertFalse(inv1.contains("apple"));

        inv1.addItem(item1);
        assertTrue(inv1.contains(item1));
        assertTrue(inv1.contains("apple"));

        assertFalse(inv1.contains(item2));
        assertFalse(inv1.contains("sword"));

        inv1.addItem(item2);
        assertTrue(inv1.contains("sword"));
    }

    @Test
    void contains2() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.removeItem(item1);
        assertTrue(inv1.contains(item1));

        inv2.addItem(item2);
        assertFalse(inv2.contains(item1));
    }

    @Test
    void getQuantity() {
        assertEquals(0, inv1.getQuantity(item1));

        int nb = 16;
        for (int i = 0; i < nb; i++)
            inv1.addItem(item1);

        assertEquals(nb, inv1.getQuantity(item1));
        assertEquals(0, inv1.getQuantity(item2));

        assertEquals(inv1.getQuantity("apple"), inv1.getQuantity(item1));

        inv1.removeItem(item1);
        assertEquals(nb - 1, inv1.getQuantity(item1));

        inv1.removeItem(item2);
        assertEquals(0, inv1.getQuantity(item2));
    }

    @Test
    void getItem() {
        assertNull(inv1.getItem("apple"));

        inv1.addItem(item1);
        assertSame(item1, inv1.getItem("apple"));

        assertNull(inv1.getItem("monkey"));

        inv1.removeItem("apple");
        assertNull(inv1.getItem("apple"));
    }
}