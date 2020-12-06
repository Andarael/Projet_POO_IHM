package item;

public class Item {

    public static final float DEFAULT_ITEM_WEIGHT = 0.1f;
    public static final int DEFAULT_ITEM_VALUE = 0;
    public static final int ITEM_SHORT_NAME_SIZE = 5;

    private final String name;
    private String shortName;
    private final float weight;
    private final int value;

    public Item(String name, float weight, int value) {
        if (name == null)
            this.name = "";
        else
            this.name = name;

        this.shortName = createShort(name);

        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0) {
            this.value = DEFAULT_ITEM_VALUE;
        }
        else {
            this.value = value;
        }

    }

    public Item(String name) {
        this(name, DEFAULT_ITEM_WEIGHT, DEFAULT_ITEM_VALUE);
        this.shortName = createShort(name);
    }

    public static String createShort(String s) {
        if (s == null)
            s = " ";
        int len = s.length();
        if (s.length() >= ITEM_SHORT_NAME_SIZE)
            return s.substring(0, ITEM_SHORT_NAME_SIZE);

        StringBuilder s2 = new StringBuilder();
        s2.append(s);
        for (int i = 0; i < ITEM_SHORT_NAME_SIZE - len; i++)
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
