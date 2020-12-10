// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package game;

import entity.*;
import entity.item.Item;
import entity.item.Key;
import entity.place.Place;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.Col.*;

public interface MasterListEntity {
    // =========================================================================

    // Items ===================================================================
    Entity pog = new Item("Pog");
    Key redKey = new Key("redKey", "a red key", RED);

    // todo add all entities
    // Weapons =================================================================

    // Food   ==================================================================

    // Keys   ==================================================================

    // Places ==================================================================

    // StaticContainers ========================================================

    // Hostiles ================================================================

    // Passive =================================================================

    Set<Entity> entityMasterList = getAllEntities();

    static Set<Entity> getAllEntities() {
        HashSet<Entity> output = new HashSet<>();

        output.addAll(initItems());
        output.addAll(initPlaces());
        output.addAll(initHostiles());
        output.addAll(initPassives());
        output.addAll(initContainers());

        // todo implement



        return output;
    }

    static Set<Item> initItems() {
        Set<Item> output = new HashSet<>();
        output.add(new Item("pogillion"));
        output.add(redKey);
        //todo init items
        return output;
    }

    static Set<Place> initPlaces() {
        Set<Place> output = new HashSet<>();
        //todo init items
        return output;
    }

    static Set<Hostile> initHostiles() {
        Set<Hostile> output = new HashSet<>();
        //todo init items
        return output;
    }

    static Set<Passive> initPassives() {
        Set<Passive> output = new HashSet<>();
        //todo init items
        return output;
    }

    static Set<Container> initContainers() {
        Set<Container> output = new HashSet<>();
        //todo init items
        return output;
    }

    static Set<Item> getItems() {
        Set<Item> output;
        output = entityMasterList.stream()
                                 .filter(x -> (x instanceof Item))
                                 .map(x -> (Item) x)
                                 .collect(Collectors.toSet());
        return output;
    }

    static Set<Place> getPlaces() {
        Set<Place> output;
        output = entityMasterList.stream()
                                 .filter(x -> (x instanceof Place))
                                 .map(x -> (Place) x)
                                 .collect(Collectors.toSet());
        return output;
    }

    static Set<Hostile> getHostiles() {
        Set<Hostile> output;
        output = entityMasterList.stream()
                                 .filter(x -> (x instanceof Hostile))
                                 .map(x -> (Hostile) x)
                                 .collect(Collectors.toSet());
        return output;
    }

    static Set<Passive> getPassives() {
        Set<Passive> output;
        output = entityMasterList.stream()
                                 .filter(x -> (x instanceof Passive))
                                 .map(x -> (Passive) x)
                                 .collect(Collectors.toSet());
        return output;
    }

    static Set<Container> getContainers() {
        Set<Container> output;
        output = entityMasterList.stream()
                                 .filter(x -> (x instanceof Container))
                                 .map(x -> (Container) x)
                                 .collect(Collectors.toSet());
        return output;
    }

    static void initPlayer(Player player) {
        // todo player.addItem(...)
        player.addItem(redKey);
    }

}
