package controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.entity.Being;
import model.entity.Container;
import model.entity.Player;
import model.entity.StaticContainer;
import model.entity.place.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainUIController extends AbstractController {

    @FXML private BorderPane direction;
    @FXML private HBox characterBar1;
    @FXML private HBox characterBar2;
    @FXML private TextArea dialogueBox;
    @FXML private GridPane characterInteraction;
    @FXML private Parent infoArea;
    @FXML private StackPane root;
    @FXML private HBox tabs;

    @FXML private DirectionController directionController;
    @FXML private CharacterBarController characterBar1Controller;
    @FXML private CharacterBarController characterBar2Controller;
    @FXML private CharacterInteractionController characterInteractionController;
    @FXML private InfoAreaController infoAreaController; // todo
    @FXML private TabsController tabsController;

    @Override
    public void initThis() {
        setCurrentPlace(null);
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
                                             characterInteractionController,
                                             infoAreaController));
    }

    public void setSelectedContainer(Container container) {

        if (container instanceof StaticContainer)
            characterBar2Controller.setCurrentBeing(null);
        else if (container instanceof Being && container != MainController.getPlayer())
            characterBar2Controller.setCurrentBeing((Being) container);
        else
            characterBar2Controller.setCurrentBeing(null);

        this.setDialogue(null);
        this.setInformation(null);

        tabsController.setSelectedContainer(container);
        characterInteractionController.setSelectedContainer(container);
        directionController.setSelectedContainer(container);
    }

    public void setCurrentPlace(Place currentPlace) {
        directionController.setCurrentPlace(currentPlace);
        characterBar1Controller.updateThis();
        tabsController.setCurrentPlace(currentPlace);
        setSelectedContainer(null);
    }

    public void setInformation(String information) {
        infoAreaController.setText(information);
    }

    public void setDialogue(String dialogue) {
        dialogueBox.setText(dialogue);
    }

    public void setPlayer(Player player) {
        characterBar1Controller.setCurrentBeing(player);
        tabsController.setPlayer(player);
    }
}
