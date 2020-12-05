package item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item1;
    private Item item2;
    private Item item3;
    private Item item4;

    @BeforeEach
    void setUp() {
        item1 = new Item("apple", 1.0f, 1);
        item2 = new Item("sword", 3.0f, 1);
        item3 = new Item("shield", 10, -10);
        item4 = new Item("pog", 10, 10);
    }

    @Test
    void getShort(){
        assertEquals(item1.getShortName(), "apple");
        assertEquals(item3.getShortName(), "shiel");
        assertEquals(item4.getShortName(), "pog  ");
    }

    @Test
    void setShortName(){
        item1.setShortName("123");
        assertEquals(item1.getShortName(), "123  ");

        item1.setShortName("12345");
        assertEquals(item1.getShortName(), "12345");

        item1.setShortName("123456789");
        assertEquals(item1.getShortName(), "12345");
    }

    @Test
    void getName() {
        assertEquals("apple", item1.getName());
        assertEquals("shield", item3.getName());
    }

    @Test
    void getWeight() {
        assertEquals(3.0f, item2.getWeight());
        assertEquals(10.0f, item3.getWeight());
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
        item1 = new Item("veryverylongname", 1.0f, 1);
        item2 = new Item("veryverylongname", 1.0f, 1);
        item2.setShortName("veryv");
        Item item = new Item("veryverylongname");
        assertEquals(item1, item2);
        assertEquals(item1, item);
        assertNotEquals(item3, item1);
    }

    @Test
    void testHashCode() {
        System.out.println(item1.hashCode());
    }

    @Test
    void testDisplay() {
        System.out.println(item1.toString());
    }
}