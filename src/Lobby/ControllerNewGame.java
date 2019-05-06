package Lobby;

import java.io.File;
import java.io.IOException;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Armor;
import CharacterFile.Health;
import java.net.URL;
import Creator.*;


import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.Initializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ControllerNewGame implements Initializable {
    Character character;

    @FXML private Button idRemove;
    @FXML private Button idNewCharacter;
    @FXML private Button idStartGame;
    @FXML private Button idExit;
    @FXML private Button idLoadCharacter;
    @FXML private Button idEdit;
    @FXML private ListView<Character> idCharacterTable = new ListView<>();


    ObservableList<Character> dsa = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 6; i++) {
            dsa.add(Party.getParty().getCharacter(i));
        }

        idCharacterTable.setItems(dsa);

    }

    @FXML
    void buttonDummy(ActionEvent event) {
        Character character1 = new Character();
        Character character2 = new Character();

        character1.setAge(12);
        character2.setAge(13);
        Party.getParty().addCharacter(character1);
        Party.getParty().addCharacter(character2);

        dsa.addAll(Party.getParty().getCharacter(1));

        idCharacterTable.setItems(dsa);
        for (int i = 0; i < 2; i++) {
        }

    }

    @FXML
    void buttonStartGame(ActionEvent event) {

    }

    @FXML
    void buttonNewCharacter(ActionEvent event) throws IOException {
        Stage stage;

        stage = (Stage) idNewCharacter.getScene().getWindow();
        URL url = new File("src/Creator/GUICharacterCreation.fxml").toURI().toURL();
        Pane root = FXMLLoader.load((url));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonLoadCharacter(ActionEvent event) {

    }

    @FXML
    void buttonEdit(ActionEvent event) {

    }

    @FXML
    void buttonRemove(ActionEvent event) {

    }

    @FXML
    void buttonExit(ActionEvent event) {
        Runtime.getRuntime().exit(0);
    }

}