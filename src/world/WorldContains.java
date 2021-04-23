// fichier par josué Raad

package world;

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

}
