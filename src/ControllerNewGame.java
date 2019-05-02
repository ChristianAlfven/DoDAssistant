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

public class ControllerNewGame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idLoadCharacter;

    @FXML
    private Button idNewCharacter;

    @FXML
    private Button idStartGame;

    @FXML
    private Button idBack;

    @FXML
    void buttonNewCharacter(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idNewCharacter.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    void buttonStartGame(ActionEvent event) {

    }

    @FXML
    void buttonBack(ActionEvent event) {

    }


}