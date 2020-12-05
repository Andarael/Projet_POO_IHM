import item.Food;
import item.Item;

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

        Item apple = new Food("apple");
        System.out.println(apple);
    }
}
