package inventory;

import item.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        item1 = new Item("apple", 1.0f, 1);
        item2 = new Item("sword", 3.0f, 1);
        item3 = new Item("shield", 5.0f, 1);
    }

    @Test
    public void Inventory() {
        Inventory inv = new Inventory();
        Assertions.assertEquals(0, inv.getNbItems());
    }

    @Test
    void display() {
        String s = "Inventory{itemList=[Item{name='apple', weight=1.0}, Item{name='apple', weight=1.0}, Item{name='sword', weight=3.0}, Item{name='shield', weight=5.0}, Item{name='sword', weight=3.0}], nbItems=5}";

        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.addItem(item3);
        inv1.addItem(item2);

        System.out.println(inv1);

        Assertions.assertEquals(s, inv1.toString());
    }

    @Test
    void getNbItems() {
        Assertions.assertEquals(0, inv1.getNbItems());

        inv1.addItem(item1);
        Assertions.assertEquals(1, inv1.getNbItems());

        inv1.addItem(item2);
        Assertions.assertEquals(2, inv1.getNbItems());

        inv1.addItem(item3);
        Assertions.assertEquals(3, inv1.getNbItems());

        inv1.removeItem(item1);
        Assertions.assertEquals(2, inv1.getNbItems());

        Assertions.assertEquals(0, inv2.getNbItems());
    }

    @Test
    void getNbItems2() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.addItem(item2);
        inv1.removeItem(item1);
        Assertions.assertEquals(3, inv1.getNbItems());
        inv1.removeItem(item2);
        Assertions.assertEquals(2, inv1.getNbItems());
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(inv1.isEmpty());

        inv1.addItem(item1);
        inv1.addItem(item2);
        Assertions.assertFalse(inv1.isEmpty());

        inv1.removeItem(item1);
        Assertions.assertFalse(inv1.isEmpty());
    }

    @Test
    void getFirstItem() {
        Assertions.assertNull(inv1.getFirstItem());

        inv1.addItem(item1);
        inv1.addItem(item2);
        Assertions.assertSame(item1, inv1.getFirstItem());

        inv2.addItem(item1);
        inv2.removeItem(item1);
        Assertions.assertNull(inv2.getFirstItem());
    }

    @Test
    void removeAllItems() {
        for (int i = 0; i < 64; i++)
            inv1.addItem(item1);
        inv1.removeAllItems();
        Assertions.assertTrue(inv1.isEmpty());
    }

    @Test
    void addItem() {
        Assertions.assertTrue(inv1.addItem(item1));
        Assertions.assertTrue(inv1.addItem(item1));
        Assertions.assertTrue(inv1.addItem(item1));
        Assertions.assertTrue(inv1.addItem(item3));

        Assertions.assertTrue(inv1.contains(item1));
        Assertions.assertTrue(inv1.contains("apple"));

        Assertions.assertEquals(3, inv1.getQuantity(item1));
        Assertions.assertEquals(3, inv1.getQuantity("apple"));
    }

    @Test
    void removeItem() {
        Assertions.assertFalse(inv1.removeItem(item1));
        Assertions.assertFalse(inv1.removeItem("apple"));

        inv1.addItem(item1);
        Assertions.assertTrue(inv1.removeItem(item1));

        inv1.addItem(item1);
        Assertions.assertTrue(inv1.removeItem("apple"));
    }

    @Test
    void removeItem2() {
        inv1.addItem(item1);
        Assertions.assertFalse(inv1.removeItem(item2));
        inv1.addItem(item2);
        Assertions.assertTrue(inv1.removeItem(item2));
    }

    @Test
    void contains() {
        Assertions.assertFalse(inv1.contains(item1));
        Assertions.assertFalse(inv1.contains("apple"));

        inv1.addItem(item1);
        Assertions.assertTrue(inv1.contains(item1));
        Assertions.assertTrue(inv1.contains("apple"));

        Assertions.assertFalse(inv1.contains(item2));
        Assertions.assertFalse(inv1.contains("sword"));

        inv1.addItem(item2);
        Assertions.assertTrue(inv1.contains("sword"));
    }

    @Test
    void contains2() {
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv1.removeItem(item1);
        Assertions.assertTrue(inv1.contains(item1));

        inv2.addItem(item2);
        Assertions.assertFalse(inv2.contains(item1));
    }

    @Test
    void getQuantity() {
        Assertions.assertEquals(0, inv1.getQuantity(item1));

        int nb = 16;
        for (int i = 0; i < nb; i++)
            inv1.addItem(item1);

        Assertions.assertEquals(nb, inv1.getQuantity(item1));
        Assertions.assertEquals(0, inv1.getQuantity(item2));

        Assertions.assertEquals(inv1.getQuantity("apple"), inv1.getQuantity(item1));

        inv1.removeItem(item1);
        Assertions.assertEquals(nb - 1, inv1.getQuantity(item1));

        inv1.removeItem(item2);
        Assertions.assertEquals(0, inv1.getQuantity(item2));
    }

    @Test
    void getItem() {
        Assertions.assertNull(inv1.getItem("apple"));

        inv1.addItem(item1);
        Assertions.assertSame(item1, inv1.getItem("apple"));

        Assertions.assertNull(inv1.getItem("monkey"));

        inv1.removeItem("apple");
        Assertions.assertNull(inv1.getItem("apple"));
    }
}