// Fichier par Florian Portrait

package entity.place;

import entity.Entity;

public class Exit extends Entity {
    private final Place destination;

    public Exit(Place destination) {
        super(destination.getName(), destination.getShortName());
        this.destination = destination;
    }

    /**
     * this retrieve the destination of the exit
     *
     * @return a place which is the destination of the exit
     */
    public Place getDestination() {
        return this.destination;
    }

    /**
     * this retrieve the place where we go
     *
     * @return the place destination
     */
    public Place goIn() {
        return this.destination;
    }


}

