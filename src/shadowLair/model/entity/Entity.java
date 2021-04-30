// Fichier par Josué Raad

package shadowLair.model.entity;

import shadowLair.model.interfaces.Lookable;

import static java.util.Objects.hash;
import static shadowLair.model.utils.Shortener.shorten;

/**
 * An Entity is an object that is Lookable, drawable and describable
 * An entity have a name, a shortName and a description
 * Only the description can be null
 * Name and ShortName are formatted (trim and replacement of ' ' with '_')
 * If an Entity is miss constructed, default values are used to avoid an ill formed Entity.
 * <p>
 * An entity is equal to another if their name or shortName are the same, their description could be different.
 */
public abstract class Entity implements Lookable {

    public static final String DEFAULT_NAME = "null";

    private final String name;
    private final String shortName;
    private String description;

    public Entity(String name, String shortName, String description) {
        // Check name is valid
        if (name == null)
            name = DEFAULT_NAME;

        name = name.trim().replaceAll(" ", "_");
        if (name.length() < 1)
            name = DEFAULT_NAME;

        // Check shortName
        if (shortName == null)
            shortName = name;

        shortName = shortName.trim().replaceAll(" ", "_");
        if (shortName.length() < 1)
            shortName = name;

        this.name = name;
        this.shortName = shorten(shortName);
        this.description = description;
    }

    public Entity(String name, String shortName) {
        this(name, shortName, null);
    }

    public Entity(String name) {
        this(name, name, null);
    }

    @Override
    final public String getName() {
        return name;
    }

    @Override
    final public String getDescription() {
        return description;
    }

    @Override
    final public void updateDescription(String update) {
        this.description = update;
    }

    @Override
    final public String getShortName() {
        return this.shortName;
    }

    final public boolean isSame(Entity entity) {
        if (entity == null)
            return false;

        return haveSameNameShortName(this, entity);
    }

    final public boolean isSameStr(String str) {
        if (str == null)
            return false;

        return haveSameNameShortNameStr(this, str);
    }

    /**
     * Two Entities are considered equal if they have the same shortName
     * Most interactions the user will have with entities is via their shortname
     * Also this prevents (in combination with hashcode)
     * the existence of 2 entities with the same shortname in sets.
     *
     * @return true if two items have the same name or shortName
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;
        else if (!(o instanceof Entity))
            return false;

        Entity ComparedEntity = (Entity) o;

        return (shortName).equalsIgnoreCase(ComparedEntity.getShortName());
    }

    @Override
    public int hashCode() {
        return hash(shortName.toUpperCase());
    }

    @Override
    public String toString() {
        return name;
    }



}
