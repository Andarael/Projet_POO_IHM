// Fichier par Florian Portrait

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

    /**
     * checks if we can go through this locked exit
     *
     * @return true if we can go
     */
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

    /**
     * checks if the locked exit is locked
     *
     * @return true if it is locked
     */
    public boolean isLocked() {
        return this.locked;
    }

    /**
     * this retrieve the color of the locked exit
     *
     * @return the color
     */
    public Col getColor() {
        return this.color;
    }

    /**
     * this unlock the locked exit with key
     *
     * @param key the key for unlock the locked exit
     */
    public void unLock(Key key) {
        if (this.getColor() == key.getColor())
            this.locked = false;
    }

    /**
     * this lock the locked exit
     */
    public void lock() {
        this.locked = true;
    }

    @Override
    public String draw() {
        return colorize(super.draw(),this.color); //on ajoute des couleurs
    }



    @Override
    public String getSimpleDisplay() {
        return colorize(super.getSimpleDisplay(),this.color); //on ajoute des couleurs
    }

    @Override
    public String getDisplay() {
        return colorize(super.getDisplay(),this.color); //on ajoute des couleurs
    }


}
