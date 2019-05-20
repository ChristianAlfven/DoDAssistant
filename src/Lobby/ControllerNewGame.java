package Lobby;

import java.io.IOException;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Armor;
import CharacterFile.Health;
import Database.DB_Connector;
import Database.LoadCharacter;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import Creator.*;


import Database.LoadCharacter;
import Database.SaveCharacter;
import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.Initializable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    void buttonDummy(ActionEvent event) {
        createDummy();
        updateTable();
    }

    @FXML
    void buttonLoadCharacter(ActionEvent event) {
        for (int i = 1; i < Party.getParty().getNextCharId(); i++) {
            System.out.println(i);
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
            character1.setBackground("Background lorem ipsum");
            character1.setPositiveTrait1(Character.SpecialTrait.Charisma);
            character1.setPositiveTrait2(Character.SpecialTrait.Psyche);
            character1.setPosTrait1Level(10);
            character1.setPosTrait2Level(15);
            character1.setNegativeTrait(Character.SpecialTrait.Agility);
            character1.setNegTraitLevel(30);
            character1.setNationality(Character.Nationality.Human);
            character1.constructHealth(100);
            character1.setTotalExp(100);
            //character1.setCharacteristics("Characteristics");
            character1.setCombatPoints(2000);

            partyInstance.addCharacter(character1);
            y++;
        } else {
            Character character2 = new Character();

            character2.setName("Lorem ipsum");
            character2.setGender(Character.Gender.Male);
            character2.setAge(1);
            character2.setHeight(2);
            character2.setWeight(3);
            character2.setRegion(Character.Region.Eastheim);
            character2.setRace(Character.Race.Dwarf);
            character2.setSubrace(Character.SubRace.Virann);
            character2.setProfession(Character.Profession.Mage);
            character2.setEnvironment(Character.Environment.Nature);
            character2.setBackground("lorem ipsum 2");
            character2.setPositiveTrait1(Character.SpecialTrait.Agility);
            character2.setPositiveTrait2(Character.SpecialTrait.Spirituality);
            character2.setPosTrait1Level(13);
            character2.setPosTrait2Level(3);
            character2.setNegativeTrait(Character.SpecialTrait.Strength);
            character2.setNegTraitLevel(1);
            character2.setNationality(Character.Nationality.Orc);
            character2.constructHealth(3);
            character2.setTotalExp(32);
            character2.setCombatPoints(3);
            character2.getSkillset().getSpeech().setRona(10);
            character2.getSkillset().getNature().setMidlands(10);
            character2.getSkillset().getCulture().setMidlands(1);
            character2.getSkillset().getSpellcasting().setSkillLevel(10);
            character2.getSkillset().getAlchemy().setSkillLevel(3);
            character2.setWeaponHand(Character.WeaponHand.Right);
            character2.getSkillset().getCrafting().setMetal(1);
            character2.getSkillset().getCrafting().setSoft(2);
            character2.getSkillset().getCrafting().setStone(3);
            character2.getSkillset().getCrafting().setWood(4);
            character2.getSkillset().getGeography().addHomeland(character2,2);


            partyInstance.addCharacter(character2);
            y--;
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
}