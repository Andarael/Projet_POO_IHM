package shadowLair.controller;

import javafx.application.Platform;
import shadowLair.model.command.Attack;
import shadowLair.model.command.Execute;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.item.Key;
import shadowLair.model.entity.place.Exit;
import shadowLair.model.interfaces.UsableOnItem;
import shadowLair.model.world.World;

import java.util.List;

import static shadowLair.controller.CommandGenerator.*;
import static shadowLair.controller.MainController.*;

/**
 * This controller executes command to update the model
 * <p>
 * This controllers methods are mostly wired to the setOnAction() methods from the view
 * And each action in the ui correspond to a command to execute
 * <p>
 * the parameters for the command are determined from the state of the MainController
 * <p>
 * Once the command has been executed the necessary updates are called from the MainController
 * <p>
 * execution schéma :
 * 1 - get current state
 * 2 - generate command from state
 * 3 - execute command
 * 4 - update ui from model via controller
 * 5 - (optional) check for victor, death, and combat
 */
public class ExecutionController {

    private static World world;

    /**
     * executes the go command from the model
     * <p>
     * <p>
     * when changing place, if there are agressive creatures in the new room, they automatically attack the player
     * also because the player can die after changing place, we check death here
     */
    public static void executeGo(Direction direction) {

        Exit exit = getCurrentPlace().getExitByIndex(direction.getIndex());
        String executionResult = Execute.execute(world, generateGoCommand(exit));

        setCurrentPlace(getWorld().currentPlace); // we update the current place weather the go was successful or not

        // same for the ui
        unselectContainer();
        updateCurrentPlace();

        // we display the info just before a potential fight.
        // If there are no fights then the infos gets displayed normally
        updateInfo(executionResult);

        String fight = Attack.checkFight(getWorld());

        if (fight != null) { // the string is null if there are no fights
            waitForInput();
            updateInfo(fight);
        }

        checkDeath();
    }

    /**
     * The look command
     * we do a spacial check at the start to see if the player wants to look at the currentPlaceContainer
     * then we instead execute a look at the room
     */
    public static void executeLook() {
        if (getCurrentPlace().getPlaceContainer() == getSelectedContainer()) {
            executeLookForPlace();
            return;
        }

        List<String> command = generateLookCommand(getSelectedContainer());

        String executionResult = Execute.execute(world, command);

        updateInfo(executionResult);
    }

    /**
     * execute look command in order to look at the current room
     */
    public static void executeLookForPlace() {
        List<String> command = generateLookCommand(getCurrentPlace());
        String executionResult = Execute.execute(world, command);
        updateInfo(executionResult);
    }

    /**
     * execute talk with the selected npc
     */
    public static void executeTalk() {
        List<String> command = generateTalkCommand(getSelectedContainer());
        String executionResult = Execute.execute(world, command);
        updateDialogue(executionResult);
    }

    /**
     * executes attack with the selected npc
     * we check death after a fight
     */
    public static void executeAttack() {
        List<String> command = generateAttackCommand(getSelectedContainer());

        String executionResult = Execute.execute(world, command);

        unselectContainer(); // the player or the being is dead, in both case the selectContainer changes

        updatePlayer();
        updateSelectedContainer();
        updateCurrentPlace();
        updateInfo(executionResult);

        checkDeath();
    }

    /**
     * executes the equip command with the selected item in the player inventory
     */
    public static void executeEquip() {
        List<String> command = generateEquipCommand(getSelectedItemPlayer());

        String executionResult = Execute.execute(world, command);

        updatePlayer();
        updateInfo(executionResult);
    }

    /**
     * exec the unequip command
     */
    public static void executeUnequip() {
        List<String> command = generateUnequipCommand();

        String executionResult = Execute.execute(world, command);

        updatePlayer();
        updateInfo(executionResult);
    }

    /**
     * exec the drop command
     */
    public static void executeDrop() {
        Item itemToDrop = getSelectedItemPlayer();
        List<String> command = generateDropCommand(itemToDrop);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithItem(executionResult);
    }

    /**
     * exec the use command
     * The model had to be modified in order to get both the result of the utilisation (boolean -> item consumed or not)
     * and the description of the utilization
     * <p>
     * because the player can poison himself, we check death here too
     */
    public static void executeUse() {

        Item itemToUse = getSelectedItemPlayer();

        List<String> command;

        if (itemToUse instanceof Key || itemToUse instanceof UsableOnItem)
            command = generateUseCommand(itemToUse, getSelectedEntityToUseItemOn());
        else
            command = generateUseCommand(itemToUse);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithItem(executionResult);

        checkDeath();
    }

    /**
     * executes the loot command
     * In fact it is the take command that is executed in order to take the golds from the currentPlaceContainer
     */
    public static void executeLoot() {
        List<String> command = CommandGenerator.generateLootCommand();

        String executionResult = Execute.execute(world, command);

        updateCurrentPlace();
        updatePlayer();
        lootPlace();
        updateInfo(executionResult);
    }

    /**
     * exec the take command
     * <p>
     * because the victory is achieved when the player takes an item we check victory here
     */
    public static void executeTake() {
        Item itemToTake = getSelectedItemLoot();
        List<String> command = generateTakeCommand(getSelectedContainer(), itemToTake);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);

        checkVictory();
    }

    /**
     * exec buy with the selected being and the selected item in his inv
     */
    public static void executeBuy() {
        Item itemToBuy = getSelectedItemTrader();
        List<String> command = generateBuyCommand(getSelectedContainer(), itemToBuy);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);
    }

    /**
     * exec sell with the selected being and the selected item in the player's inv
     */
    public static void executeSell() {
        Item itemToSell = getSelectedItemPlayer();
        List<String> command = generateSellCommand(getSelectedContainer(), itemToSell);

        String executionResult = Execute.execute(world, command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void quitGame() {
        Platform.exit();
    }

    public static void setWorld(World world) {
        ExecutionController.world = world;
    }
}