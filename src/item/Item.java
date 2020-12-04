package item;

import java.util.Objects;

public class Item {

    private static final double DEFAULT_WEIGHT = 1.0;

    private final String name;
    private final double weight;


    public Item(String name) {
        this(name, DEFAULT_WEIGHT);
    }

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Item pomme = new Item("pomme");
        System.out.println(pomme.getName());
        System.out.println(pomme);
    }
}
