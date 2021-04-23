// Fichier par Josué Raad

package world;

import entity.place.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldTest {

    World w;
    private Place p1;
    private Place p2;
    private Place p3;
    private Place p4;

    @BeforeEach
    void setUp() {
        w = new World();

        p1 = new Place("p1");
        p2 = new Place("p2");
        p3 = new Place("p3");
        p4 = new Place("p4");
    }

    @Test
    void addPlace() {
        w.addPlace(p1);
        w.addPlace(p2);
        w.addPlace(p3);
        w.addPlace(p4);

        int size = w.size();
        System.out.println(w);

        w.addPlace(p1);
        System.out.println(w);

        assertEquals(size, w.size());

        assertEquals(new Place("P1"), p1);

        w.addPlace(new Place("P1"));
        System.out.println(w);

        assertEquals(size, w.size());

    }

}