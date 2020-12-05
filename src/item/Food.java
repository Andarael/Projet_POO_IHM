package item;

public class Food extends Item {

    private static final int DEFAULT_RESTORE = 1;
    private final int restore;

    public Food(String name) {
        super(name);
        restore = DEFAULT_RESTORE;
    }

    public int getRestore() {
        return restore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Food food = (Food) o;
        return getRestore() == food.getRestore();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRestore();
        return result;
    }

    @Override
    public String toString() {
        return "Food{" +
               "'" + getName() + "'" +
               ", shortName='" + getShortName() + '\'' +
               ", weight=" + getWeight() +
               ", value=" + getValue() +
               ", restore=" + restore +
               '}';
    }
}
