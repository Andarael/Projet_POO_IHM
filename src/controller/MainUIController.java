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
import model.entity.StaticContainer;
import model.entity.place.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainUIController extends AbstractController {

    @FXML
    public BorderPane direction;
    @FXML
    public HBox characterBar1;
    @FXML
    public HBox characterBar2;
    @FXML
    public TextArea dialogueBox;
    @FXML
    public GridPane characterInteraction;
    @FXML
    public Parent infoArea;
    @FXML
    public StackPane root;
    @FXML
    public DirectionController directionController;
    @FXML
    public CharacterBarController characterBar1Controller;
    @FXML
    public CharacterBarController characterBar2Controller;
    @FXML
    public AbstractController dialogueBoxController; // todo
    @FXML
    public AbstractController characterInteractionController; // todo
    @FXML
    public InfoAreaController infoAreaController; // todo
    @FXML
    public HBox tabs;
    @FXML
    public TabsController tabsController;

    @Override
    public void initThis() {
        System.out.println(getChildrenControllers()); // todo remove
        characterBar1Controller.setCurrentBeing(MainController.player);
        characterBar1Controller.updateThis();
        setCurrentPlace(MainController.currentPlace);
        MainController.setRootController(this);
    }

    @Override
    public void updateThis() {
        // todo
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return new ArrayList<>(Arrays.asList(directionController,
                                             characterBar1Controller,
                                             characterBar2Controller,
                                             dialogueBoxController,
                                             tabsController,
                                             characterInteractionController,
                                             infoAreaController));
    }

    public void setSelectedContainer(Container container) {
        if (container == null) {
            tabsController.setSelectedContainer(null);
            characterBar2Controller.setCurrentBeing(null);

        } else if (container instanceof StaticContainer) {
            tabsController.setSelectedContainer(container);
            characterBar2Controller.setCurrentBeing(null);

        } else if (container instanceof Being && container != MainController.player) {
            tabsController.setSelectedContainer(container);
            characterBar2Controller.setCurrentBeing((Being) container);

        } else {
            tabsController.setSelectedContainer(null);
            characterBar2Controller.setCurrentBeing(null);
        }

        directionController.setSelectedContainer(container);
    }

    public void setCurrentPlace(Place currentPlace) {
        directionController.setCurrentPlace(currentPlace);

    }

    public void setInformation(String information) {
        infoAreaController.setText(information);
    }
}
