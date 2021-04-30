package shadowLair.view.stage;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shadowLair.view.RessourceManager;

/**
 * a simple stage for the game help screen
 */
public class HelpGameScreen extends Stage {

    public HelpGameScreen() {
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("How to Play ?");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString(
                "help_screen",
                ".png")));

        helpImage.setOnMouseClicked(event -> this.close());

        Scene helpScene = new Scene(new StackPane(helpImage));

        this.setScene(helpScene);

        this.setResizable(false);
    }
}
