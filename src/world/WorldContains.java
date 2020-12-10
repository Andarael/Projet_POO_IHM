package world;

import entity.Container;
import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;



public interface WorldContains {

    // todo check for null in all

    // ===========================================================
    // Contains globally
    static boolean haveEntity(World world, String str) {
        return world.entities.stream()
                             .anyMatch( x -> (x.isSameStr(str)));
    }

    static boolean isItem(World world, String item) {
        return world.items.stream()
                          .anyMatch( x -> (x.isSameStr(item)));
    }

    static boolean isPlace(World world, String place) {
        return world.places.stream()
                           .anyMatch( x -> (x.isSameStr(place)));
    }

    static boolean isHostile(World world, String hostile) {
        return world.hostiles.stream()
                             .anyMatch( x -> (x.isSameStr(hostile)));
    }

    static boolean isPassive(World world, String passive) {
        return world.passives.stream()
                             .anyMatch( x -> (x.isSameStr(passive)));
    }

    static boolean isContainer(World world, String container) {
        return world.containers.stream()
                               .anyMatch( x -> (x.isSameStr(container)));
    }

    // ===========================================================
    // Current place Contains

    static boolean isExit(Place place, Exit exit) {
        return place.getExitByName(exit.getName()) != null;
    }

    // ===========================================================

    static boolean isCurrentPlace(World world, Place place) {
        if (world == null || place == null)
            return false;
        return world.getCurrentPlace().isSame(place);
    }

    static boolean isHere(Place place, Container container) {
        if (place == null || container == null)
            return false;
        return place.getContainer(container) != null;
    }

    // ===========================================================

    static boolean playerHaveItem(World world, Item item) {
        // todo stream this
        return world.getPlayer().contains(item);
    }

    static boolean ContainerHaveItem(World world, Container container, Item item) {
        // todo stream this
        world.getCurrentPlace().getContainer(container).contains(item);
        return false;
        // todo
    }

    // ===========================================================


}
