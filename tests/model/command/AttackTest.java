package model.command;

import model.entity.Hostile;
import model.entity.Player;
import model.entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
class AttackTest {
    private Player player;
    private Hostile hostile;

    private Place place;

    @BeforeEach
    void setUp() {
        player = new Player();
        hostile = new Hostile("cyclope", null, null, 10 ,2 );
        place = new Place("testRoom", null, null);
        place.addContainer(hostile);
    }

    @Test
    void testAttack() {
        Attack.attack(player, place, "toto");
        Attack.attack(player, place, "cyclope");
        Attack.attack(player, place, "cyclope");
    }
}