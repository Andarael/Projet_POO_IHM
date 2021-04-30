package shadowLair.view.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import shadowLair.controller.ExecutionController;
import shadowLair.view.RessourceManager;
import shadowLair.view.stage.HelpGameScreen;

import java.util.List;

/**
 * This controller only manages the 4 top buttons in the UI
 * Those are always enable and it does not receive updates from higher controllers
 * <p>
 * The buttons sends notifications to MainController
 */
public class TopButtonsController extends AbstractController {
    @FXML public Button lookPlaceButton;
    @FXML public Button lootPlaceButton;
    @FXML public Button quitButton;
    @FXML public Button helpButton;

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

    @Override
    public void initThis() {
        setButtonImage(quitButton, "quit");
        setButtonImage(lootPlaceButton, "loot");
        setButtonImage(lookPlaceButton, "look");
        setButtonImage(helpButton, "help");
    }

    @Override
    public void updateThis() {
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    private void setButtonImage(Button button, String string) {
        Image image = new Image(RessourceManager.getRessourceString(string, ".png"));
        ImageView quitView = new ImageView(image);
        quitView.setFitHeight(32);
        quitView.setFitWidth(32);
        button.setGraphic(quitView);
    }
}
