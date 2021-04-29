// Fichier par Josué Raad

package model.interfaces;

public interface Talkable extends Describable {

    String getDialogue();

    void setDialogue(String str);

    default String talk() {
        if (getDialogue() == null)
            return getName() + " have nothing to say";
        else
            return getDialogue();
    }
}
