package controller;

import javafx.application.Platform;
import model.command.Execute;
import model.entity.Container;
import model.entity.Entity;
import model.entity.Player;
import model.entity.item.Item;
import model.entity.item.Key;
import model.entity.place.Exit;
import model.entity.place.Place;
import model.interfaces.UsableOnItem;
import model.utils.Printer;
import model.world.World;

import java.util.List;

import static controller.CommandGenerator.*;
import static controller.utils.Utils.readable;

public class MainController {

    private static MainUIController mainUIController;

    private static World world;

    private static Place currentPlace;
    private static Player player;

    private static Container selectedContainer;

    private static Item selectedItemPlayer; // update in InventoryList
    private static Item selectedItemTrader; // todo
    private static Item selectedItemLoot; // todo

    private static Entity selectedEntityToUseItemOn;

    /*======== initialization ======*/

    public static void setMainUIController(MainUIController mainUIController) {
        MainController.mainUIController = mainUIController;
        initialize();
    }

    public static void setSilentModel() {
        Printer.silence = true;
    }

    private static void initialize() {
        world = new World();

        mainUIController.updateThis();

        currentPlace = world.currentPlace;
        player = world.getPlayer();

        selectedContainer = null;

        selectedItemPlayer = null;
        selectedItemTrader = null;
        selectedItemLoot = null;

        selectedEntityToUseItemOn = null;

        mainUIController.setCurrentPlace(currentPlace);

        mainUIController.setPlayer(player);

        mainUIController.setSelectedContainer(selectedContainer);

    }
    /*======== getters Setters ======*/

    public static Player getPlayer() {
        return player;
    }

    public static void setSelectedEntityToUseItemOn(Entity entityToUseItemOn) {
        selectedEntityToUseItemOn = entityToUseItemOn;
    }

    public static Item getSelectedItemTrader() {
        return selectedItemTrader;
    }

    public static Item getSelectedItemPlayer() {
        return selectedItemPlayer;
    }

    public static Item getSelectedItemLoot() {
        return selectedItemLoot;
    }

    /*============= Command direction ======================*/

    static void executeByDirection(Direction direction) {
        // todo ici on affiche la pièce AVANT d' entrer
        // ou alors modifier go pour pas qu' il y ai de checkFight et du coup on peu sleep ?

        unselectContainer();

        Exit exit = currentPlace.getExitByIndex(direction.getIndex());

        Execute.execute(world, generateGoCommand(exit));

        currentPlace = world.currentPlace;

        mainUIController.setCurrentPlace(currentPlace);

    }

    /*============= Command Canevas ======================*/

    static void selectContainerByIndex(int index) {
        switch (index) {
            case 0:
                unselectContainer();
                break;
            case 1:
            case 2:
            case 3:
                selectedContainer = world.currentPlace.getContainerByIndex(index - 1);
                break;
            default:
                selectedContainer = null;
                break;
        }


        mainUIController.setSelectedContainer(selectedContainer);
    }

    static void unselectContainer() {
        selectedContainer = null;
        mainUIController.setSelectedContainer(selectedContainer);

    }

    /*============= Command Look ======================*/

    static void executeLook() {
        List<String> command = generateLookCommand(selectedContainer);// todo wire
        String executionResult = Execute.execute(world, command);
        System.out.println(executionResult);
        mainUIController.setInformation(executionResult);

        // todo disable si rien selected
    }

    static void executeLookForPlace() {
        List<String> command = generateLookCommand(currentPlace);
        String executionResult = Execute.execute(world, command);
        mainUIController.setInformation(executionResult);
    }

    /*============= Command Loot ======================*/

    static void lootPlace() {
        unselectContainer();
        selectedContainer = currentPlace.getPlaceContainer();
        mainUIController.setSelectedContainer(selectedContainer);
    }

    /*============= Command Quit & Reset ======================*/

    // todo are ya suuurerre ya vant to quit ?

    static void quitGame() {
        Platform.exit();
    }

    public static void reset() {
        initialize(); // todo faire en sorte que la population du monde se fasse avec des new pour chaque new world
    }

    /*============= Command Talk ======================*/

    public static void executeTalk() {
        List<String> command = generateTalkCommand(selectedContainer);
        String executionResult = Execute.execute(world, command);
        mainUIController.setDialogue(executionResult);
    }

    /*============= Command Attack ======================*/

    public static void executeAttack() {
        // todo
    }

    /*============= Command Equip ======================*/

    public static void executeEquip() {
        List<String> command = CommandGenerator.generateEquipCommand(selectedItemPlayer);

        String executionResult = Execute.execute(world, command);

        mainUIController.setPlayer(player);
    }

    public static void executeUnequip() {
        List<String> command = CommandGenerator.generateUnequipCommand();

        String executionResult = Execute.execute(world, command);

        mainUIController.setPlayer(player);
    }

    /*============= Command Drop ======================*/

    public static void executeDrop() {
        Item itemToDrop = MainController.selectedItemPlayer;
        List<String> command = CommandGenerator.generateDropCommand(itemToDrop);

        String executionResult = Execute.execute(world, command);

        mainUIController.setPlayer(player);

        mainUIController.setInformation("You dropped " +
                                        readable(itemToDrop.getName()) +
                                        " on the ground");
    }

    /*============= Command Use ======================*/

    public static void executeUse() {

        Item itemToUse = selectedItemPlayer;

        List<String> command;

        if (itemToUse instanceof Key || itemToUse instanceof UsableOnItem)
            command = generateUseCommand(itemToUse, selectedEntityToUseItemOn);
        else
            command = CommandGenerator.generateUseCommand(itemToUse);

        System.out.println("COMMAND : " + command);
        String executionResult = Execute.execute(world, command);

        // todo remove l'item après utilisation s'il a correctement été utilisé

        // todo récup le résultat de l'exec pour les utilisations sur d'autres items

        System.out.println(selectedEntityToUseItemOn);

        mainUIController.setPlayer(player);
        mainUIController.setInformation(executionResult);
    }


}
