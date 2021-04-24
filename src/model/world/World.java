// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package model.world;

import model.entity.Entity;
import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Place;

import java.util.Set;

import static model.game.MasterListEntity.*;

public class World implements WorldContains {


    private static final Item itemToGetToWin = divine_jewel;
    public final Set<Entity> entities;
    public final Set<Place> places;
    private final Player player;
    private final boolean win;
    private Place currentPlace;
    private boolean end;


    public World(int difficulty) {
        if (difficulty < 0 || difficulty > 2)
            difficulty = 1;

        // difficulty formula
        int baseHp = (3 - difficulty) * 10;

        this.player = new Player(baseHp);
        this.end = false;
        this.win = false;
        this.currentPlace = entrance;

        entities = entityMasterList;

        places = getPlaces();

        initPlayer(player);
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
        return places.size();
    }

    public boolean hasWin() {
        return player.contains(itemToGetToWin);
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public Place getPlace(String str) {
        return places.stream()
                     .filter(x -> x.isSameStr(str))
                     .findFirst()
                     .orElse(null);
    }

    public Place getCurrentPlace() {
        return this.currentPlace;
    }

    public void setCurrentPlace(Place place) {
        this.currentPlace = place;
    }

    @Override
    public String toString() {
        return "World { " + "\n" +
               "placeList = " + places + "\n" +
               ", currentPlace = " + currentPlace + "\n" +
               ", end = " + end + "\n" +
               ", win = " + win + "\n" +
               "player = " + player + "\n" +
               '}';
    }
}
