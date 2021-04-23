// Fichier par Josué Raad

package model.entity;

/**
 * A static Container is a container that is ... static
 * Like for example a chest, or a loot from a dead monster
 */
public class StaticContainer extends Container {

    public StaticContainer(String name, String shortName, String description) {
        super(name, shortName, description);
    }

    public StaticContainer(String name) {
        super(name);
    }
}
