package shadowLair.controller.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import shadowLair.controller.Direction;
import shadowLair.controller.ExecutionController;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.item.Key;
import shadowLair.model.entity.place.Exit;
import shadowLair.model.entity.place.LockedExit;
import shadowLair.model.entity.place.Place;
import shadowLair.model.utils.Col;

import java.util.Collections;
import java.util.List;

import static shadowLair.controller.Direction.*;
import static shadowLair.model.utils.StringUtils.readable;

/**
 * A DirectionController contains a canevas and4 buttons.
 * Each button correspond to an exit
 * <p>
 * This receive updates from higher up, and it sets the buttons accordingly
 * while also passing the updates to the canevas when necessary
 */
public class DirectionController extends AbstractController {

    /*======= FXML Nodes ========*/

    @FXML public Button buttonUp;
    @FXML public Button buttonDown;
    @FXML public Button buttonLeft;
    @FXML public Button buttonRight;
    @FXML public VBox canevas;

    /*======= FXML controllers ========*/

    @FXML
    CanevasController canevasController;

    /*======= FXML Actions ========*/

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

    /*======= inner variables ========*/

    private Place currentPlace = null;
    private Player player = null;

    /*======= AbstractController overrides ========*/

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

    /*======= updates form higher controllers ========*/

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

    /*======= private methods ========*/

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


}
