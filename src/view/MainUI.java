package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainUI extends StackPane {

    public MainUI() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainUI.class.getResource("./MainUI.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
