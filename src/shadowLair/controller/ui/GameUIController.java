package shadowLair.controller.ui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import shadowLair.controller.MainController;
import shadowLair.model.entity.Being;
import shadowLair.model.entity.Container;
import shadowLair.model.entity.Player;
import shadowLair.model.entity.StaticContainer;
import shadowLair.model.entity.item.Item;
import shadowLair.model.entity.place.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static shadowLair.model.utils.StringUtils.capitalize;
import static shadowLair.model.utils.StringUtils.readable;

/**
 * This fxmlController is associated with the root FXML file
 * It receive updates directly from the mainController
 * and passes it to its children when necessary
 */
public class GameUIController extends AbstractController {

    /*======= FXML Nodes ========*/

    @FXML private Label roomNameLabel;
    @FXML private HBox topButtons;
    @FXML private BorderPane direction;
    @FXML private HBox characterBar1;
    @FXML private HBox characterBar2;
    @FXML private TextArea dialogueBox;
    @FXML private VBox interaction;
    @FXML private Parent infoArea;
    @FXML private StackPane root;
    @FXML private HBox tabs;

    /*======= FXML controllers ========*/

    @FXML private DirectionController directionController;
    @FXML private CharacterBarController characterBar1Controller;
    @FXML private CharacterBarController characterBar2Controller;
    @FXML private InteractionController interactionController;
    @FXML private InfoAreaController infoAreaController;
    @FXML private TabsController tabsController;
    @FXML private TopButtonsController topButtonsController;

    /*======= inner variables ========*/

    Player player = null;

    /*======= AbstractController overrides ========*/

    @Override
    public void initThis() {
        MainController.setMainUIController(this);
    }

    @Override
    public void updateThis() {
        getChildrenControllers().forEach(AbstractController::updateThis);
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return new ArrayList<>(Arrays.asList(directionController,
                                             characterBar1Controller,
                                             characterBar2Controller,
                                             tabsController,
                                             interactionController,
                                             infoAreaController));
    }

    /*======= updates form higher controllers ========*/

    public void updateSelectedContainer(Container container) {

        if (container instanceof StaticContainer)
            characterBar2Controller.updateBeing(null);
        else if (container instanceof Being && container != player)
            characterBar2Controller.updateBeing((Being) container);
        else
            characterBar2Controller.updateBeing(null);

        this.updateDialogue(null);
        this.updateInformation(null);

        tabsController.updateSelectedContainer(container);
        directionController.updateSelectedContainer(container);
        interactionController.updateSelectedContainer(container);

    }

    public void updateCurrentPlace(Place currentPlace) {
        directionController.updateCurrentPlace(currentPlace);
        characterBar1Controller.updateThis();
        tabsController.setCurrentPlace(currentPlace);
        roomNameLabel.setText(capitalize(readable(currentPlace.getName())));
        updateSelectedContainer(null); // when a change occurs in the currentPlace, we always unselect the Container
    }

    public void updateInformation(String information) {
        infoAreaController.setText(readable(information));
    }

    public void updateDialogue(String dialogue) {
        dialogueBox.setText(dialogue);
    }

    public void updatePlayer(Player player) {
        this.player = player;
        characterBar1Controller.updateBeing(player);
        tabsController.setPlayer(player);
        directionController.updatePlayer(player);
    }

    public void setSelectedItemPlayer(Item item) {
        tabsController.setSelectedItemPlayer(item);
    }

    public void updateExits() {
        directionController.updateExits();
    }

    public void unselectContainer() {
        directionController.updateSelectedContainer(null);
        characterBar2Controller.updateBeing(null);
    }

    public void lockInterface() {
        setComponentsDisable(true);
        infoAreaController.waitForInput();
    }

    public void unlockInterface() {
        setComponentsDisable(false);
        infoAreaController.stopWaitForInput();
    }

    private void setComponentsDisable(Boolean bool) {
        direction.setDisable(bool);
        characterBar1.setDisable(bool);
        characterBar2.setDisable(bool);
        dialogueBox.setDisable(bool);
        interaction.setDisable(bool);
        infoArea.setDisable(bool);
        tabs.setDisable(bool);
        topButtons.setDisable(bool);
    }

    public void setDead() {
        setComponentsDisable(true);
        infoArea.setDisable(false);
        infoAreaController.stopWaitForInput();
        infoAreaController.highlightInfo();
    }

    public void waitForInput() {
        setComponentsDisable(true);
        infoArea.setDisable(false);
        infoAreaController.waitForInput();
    }
}
