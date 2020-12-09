// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package game;

import entity.Container;
import entity.Entity;
import entity.Hostile;
import entity.Passive;
import entity.item.Item;
import entity.place.Place;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface MasterListEntity {
    // =========================================================================

    // Items ===================================================================
    Entity pog = new Item("Pog");


    // todo add all entities
    // Weapons =================================================================

    // Food   ==================================================================

    // Keys   ==================================================================

    // Places ==================================================================

    // StaticContainers ========================================================

    // Hostiles ================================================================

    // Passive =================================================================


    Set<Entity> entityMasterList = initAllEntities();

    static Set<Entity> initAllEntities() {
        HashSet<Entity> output = new HashSet<>();

        output.add(pog);

        // todo implement

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

}
