package model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaticContainerTest {

    @Test
    void StaticContainer() {
        Container staticContainer = new StaticContainer("Chest", "chest", "an old rotten chest");
        StaticContainer otherContainer = new StaticContainer("chest");
        assertEquals(staticContainer, otherContainer);
    }
}