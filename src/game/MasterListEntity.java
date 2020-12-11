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
    Item golden_statue = new Item("golden statue", "a small statue with a frightful effigy",1,20);
    Item divine_jewel = new Item("divine jewel", "as you're looking this jewel, your eyes are getting lost in the maze of its crystalline curves...");

    // todo add all entities
    // Weapons =================================================================
    Weapon great_sword = new Weapon("great sword", "a big and heavy sword made with steel", 5, 5, 5);
    Weapon one_handed_sword = new Weapon("one-handed sword", "a short but sharp sword made with iron", 3, 3, 3);
    Weapon dagger = new Weapon("dagger", "a tiny dagger", 1, 1, 1);
    Weapon spear = new Weapon("spear", "a long stick with a piece of metal at the end", 4,4,4);
    Bow hunters_bow = new Bow("hunter's bow", "a small but tough bow, made for sharpened arrows", 3, 3, 3);
    Arrow irons_arrow = new Arrow();

    // Food   ==================================================================
    Food chicken = new Food("chicken", "a raw chicken", 1, 2, 2);
    Food rotten_chicken = new Food("rotten chicken", "a fragrant chicken", 1,1,-2);
    Food elixir_of_mystic_life = new Food("elixir of mystic life", "it just look like a bottle of perfume",1,10, 10);
    Food coca_zero = new Food("coca zero", "it just look like oil, but with no sugar in it", 1,5,20); // wtf
    Food big_cake = new Food("big cake", "a big lemon cake", 1,3,3);
    Food poison = new Food("weird-looking bottle", "i wouldn't drink this if i were you", 1,10,-15);
    Food apple = new Food("apple","a mouthwatering apple",1,1,1);


    // Keys   ==================================================================
    Key redKey = new Key("redKey", "a red key", RED);
    Key blueKey = new Key("blueKey", "a red key", BLUE);
    Key greenKey = new Key("greenKey", "a red key", GREEN);
    Key yellowKey = new Key("yellowKey", "a red key", YELLOW);
    Key purpleKey = new Key("purpleKey", "a red key", PURPLE);

    // Places ==================================================================
    Place tavern = new Place("Tavern","A tavern with a festive atmosphere, just watch out for the flying mug !");
    Place cave = new Place("Cave","A big dark cave, your voice echoes endlessly");
    Place graveyard = new Place("Graveyard","In the cemetery you see an expanse of old tomb adorned with various cracks and withered plants");
    Place forest = new Place("Forest","An endless and sinister forest faces you, straining your ears you might hear screams of agony in the distance");
    Place church= new Place("church","A charming little church, with beautiful stained glass windows");
    Place laboratory = new Place("Laboratory","A laboratory like any other, with all kinds of gadgets and flasks on the shelves");
    Place barn = new Place("Barn", "At the entrance to the barn, you can see a huge pile of hay, the smell goes with it of course, but that's nature !");
    Place courtyard = new Place("Courtyard","In the courtyard there is a small garden and next to a lot of training dummies");
    Place marketPlace = new Place("Marketplace","In the marketplace, lots of people are jostling for their purchases, but watch out for thieves");
    Place banditLair = new Place("Bandit lair","You see tables overturned, barrels full of swords and of course a crowd of terrifying bandits");
    Place waterSource = new Place("Water source","A great spring of pure water flows before you");

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
    Passive scandalf = new Passive("Scandalf the wizard", "He has a long beard and a pointy hat, you should listen to what he tells you", "Hello adventurer, and welcome to the dungeon of Xar Tsaroth ! If you kill the dragon and save the princess, you'll be a hero for ever!");
    Passive annoying_princess = new Passive("annoying princess", "The beautifull princess you've been looking for, she has long golden hair and beautiful sapphire eyes", "deliver me quickly, you retarded incompetent!");

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
        output.add(divine_jewel);

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
        output.add(elixir_of_mystic_life);
        output.add(coca_zero);
        output.add(big_cake);
        output.add(poison);
        output.add(apple);

        //init keys

        output.add(redKey);
        output.add(blueKey);
        output.add(greenKey);
        output.add(yellowKey);
        output.add(purpleKey);


        //todo init items
        return output;
    }

    static Set<Place> initPlaces() {
        Set<Place> output = new HashSet<>();
        output.add(tavern);
        output.add(cave);
        output.add(graveyard);
        output.add(forest);
        output.add(church);
        output.add(laboratory);
        output.add(barn);
        output.add(courtyard);
        output.add(marketPlace);
        output.add(banditLair);
        output.add(waterSource);

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
        output.add(annoying_princess);
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
        player.addItem(chicken);
        player.addItem(rotten_chicken);
        player.addItem(irons_arrow);
        player.addItem(irons_arrow);
        player.addItem(hunters_bow);
        player.addItem(dagger);
        player.addItem(poison);
        player.addItem(poison);
        player.addItem(golden_statue);
    }

}
