package interfaces;

/**
 * An Interface to interact with objects that can be looked at.
 *
 */
public interface Lookable extends Drawable {

    /**
     * Displays the content of the current object
     * @return the string that was displayed
     */
    default String look() {
        System.out.println(getDisplay());
        return getDisplay();
    }

}
