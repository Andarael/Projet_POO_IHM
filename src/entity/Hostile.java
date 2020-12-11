// Fichier par Josué Raad

package entity;

/**
 * An Hostile is a Being hostile toward the player
 */
public class Hostile extends Being {

    //todo add agressive value

    public Hostile(String name, String shortName, String description, int hp, int power) {
        super(name, shortName, description, hp, power);
    }
}
