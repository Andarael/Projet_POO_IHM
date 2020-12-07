package entity.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FoodTest {

    Item f1;
    Food f2;

    @BeforeEach
    void setUp() {
        f1 = new Food("apple", "a red apple", 0.2, 1, 3);
        f2 = new Food("chicken", "a grilled chicken", -5);
    }

    @Test
    void getRestoreValue() {
        assertEquals(3, ((Food) f1).getRestoreValue());
        assertEquals(Food.DEFAULT_RESTORE_VALUE, f2.getRestoreValue());
    }

    @Test
    void getDisplay() {
        System.out.println(f1);
        System.out.println(f2);

        assertTrue(f1.getDisplay().contains("3"));
    }
}