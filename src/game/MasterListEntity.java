// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package game;

import entity.*;
import entity.item.*;
import entity.place.Place;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.Col.*;

public interface MasterListEntity {
    // =========================================================================

    // Items ===================================================================
    Entity pog = new Item("Pog");
    Item golden_statue = new Item("golden statue", "a small statue with a frightful effigy",1,20);

    Key redKey = new Key("redKey", "a red key", RED);


    // todo add all entities
    // Weapons =================================================================
    Weapon great_sword = new Weapon("great sword", "a big and heavy sword made with steel", 5, 5, 5);
    Weapon one_handed_sword = new Weapon("one-handed sword", "a short but sharp sword made with iron", 3, 3, 3);
    Weapon dagger = new Weapon("dagger", "a tiny dagger", 1, 1, 1);
    Bow hunters_bow = new Bow("hunter's bow", "a small but tough bow, made for sharpened arrows", 3, 3, 3);
    Arrow irons_arrow = new Arrow();

    // Food   ==================================================================
    Food chicken = new Food("chicken", "a raw chicken", 1, 2, 2);
    Food rotten_chicken = new Food("rotten chicken", "a fragrant chicken", 1,1,-2);
    Food elixir_of_divine_life = new Food("elixir of divine life", "it just look like a bottle of perfume",1,10, 10);
    Food coca_zero = new Food("coca zero", "it just look like oil, but with no sugar in it", 1,5,20);
    Food big_cake = new Food("big cake", "a big lemon cake", 1,3,3);
    Food poison = new Food("weird-looking bottle", "i wouldn't drink this if i were you", 1,10,-15);

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
