package utils;

public interface StringUtils {

    static String stringFill(int size, char c) {
        String output = "";

        for (int i = 0; i < size; i++)
            output = output.concat(String.valueOf(c));

        return output;
    }

    static String rightPad(String str, int size, char c) {
        if (str == null)
            return null;

        return str + stringFill(size, c);
    }

    static String leftPad(String str, int size, char c) {
        if (str == null)
            return null;

        return stringFill(size, c) + str;
    }

}
