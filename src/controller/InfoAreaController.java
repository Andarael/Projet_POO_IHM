package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.List;

public class InfoAreaController extends AbstractController {
    @FXML
    public TextArea textArea;
    @FXML
    public Button okButton;

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
        // todo
    }
}
