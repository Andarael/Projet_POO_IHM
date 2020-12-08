package entity;

import entity.item.Item;
import interfaces.Equipable;

/**
 * An Hostile is a Being hostile toward the player
 */
public class Hostile extends Being {

    public Hostile(String name, String description, int hp, int power) {
        super(name, description, hp, power);
    }
}
