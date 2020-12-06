import item.Food;
import item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    Item f1;
    Food f2;
    Food f3;

    @BeforeEach
    void setUp() {
        f1 = new Food("apple", "a red apple", 0.2, 1, 3);
        f2 = new Food("black_apple", "a rotten apple", 0.2, 0, -3);
        f3 = new Food("chicken", "a grilled chicken",  5);
    }

    @Test
    void getRestoreValue() {
        assertEquals(3, ((Food) f1).getRestoreValue());
        assertEquals(1, f2.getRestoreValue());
        assertEquals(5, f3.getRestoreValue());
    }

    @Test
    void getDisplay() {
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        assertTrue(f1.getDisplay().contains("3"));
    }
}