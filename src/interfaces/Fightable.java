package interfaces;

import entity.Being;

public interface Fightable {

    int getPower();

    default void attack(Being opponent) {
       opponent.hurt(getPower());
    }
}
