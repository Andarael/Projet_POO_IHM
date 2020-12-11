package utils;

import org.omg.PortableInterceptor.ServerRequestInfo;

import static utils.Col.*;

public interface Printer {


    static void printErr(String str) {
        System.out.println("ERROR : " + colorize(str, RED));
    }

    static void printMsg(String str) {
        System.out.println(str);
    }

    static void printDialogue(String str) {
        System.out.println(colorize(str, CYAN));
    }
}
