// fichier par josué Raad

package shadowLair.model.utils;

import static shadowLair.model.utils.Col.*;

public class Printer {

    public static boolean silence = Boolean.FALSE;
    public static boolean displayErrors = true;


    public static String printErr(String str) {
        if (displayErrors)
            System.out.println("ERROR : " + colorize(str, RED));
        return str + "\n";
    }

    public static String printMsg(String str) {
        if (!silence)
            System.out.println(str);
        return str + "\n";
    }

    public static String printDialogue(String str) {
        if (!silence)
            System.out.println(colorize(str, CYAN));
        return str + "\n";
    }
}
