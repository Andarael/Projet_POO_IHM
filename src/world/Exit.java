package world;

import java.awt.*;

public class Exit {
    protected final Place destination;
    private String direction;

    public Exit(Place destination, String direction){
        this.destination = destination;
        this.direction = direction;
    }

    public Place getDestination() {
        return destination;
    }
    public String getDirection(){
        return this.direction;
    }

    public Place goIn(){
        return this.destination;
    }

}

