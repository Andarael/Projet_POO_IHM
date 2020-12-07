package world;

public class Exit {
    protected final Place destination;

    public Exit(Place dest) {
        this.destination = dest;
    }

    public Place GoIn() {
        return this.destination;
    }

}
