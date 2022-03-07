package shadowLair.view.stage;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shadowLair.view.RessourceManager;

/**
 * a simple stage for the beginning of the game screen
 */
public class StartGameScreen extends Stage {

    public StartGameScreen() {
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle("Welcome !");

        ImageView helpImage = new ImageView(new Image(RessourceManager.getRessourceString("welcome",
                                                                                          ".png")));

        helpImage.setOnMouseClicked(event -> {
            HelpGameScreen helpGameScreen = new HelpGameScreen();
            helpGameScreen.show();
        });

        Scene startScene = new Scene(new StackPane(helpImage));

        this.setScene(startScene);

        this.setResizable(false);
    }
}
