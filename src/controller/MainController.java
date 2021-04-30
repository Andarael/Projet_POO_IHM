package controller;

import javafx.stage.Stage;
import model.entity.Container;
import model.entity.Entity;
import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Place;
import model.utils.Printer;
import model.world.World;
import view.stage.GameOverScreen;
import view.stage.GameVictoryScreen;
import view.stage.StartGameScreen;
import view.ui.GameUIController;

/**
 * This controller contains the different game elements relevent to the interface.
 * It provides the methods to update the interface according to the state of the model elements.
 * <p>
 * When the view needs to be updated we must go through this controller
 * Also this controller is responsible for certain UI updates via listeners
 * (like the selected item or the selected container)
 * <p>
 * This controller only contains static methods. The inner state of the game could be stored in a non
 * static way, but this was easier for access.
 */
public class MainController {

    /*======== game state =========*/
    private static GameUIController gameUIController; //root FXML controller for communication with the UI

    private static World world; // world from model. Mainly used to check victory and to execute commands

    private static Place currentPlace; // the current place in the model & the ui
    private static Player player; // player

    private static Container selectedContainer; // the container actually selected in the ui canevas

    // the items currently selected in the ui in the inventory of the player, container and being
    private static Item selectedItemTrader;
    private static Item selectedItemPlayer;
    private static Item selectedItemLoot;

    private static Entity selectedEntityToUseItemOn; // The entity selected in the UseOn box in the ui

    /*======== initialization ======*/

    /**
     * to avoid having a display in the terminal
     */
    public static void setSilentModel() {
        Printer.silence = true;
    }

    /**
     * initialization without the start screens
     */
    private static void initializeNotStartScreen() {
        world = new World();

        setSilentModel();

        currentPlace = world.currentPlace;
        player = world.getPlayer();

        ExecutionController.setWorld(world);

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

    /**
     * initialization with the start screen
     */
    public static void initialize() {
        initializeNotStartScreen();
        showStartScreen();
    }

    /**
     * Shows a windows popup with the starting setting for the game.
     */
    public static void showStartScreen() {
        Stage startStage = new StartGameScreen();
        startStage.show();
        startStage.requestFocus();
    }


    /*======== getters Setters ======*/
    /*most of the getters are for the executionConroller.
    The wiew only gets the current state with the update sent by the controllers*/

    /**
     * This is in order to know the instance of the UI root controller
     */
    public static void setMainUIController(GameUIController gameUIController) {
        MainController.gameUIController = gameUIController;
        initializeNotStartScreen();
    }

    /**
     * to change place after the go command
     */
    public static void setCurrentPlace(Place currentPlace) {
        MainController.currentPlace = currentPlace;
    }

    /**
     * @return for the executionController to get the current place
     */
    public static Place getCurrentPlace() {
        return currentPlace;
    }

    public static Item getSelectedItemPlayer() {
        return selectedItemPlayer;
    }

    public static Item getSelectedItemLoot() {
        return selectedItemLoot;
    }

    public static Container getSelectedContainer() {
        return selectedContainer;
    }

    public static Entity getSelectedEntityToUseItemOn() {
        return selectedEntityToUseItemOn;
    }

    public static Item getSelectedItemTrader() {
        return selectedItemTrader;
    }

    public static World getWorld() {
        return world;
    }

    /*======= UI update ==========*/

    /**
     * refreshes the part of the ui related to the current place
     */
    public static void updateCurrentPlace() {
        gameUIController.updateCurrentPlace(currentPlace);
    }

    /**
     * refreshes the parts of the ui related the the selected container
     */
    public static void updateSelectedContainer() {
        gameUIController.updateSelectedContainer(selectedContainer);
    }

    /**
     * refreshes the parts of the ui related to the dialogue
     * The dialogue text is passed as an arg
     */
    public static void updateDialogue(String executionResult) {
        gameUIController.updateDialogue(executionResult);
    }

    /**
     * refreshes the parts of the ui related to the player
     */
    public static void updatePlayer() {
        gameUIController.updatePlayer(player);
    }

    /**
     * refreshes the parts of the ui related to the exits in the current room
     */
    public static void updateExits() {
        gameUIController.updateExits();
    }

    /**
     * refreshes the part of the ui related to the information display
     * informations to be displayed are passed as an arg
     */
    public static void updateInfo(String executionResult) {
        gameUIController.updateInformation(executionResult);
    }

    /**
     * unselect all container in the UI
     */
    public static void unselectContainer() {
        gameUIController.unselectContainer();
        selectedContainer = null;
    }

    /**
     * When the user interacts (directly or indirectly) with a container in a way that executes a command,
     * this method is called
     * For example when the content of a container inventory is changed
     */
    public static void updateOnInteractionWithContainer(String interactionResult) {
        updateSelectedContainer();
        updateOnInteractionWithItem(interactionResult);
    }

    /**
     * When the user interacts (directly or indirectly) with an item in a way that executes a command,
     * this method is called
     * For example when an item may be removed or added from the player's inventory
     */
    public static void updateOnInteractionWithItem(String executionResult) {
        updatePlayer();
        updateExits(); // in case of interaction with a key
        updateInfo(executionResult); // we update the info last
    }

    /**
     * Locks the interface until the player react with an action
     * the controller will be notified by the interface via when to unlock
     */
    public static void waitForInput() {
        gameUIController.waitForInput();
    }

    /**
     * unlocks the interface
     * We also update the current place
     * in case the content of the room have changed when the interface was locked
     */
    public static void unlockInterface() {
        gameUIController.unlockInterface();
        updateCurrentPlace();
    }

    /**
     * checks if the player is dead.
     * If so then triggers the end of the game
     * with a new stage and a full interface lock
     */
    public static void checkDeath() {
        if (player.isDead()) {
            gameUIController.setDead();
            gameUIController.updatePlayer(player);
            Stage gameOverScreen = new GameOverScreen();
            gameOverScreen.show();
        }
    }

    /**
     * checks victory
     * if so then triggers the end of the game
     * with a new stage and a full interface lock
     */
    public static void checkVictory() {
        if (world.hasWin()) {
            gameUIController.lockInterface();
            Stage victoryScreen = new GameVictoryScreen();
            victoryScreen.show();
        }
    }

    /**
     * selects the container in the world from the current room
     * This is used to display the container in the ui
     */
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

    /*============= Updates of the Controller coming from the view ====================*/
    /*Here are methods from the view that updates the state of the controller via listeners or actionEvents*/

    /**
     * triggers the selection of the hidden container in the currentPlace
     * and updates the ui accordingly
     */
    public static void lootPlace() {
        selectedContainer = currentPlace.getPlaceContainer();
        updateSelectedContainer();
    }

    /**
     * when the player selects an item in his inv in the UI
     * it calls this method to update the the controller and the rest of the ui accordingly
     */
    public static void setSelectedItemPlayer(Item item) {
        selectedItemPlayer = item;
        gameUIController.setSelectedItemPlayer(selectedItemPlayer);
    }

    /**
     * when a player selects an item in a chest, this is called
     */
    public static void setSelectedItemLoot(Item item) {
        selectedItemLoot = item;
    }

    /**
     * @param item when the player selects an intel in the inv of another being, this is called
     */
    public static void setSelectedItemTrader(Item item) {
        selectedItemTrader = item;
    }

    /**
     * when the player selects an entity in the "Use On" box, this is called
     */
    public static void setSelectedEntityToUseItemOn(Entity entityToUseItemOn) {
        selectedEntityToUseItemOn = entityToUseItemOn;
    }
}
