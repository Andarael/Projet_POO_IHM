// Fichier par Josué Raad

package model.interfaces;

import model.utils.Printer;

import static controller.utils.Utils.capitalize;
import static controller.utils.Utils.readable; // todo move to model

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
