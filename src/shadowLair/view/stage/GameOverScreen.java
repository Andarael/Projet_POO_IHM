package shadowLair.view.stage;

import shadowLair.view.RessourceManager;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * a simple stage for the game over screen
 */
public class GameOverScreen extends Stage{

    public GameOverScreen() {
        this.initModality(Modality.NONE);

        this.setTitle("Game Over !");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString("game_over", ".png")));

        helpImage.setOnMouseClicked(event -> Platform.exit());

        Scene endScene = new Scene(new StackPane(helpImage));

        this.setOnCloseRequest(event -> Platform.exit());

        this.setScene(endScene);

        this.setResizable(false);
    }
}
