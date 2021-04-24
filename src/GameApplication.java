import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Direction;

public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Parent root = new Direction();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        model.game.Game.play(1, false);
    }
}
