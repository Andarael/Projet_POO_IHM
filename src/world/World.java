package world;


import entity.place.Place;

public class World {


    private Place currentPlace;
    private boolean end;

    public Place getCurrentPlace() {
        return this.currentPlace;
    }

    public void setCurrentPlace(Place p) {
        this.currentPlace = p;
    }

    public void end() {
        this.end = true;
    }

}
