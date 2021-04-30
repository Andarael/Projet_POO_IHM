package shadowLair.view.ui;

import shadowLair.controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.List;

/**
 * An infoArea displays info it receives from higher controllers
 *
 * It is also responsible to notify the MainController when the user unlocks the interface
 */
public class InfoAreaController extends AbstractController {
    @FXML
    private TextArea textArea;
    @FXML
    private Button okButton;

    @Override
    public void initThis() {
        okButton.setDisable(true);
    }

    @Override
    public void updateThis() {
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    /**
     * this button is used to unlock the interface
     */
    @FXML
    public void OkButtonAction(ActionEvent actionEvent) {
        MainController.unlockInterface();
    }

    /**
     * is called when the interface locks up
     * we higlight the info to draw the user's attention, and enable the OkButton
     */
    public void waitForInput() {
        highlightInfo();
        okButton.setDisable(false);
    }

    /**
     * when we unlock the interface, this area gets back to its defaults
     */
    public void stopWaitForInput() {
        okButton.setDisable(true);
        textArea.getStyleClass().remove("highlighted");
    }

    public void highlightInfo() {
        textArea.getStyleClass().add("highlighted");
    }
}
