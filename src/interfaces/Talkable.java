// Fichier par Josué Raad

package interfaces;

public interface Talkable extends Describable {

    String getDialogue();

    void setDialogue(String str);

    default String talk() {
        if (getDialogue() == null)
            return getName() + " have nothing to say";
        else
            return getName() + " : " + getDialogue();
    }
}
