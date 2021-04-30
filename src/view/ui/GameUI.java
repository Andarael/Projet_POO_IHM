package view.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class GameUI extends StackPane {

    public GameUI() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GameUI.class.getResource("GameUI.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
