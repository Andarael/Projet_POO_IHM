package world;

import entity.Container;
import entity.Entity;
import entity.Hostile;
import entity.Passive;
import entity.item.Item;
import entity.place.Exit;
import entity.place.Place;



public interface WorldContains {

    // todo check for null in all

    // ===========================================================
    // Contains globally
    static boolean haveEntity(World world, String e) {
        return world.entities.contains(new Entity(e) {});
    }

    static boolean isItem(World world, String item) {
        return world.items.contains(new Item(item));
    }

    static boolean isPlace(World world, Place place) {
        return world.places.contains(place);
    }

    static boolean isPlace(World world, String place) {
        return isPlace(world, new Place(place));
    }

    static boolean isHostile(World world, Hostile hostile) {
        return world.hostiles.contains(hostile);
    }

    static boolean isPassive(World world, Passive passive) {
        return world.passives.contains(passive);
    }

    static boolean isContainer(World world, Container container) {
        return world.containers.contains(container);
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
        return world.getCurrentPlace().equals(place);
    }

    static boolean isHere(Place place, Container container) {
        if (place == null || container == null)
            return false;
        return place.getContainer(container) != null;
    }

    // ===========================================================

    static boolean playerHaveItem(World world, Item item) {
        return world.getPlayer().contains(item);
    }

    static boolean ContainerHaveItem(World world, Container container, Item item) {
        world.getCurrentPlace().getContainer(container).contains(item);
        return false;
        // todo
    }

    // ===========================================================


}
