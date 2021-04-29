package controller;

import model.entity.Container;
import model.entity.Entity;
import model.entity.place.Exit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface CommandGenerator {
    static List<String> generateGoCommand(Exit exit) {
        String destination = exit != null ? exit.getName() : "";
        return new ArrayList<>(Arrays.asList("go", destination));
    }

    static List<String> generateLookCommand(Entity entity) {


        if (entity instanceof Container)
            return new ArrayList<>(Arrays.asList("look", entity.getName()));

        return new ArrayList<>(Collections.singletonList("look"));
    }
}
