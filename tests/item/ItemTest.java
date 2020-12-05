package item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @BeforeEach
    void setUp() {
        item1 = new Item("apple", 1.0f);
        item2 = new Item("sword", 3.0f);
        item3 = new Item("shield",-10);
        item4 = new Item("shield", 10);
    }

    @Test
    void getName() {
        assertEquals("apple", item1.getName());
        assertEquals("shield", item3.getName());
    }

    @Test
    void getWeight() {
        assertEquals(3.0f, item2.getWeight());
        assertEquals(1.0f, item3.getWeight());
    }

    @Test
    void getValue() {
        assertEquals(1, item1.getValue());
        assertEquals(1, item2.getValue());
        assertEquals(10, item4.getValue());
        assertEquals(1, item3.getValue());
    }

    @Test
    void testEquals() {
        assertEquals(item1, new Item("apple", 1.0f));
        assertEquals(item3, new Item("shield"));
    }

    @Test
    void testHashCode() {
        assertEquals(-345707609, item1.hashCode());
    }

    @Test
    void testToString() {
        System.out.println(item1);
        assertEquals("Item{name='apple', weight=1.0}", item1.toString());
    }
}