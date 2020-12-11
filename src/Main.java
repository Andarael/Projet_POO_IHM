import entity.item.Food;
import entity.item.Item;
import game.Game;

import static command.Command.GO;
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

        Game.play(1);
    }
}
