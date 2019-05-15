package Game;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Character;
import groovy.transform.ToString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class GameLobby implements Initializable {

    ObservableList<Character> list = FXCollections.observableArrayList();

    @FXML private TableView<Character> idTableView;
    @FXML private TableColumn<Integer, Character> idHealthColumn;
    @FXML private TableColumn<ToString, Character> idCharacterColumn;

    @FXML private Button idCombat;
    @FXML private Button idScenario;
    @FXML private Button idLobby;
    @FXML private Button idInspect;

    private GmList gmInstance;
    private Stage stage;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
            list.add(Party.getParty().getCharacter(i));
        }
        idTableView.setItems(list);
        for (int i = 0; i < list.size(); i++) {
            idHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
//            idCharacterColumn.getCellFactory();   //Why isn't this working properly, want to call toString in Class.Character
            idCharacterColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }
        gmInstance = GmList.createGmList();

        idScenario.setDisable(true); //Disabled until scenario is implemented.
    }

    @FXML
    void buttonLobby(ActionEvent event) throws IOException {
        stage = (Stage) idLobby.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonCombat(ActionEvent event) throws IOException {
        gmInstance.setPlayersAdded(false);
        stage = (Stage) idCombat.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Combat/GUIInitiative.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonScenario(ActionEvent event) {

    }

    @FXML
    void buttonInspect(ActionEvent event) throws IOException {
        Party.getParty().setIndex(idTableView.getSelectionModel().getSelectedIndex());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("GUIInspectCharacter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
