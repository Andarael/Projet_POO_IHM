// Fichier par Florian Portrait, Josué Raad, et Thibaud Devemy

package shadowLair.model.game;

import shadowLair.model.entity.*;
import shadowLair.model.entity.item.*;
import shadowLair.model.entity.place.Place;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static shadowLair.model.utils.Col.*;

public interface MasterListEntity {
    // =========================================================================

    // Items ===================================================================

    Item golden_statue = new Item("golden statue",
                                  "gStat",
                                  "A small statue with a frightful effigy",
                                  1,
                                  2);

    Item divine_jewel = new Item("divine jewel",
                                 "diJew",
                                 "As you're looking this jewel, your eyes are getting lost in the maze of its crystalline curves and impossible geometries...",
                                 1,
                                 2);

    Item seer_thorn = new Item("Seer's thorn",
                               "sThorn",
                               "The tears of a seer contained in a small vial.",
                               1,
                               2);

    Item SignetUlric = new Item("Signet of Ulric",
                                "sUlri",
                                "A magnificent ring with sumptuous reflections",
                                1,
                                2);

    Item collectionPrayers = new Item("Collection of prayers",
                                      "cPray",
                                      "To keep with you at all cost ...",
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
                             "A tavern with a festive atmosphere, just watch out for the flying mug. Beware of this shady guy in the corner !");

    Place entrance = new Place("Entrance",
                               "Entra",
                               "The entrance of the dungeon, if you dare to take the challenge.");

    Place eternity_room = new Place("eternity room",
                                    "etern",
                                    "A mysterious room of unknown function.");

    Place cave = new Place("Cave", "cave", "A big dark cave, your voice echoes endlessly");

    Place graveyard = new Place("Graveyard",
                                " grave",
                                "In the cemetery you see an expanse of old tomb adorned with various cracks and withered plants");

    Place forest = new Place("Forest",
                             " fores",
                             "An endless and sinister forest faces you, straining your ears you might hear screams of agony in the distance");

    Place church = new Place("church",
                             "churc",
                             "An abandoned little church, with beautiful stained glass windows");

    Place laboratory = new Place("Laboratory",
                                 "labor",
                                 "All kinds of alchemical experiments and flasks on the shelves");

    Place barn = new Place("Barn",
                           "barn",
                           "At the entrance of the barn, you can see a huge pile of hay. As if someone was here recently!");

    Place courtyard = new Place("Courtyard",
                                "court",
                                "In the courtyard there is a small garden with few statues");

    Place marketPlace = new Place("Marketplace",
                                  "mPlac",
                                  "Lots of people are jostling for their purchases, but watch out for thieves");

    Place banditLair = new Place("Bandit lair",
                                 "bandi",
                                 "You see tables overturned, barrels full of swords and of course a crowd of terrifying bandits. They don't seem to care about you");

    Place waterSource = new Place("Water source",
                                  "sWate",
                                  "A great spring of pure water flows before you");

    Place mercyDreams = new Place("Mercy Dreams", "mercy", "An old church buried deep underground");

    Place desecratedCistern = new Place("Desecrated Cistern",
                                        "desec",
                                        "Very large sewer, don't mind the smell");

    Place echoesOfSalt = new Place("Echoes of Salt",
                                   "eSalt",
                                   "Is that salt or snow ? Anyway, that falling powder is not good for your armor!");

    Place whereTreesWither = new Place("Where Trees Wither",
                                       "trees",
                                       "One of the largest and oldest forests in the region, but recently this one is dying");

    Place graveyardPeaks = new Place("Graveyard of the Peaks",
                                     "Peaks",
                                     "A secret graveyard for the royal family.");

    Place patioSilentSteps = new Place("Patio of the Silent Steps", "steps", "");

    Place archiCathedral = new Place("Archicathedral Mother of Mothers",
                                     "archi",
                                     "A cathedral made of other cathedral within. It's as big as a mountain, and echoes the sound of a thousand bells");

