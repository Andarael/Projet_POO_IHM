package item;

import java.util.Objects;

public class Item {

    protected static final float DEFAULT_WEIGHT = 1.0f;
    protected static final int DEFAULT_VALUE = 1;
    protected static final int DEFAULT_SHORT_NAME_SIZE = 5;

    protected final String name;
    protected String shortName;
    protected final float weight;
    protected final int value;

    public Item(String name, float weight, int value) {
        this.name = name;

        this.shortName = createShort(name);

        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0)
            this.value = DEFAULT_VALUE;
        else
            this.value = value;
    }

    public Item(String name) {
        this(name, DEFAULT_WEIGHT, DEFAULT_VALUE);
        this.shortName = createShort(name);
    }

    public static String createShort(String s){
        int len = s.length();
        if (s.length() < DEFAULT_SHORT_NAME_SIZE) {
            StringBuilder s2 = new StringBuilder(s);
            for (int i = 0; i < DEFAULT_SHORT_NAME_SIZE - len; i++)
                s2.append(" ");
            return s2.toString();
        }
        return s.substring(0, DEFAULT_SHORT_NAME_SIZE);
    }

    public String getName() {
        return name;
    }

    public void setShortName(String s) {
        this.shortName = createShort(s);
    }

    public String getShortName() {
        return shortName;
    }

    public float getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.weight, weight) == 0 && value == item.value && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, value);
    }

    @Override
    public String toString() {
        return "Item{" +
               "'" + name + "'" +
               ", weight=" + weight +
               ", value=" + value +
               '}';
    }
}
