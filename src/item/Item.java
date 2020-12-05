package item;

import java.util.Objects;

public class Item {

    private static final float DEFAULT_WEIGHT = 1.0f;
    private static final int DEFAULT_VALUE = 1;

    private final String name;
    private final float weight;
    private final int value;

    public Item(String name) {
        this(name, DEFAULT_WEIGHT, DEFAULT_VALUE);
    }

    public Item(String name, float weight, int value) {
        this.name = name;
        this.weight = weight; // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port

        // on n'autorise pas de valeur négative.
        if (value < 0) {
            this.value = DEFAULT_VALUE;
        } else {
            this.value = value;
        }
    }

    public Item(String name, int value){
        this(name, DEFAULT_WEIGHT, value);
    }

    public Item(String name, float weight) {
        this(name, weight, DEFAULT_VALUE);
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.weight, weight) == 0 && name.equals(item.name);
    }

    @Override
    public String toString() {
        return "Item{" +
               "name='" + name + '\'' +
               ", weight=" + weight +
               '}';
    }
}
