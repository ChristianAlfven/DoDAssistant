import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerLobby {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit;

    @FXML
    private Button loadGame;

    @FXML
    private Button newGame;

    @FXML
    void buttonNewGame(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) newGame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
