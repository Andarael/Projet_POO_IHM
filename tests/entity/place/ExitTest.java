package entity.place;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitTest {
    private Place place1;
    private Place place2;
    private Exit exit1;
    private Exit exit2;

    @BeforeEach
    void setUp() {
        place1 = new Place("Laboratory");
        place2 = new Place("Cave");

        exit1 = new Exit(place1);
        exit2 = new Exit(place2);

    }

    @Test
    void getDestination() {
        assertSame(place1,exit1.getDestination());
        assertSame(place2,exit2.getDestination());
    }

    @Test
    void goIn() {
        assertSame(place1,exit1.goIn());
        assertSame(place2,exit2.goIn());
    }
}