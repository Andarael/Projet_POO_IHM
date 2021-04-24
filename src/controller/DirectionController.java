package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DirectionController {
    @FXML
    public Button buttonTop;
    @FXML
    public Button buttonBottom;
    @FXML
    public Button buttonLeft;
    @FXML
    public Button buttonRight;


    @FXML
    public void goTop(ActionEvent actionEvent) {
        System.out.println("going top");
    }

    @FXML
    public void goBottom(ActionEvent actionEvent) {
        System.out.println("going bottom");
    }

    @FXML
    public void goLeft(ActionEvent actionEvent) {
        System.out.println("going Left");
    }

    @FXML
    public void goRight(ActionEvent actionEvent) {
        System.out.println("going Right");
    }





    public Button getButtonTop() {
        return buttonTop;
    }

    public void setButtonTop(Button buttonTop) {
        this.buttonTop = buttonTop;
    }

    public Button getButtonBottom() {
        return buttonBottom;
    }

    public void setButtonBottom(Button buttonBottom) {
        this.buttonBottom = buttonBottom;
    }

    public Button getButtonLeft() {
        return buttonLeft;
    }

    public void setButtonLeft(Button buttonLeft) {
        this.buttonLeft = buttonLeft;
    }

    public Button getButtonRight() {
        return buttonRight;
    }

    public void setButtonRight(Button buttonRight) {
        this.buttonRight = buttonRight;
    }
}
