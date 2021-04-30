// Fichier par Josué Raad

package shadowLair.model.interfaces;

import shadowLair.model.utils.Printer;

import static shadowLair.model.utils.StringUtils.capitalize;
import static shadowLair.model.utils.StringUtils.readable;

/**
 * An Interface to interact with objects that can be looked at.
 */
public interface Lookable extends Drawable {

    /**
     * Displays the content of the current object
     *
     * @return the string that was displayed
     */
    default String look() {
        Printer.printMsg(getDisplay());
        return getDisplay();
    }

    default String getSimpleLook() {
        return capitalize(readable(getName())) + " : " + getDescription();
    }

}
