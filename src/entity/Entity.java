package entity;

import interfaces.Lookable;
import inventory.Inventory;
import entity.item.Weapon;

import static utils.Shortener.shorten;

public abstract class Entity implements Lookable {

    public static final String DEFAULT_NAME = "null";

    private final String name;
    private String description;
    private String shortName;
    private boolean hostile;

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

        if (!(o instanceof Entity))
            return false;

        Entity ComparedEntity = (Entity) o;

        String comparedName = ComparedEntity.getName().toUpperCase();
        String comparedShortName = ComparedEntity.getShortName().toUpperCase();

        boolean part1 = (name.toUpperCase()).equals(comparedName);
        boolean part2 = (shortName.toUpperCase()).equals(comparedShortName);

        return (part1 || part2);
    }

    private Entity enti;
    private Weapon weapon;
    private Inventory inventory;

    public boolean hasEntity() {
        if(this.enti != null)
            return true;
        return false;
    }

    public Entity getEntity() {
        return this.enti;
    }

    public boolean isHostile(){
        return this.hostile;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

}
