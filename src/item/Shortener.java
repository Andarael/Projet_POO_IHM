package item;

public class Shortener {
    public static final int SHORT_NAME_SIZE = 5;

    public static String shortenName(String s) {
        if (s == null)
            s = " ";
        int len = s.length();

        if (s.length() >= SHORT_NAME_SIZE)
            return s.substring(0, SHORT_NAME_SIZE);

        StringBuilder output = new StringBuilder();
        output.append(s);

        for (int i = 0; i < SHORT_NAME_SIZE - len; i++)
            output.append(" ");

        return output.toString();
    }
}