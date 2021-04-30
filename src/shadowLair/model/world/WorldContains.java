// fichier par josué Raad

package shadowLair.model.world;

import shadowLair.model.entity.Entity;
import shadowLair.model.entity.item.Item;

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

    static Entity getEntity(World world, String name) {
        if (world == null)
            return null;

        return world.entities.stream()
                             .filter(x -> (x.isSameStr(name)))
                             .findFirst().orElse(null);
    }

    static Item getItem(World world, String itemName) {
        Entity entity = getEntity(world, itemName);

        if (entity instanceof Item)
            return (Item) entity;

        return null;
    }

}
