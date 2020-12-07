package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item1;
    private Item item2;
    private Item item3;

    @BeforeEach
    void setUp() {
        item1 = new Item("apple", "a red apple", 0.2, 3);
        item2 = new Item("shield", -10, -10);
        item3 = new Item("pog");

    }

    @Test
    void Item() {
        assertNull(item3.getDescription());
        assertEquals(Item.DEFAULT_WEIGHT, item3.getWeight());
        assertEquals(Item.DEFAULT_VALUE, item3.getValue());
    }

    @Test
    void getWeight() {
        assertEquals(0.2, item1.getWeight());
        assertEquals(-10, item2.getWeight());
    }

    @Test
    void getValue() {
        assertEquals(3, item1.getValue());
        assertEquals(Item.DEFAULT_VALUE, item2.getValue());
    }

    @Test
    void testDisplay() {

        System.out.println(item1.getDisplay());

        System.out.println(item3);

        assertTrue(item1.getDisplay().contains("apple"));
        assertTrue(item1.getDisplay().contains("a red apple"));
        assertTrue(item1.getDisplay().contains("0.2"));
        assertTrue(item1.getDisplay().contains("3"));
    }

    @Test
    void compare() {
        assertTrue(item1.compareTo(item2) < 0 );
        assertEquals(item1.getName().compareTo(item2.getName()), item1.compareTo(item2));
        assertTrue(item1.compareTo(item3) < 0 );
        assertEquals(item1.getName().compareTo(item3.getName()), item1.compareTo(item3));
    }
}