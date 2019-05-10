package Creator;

import ActiveChars.Party;
import CharacterFile.*;
import CharacterFile.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation4Nature implements Initializable {

    Character character;

    @FXML
    private Button idContinue;

    @FXML
    private Button idBack;

    @FXML
    private Label idRaceLabel2;

    @FXML
    private Label idRaceLabel13;

    @FXML
    private Label idRaceLabel131;

    @FXML
    private Label idRaceLabel133;

    @FXML
    private Label idRaceLabel134;

    @FXML
    private Label idRaceLabel136;

    @FXML
    private Label idRaceLabel137;

    @FXML
    private Label idRaceLabel138;

    @FXML
    private TextField idHuntingBox;

    @FXML
    private TextField idSurvivalBox;

    @FXML
    private TextField idSpeechBox;

    @FXML
    private TextField idCombatBox;

    @FXML
    private TextField idSeafaringBox;

    @FXML
    private TextField idGeographyBox;

    @FXML
    private TextField idNatureBox;

    @FXML
    private Label idRaceLabel21;

    @FXML
    private Label idRaceLabel211;

    @FXML
    private Button idSurvivalBtn;

    @FXML
    private Button idGeographyBtn;

    @FXML
    private Button idHuntingBtn;

    @FXML
    private Button idNatureBtn;

    @FXML
    private Button idSpeechBtn;

    @FXML
    private Button idCombatBtn;

    @FXML
    private Button idSeafaringBtn;

    @FXML
    private Label idRaceLabel22;

    @FXML
    private TextField idHPBox;

    @FXML
    private Button idHPBtn;

    @FXML
    private Button idRaudBtn;

    @FXML
    private TextField idRaudBox;

    @FXML
    private Label idRaceLabel221;

    @FXML
    private Label idRaceLabel2212;

    @FXML
    private Label idRaceLabel2213;

    @FXML
    private Label idRaceLabel2214;

    @FXML
    private Label idRaceLabel22131;

    @FXML
    private Label idHeadHP;

    @FXML
    private Label idLegsHP;

    @FXML
    private Label idStomachHP;

    @FXML
    private Label idChestHP;

    @FXML
    private Label idArmsHP;

    @FXML
    private Label idRaceLabel221311;

    @FXML
    private Label idTotalHP;

    @FXML
    private Label idRaceLabel222;


    @FXML
    private Label idRaceLabel2213111;

    @FXML
    private Label idRaud;

    @FXML
    void buttonBack(ActionEvent event) {

    }

    @FXML
    void buttonContinue(ActionEvent event) {
        if (idCombatBox.getText()==null&&idRaudBox.getText()==null&&idSurvivalBox.getText()==null&&idSpeechBox.getText()==null
                &&idHPBox.getText()==null&&idSeafaringBox.getText()==null&&idNatureBox.getText()==null&&idHuntingBox.getText()==null
                &&idGeographyBox.getText()==null){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Warning");
            errorAlert.setContentText("Please Roll all values");
            errorAlert.showAndWait();
        } else {
            try{
                character.getSkillset().getCombat().addSkillLevel(Integer.parseInt(idCombatBox.getText()));         //COMBAT
                character.getSkillset().getSurvival().addSkillLevel(Integer.parseInt(idSurvivalBox.getText()));     //SURVIVAL
                character.getSkillset().getSeafaring().addSkillLevel(Integer.parseInt(idSeafaringBox.getText()));   //SEAFARING
                character.getSkillset().getHunting().addSkillLevel(Integer.parseInt(idHuntingBox.getText()));       //HUNTING
                character.getSkillset().getNature().addHomeland(character, Integer.parseInt(idNatureBox.getText()));//NATURE
                character.setRaud(Integer.parseInt(idRaud.getText()));                                              //RAUD

                character.getSkillset().getSpeech().addMotherTongue(character,Integer.parseInt(idSpeechBox.getText())); //SPEECH
                character.getSkillset().getGeography().addHomeland(character,Integer.parseInt(idGeographyBox.getText()));//GEOGRAPHY

            }catch(Exception e){

            }
        }
    }

    @FXML
    void rollCombat(ActionEvent event) {
        idCombatBox.setText(Integer.toString(rollDice(6)));
        idCombatBtn.setDisable(true);
        idCombatBox.setEditable(false);
    }

    @FXML
    void rollGeography(ActionEvent event) {
        idGeographyBox.setText(Integer.toString(rollDice(6)));
        idGeographyBtn.setDisable(true);
        idGeographyBox.setEditable(false);
    }

    @FXML
    void rollHunting(ActionEvent event) {
        idHuntingBox.setText(Integer.toString(rollDice(6)));
        idHuntingBtn.setDisable(true);
        idHuntingBox.setEditable(false);
    }

    @FXML
    void rollNature(ActionEvent event) {
        idNatureBox.setText(Integer.toString(rollDice(6)));
        idNatureBtn.setDisable(true);
        idNatureBox.setEditable(false);
    }

    @FXML
    void rollSeafaring(ActionEvent event) {
        idSeafaringBox.setText(Integer.toString(rollDice(6)));
        idSeafaringBtn.setDisable(true);
        idSeafaringBox.setEditable(false);
    }

    @FXML
    void rollSpeech(ActionEvent event) {
        idSpeechBox.setText(Integer.toString(rollDice(6)));
        idSpeechBtn.setDisable(true);
        idSpeechBox.setEditable(false);
    }

    @FXML
    void rollSurvival(ActionEvent event) {
        idSurvivalBox.setText(Integer.toString(rollDice(6)));
        idSurvivalBtn.setDisable(true);
        idSurvivalBox.setEditable(false);
    }

    @FXML
    void rollRaud(ActionEvent event){
        idRaudBox.setText(Integer.toString(rollDice(5)));
        idRaudBtn.setDisable(true);
        idRaudBox.setEditable(false);
        int raudValue = Integer.parseInt(idRaudBox.getText());

        if (character.getPositiveTrait1() == Character.SpecialTrait.Charisma){
            if (character.getPosTrait1Level() <= 3){
                raudValue += 4;
            } else if (character.getPosTrait1Level() <= 10){
                raudValue += 2;
            } else if (character.getPosTrait1Level() <= 20){
                raudValue += 1;
            }
        }
        if (character.getPositiveTrait2() == Character.SpecialTrait.Charisma){
            if (character.getPosTrait2Level() <= 3){
                raudValue += 4;
            } else if (character.getPosTrait2Level() <= 10){
                raudValue += 2;
            } else if (character.getPosTrait2Level() <= 20){
                raudValue += 1;
            }
        }
        if (character.getNegativeTrait() == Character.SpecialTrait.Charisma){
            if (character.getNegTraitLevel() <= 3){
                raudValue = 0;
            } else if (character.getNegTraitLevel() <= 10){
                raudValue -= 2;
            } else if (character.getNegTraitLevel() <= 20){
                raudValue -= 1;
            }
        }
        if (raudValue < 0){ raudValue = 0;}

        idRaud.setText(Integer.toString(raudValue));
    }

    @FXML
    void rollHealth(ActionEvent event) {
        idHPBox.setText(Integer.toString(rollDice(6)));
        idHPBtn.setDisable(true);
        idHPBox.setEditable(false);

        int hp = 0;
        switch (character.getRace()){
            case Human:
                if (character.getGender()== Character.Gender.Male){
                    hp = 24;
                }else {
                    hp = 21;
                }
                break;
            case Elf:
                if (character.getGender()== Character.Gender.Male){
                    hp = 22;
                }else {
                    hp = 18;
                }
                break;
            case Dwarf:
                switch (character.getSubrace()){
                    case Borjornikka:
                        hp = 25;
                        break;
                    case Buratja:
                        hp = 23;
                        break;
                    case Zvorda:
                        hp = 29;
                        break;
                }
                break;
            case HalfBlood:
                if (character.getSubrace() == Character.SubRace.HalfOrc){
                    if(character.getGender()== Character.Gender.Male){
                        hp = 26;
                    }else {
                        hp = 22;
                    }
                } else {
                    if (character.getGender()== Character.Gender.Male){
                        hp = 24;
                    }else {
                        hp = 21;
                    }
                }
                break;
        }
        character.constructHealth(hp + Integer.parseInt(idHPBox.getText()));
        idArmsHP.setText(Integer.toString(character.getHealth().getRightArm()));
        idHeadHP.setText(Integer.toString(character.getHealth().getHead()));
        idLegsHP.setText(Integer.toString(character.getHealth().getLeftLeg()));
        idStomachHP.setText(Integer.toString(character.getHealth().getStomach()));
        idChestHP.setText(Integer.toString(character.getHealth().getChest()));
        idTotalHP.setText(Integer.toString(character.getHealth().getTotal()));
    }


    public int rollDice(int sides){
        return (int)((Math.random()*sides) + 1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getCharacter(0);
    }
}
