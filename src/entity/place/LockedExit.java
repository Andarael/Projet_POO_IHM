package entity.place;

import entity.item.Key;
import utils.Col;

import static utils.Col.colorize;

public class LockedExit extends Exit {
    private final Col color;
    private boolean locked;

    public LockedExit(Place destination, Col color) {
        super(destination);
        this.locked = true;
        this.color = color;
    }

    public LockedExit(Col color) {
        super();
        this.color = color;
        this.locked = true;
    }

    public boolean canGo() {
        return !this.locked;
    }

    @Override
    public Place goIn() {
        if (this.canGo())
            return this.getDestination();
        else
            return null;

    }

    public boolean isLocked() {
        return this.locked;
    }

    public Col getColor() {
        return this.color;
    }

    public void unLock(Key key) {
        if (this.getColor() == key.getColor())
            this.locked = false;
    }

    public void lock() {
        this.locked = true;
    }

    @Override
    public String draw() {
        return colorize(super.draw(),this.color);
    }



    @Override
    public String getSimpleDisplay() {
        return colorize(super.getSimpleDisplay(),this.color);
    }

    @Override
    public String getDisplay() {
        return colorize(super.getDisplay(),this.color);
    }


}
