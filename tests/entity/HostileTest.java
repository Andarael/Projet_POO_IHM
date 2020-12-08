package entity;

import entity.item.Item;
import entity.item.Key;
import entity.item.Weapon;
import static utils.Col.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostileTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void Hostile() {
        Hostile h = new Hostile("spider", "qui fait peur", 5, 3);
        h.addGold(5);
        h.addItem(new Item("book"));
        h.addItem(new Weapon("axe", null, 3));
        h.addItem(new Key("redKey", null, RED));


        assertEquals(5, h.getHp());
        assertEquals(3, h.getPower());
        System.out.println(h.getSimpleDisplay());
        System.out.println(h.getDisplay());
        System.out.println(h);
    }
}