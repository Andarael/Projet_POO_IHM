package shadowLair.view.stage;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shadowLair.view.RessourceManager;

/**
 * a simple stage for the victory screen
 */
public class GameVictoryScreen extends Stage {

    public GameVictoryScreen() {
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("Victory !");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString("victory",
                                                                                          ".png")));

        helpImage.setOnMouseClicked(event -> Platform.exit());

        Scene endScene = new Scene(new StackPane(helpImage));

        this.setOnCloseRequest(event -> Platform.exit());

        this.setScene(endScene);

        this.setResizable(false);
    }
}
