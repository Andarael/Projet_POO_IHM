package utils;

import static utils.Col.RED;
import static utils.Col.colorize;

public interface Printer {


    static void printErr(String str) {
        System.out.println("ERREUR : " + colorize(str, RED));
    }

    static void printMsg(String str) {
        System.out.println(str);
    }
}
