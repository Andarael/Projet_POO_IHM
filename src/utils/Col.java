package utils;

/**
 * A simple enum to get colorization in terminal
 * It is based on ANSI escape code (wikipedia.org/wiki/ANSI_escape_code)
 * So the default windows powershell does not support it.
 */
public enum Col {
    RESET("\u001B[0m"),

    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),

    BACKGROUND_BLACK("\u001B[40m"),
    BACKGROUND_RED("\u001B[41m"),
    BACKGROUND_GREEN("\u001B[42m"),
    BACKGROUND_YELLOW("\u001B[43m"),
    BACKGROUND_BLUE("\u001B[44m"),
    BACKGROUND_PURPLE("\u001B[45m"),
    BACKGROUND_CYAN("\u001B[46m"),
    BACKGROUND_WHITE("\u001B[47m");

    private final String value;

    Col(String s) {
        this.value = s;
    }

    public static String colorize(String s, Col color) {
        return color + s + RESET;
    }

    public static void main(String[] args) {
        String s1 = "test en rouge";
        String s2 = "test en bleu";
        String s3 = "test en vert";

        System.out.println(colorize(s1, RED));
        System.out.println(colorize(s2, BLUE));
        System.out.println(colorize(s3, GREEN));
    }

    @Override
    public String toString() {
        return value;
    }
}
