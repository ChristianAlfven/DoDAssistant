package Creator;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import CharacterFile.Character;


import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation2 implements Initializable {

    Character character;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getCharacter(0);
    }

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
    void pressContinue(ActionEvent event) {

    }

    @FXML
    void pressNegAgility(ActionEvent event) {

    }

    @FXML
    void pressNegCharisma(ActionEvent event) {

    }

    @FXML
    void pressNegIntelligence(ActionEvent event) {

    }

    @FXML
    void pressNegPhysique(ActionEvent event) {

    }

    @FXML
    void pressNegPsyche(ActionEvent event) {

    }

    @FXML
    void pressNegSpirituality(ActionEvent event) {

    }

    @FXML
    void pressNegStrength(ActionEvent event) {

    }

    @FXML
    void pressPosAgility(ActionEvent event) {

    }

    @FXML
    void pressPosCharisma(ActionEvent event) {

    }

    @FXML
    void pressPosIntelligence(ActionEvent event) {

    }

    @FXML
    void pressPosPhysique(ActionEvent event) {

    }

    @FXML
    void pressPosPsyche(ActionEvent event) {

    }

    @FXML
    void pressPosSpirituality(ActionEvent event) {

    }

    @FXML
    void pressPosStrength(ActionEvent event) {

    }


}