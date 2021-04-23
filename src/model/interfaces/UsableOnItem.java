// Fichier par Josué Raad

package model.interfaces;

import model.entity.item.Item;

/**
 * This interface allow item to be used on other items
 */
public interface UsableOnItem extends Usable {

    boolean use(Item item);

}
