package controller;

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
        System.out.println("unlocking");
        MainController.unlockInterface();
    }

    public void waitForInput() {
        okButton.setDisable(false);
    }

    public void stopWaitForInput() {
        okButton.setDisable(true);
    }
}
