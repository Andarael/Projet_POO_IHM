package entity;

import interfaces.Talkable;

public class Passive extends Being implements Talkable {

    public static final String DEFAULT_DIALOGUE = "Hello adventurer, i am old";

    private String dialogue;

    public Passive(String name, String description, String dialogue) {
        super(name, description);
        if (dialogue == null)
            dialogue = DEFAULT_DIALOGUE;
        this.dialogue = dialogue;
    }

    public String getDialogue() {
        return dialogue;
    }

    @Override
    public void setDialogue(String str) {
        this.dialogue = str;
    }


}
