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

    Item golden_statue = new Item("golden statue",
                                  "gStat",
                                  "a small statue with a frightful effigy",
                                  1,
                                  2);

    Item divine_jewel = new Item("divine jewel",
                                 "diJew",
                                 "as you're looking this jewel, your eyes are getting lost in the maze of its crystalline curves...",
                                 1,
                                 2);

    Item seer_thorn = new Item("Seer's thorn",
                               "sThorn",
                               "The seer's tears contained in a small vial",
                               1,
                               2);

    Item SignetUlric = new Item("Signet of Ulric",
                                "sUlri",
                                "A splendid signet ring with majestic reflections",
                                1,
                                2);

    Item collectionPrayers = new Item("Collection of prayers",
                                      "cPray",
                                      "Keep the faith at all times ...",
                                      1,
                                      2);

    Item SmallWoodenStatuette = new Item("Small wooden statuette",
                                         "wStat",
                                         "beautifully carved simple statuette",
                                         1,
                                         2);

    Item humanSkull = new Item("Human Skull", "hSkul", "Who could it belong to ?", 1, 2);

    Item sacredBook = new Item("Sacred book",
                               "sBook",
                               "With its magnificent gilding, it lives up to its name!",
                               1,
                               2);


    // Weapons =================================================================

    Weapon great_sword = new Weapon("great sword",
                                    "gSwor",
                                    "a big and heavy sword made with steel",
                                    5,
                                    5,
                                    5);

    Weapon one_handed_sword = new Weapon("one-handed sword",
                                         "ohSwo",
                                         "a short but sharp sword made with iron",
                                         3,
                                         3,
                                         3);

    Weapon dagger = new Weapon("dagger", "dagge", "a tiny dagger", 1, 1, 2);

    Weapon spear = new Weapon("spear",
                              "spear",
                              "a long stick with a piece of metal at the end",
                              4,
                              4,
                              4);

    Bow hunters_bow = new Bow("hunter's bow",
                              "huBow",
                              "a small but tough bow, made for sharpened arrows",
                              3,
                              3,
                              3);

    Arrow irons_arrow = new Arrow();

    Weapon spiked_mass = new Weapon("spiked mass",
                                    "sMass",
                                    "a very heavy mass with spikes at the end",
                                    7,
                                    7,
                                    7);

    Weapon esoteric_manual = new Weapon("esoteric manual",
                                        "esMan",
                                        "a book with weird symbols on its cover",
                                        1,
                                        20,
                                        10);

    Weapon staff = new Weapon("seer's staff", "sStaf", "runic writings cover the staff", 3, 3, 3);

    Weapon daggerFaith = new Weapon("dagger of faith",
                                    "dFait",
                                    "a light and very handy dagger",
                                    3,
                                    3,
                                    3);

    Weapon limboLament = new Weapon("limbo lament",
                                    "lLame",
                                    "when she slices through the air, you'd think you heard her scream",
                                    3,
                                    3,
                                    6);

    Weapon swordFatality = new Weapon("sword of fatality",
                                      "fSwor",
                                      "his shots are fatal ... or not!",
                                      3,
                                      3,
                                      5);


    // Food   ==================================================================

    Food chicken = new Food("chicken", "chick", "a raw chicken", 1, 2, 2);

    Food rotten_chicken = new Food("rotten chicken", "rChic", "a fragrant chicken", 1, 1, -2);

    Food elixir_of_mystic_life = new Food("elixir of mystic life",
                                          "mlEli",
                                          "it just look like a bottle of perfume",
                                          1,
                                          10,
                                          10);

    Food coca_zero = new Food("coca zero",
                              "cocaZ",
                              "it just look like oil, but with no sugar in it",
                              1,
                              5,
                              20); // wtf

    Food big_cake = new Food("big cake", "bCake", "a big lemon cake", 1, 3, 3);

    Food poison = new Food("weird-looking bottle",
                           "wlBot",
                           "i wouldn't drink this if i were you",
                           1,
                           10,
                           -15);

    Food apple = new Food("apple", "apple", "a mouthwatering apple", 1, 1, 1);

    Food messiahBlood = new Food("Messiah's blood",
                                 "bMess",
                                 "you feel an energy that invades you",
                                 1,
                                 15,
                                 7);

    Food sinnerTear = new Food("sinner's tear",
                               "sTear",
                               "you feel an energy that invades you",
                               1,
                               5,
                               4);

    Food oldHam = new Food("old ham",
                           "oldHa",
                           "An old dry ham that gives off an appetizing smell",
                           1,
                           12,
                           5);

    Food staleWheatPancake = new Food("Stale wheat pancake",
                                      "sPanc",
                                      "Little wheat pancake, when you're hungry ...",
                                      1,
                                      7,
                                      3);

    Food nourishingWine = new Food("Nourishing wine",
                                   " nWine",
                                   "It's not the latest vintage, but it doesn't lack flavor",
                                   1,
                                   20,
                                   7);

    Food strangeFlask = new Food("Strange flask",
                                 "sFlas ",
                                 "Who wants to try their luck ... ?",
                                 1,
                                 2,
                                 -9);

    Food countryPate = new Food("Country pâté", "cPate", "A good old paté from the past!", 1, 1, 4);

    Food remedyNecromantic = new Food("Remedy for necromantic",
                                      "nReme",
                                      "The smell emanating from it made the flies fall",
                                      1,
                                      1,
                                      -8);

    Food HandfulBean = new Food("Handful of bean",
                                "hBean",
                                "small foods fulfilling their duty: to feed us",
                                1,
                                1,
                                2);


    // Keys   ==================================================================
    Key redKey = new Key(RED, "a red key");
    Key blueKey = new Key(BLUE, "a blue key");
    Key greenKey = new Key(GREEN, "a green key");
    Key yellowKey = new Key(YELLOW, "a yellow key");
    Key purpleKey = new Key(PURPLE, "a purple key");

    // Places ==================================================================
    Place tavern = new Place("Tavern",
                             "taver",
                             "A tavern with a festive atmosphere, just watch out for the flying mug !");

    Place entrance = new Place("Entrance",
                               "Entra",
                               "The entrance of the dungeon, you're not ready for what's next.");

    Place eternity_room = new Place("eternity room",
                                    "etern",
                                    "The chamber of the dragon. Your journey comes to an end.");

    Place cave = new Place("Cave",
                           "cave",
                           "A big dark cave, your voice echoes endlessly");

    Place graveyard = new Place("Graveyard",
                                " grave",
                                "In the cemetery you see an expanse of old tomb adorned with various cracks and withered plants");

    Place forest = new Place("Forest",
                             " fores",
                             "An endless and sinister forest faces you, straining your ears you might hear screams of agony in the distance");

    Place church = new Place("church",
                             "churc",
                             "A charming little church, with beautiful stained glass windows");

    Place laboratory = new Place("Laboratory",
                                 "labor",
                                 "A laboratory like any other, with all kinds of gadgets and flasks on the shelves");

    Place barn = new Place("Barn",
                           "barn",
                           "At the entrance of the barn, you can see a huge pile of hay, the smell goes with it of course, but that's nature !");

    Place courtyard = new Place("Courtyard",
                                "court",
                                "In the courtyard there is a small garden and next to a lot of training dummies");

    Place marketPlace = new Place("Marketplace",
                                  "mPlac",
                                  "In the marketplace, lots of people are jostling for their purchases, but watch out for thieves");

    Place banditLair = new Place("Bandit lair",
                                 "bandi",
                                 "You see tables overturned, barrels full of swords and of course a crowd of terrifying bandits");

    Place waterSource = new Place("Water source",
                                  "sWate",
                                  "A great spring of pure water flows before you");

    Place mercyDreams = new Place("Mercy Dreams",
                                  "mercy",
                                  "a church deep underground");

    Place desecratedCistern = new Place("Desecrated Cistern",
                                        "desec",
                                        "Very large sewer, don't mind the smell");

    Place echoesOfSalt = new Place("Echoes of Salt",
                                   "eSalt",
                                   "with all that salt, we could conserve tons of meat!");

    Place whereTreesWither = new Place("Where Trees Wither",
                                       "trees",
                                       "one of the largest and oldest forests in the region, but recently this one is dying");

    Place graveyardPeaks = new Place("Graveyard of the Peaks",
                                     "Peaks",
                                     "");

    Place patioSilentSteps = new Place("Patio of the Silent Steps",
                                       "steps",
                                       "");

    Place archicathedral = new Place("Archicathedral Mother of Mothers",
                                     "archi",
                                     "");

    Place libraryNegatedWords = new Place("Library of the Negated Words",
                                          "libra",
                                          "");

    Place sleepingCanvases = new Place("The Sleeping Canvases",
                                       "canva",
                                       "");

    Place wallHolyProhibitions = new Place("Wall of the Holy Prohibitions",
                                           "wallH",
                                           "");

    Place deambulatoryHoliness = new Place("Deambulatory of His Holiness",
                                           "deamb",
                                           "");


    // StaticContainers ========================================================

    StaticContainer wooden_chest = new StaticContainer("wooden chest",
                                                       "wooCh",
                                                       "a massive chest that probably houses sumptuous treasures ...");

    StaticContainer iron_chest = new StaticContainer("iron chest",
                                                     "iroCh",
                                                     "a massive chest that probably houses sumptuous treasures ...");

    StaticContainer steel_chest = new StaticContainer("steel chest",
                                                      "steCh",
                                                      "a massive chest that probably houses sumptuous treasures ...");

    StaticContainer emerald_chest = new StaticContainer("emerald chest",
                                                        "emeChe",
                                                        "a massive chest that probably houses sumptuous treasures ...");

    // Hostiles ================================================================
    Hostile orc = new Hostile("orc", "orc", "a green creature", 4, 2);

    Hostile goblin = new Hostile("goblin", "gobli", "a small and pathetic creature", 3, 3);

    Hostile dragon = new Hostile("dragon",
                                 "drago",
                                 "a gigantic dragon with emerald reflections",
                                 20,
                                 5,
                                 false);

    Hostile necromancer = new Hostile("necromancer",
                                      "necro",
                                      "a dark wizard in tattered clothes",
                                      10,
                                      10);

    Hostile minotaur = new Hostile("minotaur",
                                   "minot",
                                   "a scary creature with a man's body but a bull's head",
                                   8,
                                   8);

    Hostile ghost = new Hostile("ghost",
                                "ghost",
                                "you can barely see the outlines of this creature",
                                6,
                                6);

    Hostile skeleton = new Hostile("skeleton",
                                   "skele",
                                   "a human skeleton with shreds of flesh still attached to its bones",
                                   4,
                                   4);

    Hostile wolf = new Hostile("wolf",
                               "wolf",
                               "a piercing gaze  wolf and  sharp fangs, he's ready to pounce",
                               10,
                               5);


    // Passive =================================================================

    Passive ordinary_guy = new Passive("ordinary guy",
                                       "orGuy",
                                       "a human just like you",
                                       "Hello sir, the weather is nice, don't you think?");

    Passive merchant = new Passive("merchant",
                                   "merch",
                                   "a big guy with all kinds of things in his bag",
                                   "Hello adventurer, would you like to take a look at my goods?");

    Passive scandalf = new Passive("Scandalf the wizard",
                                   "scand",
                                   "He has a long beard and a pointy hat, you should listen to what he tells you",
                                   "Hello adventurer, and welcome to the dungeon of Xar Tsaroth ! If you kill the dragon and save the princess, you'll be a hero for ever!");

    Passive annoying_princess = new Passive("annoying princess",
                                            "aPrin",
                                            "The beautiful princess you've been looking for, she has long golden hair and beautiful sapphire eyes",
                                            "free me quick, you retarded incompetent!");

    Passive ulricWise = new Passive("Ulric the Wise",
                                    "ulric",
                                    "Former ruler of the dungeon, he fled the takeover of the Necromancer, this dragon story really did not help matters!",
                                    "take this key and deliver my kingdom!");

    Passive WillyPillager = new Passive("Willy the pillager",
                                        "Willy",
                                        "Little man with graying hair, take advantage of the discord to plunder the dungeon",
                                        "I found lots of beautiful things! You want some ?");

    Passive piousHelen = new Passive("Pious helen",
                                     "helen",
                                     "Girl with blond hair",
                                     "I lost my statuette, if you found it, keep it in memory of me sir");

    Passive torakStrange = new Passive("Torak the strange",
                                       "torak",
                                       "Elderly man with red head",
                                       "At a time I could have helped you... at a time ...");

    Passive arthurBrave = new Passive("Arthur the brave",
                                      "Arthu",
                                      "Young knight",
                                      "Hello, my sword send you it's regards!");

    Passive madelaine = new Passive("Madelaine the beloved",
                                    "Madel",
                                    "Young girl with black hair, child of Ulric",
                                    "please save us sir");


    Set<Entity> entityMasterList = getAllEntities();

    static Set<Entity> getAllEntities() {
        HashSet<Entity> output = new HashSet<>();

        output.addAll(initItems());
        output.addAll(initPlaces());
        output.addAll(initHostiles());
        output.addAll(initPassives());
        output.addAll(initContainers());

        return output;
    }

    static Set<Item> initItems() {
        Set<Item> output = new HashSet<>();
        output.add(new Item("pogillion"));

        //init item

        output.add(golden_statue);
        output.add(divine_jewel);
        output.add(seer_thorn);
        output.add(SignetUlric);
        output.add(collectionPrayers);
        output.add(SmallWoodenStatuette);
        output.add(humanSkull);
        output.add(sacredBook);

        //init weapon

        output.add(great_sword);
        output.add(one_handed_sword);
        output.add(dagger);
        output.add(hunters_bow);
        output.add(irons_arrow);
        output.add(spear);
        output.add(spiked_mass);
        output.add(esoteric_manual);
        output.add(staff);
        output.add(daggerFaith);
        output.add(limboLament);
        output.add(swordFatality);

        //init food

        output.add(chicken);
        output.add(rotten_chicken);
        output.add(elixir_of_mystic_life);
        output.add(coca_zero);
        output.add(big_cake);
        output.add(poison);
        output.add(apple);
        output.add(messiahBlood);
        output.add(sinnerTear);
        output.add(oldHam);
        output.add(staleWheatPancake);
        output.add(nourishingWine);
        output.add(strangeFlask);
        output.add(countryPate);
        output.add(remedyNecromantic);
        output.add(HandfulBean);


        //init keys

        output.add(redKey);
        output.add(blueKey);
        output.add(greenKey);
        output.add(yellowKey);
        output.add(purpleKey);


        return output;
    }

    static Set<Place> initPlaces() {
        Set<Place> output = new HashSet<>();

        output.add(tavern);
        output.add(entrance);
        output.add(eternity_room);
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

        entrance.addItemToPlace(redKey);
        entrance.addItemToPlace(dagger);
        entrance.addExit(barn, 2);
        entrance.addContainer(scandalf);

        barn.addContainer(iron_chest);
        barn.addContainer(ordinary_guy);
        barn.addContainer(orc);
        barn.addExit(cave, 0);
        barn.addExit(entrance, 1);
        barn.addLockedExit(laboratory, 2, RED);
        barn.addLockedExit(forest, 3, GREEN);

        forest.addExit(barn, 0);

        cave.addContainer(merchant);
        cave.addContainer(minotaur);
        cave.addContainer(skeleton);
        cave.addExit(barn, 3);

        laboratory.addItemToPlace(esoteric_manual);
        laboratory.addExit(barn, 3);
        laboratory.addLockedExit(church, 0, BLUE);

        church.addContainer(ulricWise);
        church.addContainer(necromancer);
        church.addExit(laboratory,3);
        church.addExit(eternity_room,2);

        eternity_room.addContainer(annoying_princess);
        eternity_room.addContainer(dragon);
        eternity_room.addExit(church,1);


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
        output.add(wolf);

        minotaur.addItem(spiked_mass);
        skeleton.addItem(one_handed_sword);
        dragon.addItem(divine_jewel);

        return output;
    }

    static Set<Passive> initPassives() {
        Set<Passive> output = new HashSet<>();

        output.add(ordinary_guy);
        output.add(merchant);
        output.add(scandalf);
        output.add(annoying_princess);
        output.add(ulricWise);
        output.add(WillyPillager);
        output.add(piousHelen);
        output.add(torakStrange);
        output.add(arthurBrave);
        output.add(madelaine);

        merchant.addItem(irons_arrow);
        merchant.addItem(hunters_bow);
        merchant.addGold(10);

        return output;
    }

    static Set<Container> initContainers() {
        Set<Container> output = new HashSet<>();

        output.add(wooden_chest);
        output.add(iron_chest);
        output.add(steel_chest);
        output.add(emerald_chest);


        iron_chest.addItem(apple);
        iron_chest.addItem(poison);

        steel_chest.addItem(greenKey);
        steel_chest.addItem(coca_zero);



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

        player.addItem(rotten_chicken);
        player.addItem(hunters_bow);
        player.addItem(irons_arrow);
        player.addItem(irons_arrow);
        player.addItem(irons_arrow);
        player.addItem(irons_arrow);
        player.addItem(blueKey);

    }

}