    Place libraryNegatedWords = new Place("Library of the Negated Words",
                                          "libra",
                                          "In this library you can't read the books. A very bad omen awaits anyone who dares to disturb the place");

    Place sleepingCanvases = new Place("The Sleeping Canvases",
                                       "canva",
                                       "This is the place where paintings of long forgotten artists remains.");

    Place wallHolyProhibitions = new Place("Wall of the Holy Prohibitions",
                                           "wallH",
                                           "A wall on the side of the main castle. It has a gloomy feel");

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
                                                        "emeCh",
                                                        "a massive chest that probably houses sumptuous treasures ...");

    // Hostiles ================================================================
    Hostile orc = new Hostile("orc", "orc", "a green creature", 4, 2);

    Hostile goblin = new Hostile("goblin", "gobli", "a small and pathetic creature", 3, 2);

    Hostile dragon = new Hostile("dragon",
                                 "drago",
                                 "A gigantic dragon with dark eyes and emerald reflections. He keeps what you seek",
                                 25,
                                 7,
                                 false);

    Hostile necromancer = new Hostile("necromancer",
                                      "necro",
                                      "A dark wizard in tattered clothes",
                                      10,
                                      7);

    Hostile minotaur = new Hostile("minotaur",
                                   "minot",
                                   "A scary creature with a man's body but a bull's head",
                                   8,
                                   6);

    Hostile ghost = new Hostile("ghost",
                                "ghost",
                                "You can barely see this creature",
                                6,
                                4);

    Hostile skeleton = new Hostile("skeleton",
                                   "skele",
                                   "Shreds of flesh are still  attached to its bones. He does not seem bothered by your presence",
                                   4,
                                   4,
                                   false);

    Hostile wolf = new Hostile("wolf",
                               "wolf",
                               "It have a piercing gaze and  sharp fangs, he's ready to kill any intruder",
                               5,
                               3);

    // Passive =================================================================

    Passive ordinary_guy = new Passive("ordinary guy",
                                       "orGuy",
                                       "a human just like you",
                                       "Hello sir, the weather is nice since we got this dragon thing, don't you think ?");

    Passive merchant = new Passive("merchant",
                                   "merch",
                                   "a big guy with all kinds of things in his bag",
                                   "Hello adventurer, would you like to take a look at my goods?");

    Passive scandalf = new Passive("Scandalf the wizard",
                                   "scand",
                                   "He has a long beard and a pointy hat, you should listen to what he tells you",
                                   "Hello adventurer, and welcome to the dungeon of Xar Tsaroth ! If you kill the dragon and save the princess, you'll be a hero for ever! " +
                                   "Beware, this land is treacherous, a dragon and a necromancer are fighting for the power, " +
                                   "while poor King Ulric is hiding in the basement of his own castle. " +
                                   "Take the Divine Jewel and restore balance !");

    Passive annoying_princess = new Passive("annoying princess",
                                            "aPrin",
                                            "The beautiful princess you've been looking for, she has long golden hair and beautiful sapphire eyes",
                                            "You ! Free me quick, you retarded incompetent!");

    Passive ulricWise = new Passive("Ulric the Wise",
                                    "ulric",
                                    "Former ruler of the dungeon, he fled the takeover of the Necromancer, this dragon story really did not help matters!",
                                    "Take this key and deliver my kingdom!");

    Passive willyPillager = new Passive("Willy the pillager",
                                        "Willy",
                                        "Little man with graying hair, take advantage of the discord to plunder the dungeon",
                                        "Hey, I found lots of beautiful things! You want some ?");

    Passive piousHelen = new Passive("Pious helen",
                                     "helen",
                                     "Girl with blond hair",
                                     "I lost my statuette, if you found it please keep it in memory of me sir");

    Passive torakStrange = new Passive("Torak the strange",
                                       "torak",
                                       "An elderly man blind",
                                       "A long time ago I could have helped you, ... A long time ago");

    Passive arthurBrave = new Passive("Arthur the brave",
                                      "Arthu",
                                      "Young (and very small) knight lost in the castle, juste as you",
                                      "Hello, my sword is blunt, I can go no further !");

    Passive madelaine = new Passive("Madelaine the beloved",
                                    "Madel",
                                    "Young girl with black hair, child of Ulric",
                                    "Please save us sir, first a Necromancer, then a Dragon, what now ? ");


    /*==============================================================================================*/
    /*===========================Creation & instanciation of entities===============================*/
    /*==============================================================================================*/

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
        output.add(mercyDreams);
        output.add(barn);
        output.add(courtyard);
        output.add(marketPlace);
        output.add(banditLair);
        output.add(waterSource);
        output.add(whereTreesWither);
        output.add(sleepingCanvases);
        output.add(desecratedCistern);
        output.add(graveyardPeaks);
        output.add(libraryNegatedWords);
        output.add(archiCathedral);
        output.add(patioSilentSteps);
        output.add(wallHolyProhibitions);
        output.add(echoesOfSalt);


        entrance.addItemToPlace(redKey);
        entrance.addGoldToPlace(5);
        entrance.addExit(courtyard, 0);
        entrance.addContainer(scandalf);

        courtyard.addContainer(arthurBrave);
        courtyard.addItemToPlace(dagger);
        courtyard.addExit(entrance, 3);
        courtyard.addLockedExit(forest, 2, RED);
        courtyard.addLockedExit(graveyard, 0, BLUE);

        forest.addContainer(ordinary_guy);
        forest.addContainer(wolf);
        forest.addContainer(iron_chest);
        forest.addExit(courtyard, 1);
        forest.addLockedExit(waterSource, 3, GREEN);

        graveyard.addContainer(skeleton);
        graveyard.addExit(marketPlace, 2);
        graveyard.addExit(courtyard, 3);
        graveyard.addItemToPlace(humanSkull);

        marketPlace.addContainer(merchant);
        marketPlace.addExit(graveyard, 1);
        marketPlace.addExit(laboratory, 2);

        laboratory.addContainer(ghost);
        laboratory.addExit(marketPlace, 1);
        laboratory.addExit(mercyDreams, 3);

        mercyDreams.addContainer(madelaine);
        mercyDreams.addContainer(wooden_chest);
        mercyDreams.addExit(laboratory, 0);
        mercyDreams.addExit(courtyard, 3);

        waterSource.addExit(forest, 0);
        waterSource.addExit(banditLair, 2);
        waterSource.addExit(eternity_room, 3);
        waterSource.addItemToPlace(elixir_of_mystic_life);
        waterSource.addContainer(torakStrange);

        banditLair.addExit(waterSource, 1);
        banditLair.addExit(whereTreesWither, 2);
        banditLair.addContainer(orc);
        banditLair.addContainer(steel_chest);

        whereTreesWither.addExit(banditLair, 1);
        whereTreesWither.addLockedExit(barn, 0, PURPLE);
        whereTreesWither.addContainer(willyPillager);

        barn.addContainer(minotaur);
        barn.addExit(whereTreesWither, 3);
        barn.addExit(church, 2);

        church.addContainer(piousHelen);
        church.addContainer(necromancer);
        church.addContainer(emerald_chest);
        church.addExit(barn, 1);
        church.addExit(sleepingCanvases, 3);

        sleepingCanvases.addExit(church, 0);
        sleepingCanvases.addExit(cave, 2);
        sleepingCanvases.addLockedExit(wallHolyProhibitions, 3, YELLOW);
        sleepingCanvases.addItemToPlace(rotten_chicken);
        sleepingCanvases.addItemToPlace(coca_zero);

        cave.addExit(sleepingCanvases, 1);
        cave.addItemToPlace(SmallWoodenStatuette);
        cave.addExit(patioSilentSteps, 2);

        wallHolyProhibitions.addExit(sleepingCanvases, 0);
        wallHolyProhibitions.addContainer(dragon);
        wallHolyProhibitions.addContainer(annoying_princess);

        eternity_room.addExit(waterSource, 0);
        eternity_room.addContainer(ulricWise);
        eternity_room.addItemToPlace(golden_statue);

        patioSilentSteps.addExit(cave, 1);
        patioSilentSteps.addExit(echoesOfSalt, 2);
        patioSilentSteps.addItemToPlace(staleWheatPancake);

        echoesOfSalt.addExit(patioSilentSteps, 1);
        echoesOfSalt.addExit(desecratedCistern, 2);
        echoesOfSalt.addItemToPlace(sinnerTear);

        desecratedCistern.addExit(echoesOfSalt, 1);
        desecratedCistern.addExit(archiCathedral, 2);
        desecratedCistern.addContainer(goblin);

        archiCathedral.addExit(desecratedCistern, 1);
        archiCathedral.addExit(libraryNegatedWords, 2);
        archiCathedral.addItemToPlace(rotten_chicken);
        archiCathedral.addItemToPlace(messiahBlood);

        libraryNegatedWords.addExit(archiCathedral, 1);
        libraryNegatedWords.addExit(tavern, 2);
        libraryNegatedWords.addItemToPlace(irons_arrow);
        libraryNegatedWords.addItemToPlace(irons_arrow);
        libraryNegatedWords.addItemToPlace(irons_arrow);

        tavern.addExit(libraryNegatedWords, 1);
        tavern.addExit(entrance, 2);
        tavern.addItemToPlace(irons_arrow);
        tavern.addItemToPlace(apple);
        tavern.addItemToPlace(poison);

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

        orc.addItem(staff);
        minotaur.addItem(spiked_mass);
        minotaur.addGold(3);
        skeleton.addItem(one_handed_sword);
        dragon.addItem(divine_jewel);
        dragon.addGold(20);
        necromancer.addGold(5);
        necromancer.addItem(limboLament);
        wolf.addItem(rotten_chicken);

        return output;
    }

    static Set<Passive> initPassives() {
        Set<Passive> output = new HashSet<>();

        output.add(ordinary_guy);
        output.add(merchant);
        output.add(scandalf);
        output.add(annoying_princess);
        output.add(ulricWise);
        output.add(willyPillager);
        output.add(piousHelen);
        output.add(torakStrange);
        output.add(arthurBrave);
        output.add(madelaine);

        merchant.addItem(irons_arrow);
        merchant.addItem(irons_arrow);
        merchant.addItem(irons_arrow);
        merchant.addItem(irons_arrow);
        merchant.addItem(apple);
        merchant.addItem(apple);
        merchant.addItem(apple);
        merchant.addItem(elixir_of_mystic_life);
        merchant.addItem(big_cake);
        merchant.addGold(10);

        scandalf.addItem(apple);
        scandalf.addItem(sacredBook);

        ulricWise.addItem(SignetUlric);
        ulricWise.addItem(purpleKey);

        arthurBrave.addItem(great_sword);

        torakStrange.addItem(esoteric_manual);

        piousHelen.addItem(collectionPrayers);

        willyPillager.addItem(dagger);

        return output;
    }

    static Set<Container> initContainers() {
        Set<Container> output = new HashSet<>();

        output.add(wooden_chest);
        output.add(iron_chest);
        output.add(steel_chest);
        output.add(emerald_chest);

        iron_chest.addItem(apple);
        iron_chest.addItem(blueKey);

        steel_chest.addItem(coca_zero);
        steel_chest.addGold(3);

        emerald_chest.addItem(yellowKey);
        emerald_chest.addItem(oldHam);
        emerald_chest.addGold(4);

        wooden_chest.addItem(greenKey);
        wooden_chest.addItem(daggerFaith);
        wooden_chest.addItem(countryPate);
        wooden_chest.addGold(2);

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

    static void initPlayer(Player player) {

        player.addItem(rotten_chicken);
        player.addItem(hunters_bow);
        hunters_bow.addArrow();
        player.addItem(irons_arrow);
        player.addItem(irons_arrow);

        player.addItem(esoteric_manual); // todo remove

        player.addGold(3);
    }

}