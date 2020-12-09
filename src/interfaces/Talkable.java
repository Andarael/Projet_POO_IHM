package interfaces;

public interface Talkable extends Describable {

    String getDialogue();

    void setDialogue(String str);

    default String talk() {
        return getName() + " : " + getDialogue();
    }
}
