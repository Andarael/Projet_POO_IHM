package entity;

import interfaces.Descriptable;
import interfaces.Lookable;
import interfaces.Shortable;

import static utils.Shortener.shorten;

public class Entity implements Lookable, Shortable, Descriptable {

    private static final String DEFAULT_NAME = "entityName";
    private static final int DEFAULT_HEALTH = 20;

    private final String name;
    private final String description;
    private String shortName;
    protected final int MAX_HEALTH;
    protected int health;

    public Entity(String name, String description, int health) {
        if (name == null)
            name = DEFAULT_NAME;

        if (health < 1)
            health = DEFAULT_HEALTH;

        this.MAX_HEALTH = health;
        this.health = health;
        this.name = name;
        this.description = description;
        this.shortName = shorten(name);
    }

    public Entity(String name, String description) {
        this(name, description, DEFAULT_HEALTH);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void healMax() {
        this.health = MAX_HEALTH;
    }

    public void heal(int hp) {
        if (hp > 0)
            this.health += hp;
    }

    public void hurt(int amount) {
        health -= amount;
        if (health < 0)
            health = 0;
    }

    public boolean isDead() {
        return health < 0;
    }

    public void setHealth(int hp) {
        this.health = hp;
    }

    @Override
    public String look() {
        return getDisplay();
    }

    @Override
    public String getDisplay() {
        if (description != null)
            return name + " : " + description;
        return name;
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
        return getClass().getSimpleName() + " {" +
                      getDisplay() +
                      "}";
    }
}
