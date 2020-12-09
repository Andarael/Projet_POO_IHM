// Fichier par Josué Raad

package entity;

/**
 * A static Container is a container that is ... static
 * Like for example a chest, or a loot from a dead monster
 */
public class StaticContainer extends Container {

    public StaticContainer(String name, String description) {
        super(name, description);
    }

    public StaticContainer(String name) {
        super(name);
    }
}
