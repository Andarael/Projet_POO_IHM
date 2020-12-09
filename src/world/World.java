// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package world;


import entity.Player;
import entity.place.Place;

import java.util.HashSet;
import java.util.Set;

public class World {

    private final Player player;
    private final Set<Place> placeList;
    private Place currentPlace;
    private boolean end;
    private final boolean win;

    public World(int difficulty) {
        if (difficulty < 0 || difficulty > 2)
            difficulty = 1;

        int baseHp = (3 - difficulty) * 10;

        this.player = new Player(baseHp);
        this.end = false;
        this.win = false;
        this.currentPlace = null;
        placeList = new HashSet<>();
    }

    public World() {
        this(1);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isEnd() {
        return end;
    }

    public void end() {
        end = true;
    }

    public int size() {
        return placeList.size();
    }

    public boolean hasWin() {
        return win;
    }

    public void addPlace(Place place) {
        placeList.add(place);
    }

    public Place getPlace(Place place) {
        return
                placeList.stream()
                         .filter(x -> x.equals(place))
                         .findFirst()
                         .orElse(null);
    }

    public Place getPlace(String str) {
        return getPlace(new Place(str));
    }

    public Place getCurrentPlace() {
        return this.currentPlace;
    }

    public void setCurrentPlace(Place place) {
        this.currentPlace = place;
    }

    public void setCurrentPlace(String str) {
        Place place = getPlace(str);

        if (place != null)
            setCurrentPlace(place);
    }

    @Override
    public String toString() {
        return "World {" + "\n" +
               player + "\n" +
               ", placeList=" + placeList + "\n" +
               ", currentPlace=" + currentPlace + "\n" +
               ", end=" + end + "\n" +
               ", win=" + win + "\n" +
               '}';
    }
}
