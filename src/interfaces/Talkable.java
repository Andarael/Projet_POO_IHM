package interfaces;

public interface Talkable extends Describable {

    String getDialogue();

    default String talk() {
        return getName() + getDialogue();
    }
}
