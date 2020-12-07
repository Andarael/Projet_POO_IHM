package entity;

import interfaces.Fightable;

public class Hostile extends Being implements Fightable {

    private final int power;

    public Hostile(String name, String description, int hp, int power) {
        super(name, description, hp);
        if (power < 1)
            power = 1;
        this.power = power;
    }

    public void attack(Being opponent) {
        if (!isDead())
            opponent.hurt(getPower());
    }

    public int getPower() {
        return power;
    }
}
