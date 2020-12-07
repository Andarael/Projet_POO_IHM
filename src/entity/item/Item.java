package item;

import entity.Entity;

public class Item extends Entity implements Comparable<Item> {

    public static final double DEFAULT_WEIGHT = 0.1;
    public static final int DEFAULT_VALUE = 0;

    protected static String PREFIX;

    private final double weight;
    private final int value;

    public Item(String name, String description, double weight, int value) {
        super(name, description);

        // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
        this.weight = weight;

        // on n'autorise pas de valeur négative.
        if (value < 0)
            this.value = DEFAULT_VALUE;
        else
            this.value = value;

        PREFIX = "ITEM : ";
    }

    public Item(String name, double weight, int value) {
        this(name, null, weight, value);
    }

    public Item(String name, String description) {
        this(name, description, DEFAULT_WEIGHT, DEFAULT_VALUE);
    }

    public Item(String name) {
        this(name, null);
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getDisplay() {
        return PREFIX +  getSimpleDisplay() +
               ", weight : " + weight +
               ", value : " + value;
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }
}
