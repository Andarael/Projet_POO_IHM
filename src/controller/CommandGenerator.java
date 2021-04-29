package controller;

import model.entity.Being;
import model.entity.Container;
import model.entity.Entity;
import model.entity.item.Item;
import model.entity.place.Exit;
import model.interfaces.Equipable;
import model.interfaces.Usable;

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
        ArrayList<String> command = getBaseCommand("look");

        if (entity instanceof Container)
            command.add(entity.getName());

        return command;
    }

    static  List<String> generateTalkCommand(Container container) {
        ArrayList<String> command = getBaseCommand("talk");

        if (container instanceof Being)
            command.add(container.getName());

        return command;
    }

    static List<String> generateEquipCommand(Item item) {
        ArrayList<String> command = getBaseCommand("equip");

        if (item instanceof Equipable)
            command.add(item.getName());

        return command;
    }

    static List<String> generateUnequipCommand() {
        return new ArrayList<>(Collections.singletonList("unequip"));
    }

    static List<String> generateDropCommand(Item item) {
        ArrayList<String> command = getBaseCommand("drop");

        if (item != null)
            command.add(item.getName());

        return command;
    }

    static ArrayList<String> getBaseCommand(String baseCommand) {
        ArrayList<String> command = new ArrayList<>();
        if (baseCommand != null)
            command.add(baseCommand);
        return command;
    }

    static List<String> generateUseCommand(Item itemToUse) {
        ArrayList<String> command = getBaseCommand("use");

        if (itemToUse instanceof Usable)
            command.add(itemToUse.getName());

        return command;
    }

    static List<String> generateUseCommand(Item itemToUse, Entity target) {
        ArrayList<String> command = getBaseCommand("use");

        if (itemToUse instanceof Usable)
            command.add(itemToUse.getName());

        if (target instanceof Exit || target instanceof Item)
            command.add(target.getName());

        return command;
    }
}
