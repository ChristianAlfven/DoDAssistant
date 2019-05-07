package Creator;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import CharacterFile.Character;
import javafx.stage.Stage;
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
    void pressContinue(ActionEvent event) {
        if ((pos2 == null) || (neg == null)) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please choose all special traits");
            errorAlert.showAndWait();
        } else {
            character.setPositiveTrait1(pos1);
            character.setPositiveTrait2(pos2);
            character.setNegativeTrait(neg);
            try {
                Stage stage = (Stage) idContinue.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation3.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    @FXML
    void pressNegAgility(ActionEvent event) {
        neg = Character.SpecialTrait.Agility;
        if (pos1 == Character.SpecialTrait.Agility) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Agility) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegCharisma(ActionEvent event) {
        neg = Character.SpecialTrait.Charisma;
        if (pos1 == Character.SpecialTrait.Charisma) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Charisma) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegIntelligence(ActionEvent event) {
        neg = Character.SpecialTrait.Intelligence;
        if (pos1 == Character.SpecialTrait.Intelligence) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Intelligence) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegPhysique(ActionEvent event) {
        neg = Character.SpecialTrait.Physique;
        if (pos1 == Character.SpecialTrait.Physique) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Physique) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegPsyche(ActionEvent event) {
        neg = Character.SpecialTrait.Psyche;
        if (pos1 == Character.SpecialTrait.Psyche) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Psyche) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegSpirituality(ActionEvent event) {
        neg = Character.SpecialTrait.Spirituality;
        if (pos1 == Character.SpecialTrait.Spirituality) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Spirituality) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressNegStrength(ActionEvent event) {
        neg = Character.SpecialTrait.Strength;
        if (pos1 == Character.SpecialTrait.Strength) {
            pos1 = null;
        }else if (pos2 == Character.SpecialTrait.Strength) {
            pos2 = null;
        }
        updateText();
    }

    @FXML
    void pressPosAgility(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Agility) && (pos2 != Character.SpecialTrait.Agility)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Agility;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Agility;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Agility;
            }
            if (neg == Character.SpecialTrait.Agility) {
                neg = null;
            }

            updateText();
        }
    }

    @FXML
    void pressPosCharisma(ActionEvent event) {

        if ((pos1 != Character.SpecialTrait.Charisma) && (pos2 != Character.SpecialTrait.Charisma)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Charisma;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Charisma;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Charisma;
            }
            if (neg == Character.SpecialTrait.Charisma) {
                neg = null;
            }
            updateText();
        }
    }

    @FXML
    void pressPosIntelligence(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Intelligence) && (pos2 != Character.SpecialTrait.Intelligence)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Intelligence;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Intelligence;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Intelligence;
            }
            if (neg == Character.SpecialTrait.Intelligence) {
                neg = null;
            }
            updateText();
        }
    }

    @FXML
    void pressPosPhysique(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Physique) && (pos2 != Character.SpecialTrait.Physique)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Physique;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Physique;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Physique;
            }
            if (neg == Character.SpecialTrait.Physique) {
                neg = null;
            }
            updateText();
        }
    }

    @FXML
    void pressPosPsyche(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Psyche) && (pos2 != Character.SpecialTrait.Psyche)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Psyche;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Psyche;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Psyche;
            }
            if (neg == Character.SpecialTrait.Psyche) {
                neg = null;
            }
            updateText();
        }
    }

    @FXML
    void pressPosSpirituality(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Spirituality) && (pos2 != Character.SpecialTrait.Spirituality)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Spirituality;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Spirituality;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Spirituality;
            }
            if (neg == Character.SpecialTrait.Spirituality) {
                neg = null;
            }
            updateText();
        }
    }

    @FXML
    void pressPosStrength(ActionEvent event) {
        if ((pos1 != Character.SpecialTrait.Strength) && (pos2 != Character.SpecialTrait.Strength)) {
            if (pos1 == null) {
                pos1 = Character.SpecialTrait.Strength;
            } else if (pos2 == null) {
                pos2 = Character.SpecialTrait.Strength;
            } else {
                pos1 = pos2;
                pos2 = Character.SpecialTrait.Strength;
            }
            if (neg == Character.SpecialTrait.Strength) {
                neg = null;
            }
            updateText();
        }
    }

    void updateText(){
        if (pos1 != null) {
            posTrait1.setText(pos1.toString());
        }else {
            posTrait1.setText("");
        }
        if (pos2 != null) {
            posTrait2.setText(pos2.toString());
        }else {
            posTrait2.setText("");
        }
        if (neg != null) {
            negTrait.setText(neg.toString());
        }else {
            negTrait.setText("");
        }
    }

}