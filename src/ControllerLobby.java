import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControllerLobby {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idExit;

    @FXML
    private Button idLoadGame;

    @FXML
    private Button idNewGame;

    @FXML
    private TableView<?> idCharacterTable;

    @FXML
    void buttonNewGame(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idNewGame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
