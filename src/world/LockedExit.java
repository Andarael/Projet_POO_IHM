package world;

import entity.item.Key;
import utils.Col;

import java.awt.*;

public class LockedExit extends Exit {
    private boolean isLocked;
    private final Place origine;
    private final Col color;

    public LockedExit(Place destination, Place origine, String direction, Col color) {
        super(destination, direction);
        this.origine = origine;
        this.isLocked = true;
        this.color = color;
    }

    public boolean canGo(){
        return !this.isLocked;
    }

    @Override
    public Place goIn(){
        if (!this.canGo()){
            System.out.println("Exit is locked");
            return this.origine;
        }else {
            return this.destination;
        }
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public Place getOrigine() {
        return this.origine;
    }

    public Col getColor(){
        return this.color;
    }

    public void unLock(Key key) {
        if (getColor() == key.getColor()){
            isLocked = false;
        }else{
            System.out.println("Please use the key required for this outing");
        }

    }

    public void lock(){
        this.isLocked = true;
    }



}
