package item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inv1;
    private Inventory inv2;

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @BeforeEach
    void setUp() {
        inv1 = new Inventory(10.0);
        inv2 = new Inventory();

        item1 = new Item("apple", 1.0);
        item2 = new Item("sword", 3.0);
        item2 = new Item("shield", 5.0);
        item2 = new Item("heavy_thing", 500.0);
    }

    /*
    @Test
    public void {

    }
    */

    @Test
    public void Inventory(){
        Inventory inv3 = new Inventory();
        Inventory inv4 = new Inventory(10.0);

        assertEquals(0,inv3.getNbItems());

        assertEquals(10.0, inv4.getCapacity());
        assertEquals(10.0, inv4.getUsedCapacity());
    }

    @Test
    public void addItem(){
        inv1.addItem(item1);

        assertTrue(inv1.contains(item1));
        assertTrue(inv1.contains("apple"));
        assertEquals(1, inv1.getQuantity(item1));
        assertEquals(1, inv1.getQuantity("apple"));
    }

    @Test
    public void addItem2(){
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);

        assertEquals(inv1.getUsedCapacity(), 9.0);

        inv1.addItem(item3);
        assertEquals(inv1.getUsedCapacity(), 9.0);
    }

    @Test
    public void addItem3() {
        boolean b = inv1.addItem(item4);
        assertFalse(b);
    }

    @Test
    public void contains() {
        inv1.addItem(item1);

        assertTrue(inv1.contains(item1));
        assertTrue(inv1.contains("apple"));

        assertFalse(inv1.contains(item2));
        assertFalse(inv1.contains("sword"));
    }

    @Test
    public void getNbItem() {
        assertEquals(0, inv1.getNbItems());
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item1);

        assertEquals(3, inv1.getNbItems());
        assertEquals(0, inv2.getNbItems());
    }

    @Test void canAddItem() {
        assertTrue(inv1.canAddItem(item1));
        assertTrue(inv1.canAddItem(item4));
    }

    @Test void removeItem() {
        assertFalse(inv1.removeItem(item1));
        assertFalse(inv1.removeItem("apple"));
    }

    @Test void removeItem2() {

    }
}