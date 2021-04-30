package view.ui;

import controller.ExecutionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.RessourceManager;
import view.stage.HelpGameScreen;

import java.util.List;

public class TopButtonsController extends AbstractController {
    @FXML public Button lookPlaceButton;
    @FXML public Button lootPlaceButton;
    @FXML public Button quitButton;
    @FXML public Button helpButton;

    @Override
    public void initThis() {
        setButtonImage(quitButton, "quit");
        setButtonImage(lootPlaceButton, "loot");
        setButtonImage(lookPlaceButton, "look");
        setButtonImage(helpButton, "help");
    }

    private void setButtonImage(Button button, String string) {
        ImageView quitView = new ImageView(new Image(RessourceManager.getRessourceString(string,".png")));
        quitView.setFitHeight(32);
        quitView.setFitWidth(32);
        button.setGraphic(quitView);
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
        ExecutionController.executeLookForPlace();
    }

    @FXML
    public void lootPlaceAction(ActionEvent actionEvent) {
        ExecutionController.executeLoot();
    }

    @FXML
    public void quitAction(ActionEvent actionEvent) {
        ExecutionController.quitGame();
    }

    @FXML
    public void helpAction(ActionEvent actionEvent) {

        HelpGameScreen helpGameScreen = new HelpGameScreen();
        helpGameScreen.show();

    }
}
