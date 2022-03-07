// fichier par josué Raad

package shadowLair.model.command;

import shadowLair.model.world.World;

public interface Quit {
    static void quit(World world) {
        world.end();
    }
}
