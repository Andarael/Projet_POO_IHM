package view;

import controller.RessourceManager;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpGameScreen extends Stage{

    public HelpGameScreen() {
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("How to Play ?");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString("help", ".png", this)));

        helpImage.setOnMouseClicked(event -> this.close());

        Scene helpScene = new Scene(new StackPane(helpImage));

        this.setScene(helpScene);

        this.setResizable(false);
        // todo help image
    }
}
