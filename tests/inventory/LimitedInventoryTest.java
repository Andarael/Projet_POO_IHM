// Fichier par Josué Raad

package inventory;

import entity.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimitedInventoryTest {

    private LimitedInventory inv1;

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @BeforeEach
    void setUp() {
        inv1 = new LimitedInventory(10.0);

        item1 = new Item("apple", 1.0, 1);
        item2 = new Item("sword", 3.0, 1);
        item3 = new Item("shield", 5.0, 1);
        item4 = new Item("heavy_thing", 500.0, 1);
    }

    @Test
    void display() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);
        inv1.addItem(item2);

        System.out.println(inv1.getItemListDisplay(true));
        System.out.println(inv1.getInvDisplayNoDetails());
        System.out.println(inv1);
    }

    @Test
    void Inventory() {
        LimitedInventory inv = new LimitedInventory();
        LimitedInventory inv2 = new LimitedInventory(10.0);
        LimitedInventory inv3 = new LimitedInventory(-10.0);

        assertEquals(0, inv.getNbItems());
        assertEquals(LimitedInventory.DEFAULT_CAPACITY, inv.getCapacity());

        assertEquals(LimitedInventory.DEFAULT_CAPACITY, inv3.getCapacity());

        assertEquals(10.0, inv2.getCapacity());
        assertEquals(0.0, inv2.getUsedCapacity());
    }

    @Test
    void addItem2() {
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);

        assertEquals(9.0f, inv1.getUsedCapacity());

        inv1.addItem(item3);
        assertEquals(9.0f, inv1.getUsedCapacity());
    }

    @Test
    void addItem3() {
        assertFalse(inv1.addItem(null));
        assertFalse(inv1.addItem(item4));

        assertTrue(inv1.addItem(item1));
    }

    @Test
    void contains() {
        inv1.addItem(item1);

        assertTrue(inv1.contains(item1));
        assertTrue(inv1.contains("apple"));

        assertFalse(inv1.contains(item2));
        assertFalse(inv1.contains("sword"));
    }

    @Test
    void testCanAddItem() {
        assertTrue(inv1.canAddItem(item1));
        assertFalse(inv1.canAddItem(item4));
    }

    @Test
    void getUsedCapacity() {
        assertEquals(0.0, inv1.getUsedCapacity());

        inv1.addItem(item1);
        inv1.addItem(item1);
        assertEquals(2.0, inv1.getUsedCapacity());

        inv1.removeItem(item1);
        assertEquals(1.0, inv1.getUsedCapacity());
    }

    @Test
    void getCapacity() {
        assertEquals(10.0, inv1.getCapacity());
    }

}