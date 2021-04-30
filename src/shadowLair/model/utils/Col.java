// fichier par josué Raad

package shadowLair.model.utils;

/**
 * A simple enum to get colorization in terminal
 * It is based on ANSI escape code (wikipedia.org/wiki/ANSI_escape_code)
 * So the default windows powershell does not support it.
 */
public enum Col {
    RESET("\u001B[0m", "RESET"),

    BLACK("\u001B[30m", "BLACK"),
    RED("\u001B[31m", "RED"),
    GREEN("\u001B[32m", "GREEN"),
    YELLOW("\u001B[33m", "YELLOW"),
    BLUE("\u001B[34m", "BLUE"),
    PURPLE("\u001B[35m", "PURPLE"),
    CYAN("\u001B[36m", "CYAN"),
    WHITE("\u001B[37m", "WHITE"),

    BACKGROUND_BLACK("\u001B[40m", "BACKGROUND_BLACK"),
    BACKGROUND_RED("\u001B[41m", "BACKGROUND_RED"),
    BACKGROUND_GREEN("\u001B[42m", "BACKGROUND_GREEN"),
    BACKGROUND_YELLOW("\u001B[43m", "BACKGROUND_YELLOW"),
    BACKGROUND_BLUE("\u001B[44m", "BACKGROUND_BLUE"),
    BACKGROUND_PURPLE("\u001B[45m", "BACKGROUND_PURPLE"),
    BACKGROUND_CYAN("\u001B[46m", "BACKGROUND_CYAN"),
    BACKGROUND_WHITE("\u001B[47m", "BACKGROUND_WHITE");

    private final String value;
    private final String colorName;

    Col(String s, String colorName) {
        this.value = s;
        this.colorName = colorName;
    }

    /**
     * Colorize a string with the specified color
     *
     * @param s     the string to colorize
     * @param color the color desired
     * @return the colorize string
     */
    public static String colorize(String s, Col color) {
        return color + s + RESET;
    }

    public String getColorName() {
        return this.colorName;
    }

    @Override
    public String toString() {
        return value;
    }
}
