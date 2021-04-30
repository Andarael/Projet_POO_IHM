package view;

import controller.RessourceManager;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartGameScreen extends Stage{

    public StartGameScreen() {
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("Welcome !");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString("welcome", ".png", this)));

        helpImage.setOnMouseClicked(event -> {
            HelpGameScreen helpGameScreen = new HelpGameScreen();
            helpGameScreen.show();
        });

        Scene startScene = new Scene(new StackPane(helpImage));

        this.setScene(startScene);

        this.setResizable(false);
    }
}
