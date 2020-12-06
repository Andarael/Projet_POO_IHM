package item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void handTest() {
        Item h1 = new Hand();
        Item h2 = new Hand();
        h2.setShortName("h");
        assertEquals(h1,h2);

        System.out.println(h1);
        System.out.println(h2);
    }

}