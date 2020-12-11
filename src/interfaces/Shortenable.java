// Fichier par Josué Raad

package interfaces;

/**
 * An Interface to interact with object that can be shortened
 * A shortname is the usual way for the user to interact with game elements in the terminal
 *
 * For example : > GET SWRD -> will SWRD can be interpreted as short for Sword
 */
public interface Shortenable {

    String getShortName();

}
