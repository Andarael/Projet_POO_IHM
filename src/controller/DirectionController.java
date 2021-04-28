package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.entity.item.Key;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.utils.Col;
import model.world.StaticWorld;
import model.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static controller.utils.Utils.readable;

public class DirectionController extends AbstractController{

    private final World world = StaticWorld.world;

    @FXML
    public Button buttonTop;
    @FXML
    public Button buttonBottom;
    @FXML
    public Button buttonLeft;
    @FXML
    public Button buttonRight;
    @FXML
    public VBox canevas;

    @FXML
    AbstractController canevasController;


    @FXML
    public void goTop(ActionEvent actionEvent) {
        executeByuDirection(0);
        canevasController.updateAll();
        // todo afficher le canevas avec la prochaine room avant l' update et sleep un peu
        updateAll();
    }

    @FXML
    public void goLeft(ActionEvent actionEvent) {
        executeByuDirection(1);
        canevasController.updateAll();
        updateAll();
    }

    @FXML
    public void goRight(ActionEvent actionEvent) {
        executeByuDirection(2);
        canevasController.updateAll();
        updateAll();
    }

    @FXML
    public void goBottom(ActionEvent actionEvent) {
        executeByuDirection(3);
        canevasController.updateAll();
        updateAll();
    }

    public void initAll() {
        updateAll();
        canevas.toBack();
        canevasController.setParentController(this);
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return Collections.singletonList(canevasController);
    }


    @Override
    public void updateAll() {
        updateAllChildren();
        updateAllButtons();
    }

    private void updateAllButtons() {
        updateButton(buttonTop, 0);
        updateButton(buttonLeft, 1);
        updateButton(buttonRight, 2);
        updateButton(buttonBottom, 3);
    }

    private void updateButton(Button button, int index) {
        resetButtonColor(button);
        button.setDisable(true);

        if (world.currentPlace.exitExistIndex(index)) {
            Exit exit = world.currentPlace.getExitByIndex(index);
            button.setDisable(false);
            button.setText(readable(exit.getName()));
            setButtonColorFromExit(button, exit);
        } else {
            button.setText("      ");
        }

        if (index == 1 || index == 2) {
            setVerticalText(button);
        }
    }

    /**
     * We must set the text to vertical, button rotation is not good
     * because then TrueType font antialiasing does not apply properly (windows)
     */
    private void setVerticalText(Button button) {
        String originalText = button.getText();
        String newText = "";

        for (char c : originalText.toCharArray())
            newText += c + "\n";

        button.setLineSpacing(-5); // i can't put negative value in css
        button.setText(newText);
    }

    private void setButtonColorFromExit(Button button, Exit exit) {
        if (exit instanceof LockedExit) {
            disableButtonIfNoKey(button, (LockedExit) exit);
            setButtonToExitColor(button, exit);
        }
    }

    private void disableButtonIfNoKey(Button button, LockedExit exit) {
        String keyName = Key.generateKeyName(exit.getColor());
        button.setDisable(!world.getPlayer().contains(keyName));
    }

    private void setButtonToExitColor(Button button, Exit exit) {
        if (exit.getDestination() == null)
            button.setDisable(true);

        String colorName = ((LockedExit) exit).getColor().getColorName();
        button.getStyleClass().add(colorName);
    }

    private void resetButtonColor(Button button) {
        for (Col col : Col.values()) {
            String colorName = col.getColorName();
            button.getStyleClass().remove(colorName);
        }
    }

    private List<String> getCommandByDirection(int index) {
        Exit exit = world.currentPlace.getExitByIndex(index);
        String destination = exit != null ? exit.getName() : "";
        return new ArrayList<>(Arrays.asList("go", destination));
    }

    private void executeByuDirection(int index) {
        model.command.Execute.execute(world, getCommandByDirection(index));
    }


}
