package Creator;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import CharacterFile.Character;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javax.swing.event.InternalFrameListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation2 implements Initializable {

    Character character;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getCharacter(0);
    }

    Character.SpecialTrait pos1;
    Character.SpecialTrait pos2;
    Character.SpecialTrait neg;

    @FXML
    private Button buttonStrength;

    @FXML
    private Button buttonPsyche;

    @FXML
    private Button buttonIntelligence;

    @FXML
    private Button buttonSpirituality;

    @FXML
    private Button buttonAgility;

    @FXML
    private Button buttonPhysique;

    @FXML
    private Button buttonCharisma;

    @FXML
    private Button buttonNegStrength;

    @FXML
    private Button buttonNegCharisma;

    @FXML
    private Button buttonNegPsyche;

    @FXML
    private Button buttonNegIntelligence;

    @FXML
    private Button buttonNegSpirituality;

    @FXML
    private Button buttonNegAgility;

    @FXML
    private Button buttonNegPhysique;

    @FXML
    private TextField posTrait1;

    @FXML
    private TextField posTrait2;

    @FXML
    private TextField negTrait;

    @FXML
    private Button idContinue;

    @FXML
    void pressContinue(ActionEvent event) throws IOException {
        if ((pos2 == null)||(neg == null)){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please choose all special traits");
            errorAlert.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("C:\\Users\\hejpe\\IdeaProjects\\DoDAssistant\\src\\Lobby\\GUILobby.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void pressNegAgility(ActionEvent event) {
        neg = Character.SpecialTrait.Agility;
        updateText();
    }

    @FXML
    void pressNegCharisma(ActionEvent event) {
        neg = Character.SpecialTrait.Charisma;
        updateText();
    }

    @FXML
    void pressNegIntelligence(ActionEvent event) {
        neg = Character.SpecialTrait.Intelligence;
        updateText();
    }

    @FXML
    void pressNegPhysique(ActionEvent event) {
        neg = Character.SpecialTrait.Physique;
        updateText();
    }

    @FXML
    void pressNegPsyche(ActionEvent event) {
        neg = Character.SpecialTrait.Psyche;
        updateText();
    }

    @FXML
    void pressNegSpirituality(ActionEvent event) {
        neg = Character.SpecialTrait.Spirituality;
        updateText();
    }

    @FXML
    void pressNegStrength(ActionEvent event) {
        neg = Character.SpecialTrait.Strength;
        updateText();
    }

    @FXML
    void pressPosAgility(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Agility;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Agility;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Agility;
        }
        updateText();
    }

    @FXML
    void pressPosCharisma(ActionEvent event) {

        if (pos1 == null){
            pos1 = Character.SpecialTrait.Charisma;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Charisma;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Charisma;
        }
        updateText();
    }

    @FXML
    void pressPosIntelligence(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Intelligence;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Intelligence;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Intelligence;
        }
        updateText();
    }

    @FXML
    void pressPosPhysique(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Physique;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Physique;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Physique;
        }
        updateText();
    }

    @FXML
    void pressPosPsyche(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Psyche;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Psyche;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Psyche;
        }
        updateText();
    }

    @FXML
    void pressPosSpirituality(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Spirituality;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Spirituality;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Spirituality;
        }
        updateText();
    }

    @FXML
    void pressPosStrength(ActionEvent event) {
        if (pos1 == null){
            pos1 = Character.SpecialTrait.Strength;
        } else if (pos2 == null){
            pos2 = Character.SpecialTrait.Strength;
        } else {
            pos1 = pos2;
            pos2 = Character.SpecialTrait.Strength;
        }
        updateText();
    }

    void updateText(){
        if (pos1 != null)
            posTrait1.setText(pos1.toString());
        if (pos2 != null)
            posTrait2.setText(pos2.toString());
        if (neg != null)
            negTrait.setText(neg.toString());
    }

}