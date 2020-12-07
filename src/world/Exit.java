package world;

public class Exit {
    protected final Place destination;

    public Exit(Place destination){
        this.destination = destination;
    }

    public Place getDestination() {
        return destination;
    }

    public Place goIn(){
        return this.destination;
    }

}

