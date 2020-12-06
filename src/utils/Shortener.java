package utils;

public class Shortener {
    public static final int SHORT_NAME_SIZE = 5;

    /**
     * Shortens the input string to fit the SHORT_NAME_SIZE length
     *
     * @param str the input String to shorten
     * @return shortened String
     */
    public static String shortenName(String str) {
        if (str == null)
            return StringUtils.stringFill(SHORT_NAME_SIZE, ' ');

        return StringUtils.rightPad(str, SHORT_NAME_SIZE, ' ').substring(0, SHORT_NAME_SIZE);
    }

}