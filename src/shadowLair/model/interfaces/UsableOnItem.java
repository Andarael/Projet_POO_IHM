// Fichier par Josué Raad

package shadowLair.model.interfaces;

import javafx.util.Pair;
import shadowLair.model.entity.item.Item;

/**
 * This interface allow item to be used on other items
 */
public interface UsableOnItem extends Usable {

    Pair<Boolean, String> use(Item item);

}
