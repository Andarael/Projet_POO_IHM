import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.world.StaticWorld;
import model.world.World;
import view.MainUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        Parent root;


//        root = new Direction();
        root = new MainUI();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        World world = StaticWorld.world;

        List<String> args = new ArrayList<>();

        args.add("i");

        model.command.Execute.execute(world, args);

    }
}
