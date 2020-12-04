package item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LimitedInventoryTest {

    private LimitedInventory inv1;
    private LimitedInventory inv2;

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @BeforeEach
    void setUp() {
        inv1 = new LimitedInventory(10.0);
        inv2 = new LimitedInventory();

        item1 = new Item("apple", 1.0);
        item2 = new Item("sword", 3.0);
        item3 = new Item("shield", 5.0);
        item4 = new Item("heavy_thing", 500.0);
    }

    @Test
    public void testInventory() {
        LimitedInventory inv3 = new LimitedInventory();
        LimitedInventory inv4 = new LimitedInventory(10.0);

        assertEquals(0, inv3.getNbItems());

        assertEquals(10.0, inv4.getCapacity());
        assertEquals(10.0, inv4.getUsedCapacity());
    }

    @Test
    void testGetUsedCapacity() {

    }

    @Test
    void testGetCapacity() {
    }


    @Test
    public void addItem2() {
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);

        assertEquals(inv1.getUsedCapacity(), 9.0);

        inv1.addItem(item3);
        assertEquals(inv1.getUsedCapacity(), 9.0);
    }

    @Test
    public void addItem3() {
        assertFalse(inv1.addItem(item4));

        assertTrue(inv1.addItem(item1));
    }

    @Test
    void testContains() {
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


}