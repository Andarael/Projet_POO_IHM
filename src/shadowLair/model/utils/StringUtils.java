// Fichier par Josué Raad

package shadowLair.model.utils;

/**
 * An interface to perform some basic functions on strings.
 */
public interface StringUtils {

    /**
     * Create a String of a given length filled with a given char
     *
     * @param size the length of the String to generate
     * @param c    the char to fill the String with
     * @return a new String filled with chars 'c' of length 'size'
     */
    static String stringFill(int size, char c) {
        String output = "";

        for (int i = 0; i < size; i++)
            output = output + c;

        return output;
    }

    /**
     * Add a given amount of char to the right of the given string
     *
     * @param str  the String to add char to the left
     * @param size the number of chars to add
     * @param c    the char to add
     * @return str with size char to the right
     */
    static String rightPad(String str, int size, char c) {
        if (str == null)
            str = "";

        return str + stringFill(size, c);
    }

    /**
     * same as rightPad, but to the left
     */
    static String leftPad(String str, int size, char c) {
        if (str == null)
            str = "";

        return stringFill(size, c) + str;
    }

    static String pluralize(String string, int number, String plural) {
        return number == 1 ? string : plural;
    }

    static String pluralize(String string, int number) {
        return pluralize(string, number, string.trim() + 's');
    }

    static  String capitalize(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }

    static String readable(String str) {
        if (str == null)
            return null;

        return str.replace('_', ' ').trim();
    }
}
