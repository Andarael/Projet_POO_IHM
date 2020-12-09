package entity.place;

import entity.item.Key;
import utils.Col;

public class LockedExit extends Exit {
    private boolean locked;
    private final Place origine;
    private final Col color;

    public LockedExit(Place destination, Place origine, Col color) {
        super(destination);
        this.origine = origine;
        this.locked = true;
        this.color = color;
    }

    public boolean canGo(){
        return !this.locked;
    }

    @Override
    public Place goIn(){
        if (!this.canGo()){
            return this.origine;
        }else {
            return this.destination;
        }
    }

    public boolean isLocked() {
        return this.locked;
    }

    public Place getOrigine() {
        return this.origine;
    }

    public Col getColor(){
        return this.color;
    }

    public void unLock(Key key) {
        if (getColor() == key.getColor())
            this.locked = false;
    }

    public void lock(){
        this.locked = true;
    }



}
