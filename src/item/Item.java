package item;

public class Item {

    private static final float DEFAULT_WEIGHT = 1.0f;
    private static final int DEFAULT_VALUE = 1;
    private static final int DEFAULT_SHORT_NAME_SIZE = 5;

    private final String name;
    private final float weight;
    private final int value;
    private String shortName;

    public Item(String name, float weight, int value) {
        this.name = name;


        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0)
            this.value = DEFAULT_VALUE;
        else
            this.value = value;

        this.shortName = createShort(name);
    }

    public Item(String name) {
        this(name, DEFAULT_WEIGHT, DEFAULT_VALUE);
        this.shortName = createShort(name);
    }

    public static String createShort(String s) {
        int len = s.length();
        if (s.length() >= DEFAULT_SHORT_NAME_SIZE)
            return s.substring(0, DEFAULT_SHORT_NAME_SIZE);

        StringBuilder s2 = new StringBuilder();
        s2.append(s);
        for (int i = 0; i < DEFAULT_SHORT_NAME_SIZE - len; i++)
            s2.append(" ");
        return s2.toString();
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String s) {
        this.shortName = createShort(s);
    }

    public float getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }


    /**
     * @return returns true if two items have the same name
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getDisplay() {
        return "'" + name + "'" +
               ", weight=" + weight +
               ", value=" + value;
    }

    @Override
    public String toString() {
        return "Item{" +
               getDisplay() +
               '}';
    }
}
