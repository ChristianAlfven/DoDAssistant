package Creator;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import CharacterFile.Character;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation3 implements Initializable {

    Character character;
    int pos1;
    int pos2;
    int neg;


    @FXML
    private Label idRaceLabel;

    @FXML
    private Button idContinue;

    @FXML
    private TextField idPosBox1;

    @FXML
    private Button idBack;

    @FXML
    private Label idWeaponHand;

    @FXML
    private Label idPosTrait1;

    @FXML
    private Label idNegTraitDescription;

    @FXML
    private Label idPosTraitDescription1;

    @FXML
    private Label idPosTraitDescription2;

    @FXML
    private Label idPosTrait2;

    @FXML
    private Label idNegTrait;

    @FXML
    private TextField idNegBox;

    @FXML
    private TextField idPosBox2;

    @FXML
    private TextField IdWpnBox;

    @FXML
    private Label idRaceLabel2;

    @FXML
    private Label idRaceLabel13;

    @FXML
    private Label idRaceLabel131;

    @FXML
    private Label idRaceLabel132;

    @FXML
    private Label idRaceLabel133;

    @FXML
    private Label idRaceLabel134;

    @FXML
    private Label idRaceLabel135;

    @FXML
    private Label idRaceLabel136;

    @FXML
    private Label idRaceLabel137;

    @FXML
    private Label idRaceLabel138;

    @FXML
    private Label idRaceLabel139;

    @FXML
    private TextField idCultureBox;

    @FXML
    private TextField idRidingBox;

    @FXML
    private TextField idEntertainmentBox;

    @FXML
    private TextField idSpeechBox;

    @FXML
    private TextField idMobilityBox;

    @FXML
    private TextField idCombatBox;

    @FXML
    private TextField idCrimeBox;

    @FXML
    private TextField idGeographyBox;

    @FXML
    private Button idCraftingBtn;

    @FXML
    private TextField idNatureBox;

    @FXML
    private Label idRaceLabel21;

    @FXML
    private Label idRaceLabel22;

    @FXML
    private Label idRaceLabel211;

    @FXML
    private Button idPosBtn2;

    @FXML
    private Button idWpnBtn;

    @FXML
    private Button idNegBtn;

    @FXML
    private Button idPosBtn1;

    @FXML
    private Button idRidingBtn;

    @FXML
    private Button idGeographyBtn;

    @FXML
    private TextField idMetalBox;

    @FXML
    private TextField idWoodBox;

    @FXML
    private TextField idStoneBox;

    @FXML
    private TextField idSoftBox;

    @FXML
    private Button idCultureBtn;

    @FXML
    private Button idNatureBtn;

    @FXML
    private Button idEntertainmentBtn;

    @FXML
    private Button idSpeechBtn;

    @FXML
    private Button idMobilityBtn;

    @FXML
    private Button idCombatBtn;

    @FXML
    private Button idCrimeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getLastCharacter();
        idPosTrait1.setText(character.getPositiveTrait1().toString());
        idPosTrait2.setText(character.getPositiveTrait2().toString());
        idNegTrait.setText(character.getNegativeTrait().toString());
    }

    @FXML
    void buttonBack(ActionEvent event) {

    }

    @FXML
    void buttonContinue(ActionEvent event) throws IOException {

        if(idCombatBox.getText()!= null && idPosBox1.getText() != null && idPosBox2.getText() != null && idSpeechBox != null
                && idRidingBox.getText() != null && idNatureBox.getText() != null && idMobilityBox.getText() != null
                && idGeographyBox.getText() != null && idCrimeBox.getText() != null && idNegBox.getText() != null
                && idEntertainmentBox.getText() != null && IdWpnBox.getText() != null && idMetalBox.getText() != null
                && idCultureBox.getText()!= null && idSoftBox.getText()!=null && idWoodBox.getText()!=null&&idStoneBox.getText()!=null)
        {
            try{
                character.getSkillset().getCombat().addSkillLevel(Integer.parseInt(idCombatBox.getText()));
                character.getSkillset().getMobility().addSkillLevel(Integer.parseInt(idMobilityBox.getText()));
                character.getSkillset().getEntertainment().addSkillLevel(Integer.parseInt(idEntertainmentBox.getText()));
                character.getSkillset().getRiding().addSkillLevel(Integer.parseInt(idRidingBox.getText()));
                character.getSkillset().getCrime().addSkillLevel(Integer.parseInt(idCrimeBox.getText()));
                character.setPosTrait1Level(Integer.parseInt(idPosBox1.getText()));
                character.setPosTrait2Level(Integer.parseInt(idPosBox2.getText()));
                character.setNegTraitLevel(Integer.parseInt(idNegBox.getText()));
                character.getSkillset().getCrafting().addMetal(Integer.parseInt(idMetalBox.getText()));
                character.getSkillset().getCrafting().addStone(Integer.parseInt(idStoneBox.getText()));
                character.getSkillset().getCrafting().addSoft(Integer.parseInt(idSoftBox.getText()));
                character.getSkillset().getCrafting().addWood(Integer.parseInt(idWoodBox.getText()));
                if (Integer.parseInt(IdWpnBox.getText()) <= 14) {
                    character.setWeaponHand(Character.WeaponHand.Right);
                }else if (Integer.parseInt(IdWpnBox.getText()) <= 18){
                    character.setWeaponHand(Character.WeaponHand.Left);
                }else {
                    character.setWeaponHand(Character.WeaponHand.Dual);
                }

                if (Integer.parseInt(idPosBox1.getText()) <= 3) {
                    character.setPosTrait1Level(4);
                }else if (Integer.parseInt(idPosBox1.getText()) <= 10){
                    character.setPosTrait1Level(2);
                }else {
                    character.setPosTrait1Level(1);
                }

                if (Integer.parseInt(idPosBox2.getText()) <= 3) {
                    character.setPosTrait2Level(4);
                }else if (Integer.parseInt(idPosBox2.getText()) <= 10){
                    character.setPosTrait2Level(2);
                }else {
                    character.setPosTrait2Level(1);
                }

                if (Integer.parseInt(idNegBox.getText()) <= 10) {
                    character.setNegTraitLevel(-1);
                }else if (Integer.parseInt(idPosBox1.getText()) <= 17){
                    character.setNegTraitLevel(-2);
                }else {
                    character.setNegTraitLevel(-4);
                }

                switch(character.getRace()){
                    case Human:
                        switch (character.getSubrace()){
                            case Stormlander:
                                character.getSkillset().getSpeech().addVrok(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().addEastheim(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().addEastheim(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().addEastheim(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Midlander:
                                character.getSkillset().getSpeech().addRona(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().addMidlands(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().addMidlands(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().addMidlands(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Virann:
                                character.getSkillset().getSpeech().addRona(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().addWestlands(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().addWestland(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().addWestlands(Integer.parseInt(idCultureBox.getText()));
                                break;
                        }
                        break;
                    case Dwarf:
                        character.getSkillset().getSpeech().addFuthark(Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getNature().addUnderworld(Integer.parseInt(idNatureBox.getText()));
                        character.getSkillset().getGeography().addUnderworld(Integer.parseInt(idGeographyBox.getText()));
                        character.getSkillset().getCulture().addDwarfish(Integer.parseInt(idCultureBox.getText()));
                        break;
                    case Elf:
                        character.getSkillset().getSpeech().addEika(Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getNature().addSoj(Integer.parseInt(idNatureBox.getText()));
                        character.getSkillset().getGeography().addSoj(Integer.parseInt(idGeographyBox.getText()));
                        character.getSkillset().getCulture().addElvish(Integer.parseInt(idCultureBox.getText()));
                        break;
                    case HalfBlood:
                        switch (character.getNationality()) {
                            case Human:
                                switch (character.getRegion()) {
                                    case Eastheim:
                                        character.getSkillset().getSpeech().addVrok(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().addEastheim(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addEastheim(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addEastheim(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Midlands:
                                        character.getSkillset().getSpeech().addRona(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().addMidlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addMidlands(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addMidlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Westlands:
                                        character.getSkillset().getSpeech().addRona(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().addWestlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addWestland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addWestlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                }break;
                            case Elf:
                                character.getSkillset().getSpeech().addEika(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().addSoj(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().addSoj(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().addElvish(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Orc:
                                character.getSkillset().getSpeech().addOrcish(Integer.parseInt(idSpeechBox.getText()));
                                switch (character.getRegion()) {
                                    case Westlands:
                                        character.getSkillset().getNature().addWestlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addWestland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addWestlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Midlands:
                                        character.getSkillset().getNature().addMidlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addMidlands(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addMidlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Eastheim:
                                        character.getSkillset().getNature().addEastheim(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().addEastheim(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().addEastheim(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                }
                                break;
                        }
                        break;

                    }

                Stage stage;
                Parent root;

                stage = (Stage) idContinue.getScene().getWindow();
                switch (character.getEnvironment()){
                    case Nature:
                        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation4Nature.fxml"));
                        break;
                    case City:
                        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation4City.fxml"));
                        break;
                    case Country:
                        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation4Country.fxml"));
                        break;
                    case Academic:
                        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation4Academic.fxml"));
                        break;
                    default:
                        root = FXMLLoader.load(getClass().getResource("../Lobby/GUINewGame.fxml"));
                        break;

                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch (Exception e){
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Warning");
                errorAlert.setContentText("Wrongful input");
                errorAlert.showAndWait();
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Warning");
            errorAlert.setContentText("Please roll all values");
            errorAlert.showAndWait();
        }


    }

    @FXML
    void rollCombat(ActionEvent event) {
        idCombatBox.setText(Integer.toString(rollDice(6)));
        idCombatBtn.setDisable(true);
        idCombatBox.setEditable(false);
    }

    @FXML
    void rollCrafting(ActionEvent event) {
        idMetalBox.setText(Integer.toString(rollDice(6)));
        idSoftBox.setText(Integer.toString(rollDice(6)));
        idStoneBox.setText(Integer.toString(rollDice(6)));
        idWoodBox.setText(Integer.toString(rollDice(6)));
        idCraftingBtn.setDisable(true);
        idMetalBox.setEditable(false);
        idWoodBox.setEditable(false);
        idStoneBox.setEditable(false);
        idSoftBox.setEditable(false);
    }

    @FXML
    void rollCrime(ActionEvent event) {
        idCrimeBox.setText(Integer.toString(rollDice(6)));
        idCrimeBtn.setDisable(true);
        idCrimeBox.setEditable(false);
    }

    @FXML
    void rollCulture(ActionEvent event) {
        idCultureBox.setText(Integer.toString(rollDice(6)));
        idCultureBtn.setDisable(true);
        idCultureBox.setEditable(false);
    }

    @FXML
    void rollEntertainment(ActionEvent event) {
        idEntertainmentBox.setText(Integer.toString(rollDice(6)));
        idEntertainmentBtn.setDisable(true);
        idEntertainmentBox.setEditable(false);
    }

    @FXML
    void rollGeography(ActionEvent event) {
        idGeographyBox.setText(Integer.toString(rollDice(6)));
        idGeographyBtn.setDisable(true);
        idGeographyBox.setEditable(false);
    }

    @FXML
    void rollMobility(ActionEvent event) {
        idMobilityBox.setText(Integer.toString(rollDice(6)));
        idMobilityBtn.setDisable(true);
        idMobilityBox.setEditable(false);
    }

    @FXML
    void rollNature(ActionEvent event) {
        idNatureBox.setText(Integer.toString(rollDice(6)));
        idNatureBtn.setDisable(true);
        idNatureBox.setEditable(false);
    }

    @FXML
    void rollNeg(ActionEvent event) {
        idNegBox.setText(Integer.toString(rollDice(20)));
        idNegBtn.setDisable(true);
        idNegBox.setEditable(false);
        if (Integer.parseInt(idNegBox.getText())<= 10){
            idNegTraitDescription.setText("(" + character.getTraitDescription(character.getNegativeTrait(),-1) + ")");
        } else if (Integer.parseInt(idNegBox.getText())<= 17){
            idNegTraitDescription.setText("(" + character.getTraitDescription(character.getNegativeTrait(),-2) + ")");
        } else if (Integer.parseInt(idNegBox.getText())<= 20){
            idNegTraitDescription.setText("(" + character.getTraitDescription(character.getNegativeTrait(),-4) + ")");
        }
    }

    @FXML
    void rollPos1(ActionEvent event) {
        idPosBox1.setText(Integer.toString(rollDice(20)));
        idPosBtn1.setDisable(true);
        idPosBox1.setEditable(false);
        if (Integer.parseInt(idPosBox1.getText())<= 3){
            idPosTraitDescription1.setText("(" + character.getTraitDescription(character.getPositiveTrait1(),4) + ")");
        } else if (Integer.parseInt(idPosBox1.getText())<= 10){
            idPosTraitDescription1.setText("(" + character.getTraitDescription(character.getPositiveTrait1(),2) + ")");
        } else if (Integer.parseInt(idPosBox1.getText())<= 20){
            idPosTraitDescription1.setText("(" + character.getTraitDescription(character.getPositiveTrait1(),1) + ")");
        }
    }

    @FXML
    void rollPos2(ActionEvent event) {
        idPosBox2.setText(Integer.toString(rollDice(20)));
        idPosBtn2.setDisable(true);
        idPosBox2.setEditable(false);
        if (Integer.parseInt(idPosBox2.getText())<= 3){
            idPosTraitDescription2.setText("(" + character.getTraitDescription(character.getPositiveTrait2(),4) + ")");
        } else if (Integer.parseInt(idPosBox2.getText())<= 10){
            idPosTraitDescription2.setText("(" + character.getTraitDescription(character.getPositiveTrait2(),2) + ")");
        } else if (Integer.parseInt(idPosBox2.getText())<= 20){
            idPosTraitDescription2.setText("(" + character.getTraitDescription(character.getPositiveTrait2(),1) + ")");
        }
    }

    @FXML
    void rollRiding(ActionEvent event) {
        idRidingBox.setText(Integer.toString(rollDice(6)));
        idRidingBtn.setDisable(true);
        idRidingBox.setEditable(false);
    }

    @FXML
    void rollSpeech(ActionEvent event) {
        idSpeechBox.setText(Integer.toString(rollDice(6)));
        idSpeechBtn.setDisable(true);
        idSpeechBox.setEditable(false);
    }

    @FXML
    void rollWpnHand(ActionEvent event) {
        IdWpnBox.setText(Integer.toString(rollDice(20)));
        idWpnBtn.setDisable(true);
        IdWpnBox.setEditable(false);
        if (Integer.parseInt(IdWpnBox.getText()) <= 14) {
            idWeaponHand.setText("(Right)");
        }else if (Integer.parseInt(IdWpnBox.getText()) <= 18){
            idWeaponHand.setText("(Left)");
        }else {
            idWeaponHand.setText("(Dual)");
        }
    }



    public int rollDice(int sides){
        return (int)((Math.random()*sides) + 1);
    }
}
