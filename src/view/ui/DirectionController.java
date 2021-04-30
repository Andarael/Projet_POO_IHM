package view.ui;

import controller.Direction;
import controller.ExecutionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.entity.Container;
import model.entity.Player;
import model.entity.item.Key;
import model.entity.place.Exit;
import model.entity.place.LockedExit;
import model.entity.place.Place;
import model.utils.Col;

import java.util.Collections;
import java.util.List;

import static controller.Direction.*;
import static model.utils.StringUtils.readable;

public class DirectionController extends AbstractController {

    @FXML public Button buttonUp;
    @FXML public Button buttonDown;
    @FXML public Button buttonLeft;
    @FXML public Button buttonRight;
    @FXML public VBox canevas;

    @FXML
    CanevasController canevasController;

    private Place currentPlace = null;
    private Player player = null;


    @FXML
    public void goUp(ActionEvent actionEvent) {
        ExecutionController.executeGo(UP);
    }

    @FXML
    public void goLeft(ActionEvent actionEvent) {
        ExecutionController.executeGo(LEFT);
    }

    @FXML
    public void goRight(ActionEvent actionEvent) {
        ExecutionController.executeGo(RIGHT);
    }

    @FXML
    public void goDown(ActionEvent actionEvent) {
        ExecutionController.executeGo(DOWN);
    }

    @Override
    public void initThis() {
        updateThis();
        canevas.toBack();
    }

    @Override
    public void updateThis() {
        updateAllChildren();
        updateAllButtons();
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return Collections.singletonList(canevasController);
    }

    private void updateAllButtons() {
        updateButton(buttonUp, UP);
        updateButton(buttonLeft, LEFT);
        updateButton(buttonRight, RIGHT);
        updateButton(buttonDown, DOWN);
    }

    private void updateButton(Button button, Direction direction) {
        resetButtonColor(button);
        button.setDisable(true);

        if (currentPlace != null && currentPlace.exitExistIndex(direction.getIndex())) {
            Exit exit = currentPlace.getExitByIndex(direction.getIndex());
            button.setDisable(false);
            button.setText(readable(exit.getName()));
            setButtonColorFromExit(button, exit);
        } else {
            button.setText("      ");
        }

        if (direction == LEFT || direction == RIGHT) {
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

        button.setLineSpacing(-5); // I can't put negative value in the css
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
        button.setDisable(!player.contains(keyName) && exit.isLocked());
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

    public void updateCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
        canevasController.updateCurrentPlace(currentPlace);
        updateThis();
    }

    public void updateSelectedContainer(Container container) {
        canevasController.updateSelectedContainer(container);
    }

    public void updatePlayer(Player player) {
        this.player = player;
        canevasController.updatePlayer(player);
    }

    public void updateExits() {
        updateThis();
    }
}
