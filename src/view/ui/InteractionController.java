package view.ui;

import controller.ExecutionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.entity.Being;
import model.entity.Container;
import model.interfaces.Talkable;
import view.RessourceManager;

import static model.utils.StringUtils.capitalize;
import static model.utils.StringUtils.readable;

public class InteractionController extends AbstractController {

    @FXML public VBox interactionArea;
    @FXML private Label npcInteractionLabel;
    @FXML private Button talkButton;
    @FXML private Button attackButton;
    @FXML private Button lookButton;


    private Container selectedContainer = null;

    @Override
    public void initThis() {
        setButtonImage(talkButton, "talk");
        setButtonImage(attackButton, "attack");
        setButtonImage(lookButton, "look");
        updateThis();
    }

    private void setButtonImage(Button button, String string) {
        ImageView quitView = new ImageView(new Image(RessourceManager.getRessourceString(string, ".png")));
        quitView.setFitHeight(32);
        quitView.setFitWidth(32);
        button.setGraphic(quitView);
    }


    @Override
    public void updateThis() {
        interactionArea.setDisable(selectedContainer == null);

        updateLabel();

        boolean isBeing = selectedContainer instanceof Being;
        boolean isTalkable = selectedContainer instanceof Talkable;

        attackButton.setDisable(!isBeing);
        talkButton.setDisable(!isTalkable);
    }

    @FXML
    public void lookButtonAction(ActionEvent actionEvent) {
        ExecutionController.executeLook();
    }

    @FXML
    public void talkButtonAction(ActionEvent actionEvent) {
        ExecutionController.executeTalk();
    }

    @FXML
    public void attackButtonAction(ActionEvent actionEvent) {
        ExecutionController.executeAttack();
    }

    private void updateLabel() {
        if (selectedContainer == null)
            npcInteractionLabel.setText(null);
        else
            npcInteractionLabel.setText("What to do with " +
                                        capitalize(readable(selectedContainer.getName())) +
                                        " : ");

    }

    public void updateSelectedContainer(Container container) {
        this.selectedContainer = container;
        updateThis();
    }
}
