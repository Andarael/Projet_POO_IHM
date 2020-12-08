package interfaces;

public interface Talkable extends Describable {

    String getDialogue();

    void changeDialogue(String str);

    default String talk() {
        return getName() + getDialogue();
    }
}
