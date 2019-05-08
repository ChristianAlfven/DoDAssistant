package Game;

import ActiveChars.Party;
import CharacterFile.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameLobby implements Initializable {

    ObservableList<Character> list = FXCollections.observableArrayList();
    @FXML private ListView<Character> idCharacterTable = new ListView<>();
    @FXML private Button idCombat;
    @FXML private Button idScenario;
    @FXML private Button idLobby;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCharacterTable.getItems().clear();
        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
            list.add(Party.getParty().getCharacter(i));
        }
        idCharacterTable.setItems(list);
    }

    @FXML
    void buttonLobby(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idLobby.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void buttonCombat(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idCombat.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Combat/GUICombat.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void buttonScenario(ActionEvent event) {

    }


}
