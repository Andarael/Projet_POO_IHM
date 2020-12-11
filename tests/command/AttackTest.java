package command;

import entity.Hostile;
import entity.Player;
import entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.HierarchyBoundsAdapter;
import java.lang.management.PlatformManagedObject;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void checkFight() {
    }

    @Test
    void addLootToPlace() {
    }

    @Test
    void updatedPlayerKills() {
    }
}