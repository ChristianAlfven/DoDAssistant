package Combat;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CombatTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = FXMLLoader.load(getClass().getResource("GUICombat.fxml"));
        primaryStage.setTitle("Initiative");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
