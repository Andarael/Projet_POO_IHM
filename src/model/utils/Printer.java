// fichier par josué Raad

package model.utils;

import static model.utils.Col.*;

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
