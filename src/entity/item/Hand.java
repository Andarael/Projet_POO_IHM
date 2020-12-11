// Fichier par Josué Raad

package entity.item;

/**
 * Hand is a special unique weapon
 * All hand instances are equal
 * Hand is used to represent no item equipped by the player.
 */
public class Hand extends Weapon {

    public Hand() {
        super("hand", "h", "your very own hands !", 0, 0, 1);
    }

    @Override
    public String getPrefix() {
        return "HAND : ";
    }
}
