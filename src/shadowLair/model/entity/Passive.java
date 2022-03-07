// Fichier par Josué Raad

package shadowLair.model.entity;

import shadowLair.model.interfaces.Talkable;

public class Passive extends Being implements Talkable {

    public static final String DEFAULT_DIALOGUE = "Hello adventurer, i am old";
    public static final int PASSIVE_HEALTH = 7;
    public static final int PASSIVE_POWER = 2;
    private String dialogue;

    public Passive(String name, String shortName, String description, String dialogue) {
        super(name, shortName, description, PASSIVE_HEALTH, PASSIVE_POWER);

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
