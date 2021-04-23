// Fichier par Josué Raad

package model.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shorten(s1).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shorten(s2).length());
        assertEquals(s3.length(), Shortener.shorten(s3).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shorten(s4).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shorten(s5).length());
        assertEquals(Shortener.SHORT_NAME_SIZE, Shortener.shorten(s6).length());
    }

    @Test
    void shortenName2() {
        assertEquals("longN", Shortener.shorten(s1));
        assertEquals("short", Shortener.shorten(s2));
        assertEquals("vs", Shortener.shorten(s3));
        assertEquals("_____", Shortener.shorten(s4));
        assertEquals("_____", Shortener.shorten(s5));
        assertEquals("_____", Shortener.shorten(s6));
    }

    @Test
    void display() {
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println("s3 : " + s3);
        System.out.println("s4 : " + s4);
        System.out.println("s5 : " + s5);
        System.out.println("s6 : " + s6);

        System.out.println(Shortener.shorten(s1));
        System.out.println(Shortener.shorten(s2));
        System.out.println(Shortener.shorten(s3));
        System.out.println(Shortener.shorten(s4));
        System.out.println(Shortener.shorten(s5));
        System.out.println(Shortener.shorten(s6));
    }

}