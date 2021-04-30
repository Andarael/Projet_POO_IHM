package controller;

import javafx.stage.Stage;
import model.entity.Container;
import model.entity.Entity;
import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Place;
import model.utils.Printer;
import model.world.World;
import view.stage.EndGameScreen;
import view.stage.StartGameScreen;
import view.ui.MainUIController;

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

    public static void showStartScreen() {
        Stage startStage = new StartGameScreen();
        startStage.show();
        startStage.requestFocus();
    }

    public static Player getPlayer() {
        return player;
    }

    /*======== getters Setters ======*/

    public static void setPlayer(Player player) {
        MainController.player = player;
    }

    public static MainUIController getMainUIController() {
        return mainUIController;
    }

    public static void setMainUIController(MainUIController mainUIController) {
        MainController.mainUIController = mainUIController;
        initializePrivate();
    }

    public static Place getCurrentPlace() {
        return currentPlace;
    }

    public static void setCurrentPlace(Place currentPlace) {
        MainController.currentPlace = currentPlace;
    }

    public static void updateCurrentPlace() {
        mainUIController.updateCurrentPlace(currentPlace);
    }

    public static void updateSelectedContainer() {
        mainUIController.updateSelectedContainer(selectedContainer);
    }

    public static void updateDialogue(String executionResult) {
        mainUIController.updateDialogue(executionResult);
    }

    public static void updatePlayer() {
        mainUIController.updatePlayer(player);
    }

    public static void updateExits() {
        mainUIController.updateExits();
    }

    public static void updateInfo(String executionResult) {
        mainUIController.updateInformation(executionResult);
    }


    /*============= Update the View ======================*/

    public static void unselectContainer() {
        mainUIController.unselectContainer();
        selectedContainer = null;
    }

    public static void updateOnInteractionWithContainer(String interactionResult) {
        updateSelectedContainer();
        updateOnInteractionWithItem(interactionResult);
    }

    public static void updateOnInteractionWithItem(String executionResult) {
        updatePlayer();
        updateExits(); // in case of interaction with a key
        updateInfo(executionResult);
    }

    public static void waitForInput() {
        mainUIController.waitForInput();
    }

    public static void unlockInterface() {
        mainUIController.unlockInterface();
        updateCurrentPlace();
    }

    public static void checkDeath() {
        if (player.isDead()) {
            mainUIController.setDead();
            Stage endStage = new EndGameScreen();
            endStage.show();
        }
    }

    public static void selectContainerByIndex(int index) {
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

    public static void lootPlace() {
        selectedContainer = currentPlace.getPlaceContainer();
        updateSelectedContainer();
    }

    public static Item getSelectedItemPlayer() {
        return selectedItemPlayer;
    }

    public static void setSelectedItemPlayer(Item item) {
        selectedItemPlayer = item;
        mainUIController.setSelectedItemPlayer(selectedItemPlayer);
    }

    public static Container getSelectedContainer() {
        return selectedContainer;
    }

    public static void setSelectedContainer(Container selectedContainer) {
        MainController.selectedContainer = selectedContainer;
    }

    public static Item getSelectedItemLoot() {
        return selectedItemLoot;
    }

    public static void setSelectedItemLoot(Item selectedItemLoot) {
        MainController.selectedItemLoot = selectedItemLoot;
    }

    public static Entity getSelectedEntityToUseItemOn() {
        return selectedEntityToUseItemOn;
    }

    public static void setSelectedEntityToUseItemOn(Entity entityToUseItemOn) {
        selectedEntityToUseItemOn = entityToUseItemOn;
    }

    public static Item getSelectedItemTrader() {
        return selectedItemTrader;
    }

    public static void setSelectedItemTrader(Item item) {
        selectedItemTrader = item;
    }

    public static World getWorld() {
        return world;
    }

    public static void setWorld(World world) {
        MainController.world = world;
    }
}
