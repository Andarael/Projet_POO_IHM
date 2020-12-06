package item;

import utils.Shortener;

public class Item {

    public static final float DEFAULT_WEIGHT = 0.1f;
    public static final int DEFAULT_VALUE = 0;
    public static final String DEFAULT_NAME = "default";

    private final String name;
    private String shortName;
    private final String description;

    private final float weight;
    private final int value;

    public Item(String name, String description, float weight, int value) {

        // le nom ne peut pas être null.
        if (name == null)
            name = DEFAULT_NAME;

        this.name = name;

        this.description = description;

        this.shortName = Shortener.shortenName(name);

        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0) {
            this.value = DEFAULT_VALUE;
        }
        else {
            this.value = value;
        }

    }

    public Item(String name, float weight, int value) {
        this(name, null, weight, value);
    }

    public Item(String name) {
        this(name, null, DEFAULT_WEIGHT, DEFAULT_VALUE);
        this.shortName = Shortener.shortenName(name);
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String s) {
        this.shortName = Shortener.shortenName(s);
    }

    public float getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    /**
     * The only qualification for 2 items to be equal is their name
     *
     * @return true if two items have the same name
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

    public String getSimpleDisplay() {
        if (description != null)
            return name + " : " + description;
        return name;
    }

    public String getDisplay() {
        return getSimpleDisplay() +
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
