package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class MainUI extends HBox {

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
