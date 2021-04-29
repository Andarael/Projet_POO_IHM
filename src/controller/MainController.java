package controller;

import javafx.application.Platform;
import model.command.Execute;
import model.entity.Container;
import model.entity.Player;
import model.entity.item.Item;
import model.entity.place.Exit;
import model.entity.place.Place;
import model.utils.Printer;
import model.world.World;

import java.util.List;

import static controller.CommandGenerator.generateGoCommand;
import static controller.CommandGenerator.generateLookCommand;

public class MainController {

    static World world = new World();

    static Container selectedContainer = null;

    static Item selectedItemInv = null; // update in InventoryList

    static Item selectItemTrade = null;

    static Item getSelectedItemLoot = null;

    static MainUIController mainUIController;

    static Player player = world.getPlayer();

    static Place currentPlace = world.currentPlace;

    public static void setRootController(MainUIController mainUIController) {
        MainController.mainUIController = mainUIController;
    }

    public static void setSilentModel() {
        Printer.silence = true;
    }

    /*============= Command direction ======================*/

    static void executeByDirection(Direction direction) {
        // todo ici on affiche la pièce AVANT d' entrer
        // ou alors modifier go pour pas qu' il y ai de checkFight et du coup on peu sleep ?

        unselectContainer();

        Exit exit = currentPlace.getExitByIndex(direction.getIndex());

        Execute.execute(world, generateGoCommand(exit));

        currentPlace = world.currentPlace;

        mainUIController.characterBar1Controller.updateThis(); // todo simple appel au root

        mainUIController.setCurrentPlace(currentPlace);

    }

    /*============= Command Canevas ======================*/

    static void selectContainerByIndex(int index) {
        switch (index) {
            case 0:
                unselectContainer();
                break;
            case 1: case 2: case 3:
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

    static void executeLookForSelected() {
        List<String> command = generateLookCommand(selectedContainer);// todo wire
        String executionResult = Execute.execute(world, command);
        System.out.println(executionResult);
        mainUIController.setInformation(executionResult);

        // todo disable si rien selected
    }

    static void executeLookForPlace() {
        List<String> command = generateLookCommand(currentPlace);
        System.out.println(command);
        String executionResult = Execute.execute(world, command);
        System.out.println(executionResult);
        mainUIController.setInformation(executionResult);
    }

    /*============= Command Loot ======================*/

    static void lootPlace() {
        unselectContainer();
        selectedContainer = currentPlace.getPlaceContainer();
        mainUIController.setSelectedContainer(selectedContainer);
    }

    /*============= Command Quit ======================*/

    // todo are ya suuurerre ya vant to quit ?

    static void quitGame() {
        Platform.exit();
    }


}
