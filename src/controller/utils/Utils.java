package controller.utils;

public interface Utils {
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
