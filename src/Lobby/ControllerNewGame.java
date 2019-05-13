package Lobby;

import java.io.File;
import java.io.IOException;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Armor;
import CharacterFile.Health;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import Creator.*;


import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.Initializable;

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
    Character character;

    @FXML private Button idRemove;
    @FXML private Button idNewCharacter;
    @FXML private Button idStartGame;
    @FXML private Button idExit;
    @FXML private Button idLoadCharacter;
    @FXML private Button idEdit;

    @FXML private TableView<Character> idTableView;
    @FXML private TableColumn<Integer, Character> idHealthColumn;
    @FXML private TableColumn<String, Character> idCharacterColumn;

    ObservableList<Character> list = FXCollections.observableArrayList();

//    DB_Connector db_connector = new DB_Connector();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        idCharacterTable.getItems().clear();
        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
            list.add(Party.getParty().getCharacter(i));
        }
        idTableView.setItems(list);
        for (int i = 0; i < list.size(); i++) {
            idHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
            idCharacterColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        }
    }



    int index = 0;
    @FXML
    void buttonDummy(ActionEvent event) {
        createDummy();
//        idTableView.getItems().clear();
//        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
//            list.add(Party.getParty().getCharacter(i));
//        }
//        idCharacterTable.setItems(list);

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
    void buttonLoadCharacter(ActionEvent event) {

    }

    @FXML
    void buttonEdit(ActionEvent event) throws IOException {
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
//        Party.getParty().setIndex(idCharacterTable.getSelectionModel().getSelectedIndex());
//        Party.getParty().removeCharacter(Party.getParty().getIndex());
//
//        idTableView.getItems().clear();
//        for (int i = 0; i <= Party.getParty().getArray() - 1; i++) {
//            list.add(Party.getParty().getCharacter(i));
//        }
//        idTableView.setItems(list);

    }

    @FXML
    void buttonExit(ActionEvent event) {
        Runtime.getRuntime().exit(0);
    }


    int y = 0;

    void createDummy() {
        if (y==0) {
            Character character1 = new Character();

            character1.setName("Pelle");
            character1.setGender(Character.Gender.Female);
            character1.setAge(12);
            character1.setHeight(123);
            character1.setWeight(10);
            character1.setRace(Character.Race.Human);
            character1.setSubrace(Character.SubRace.Borjornikka);
            character1.setProfession(Character.Profession.Priest);
            character1.setEnvironment(Character.Environment.City);
            character1.setBackground("Hej");
            character1.constructHealth(100);
//            character1.setTotalExp(100);

            Party.getParty().addCharacter(character1);
            y++;
        } else {
            Character character2 = new Character();

            character2.setName("Ost");
            character2.setGender(Character.Gender.Male);
            character2.setAge(321);
            character2.setHeight(100);
            character2.setWeight(300);
            character2.setRace(Character.Race.Dwarf);
            character2.setSubrace(Character.SubRace.Illmalaina);
            character2.setProfession(Character.Profession.Peasant);
            character2.setEnvironment(Character.Environment.Academic);
            character2.setBackground("Då");
            character2.constructHealth(200);
//            character2.setTotalExp(100);

            Party.getParty().addCharacter(character2);
            y--;
        }
    }



}