// Fichier par Josué Raad

package utils;

public interface Shortener {
    int SHORT_NAME_SIZE = 5;

    /**
     * Shortens the input string to fit the SHORT_NAME_SIZE length
     *
     * @param str the input String to shorten
     * @return shortened String
     */
    static String shorten(String str) {
        String output = StringUtils.stringFill(SHORT_NAME_SIZE, '_');

        if (str == null)
            return output;

        if (str.length() < 1)
            return output;

        if (str.trim().length() < 1) {
            return output;
        }

        output = str.substring(0, Math.min(str.length(), SHORT_NAME_SIZE)).trim();

        return output;
    }

}