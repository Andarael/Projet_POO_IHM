package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.List;

public class TopButtonsController extends AbstractController {
    @FXML
    public Button lookPlaceButtonButton;
    @FXML
    public Button lootPlaceButton;
    @FXML
    public Button quitButton;

    @Override
    public void initThis() {
    }

    @Override
    public void updateThis() {
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    @FXML
    public void lookPlaceAction(ActionEvent actionEvent) {
        MainController.executeLookForPlace();
    }

    @FXML
    public void lootPlaceAction(ActionEvent actionEvent) {
        MainController.lootPlace();
    }

    @FXML
    public void quitAction(ActionEvent actionEvent) {
        MainController.quitGame();
    }
}
