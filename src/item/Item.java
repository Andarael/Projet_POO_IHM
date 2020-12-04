package item;

import java.util.Objects;

public class Item {

    private static final double DEFAULT_WEIGHT = 1.0;

    private final String name;
    private final double weight;
    private int quantity;


    public Item(String name, double weight){
        this(name, weight, 1);
    }

    public Item(String name) {
        this(name, DEFAULT_WEIGHT, 1);
    }

    private Item(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public static void main(String[] args) {
        Item pomme = new Item("pomme");

        pomme.getName();
        System.out.println(pomme);


    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                ", x " + quantity +
                '}';
    }
}
