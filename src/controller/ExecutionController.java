package controller;

import javafx.application.Platform;
import model.command.Attack;
import model.command.Execute;
import model.entity.Entity;
import model.entity.item.Item;
import model.entity.item.Key;
import model.entity.place.Exit;
import model.interfaces.UsableOnItem;

import java.util.List;

import static controller.CommandGenerator.*;
import static controller.MainController.*;

public class ExecutionController {
    public static void executeGo(Direction direction) {

        Exit exit = getCurrentPlace().getExitByIndex(direction.getIndex());
        String executionResult = Execute.execute(getWorld(), generateGoCommand(exit));

        setCurrentPlace(getWorld().currentPlace);

        unselectContainer();
        updateCurrentPlace();
        updateInfo(executionResult);

        String fight = Attack.checkFight(getWorld());

        if (fight != null)
            waitForInput();

        updateInfo(fight);

        checkDeath();
    }

    public static void executeLook() {
        Entity whatToLookAt = getSelectedContainer();

        if (getCurrentPlace().getPlaceContainer() ==
            getSelectedContainer())
            whatToLookAt = getCurrentPlace();

        List<String> command = generateLookCommand(whatToLookAt);

        String executionResult = Execute.execute(getWorld(), command);

        updateInfo(executionResult);
    }

    public static void executeLookForPlace() {
        List<String> command = generateLookCommand(getCurrentPlace());
        String executionResult = Execute.execute(getWorld(), command);
        updateInfo(executionResult);
    }

    public static void executeTalk() {
        List<String> command = generateTalkCommand(getSelectedContainer());
        String executionResult = Execute.execute(getWorld(), command);
        updateDialogue(executionResult);
    }

    public static void executeAttack() {
        List<String> command = generateAttackCommand(getSelectedContainer());

        String executionResult = Execute.execute(getWorld(), command);

        unselectContainer();

        updatePlayer();
        updateSelectedContainer();
        updateCurrentPlace();
        updateInfo(executionResult);

        checkDeath();
    }

    public static void executeEquip() {
        List<String> command = generateEquipCommand(getSelectedItemPlayer());

        String executionResult = Execute.execute(getWorld(), command);

        updatePlayer();
        updateInfo(executionResult);
    }

    public static void executeUnequip() {
        List<String> command = generateUnequipCommand();

        String executionResult = Execute.execute(getWorld(), command);

        updatePlayer();
        updateInfo(executionResult);
    }

    public static void executeDrop() {
        Item itemToDrop = getSelectedItemPlayer();
        List<String> command = generateDropCommand(itemToDrop);

        String executionResult = Execute.execute(getWorld(), command);

        updateOnInteractionWithItem(executionResult);
    }

    public static void executeUse() {

        Item itemToUse = getSelectedItemPlayer();

        List<String> command;

        if (itemToUse instanceof Key || itemToUse instanceof UsableOnItem)
            command = generateUseCommand(itemToUse, getSelectedEntityToUseItemOn());
        else
            command = generateUseCommand(itemToUse);

        String executionResult = Execute.execute(getWorld(), command);

        updateOnInteractionWithItem(executionResult);

        checkDeath();
    }

    public static void executeTake() {
        Item itemToTake = getSelectedItemLoot();
        List<String> command = generateTakeCommand(getSelectedContainer(),
                                                   itemToTake);

        String executionResult = Execute.execute(getWorld(), command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void executeBuy() {
        Item itemToBuy = getSelectedItemTrader();
        List<String> command = generateBuyCommand(getSelectedContainer(), itemToBuy);

        String executionResult = Execute.execute(getWorld(), command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void executeSell() {
        Item itemToSell = getSelectedItemPlayer();
        List<String> command = generateSellCommand(getSelectedContainer(), itemToSell);

        String executionResult = Execute.execute(getWorld(), command);

        updateOnInteractionWithContainer(executionResult);
    }

    public static void quitGame() {
        Platform.exit();
    }
}