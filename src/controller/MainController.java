package controller;

import javafx.application.Platform;
import javafx.stage.Stage;
import model.command.Attack;
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
import view.EndGameScreen;
import view.StartGameScreen;

import java.util.List;

import static controller.CommandGenerator.*;

public class MainController {

    private static MainUIController mainUIController;

    private static World world;

    private static Place currentPlace;
    private static Player player;

    private static Container selectedContainer;

    private static Item selectedItemPlayer;
    private static Item selectedItemTrader;
    private static Item selectedItemLoot;

    private static Entity selectedEntityToUseItemOn;

    /*======== initialization ======*/

    public static void setSilentModel() {
        Printer.silence = true;
    }

    private static void initializePrivate() {
        world = new World();

        setSilentModel();

        currentPlace = world.currentPlace;
        player = world.getPlayer();

        player.addGold(10);

        selectedContainer = null;

        selectedItemPlayer = null;
        selectedItemTrader = null;
        selectedItemLoot = null;

        selectedEntityToUseItemOn = null;

        unselectContainer();
        updateCurrentPlace();
        updatePlayer();
        updateSelectedContainer();
    }

    public static void initialize() {
        initializePrivate();
        showStartScreen();
    }

    private static void showStartScreen() {
        Stage startStage = new StartGameScreen();
        startStage.show();
        startStage.requestFocus();
    }

    public static Player getPlayer() {
        return player;
    }

    /*======== getters Setters ======*/

    public static Item getSelectedItemPlayer() {
        return selectedItemPlayer;
    }

    public static void setSelectedItemPlayer(Item item) {
        selectedItemPlayer = item;
        mainUIController.setSelectedItemPlayer(selectedItemPlayer);
    }

    public static Item getSelectedItemTrader() {
        return selectedItemTrader;
    }

    public static void setSelectedItemTrader(Item item) {
        selectedItemTrader = item;
    }

    public static MainUIController getMainUIController() {
        return mainUIController;
    }

    public static void setMainUIController(MainUIController mainUIController) {
        MainController.mainUIController = mainUIController;
        initializePrivate();
    }

    public static World getWorld() {
        return world;
    }

    public static Place getCurrentPlace() {
        return currentPlace;
    }

    public static Container getSelectedContainer() {
        return selectedContainer;
    }

    public static Entity getSelectedEntityToUseItemOn() {
        return selectedEntityToUseItemOn;
    }

    public static void setSelectedEntityToUseItemOn(Entity entityToUseItemOn) {
        selectedEntityToUseItemOn = entityToUseItemOn;
    }

    public static Item getSelectedItemLoot() {
        return selectedItemLoot;
    }

    public static void setSelectedItemLoot(Item selectedItemLoot) {
        MainController.selectedItemLoot = selectedItemLoot;
    }


    /*============= Update the View ======================*/

    private static void updateCurrentPlace() {
        mainUIController.updateCurrentPlace(currentPlace);
    }

    private static void updateSelectedContainer() {
        mainUIController.updateSelectedContainer(selectedContainer);
    }

    private static void updateDialogue(String executionResult) {
        mainUIController.updateDialogue(executionResult);
    }

    private static void updatePlayer() {
        mainUIController.updatePlayer(player);
    }

    private static void updateExits() {
        mainUIController.updateExits();
    }

    private static void updateInfo(String executionResult) {
        mainUIController.updateInformation(executionResult);
    }

    private static void unselectContainer() {
        mainUIController.unselectContainer();
        selectedContainer = null;
    }

    private static void updateOnInteractionWithContainer(String interactionResult) {
        updateSelectedContainer();
        updateOnInteractionWithItem(interactionResult);
    }

    private static void updateOnInteractionWithItem(String executionResult) {
        updatePlayer();
        updateExits(); // in case of interaction with a key
        updateInfo(executionResult);
    }

    private static void waitForInput() {
        mainUIController.waitForInput();
    }

    protected static void unlockInterface() {
        mainUIController.unlockInterface();
        updateCurrentPlace();
    }

    private static void checkDeath() {
        if (player.isDead()) {
            mainUIController.setDead();
            Stage endStage = new EndGameScreen();
            endStage.show();
        }
    }

