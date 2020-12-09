// Fichier par Josué Raad

package entity;

import interfaces.Lookable;

import static java.util.Objects.hash;
import static utils.Shortener.shorten;

/**
 * An Entity is an object that is Lookable, drawable and describable
 * An entity have a name, a shortName and a description
 * Only the description can be null
 * If an Entity is miss constructed, default values are used to avoid an ill formed Entity.
 * <p>
 * An entity is equal to another if their name or shortName are the same, their description could be different.
 */
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
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

        if (!(o instanceof Entity))
            return false;

        Entity ComparedEntity = (Entity) o;

        String comparedName = ComparedEntity.getName().toUpperCase();
        String comparedShortName = ComparedEntity.getShortName().toUpperCase();

        boolean part1 = (name.toUpperCase()).equals(comparedName);
        boolean part2 = (shortName.toUpperCase()).equals(comparedShortName);

        return (part1 || part2);
    }

    @Override
    public int hashCode() {
        int hash1 = hash(name.toUpperCase());
        int hash2 = hash(shortName.toUpperCase());

        // opération bit à bit sur sur les hash de name et ShortName pour correspondre à equals()
        return hash(hash1 | hash2);
    }

    @Override
    public String toString() {
        return print();
    }

}
