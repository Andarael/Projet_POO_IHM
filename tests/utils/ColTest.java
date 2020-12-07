package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Col.*;

class ColTest {

    @Test
    void testCol() {
        System.out.println(colorize("RED", RED));
        System.out.println(colorize("BLACK", BLACK));
        System.out.println(colorize("GREEN", GREEN));
        System.out.println(colorize("YELLOW", YELLOW));
        System.out.println(colorize("BLUE", BLUE));
        System.out.println(colorize("PURPLE", PURPLE));
        System.out.println(colorize("CYAN", CYAN));
        System.out.println(colorize("WHITE", WHITE));

        String scol = colorize("some text", BLUE);
        System.out.println(colorize(scol, BACKGROUND_BLUE));

        System.out.println(colorize("BACKGROUND_BLACK", BACKGROUND_BLACK));
        System.out.println(colorize("BACKGROUND_RED", BACKGROUND_RED));
        System.out.println(colorize("BACKGROUND_GREEN", BACKGROUND_GREEN));
        System.out.println(colorize("BACKGROUND_YELLOW", BACKGROUND_YELLOW));
        System.out.println(colorize("BACKGROUND_BLUE", BACKGROUND_BLUE));
        System.out.println(colorize("BACKGROUND_PURPLE", BACKGROUND_PURPLE));
        System.out.println(colorize("BACKGROUND_CYAN", BACKGROUND_CYAN));
        System.out.println(colorize("BACKGROUND_WHITE", BACKGROUND_WHITE));


    }
}