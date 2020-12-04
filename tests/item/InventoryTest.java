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

    @BeforeEach
    void setUp() {
        inv1 = new Inventory(10.0);
        inv2 = new Inventory();

        item1 = new Item("apple", 1.0);
        item2 = new Item("sword", 3.0);
        item2 = new Item("shield", 5.0);
    }

    /*
    @Test
    public void {
    }
    */

    @Test
    public void addItem(){

    }
}