// fichier par josué Raad

package model.command;

import model.world.World;

public interface Quit {
    static void quit(World world) {
        world.end();
    }
}
