// fichier par josué Raad

package model.utils;

import static model.utils.Col.*;

public class Printer {

    public static boolean silence = Boolean.FALSE;
    public static boolean displayErrors = true;


    public static void printErr(String str) {
        if (displayErrors)
            System.out.println("ERROR : " + colorize(str, RED));
    }

    public static void printMsg(String str) {
        if (! silence)
            System.out.println(str);
    }

    public static void printDialogue(String str) {
        if (! silence)
            System.out.println(colorize(str, CYAN));
    }
}
