import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CCMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane root = FXMLLoader.load(getClass().getResource("GUICharacterCreation.fxml"));
        primaryStage.setTitle("CharacterFile Creator");
        primaryStage.setScene(new Scene(root, 620 , 410));
        primaryStage.show();
    }


    public static void main(String[] args) {
        CharacterCreator characterCreator = new CharacterCreator();
        launch(args);
    }
}
