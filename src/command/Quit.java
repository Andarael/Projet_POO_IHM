// fichier par josué Raad

package command;

import world.World;

public interface Quit {
    static void quit(World world) {
        world.end();
    }
}
