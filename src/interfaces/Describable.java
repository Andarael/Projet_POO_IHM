// Fichier par Josué Raad

package interfaces;

/**
 * An interface for objects that can be described
 * Such objects have a name, a shortName and a description
 *
 */
public interface Describable extends Shortenable {

    /**
     * @return the name of the describable object
     */
    String getName();

    /**
     * @return the description of the describable object
     */
    String getDescription();

    /**
     * @param update the updated description of the describable object
     */
    void updateDescription(String update);

    /**
     * Create a simple version of the describable object to be displayed
     * > (short) Name : description
     * or
     * > (short) Name
     *
     * @return a simple version of the object to be displayed
     */
    default String getSimpleDisplay() {
        String output = "(" + getShortName().trim() + ") " + getName();
        if (getDescription() != null)
            return output + " : " + getDescription();
        return output;
    }

    /**
     * Same principle as getSimpleDisplay(), but with more information the the object if possible
     * @return a detailed version of the object to be displayed
     */
    default String getDisplay() {
        return getSimpleDisplay();
    }

    /**
     * Same as getDisplay() but with possible last minute additions to the display
     * @return a final version of the object to be displayed
     */
    default String print() {
        return getDisplay();
    }

}
