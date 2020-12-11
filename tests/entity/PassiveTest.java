// Fichier par Josué Raad

package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PassiveTest {

    private Passive passive;

    @BeforeEach
    void setUp() {
        passive = new Passive("Marchand", null, null, "bonjour aventurier, je suis vieux");
    }

    @Test
    void Passive() {
        passive = new Passive(null, null, null, "je suis vieux");
        assertNotNull(passive.getDialogue());
    }

    @Test
    void getDialogue() {
        assertTrue(passive.getDialogue().contains("vieux"));
    }

    @Test
    void changeDialogue() {
        passive.setDialogue("je susi un jeune marchand !");
        assertTrue(passive.getDialogue().contains("jeune"));
    }

}