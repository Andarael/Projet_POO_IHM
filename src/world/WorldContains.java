package world;

import entity.Container;
import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;


public interface WorldContains {

    static boolean haveEntity(World world, String str) {
        if (world == null || str == null)
            return false;

        return world.entities.stream()
                             .anyMatch(x -> (x.isSameStr(str)));
    }

    static boolean isAPlace(World world, String place) {
        if (world == null || place == null)
            return false;

        return world.places.stream()
                           .anyMatch(x -> (x.isSameStr(place)));
    }

/*

    static boolean isItem(World world, String item) {
        if (world == null || item == null)
            return false;
        return world.items.stream()
                          .anyMatch(x -> (x.isSameStr(item)));
    }

   static boolean isHostile(World world, String hostile) {
        if (world == null || hostile == null)
            return false;

        return world.hostiles.stream()
                             .anyMatch(x -> (x.isSameStr(hostile)));
    }

    static boolean isPassive(World world, String passive) {
        if (world == null || passive == null)
            return false;

        return world.passives.stream()
                             .anyMatch(x -> (x.isSameStr(passive)));
    }

    static boolean isContainer(World world, String container) {
        if (world == null || container == null)
            return false;

        return world.containers.stream()
                               .anyMatch(x -> (x.isSameStr(container)));
    }

    // ===========================================================
    // Current place Contains

    static boolean isExit(Place place, Exit exit) {
        if (place == null || exit == null)
            return false;

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

    static boolean playerHaveItem(World world, String item) {
        if (world == null || item == null)
            return false;

        return world.getPlayer().contains(item);
    }

    static boolean ContainerHaveItem(World world, Container container, String item) {
        if (world == null || container == null || item == null)
            return false;

        return world.getCurrentPlace().getContainer(container).contains(item);
    }

    // ===========================================================*/


}