    /*============= Command Go ======================*/

    static void executeGo(Direction direction) {

        Exit exit = currentPlace.getExitByIndex(direction.getIndex());
        String executionResult = Execute.execute(world, generateGoCommand(exit));

        currentPlace = world.currentPlace;

        unselectContainer();
        updateCurrentPlace();
        updateInfo(executionResult);

        String fight = Attack.checkFight(world);

        if (fight != null)
            waitForInput();

        updateInfo(fight);

        checkDeath();
    }


    /*============= Command Canevas ======================*/

    static void selectContainerByIndex(int index) {
        switch (index) {
            case 1:
            case 2:
            case 3:
                selectedContainer = world.currentPlace.getContainerByIndex(index - 1);
                break;
            default:
                unselectContainer();
                break;
        }

        updateSelectedContainer();
    }

    /*============= Command Look ======================*/

    static void executeLook() {
        Entity whatToLookAt = selectedContainer;

        if (currentPlace.getPlaceContainer() == selectedContainer)
            whatToLookAt = currentPlace;

        List<String> command = generateLookCommand(whatToLookAt);

        String executionResult = Execute.execute(world, command);

        updateInfo(executionResult);
    }

    static void executeLookForPlace() {
        List<String> command = generateLookCommand(currentPlace);
        String executionResult = Execute.execute(world, command);
        updateInfo(executionResult);
    }

    /*============= Command Loot ======================*/

    static void lootPlace() {
        selectedContainer = currentPlace.getPlaceContainer();
        updateSelectedContainer();
    }

    /*============= Command Quit & Reset ======================*/

    static void quitGame() {
        Platform.exit();
    }

    public static void reset() {
        initializePrivate(); // todo faire en sorte que la population du monde se fasse avec des new pour chaque new world
    }

    /*============= Command Talk ======================*/

    public static void executeTalk() {
        List<String> command = generateTalkCommand(selectedContainer);
        String executionResult = Execute.execute(world, command);
        updateDialogue(executionResult);
    }

    /*============= Command Attack ======================*/

    public static void executeAttack() {
        List<String> command = CommandGenerator.generateAttackCommand(selectedContainer);

        String executionResult = Execute.execute(world, command);

        unselectContainer();

        updatePlayer();
        updateSelectedContainer();
        updateCurrentPlace();
        updateInfo(executionResult);

        checkDeath();
    }

    /*============= Command Equip ======================*/

    public static void executeEquip() {
        List<String> command = CommandGenerator.generateEquipCommand(selectedItemPlayer);

        String executionResult = Execute.execute(world, command);

        updatePlayer();
        updateInfo(executionResult);
    }

    public static void executeUnequip() {
        List<String> command = CommandGenerator.generateUnequipCommand();

        String executionResult = Execute.execute(world, command);

        updatePlayer();
        updateInfo(executionResult);
    }

    /*============= Command Drop ======================*/

    public static void executeDrop() {
        Item itemToDrop = selectedItemPlayer;
        List<String> command = CommandGenerator.generateDropCommand(itemToDrop);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithItem(executionResult);
    }

    /*============= Command Use ======================*/

    public static void executeUse() {

        Item itemToUse = selectedItemPlayer;

        List<String> command;

        if (itemToUse instanceof Key || itemToUse instanceof UsableOnItem)
            command = generateUseCommand(itemToUse, selectedEntityToUseItemOn);
        else
            command = CommandGenerator.generateUseCommand(itemToUse);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithItem(executionResult);

        checkDeath();
    }

    /*============= Command Take, Buy & Sell ======================*/

    public static void executeTake() {
        Item itemToTake = selectedItemLoot;
        List<String> command = CommandGenerator.generateTakeCommand(selectedContainer, itemToTake);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void executeBuy() {
        Item itemToBuy = selectedItemTrader;
        List<String> command = CommandGenerator.generateBuyCommand(selectedContainer, itemToBuy);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void executeSell() {
        Item itemToSell = selectedItemPlayer;
        List<String> command = CommandGenerator.generateSellCommand(selectedContainer, itemToSell);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);
    }

}
