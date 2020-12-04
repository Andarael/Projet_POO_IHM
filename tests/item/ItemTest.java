package item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    private Item item1;
    private Item item2;
    private Item item3;

    @BeforeEach
    void setUp() {
        item1 = new Item("apple", 1.0);
        item2 = new Item("sword", 3.0);
        item3 = new Item("shield");
    }

    @Test
    void getName() {
        assertEquals("apple", item1.getName());
        assertEquals("shield", item3.getName());
    }

    @Test
    void getWeight() {
        assertEquals(3.0, item2.getWeight());
        assertEquals(1.0, item3.getWeight());
    }

    @Test
    void testEquals() {
        assertEquals(item1, new Item("apple", 1.0));
        assertEquals(item3, new Item("shield"));
    }

    @Test
    void testHashCode() {
        assertEquals(-338367577, item1.hashCode());
    }

    @Test
    void testToString() {
        System.out.println(item1);
        assertEquals("Item{name='apple', weight=1.0}", item1.toString());
    }
}