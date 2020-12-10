// Fichier par Josué Raad

package interfaces;

import entity.Entity;

/**
 * An interface for objects that can be used by the player
 * The used object displays the message when used
 * and returns true if the use was successfully
 */
public interface Usable {

    /**
     * @return the intended usage of the item
     */
    String getUsage();

    /**
     * displays what happens when the item is used
     *
     * @return true if the item was used correctly
     */
    boolean use();

    boolean use(Entity entity);

}
