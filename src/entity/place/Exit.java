package entity.place;

import entity.Entity;

public class Exit extends Entity {
    protected final Place destination;

    public Exit(Place destination) {
        super(destination.getName());
        this.destination = destination;
    }

    public Exit() {
        super(null);
        destination = null;
    }

    public Place getDestination() {
        return this.destination;
    }

    public Place goIn() {
        return this.destination;
    }


}

