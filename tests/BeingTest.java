import entity.Being;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeingTest {

    private Being player;
    private Being npc;
    private Being monster1;
    private Being monster2;

    @BeforeEach
    void setUp() {
      /*  player = new Player();
        npc = new Npc("vieux_marchand", "un vieux marchand");
        monster1 = new Monster("monster", "il fait peur", 10);
        monster2 = new Monster("spider", "silky beauty", 5);*/

        player = new Being(null, null);
        npc = new Being("vieux_marchand", "un vieux marchand");
        monster1 = new Being("monster", "il fait peur", 10);
        monster2 = new Being("spider", "silky beauty", 5);
    }

    @Test
    void getName() {
        assertSame("vieux_marchand", npc.getName());
        assertSame("player", npc.getName().toLowerCase());
        assertSame("monster", npc.getName().toLowerCase());
    }

    @Test
    void getDescription() {
        assertTrue(npc.getDescription().contains("marchand"));
        assertNull(player.getDescription());
    }

    @Test
    void look() {
        assertTrue(npc.look().contains(npc.getDisplay()));
    }

    @Test
    void getDisplay() {
        System.out.println(npc);
        System.out.println(monster1);
        System.out.println(player);
        assertTrue(npc.getDisplay().contains("un vieux"));
    }

    @Test
    void setShortName() {
        monster1.setShortName("M");
        assertEquals("M    ", monster1.getShortName());

        monster1.setShortName("MONSTRE");
        assertEquals("MONST", monster1.getShortName());
    }


    @Test
    void getHealth() {
        assertEquals(10, monster1.getHP());
        assertEquals(20, npc.getHP());
        assertEquals(20, player.getHP());
    }

    @Test
    void getMAX_HEALTH() {
        assertEquals(10, monster1.getMAX_HP());
        assertEquals(20, npc.getMAX_HP());
        assertEquals(20, player.getMAX_HP());
    }

    @Test
    void healMax() {
        player.hurt(player.getMAX_HP() - 5);
        assertNotEquals(player.getMAX_HP(), player.getHP());
        player.healMax();
        assertEquals(player.getMAX_HP(), player.getHP());
    }

    @Test
    void heal() {
        int healthTemp = player.getHP();

        player.hurt(10);
        player.heal(5);

        assertEquals(healthTemp-10+5, player.getHP());
    }

    @Test
    void heal2() {
        int healthTemp = player.getHP();
        player.heal(15);
        assertEquals(healthTemp, player.getHP());

        player.hurt(5);
        healthTemp = player.getHP();
        player.heal(-15);
        assertEquals(healthTemp, player.getHP());

        player.hurt(5);
        healthTemp = player.getHP();
        player.heal(-15);
        assertEquals(healthTemp, player.getHP());

        player.hurt(5);
        healthTemp = player.getHP();
        player.heal(-15);
        assertEquals(healthTemp, player.getHP());
    }

    @Test
    void hurt() {
        npc.hurt(999);
        assertEquals(0, npc.getHP());

        player.hurt(5);
        assertEquals(player.getMAX_HP() - 5, player.getHP());
    }

    @Test
    void isDead() {
        npc.hurt(999);
        assertTrue(npc.isDead());

        monster1.kill();
        assertTrue(monster1.isDead());
    }

    @Test
    void getLevel() {
        assertEquals(1, monster1.getLevel());

        monster1.levelUP();

        assertEquals(2,monster1.getLevel());

        monster2.levelUP(9);
        assertEquals(10,monster2.getLevel());
    }

    @Test
    void levelUP() {
        monster1.levelUP();
        assertEquals(2,monster1.getLevel());

        int expectedMAX_HEALTH = monster1.getMAX_HP() +
                                 monster1.getMAX_HP() /
                                 monster1.getLevel();

        assertEquals(expectedMAX_HEALTH, monster1.getMAX_HP());
        assertEquals(monster1.getMAX_HP(), monster1.getHP());
    }

    @Test
    void levelUP2() {


        int expectedMAX_HEALTH = monster1.getMAX_HP();
        for (int i = 0; i < 9; i++)
            expectedMAX_HEALTH += monster1.getMAX_HP() /
                                  monster1.getLevel();

        monster1.levelUP(9);
        assertEquals(expectedMAX_HEALTH, monster1.getHP());
    }

    @Test
    void testToString() {
    }
}