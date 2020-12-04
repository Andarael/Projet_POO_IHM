package item;

import java.util.Objects;

public class Item {

    private static final float DEFAULT_WEIGHT = 1.0f;

    private final String name;
    private final float weight;


    public Item(String name) {
        this(name, DEFAULT_WEIGHT);
    }

    public Item(String name, float weight) {
        this.name = name;
        this.weight = weight; // on autorise les poids négatifs, par ex pour un item qui ajout de la capacité de port
    }

    public Item(String name, double weight) {
        this(name, (float) weight);
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
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
