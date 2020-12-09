// Fichier par Josué Raad

package interfaces;

public interface Drawable extends Describable {

    default String draw() {
        return getShortName();
    }
}
