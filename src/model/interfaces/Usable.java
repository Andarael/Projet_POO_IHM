// Fichier par Josué Raad

package model.interfaces;

import javafx.util.Pair;
import model.entity.Entity;

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
    Pair<Boolean, String> use();

    Pair<Boolean, String> use(Entity entity);

}
