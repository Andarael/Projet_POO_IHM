package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.entity.Being;
import model.entity.Container;
import model.interfaces.Talkable;

import static controller.utils.Utils.capitalize;
import static controller.utils.Utils.readable;

public class InteractionController extends AbstractController {

    @FXML public VBox interactionArea;
    @FXML private Label npcInteractionLabel;
    @FXML private Button talkButton;
    @FXML private Button attackButton;
    @FXML private Button lookButton;


    private Container selectedContainer = null;

    @Override
    public void initThis() {
        updateThis();
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
        MainController.executeLook();
    }

    @FXML
    public void talkButtonAction(ActionEvent actionEvent) {
        MainController.executeTalk();
    }

    @FXML
    public void attackButtonAction(ActionEvent actionEvent) {
        MainController.executeAttack();
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
