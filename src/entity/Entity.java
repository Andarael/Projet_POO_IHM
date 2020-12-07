package entity;

import interfaces.Lookable;

import static utils.Shortener.shorten;

public abstract class Entity implements Lookable {

    public static final String DEFAULT_NAME = "null";

    private final String name;
    private String description;
    private String shortName;

    public Entity(String name, String description) {
        // le nom ne peut pas être null.
        if (name == null)
            name = DEFAULT_NAME;

        this.name = name;
        this.description = description;

        this.shortName = shorten(name);
    }

    public Entity(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String update) {
        this.description = update;
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public void setShortName(String s) {
        this.shortName = shorten(s);
    }

    @Override
    public String toString() {
        return print();
    }

    /**
     * The only qualification for 2 entities to be equal is their ShortName or name
     * The only interaction the user will have with entities is via their shortname
     * The obvious downside is that it won't be possible to add multiple items with
     * different values but same name or shortname to a Set.
     *
     * @return true if two items have the same name or shortName
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Entity ComparedEntity = (Entity) o;
        String comparedName = ComparedEntity.name.toUpperCase();
        String comparedShortName = ComparedEntity.shortName.toUpperCase();

        boolean part1 = shortName.toUpperCase().equals(comparedShortName);
        boolean part2 = name.toUpperCase().equals(comparedName);
        return (part1 || part2);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
