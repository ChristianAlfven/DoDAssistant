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

    @FXML
    private Label idRaceLabel;

    @FXML
    private Button idContinue;

    @FXML
    private TextField idPosBox1;

    @FXML
    private Button idBack;

    @FXML
    private Label idPosTrait1;

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
                character.getSkillset().getCombat().setSkillLevel(Integer.parseInt(idCombatBox.getText()));
                character.getSkillset().getMobility().setSkillLevel(Integer.parseInt(idMobilityBox.getText()));
                character.getSkillset().getEntertainment().setSkillLevel(Integer.parseInt(idEntertainmentBox.getText()));
                character.getSkillset().getRiding().setSkillLevel(Integer.parseInt(idRidingBox.getText()));
                character.getSkillset().getCrime().setSkillLevel(Integer.parseInt(idCrimeBox.getText()));
                character.setPosTrait1Level(Integer.parseInt(idPosBox1.getText()));
                character.setPosTrait2Level(Integer.parseInt(idPosBox2.getText()));
                character.setNegTraitLevel(Integer.parseInt(idNegBox.getText()));
                character.getSkillset().getCrafting().setMetal(Integer.parseInt(idMetalBox.getText()));
                character.getSkillset().getCrafting().setStone(Integer.parseInt(idStoneBox.getText()));
                character.getSkillset().getCrafting().setSoft(Integer.parseInt(idSoftBox.getText()));
                character.getSkillset().getCrafting().setWood(Integer.parseInt(idWoodBox.getText()));

                switch(character.getRace()){
                    case Human:
                        switch (character.getSubrace()){
                            case Stormlander:
                                character.getSkillset().getSpeech().setVrok(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().setEastheim(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().setEastheim(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().setEastheim(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Midlander:
                                character.getSkillset().getSpeech().setRona(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().setMidlands(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().setMidland(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().setMidlands(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Virann:
                                character.getSkillset().getSpeech().setRona(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().setWestlands(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().setWestland(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().setWestlands(Integer.parseInt(idCultureBox.getText()));
                                break;
                        }
                        break;
                    case Dwarf:
                        character.getSkillset().getSpeech().setFuthark(Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getNature().setUnderworld(Integer.parseInt(idNatureBox.getText()));
                        character.getSkillset().getGeography().setUnderworld(Integer.parseInt(idGeographyBox.getText()));
                        character.getSkillset().getCulture().setDwarfish(Integer.parseInt(idCultureBox.getText()));
                        break;
                    case Elf:
                        character.getSkillset().getSpeech().setEika(Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getNature().setSoj(Integer.parseInt(idNatureBox.getText()));
                        character.getSkillset().getGeography().setSoj(Integer.parseInt(idGeographyBox.getText()));
                        character.getSkillset().getCulture().setElvish(Integer.parseInt(idCultureBox.getText()));
                        break;
                    case HalfBlood:
                        switch (character.getNationality()) {
                            case Human:
                                switch (character.getRegion()) {
                                    case Eastheim:
                                        character.getSkillset().getSpeech().setVrok(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().setEastheim(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setEastheim(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setEastheim(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Midlands:
                                        character.getSkillset().getSpeech().setRona(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().setMidlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setMidland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setMidlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Westlands:
                                        character.getSkillset().getSpeech().setRona(Integer.parseInt(idSpeechBox.getText()));
                                        character.getSkillset().getNature().setWestlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setWestland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setWestlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                }break;
                            case Elf:
                                character.getSkillset().getSpeech().setEika(Integer.parseInt(idSpeechBox.getText()));
                                character.getSkillset().getNature().setSoj(Integer.parseInt(idNatureBox.getText()));
                                character.getSkillset().getGeography().setSoj(Integer.parseInt(idGeographyBox.getText()));
                                character.getSkillset().getCulture().setElvish(Integer.parseInt(idCultureBox.getText()));
                                break;
                            case Orc:
                                character.getSkillset().getSpeech().setOrcish(Integer.parseInt(idSpeechBox.getText()));
                                switch (character.getRegion()) {
                                    case Westlands:
                                        character.getSkillset().getNature().setWestlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setWestland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setWestlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Midlands:
                                        character.getSkillset().getNature().setMidlands(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setMidland(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setMidlands(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                    case Eastheim:
                                        character.getSkillset().getNature().setEastheim(Integer.parseInt(idNatureBox.getText()));
                                        character.getSkillset().getGeography().setEastheim(Integer.parseInt(idGeographyBox.getText()));
                                        character.getSkillset().getCulture().setEastheim(Integer.parseInt(idCultureBox.getText()));
                                        break;
                                }
                                break;
                        }
                        break;

                    }

                Stage stage;
                Parent root;

                stage = (Stage) idContinue.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../Lobby/GUINewGame.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();



            }catch (Exception e){
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
    }

    @FXML
    void rollPos1(ActionEvent event) {
        idPosBox1.setText(Integer.toString(rollDice(20)));
        idPosBtn1.setDisable(true);
        idPosBox1.setEditable(false);
    }

    @FXML
    void rollPos2(ActionEvent event) {
        idPosBox2.setText(Integer.toString(rollDice(20)));
        idPosBtn2.setDisable(true);
        idPosBox2.setEditable(false);
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getCharacter(0);
        idPosTrait1.setText(character.getPositiveTrait1().toString());
        idPosTrait2.setText(character.getPositiveTrait2().toString());
        idNegTrait.setText(character.getNegativeTrait().toString());
    }

    public int rollDice(int sides){
        return (int)((Math.random()*sides) + 1);
    }
}
