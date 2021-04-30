package view.ui;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.List;

public class InfoAreaController extends AbstractController {
    @FXML
    private TextArea textArea;
    @FXML
    private Button okButton;

    @Override
    public void initThis() {
        okButton.setDisable(true);
//        okButton.setOpacity(0); // todo
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

    @FXML
    public void OkButtonAction(ActionEvent actionEvent) {
        MainController.unlockInterface();
    }

    public void waitForInput() {
        highlightInfo();
        okButton.setDisable(false);
    }

    public void stopWaitForInput() {
        okButton.setDisable(true);
        textArea.getStyleClass().remove("highlighted");
    }

    public void highlightInfo() {
        textArea.getStyleClass().add("highlighted");
    }
}
