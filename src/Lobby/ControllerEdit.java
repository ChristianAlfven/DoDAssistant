package Lobby;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerEdit implements Initializable {

    @FXML
    private TextArea idBackgroundBox;

    @FXML
    private ToggleButton idScholar;

    @FXML
    private Button idContinue;

    @FXML
    private RadioButton idAcademic;

    @FXML
    private ToggleButton idZvorda;

    @FXML
    private RadioButton idFemale;

    @FXML
    private TextField idAgeBox;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private ToggleButton idDwarf;

    @FXML
    private ToggleButton idHuman;

    @FXML
    private RadioButton idNature;

    @FXML
    private Label idWeightLabel;

    @FXML
    private ToggleGroup Race;

    @FXML
    private ToggleGroup Subrace;

    @FXML
    private ToggleButton idPeasant;

    @FXML
    private RadioButton idMale;

    @FXML
    private Label idHeightLabel;

    @FXML
    private ToggleButton idWarrior;

    @FXML
    private ToggleButton idBard;

    @FXML
    private ToggleButton idBorjornikka;

    @FXML
    private Label idBackgroundLabel;

    @FXML
    private TextField idNamebox;

    @FXML
    private Label idNameLabel;

    @FXML
    private RadioButton idCity;

    @FXML
    private RadioButton idCountry;

    @FXML
    private TextField idWeightBox;

    @FXML
    private Label idAgeLabel;

    @FXML
    private Button idBack;

    @FXML
    private Label idRaceLabel;

    @FXML
    private Label idSubraceLabel;

    @FXML
    private ToggleGroup Profession;

    @FXML
    private ToggleButton idElf;

    @FXML
    private ToggleButton idBuratja;

    @FXML
    private ToggleButton idRogue;

    @FXML
    private Label idProfessionLabel;

    @FXML
    private ToggleGroup Environment;

    @FXML
    private TextField idHeightBox;

    @FXML
    private ToggleButton idHalfBlood;

    @FXML
    private ToggleButton idPriest;

    @FXML
    private ToggleButton idMage;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Party.getParty().getCharacter(Party.getParty().getIndex()).getName());
    }


    @FXML
    void buttonBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonContinue(ActionEvent event) throws IOException {

    }


}
