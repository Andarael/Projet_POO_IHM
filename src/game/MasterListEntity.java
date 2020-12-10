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
    Weapon spear = new Weapon("spear", "a long stick with a piece of metal at the end", 4,4,4);

    // Food   ==================================================================
    Food chicken = new Food("chicken", "a raw chicken", 1, 2, 2);
    Food rotten_chicken = new Food("rotten chicken", "a fragrant chicken", 1,1,-2);
    Food elixir_of_divine_life = new Food("elixir of divine life", "it just look like a bottle of perfume",1,10, 10);
    Food coca_zero = new Food("coca zero", "it just look like oil, but with no sugar in it", 1,5,20);
    Food big_cake = new Food("big cake", "a big lemon cake", 1,3,3);
    Food poison = new Food("weird-looking bottle", "i wouldn't drink this if i were you", 1,10,-15);
    Food apple = new Food("apple","a mouthwatering apple",1,1,1);


    // Keys   ==================================================================


    // Places ==================================================================

    // StaticContainers ========================================================

    // Hostiles ================================================================
    Hostile orc = new Hostile("orc", "a green creature", 5, 5);
    Hostile goblin = new Hostile("goblin", "a small and pathetic creature", 3, 3);
    Hostile dragon = new Hostile("dragon", "a gigantic dragon with emerald reflections", 20, 20);
    Hostile necromancer = new Hostile("necromancer", "a dark wizard in tattered clothes", 10, 10);
    Hostile minotaur = new Hostile("minotaur", "a scary creature with a man's body but a bull's head", 8,8);
    Hostile ghost = new Hostile("ghost", "you can barely see the outlines of this creature", 6,6);
    Hostile skeleton = new Hostile("skeleton", "a human skeleton with shreds of flesh still attached to its bones", 4, 4);


    // Passive =================================================================
    Passive ordinary_guy = new Passive("ordinary guy", "a human just like you", "Hello sir, the weather is nice, don't you think?");
    Passive merchant = new Passive("merchant", "a big guy with all kinds of things in his bag", "Hello adventurer, would you like to take a look at my goods?");
    Passive scandalf = new Passive("Scandalf the wizard", "He has a long beard and a pointy hat, you should listen to what he tells you", "Hello adventurer, and welcome to the dungeon of Xar Tsaroth ! Kill the dragon and you'll be a hero for ever");


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

        //init item

        output.add(golden_statue);

        //init weapon

        output.add(great_sword);
        output.add(one_handed_sword);
        output.add(dagger);
        output.add(hunters_bow);
        output.add(irons_arrow);
        output.add(spear);

        //init food

        output.add(chicken);
        output.add(rotten_chicken);
        output.add(elixir_of_divine_life);
        output.add(coca_zero);
        output.add(big_cake);
        output.add(poison);
        output.add(apple);

        //init keys
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
        output.add(orc);
        output.add(goblin);
        output.add(dragon);
        output.add(necromancer);
        output.add(minotaur);
        output.add(ghost);
        output.add(skeleton);
        //todo init items
        return output;
    }

    static Set<Passive> initPassives() {
        Set<Passive> output = new HashSet<>();
        output.add(ordinary_guy);
        output.add(merchant);
        output.add(scandalf);
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
