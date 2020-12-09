import entity.item.Food;
import entity.item.Item;

import static game.EnumCommand.GO;
import static utils.Col.*;

public class Main {


    public static String createShort(String s) {
        int len = s.length();
        if (s.length() < 5) {
            StringBuilder s2 = new StringBuilder(s);
            for (int i = 0; i < 5 - len; i++)
                s2.append(" ");
            return s2.toString();
        }
        return s.substring(0, 5);
    }


    public static void main(String[] args) {

        String s;

        s = "13245678";

        System.out.println("s : \"" + s + "\", len(s) : " + s.length());

        String s2 = createShort(s);
        System.out.println("s2 : \"" + s2 + "\", len(s) : " + s2.length());

        String s3 = createShort("123");
        System.out.println("s3 : \"" + s3 + "\", len(s) : " + s2.length());

        Item apple = new Food("apple", "a delicious red apple", 2);
        System.out.println(apple);

        System.out.println("\ntaille 2 (7) : ");
        System.out.println("### ###\n" +
                           "#     #\n" +
                           "       \n" +
                           "### ###");

        System.out.println(colorize("RED", RED));
        System.out.println(colorize("BLACK", BLACK));
        System.out.println(colorize("GREEN", GREEN));
        System.out.println(colorize("YELLOW", YELLOW));
        System.out.println(colorize("BLUE", BLUE));
        System.out.println(colorize("PURPLE", PURPLE));
        System.out.println(colorize("CYAN", CYAN));
        System.out.println(colorize("WHITE", WHITE));

        String scol = colorize("some text", BLUE);
        System.out.println(colorize(scol, BACKGROUND_BLUE));

        System.out.println(colorize("BACKGROUND_BLACK", BACKGROUND_BLACK));
        System.out.println(colorize("BACKGROUND_RED", BACKGROUND_RED));
        System.out.println(colorize("BACKGROUND_GREEN", BACKGROUND_GREEN));
        System.out.println(colorize("BACKGROUND_YELLOW", BACKGROUND_YELLOW));
        System.out.println(colorize("BACKGROUND_BLUE", BACKGROUND_BLUE));
        System.out.println(colorize("BACKGROUND_PURPLE", BACKGROUND_PURPLE));
        System.out.println(colorize("BACKGROUND_CYAN", BACKGROUND_CYAN));
        System.out.println(colorize("BACKGROUND_WHITE", BACKGROUND_WHITE));


        System.out.println(GO);
    }
}
