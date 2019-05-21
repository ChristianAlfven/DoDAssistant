package Lobby;

import java.io.IOException;

import ActiveChars.Party;
import CharacterFile.Character;
import Database.DB_Connector;
import Database.LoadCharacter;

import java.net.URL;


import Database.SaveCharacter;
import javafx.fxml.Initializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ControllerNewGame implements Initializable {
    private DB_Connector connector = new DB_Connector();
    Character character;

    private Party partyInstance = Party.getParty();
    private LoadCharacter charLoader = LoadCharacter.charLoader();
    private SaveCharacter charSaver = SaveCharacter.charSaver();

    @FXML private Button idRemove;
    @FXML private Button idNewCharacter;
    @FXML private Button idStartGame;
    @FXML private Button idExit;
    @FXML private Button idLoadCharacter;
    @FXML private Button idSaveCharacter;
    @FXML private Button idEdit;
    @FXML private Button idCreateCombatantButton;

    @FXML private TableView<Character> idTableView;
    @FXML private TableColumn<Integer, Character> idHealthColumn;
    @FXML private TableColumn<String, Character> idCharacterColumn;

    ObservableList<Character> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getCharacters();
        dbGetLastCharId();
    }


    int index = 0;

    @FXML
    void buttonLoadCharacter(ActionEvent event) {
        for (int i = 1; i < Party.getParty().getNextCharId(); i++) {
            charLoader.loadCharacter(i);
            updateTable();
        }
        idLoadCharacter.setDisable(true);
    }

    @FXML
    void buttonSaveCharacter(ActionEvent event) {
        charSaver.storeCharacters();
    }


    private void updateTable(){

        list.add(Party.getParty().getCharacter(index));

        idTableView.setItems(list);
        for (int i = 0; i < list.size(); i++) {
            idHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
            idCharacterColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }
        index++;
    }



    @FXML
    void buttonStartGame(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idStartGame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Game/GUIGameLobby.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void buttonNewCharacter(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idNewCharacter.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Creator/GUICharacterCreation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonInspect(ActionEvent event) throws IOException {
        Party.getParty().setIndex(idTableView.getSelectionModel().getSelectedIndex());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../Game/GUIInspectCharacter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonRemove(ActionEvent event) {
        Party.getParty().setIndex(idTableView.getSelectionModel().getSelectedIndex());
        Party.getParty().removeCharacter(Party.getParty().getIndex());

        idTableView.getItems().clear();
        getCharacters();
    }

    @FXML
    void buttonExit(ActionEvent event) {
        Runtime.getRuntime().exit(0);
    }


    void getCharacters() {
        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
            list.add(Party.getParty().getCharacter(i));
        }
        idTableView.setItems(list);
        for (int i = 0; i < list.size(); i++) {
            idHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
            idCharacterColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }
    }

    public void dbGetLastCharId(){
        String dbScript;
        int dbCharId = 0;
        dbScript = String.format("SELECT charId FROM `character`;");
        try {
            ResultSet rs = connector.statement.executeQuery(dbScript);
            while(rs.next()){
                dbCharId = rs.getInt(1);
            }
            Party.getParty().setNextCharId(dbCharId + 1);
        } catch (SQLException ex) {
            System.out.println("error on executing the query (NewGame - dbGetLastCharId");
        }
    }

    @FXML
    void createCombatant(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idCreateCombatantButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../Creator/GUICombatantCreation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}