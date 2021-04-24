package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Direction extends BorderPane {
    public Direction() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Direction.class.getResource("./Direction.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException ioe) {
            System.err.println("MyBorderPane2 constructor error");
            ioe.printStackTrace();
        }
    }
}
