import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Shortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortenerTest {


    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;
    private String s6;

    @BeforeEach
    void setUp() {
        s1 = "longName";
        s2 = "short";
        s3 = "vs"; // very short
        s4 = "";
        s5 = " ";
        s6 = null;
    }


    @Test
    void shortenName1() {
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s1).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s2).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s3).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s4).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s5).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shortenName(s6).length());
    }

    @Test
    void shortenName2() {
        assertEquals("longN", Shortener.shortenName(s1));
        assertEquals("short", Shortener.shortenName(s2));
        assertEquals("vs   ", Shortener.shortenName(s3));
        assertEquals("     ", Shortener.shortenName(s4));
        assertEquals("     ", Shortener.shortenName(s5));
        assertEquals("     ", Shortener.shortenName(s6));
    }

    @Test
    void display() {
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println("s3 : " + s3);
        System.out.println("s4 : " + s4);
        System.out.println("s5 : " + s5);
        System.out.println("s6 : " + s6);

        System.out.println(Shortener.shortenName(s1));
        System.out.println(Shortener.shortenName(s2));
        System.out.println(Shortener.shortenName(s3));
        System.out.println(Shortener.shortenName(s4));
        System.out.println(Shortener.shortenName(s5));
        System.out.println(Shortener.shortenName(s6));
    }

}