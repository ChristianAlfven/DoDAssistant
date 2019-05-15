package Creator;

import ActiveChars.Party;
import CharacterFile.Character;
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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation4 implements Initializable {

    Character character;
    boolean override = false;
    int firstSkill = 0;
    int firstPick = 0;
    int craftingType = 0;

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
    private Label idSkill1;
    @FXML
    private Label idSkill2;
    @FXML
    private Button idSurvivalBtn;
    @FXML
    private Button idGeographyBtn;
    @FXML
    private TextField idCultureBox;
    @FXML
    private Button idRidingBtn;
    @FXML
    private Button idCultureBtn;
    @FXML
    private Button idSpeechBtn;
    @FXML
    private Button idMetalBtn;
    @FXML
    private Button idManagementBtn;
    @FXML
    private Button idSoftBtn;
    @FXML
    private Button idWoodBtn;
    @FXML
    private Button idStoneBtn;
    @FXML
    private TextField idCraftingBox;
    @FXML
    private TextField idManagementBox;
    @FXML
    private TextField idRidingBox;
    @FXML
    private Button idHuntingBtn;
    @FXML
    private Button idNatureBtn;
    @FXML
    private Button idCombatBtn;
    @FXML
    private Button idSeafaringBtn;
    @FXML
    private Button idMedicineBtn;
    @FXML
    private TextField idMedicineBox;
    @FXML
    private Label idRaceLabel22;
    @FXML
    private Button idOrcishBtn;
    @FXML
    private Button idFutharkBtn;
    @FXML
    private Button idEikaBtn;
    @FXML
    private Button idRonaBtn;
    @FXML
    private Button idVrokBtn;
    @FXML
    private TextField idSpeechChoiceBtn;
    @FXML
    private TextField idTradeBox;
    @FXML
    private Label idSpeechType;
    @FXML
    private Button idTradeBtn;
    @FXML
    private TextField idSpeechChoiceBox;
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
    private TextField idTheoreticalBox1;
    @FXML
    private TextField idTheoreticalBox2;
    @FXML
    private Button idTheoreticalBtn1;
    @FXML
    private Button idTheoreticalBtn2;
    @FXML
    private Button idTheoreticalBtn3;
    @FXML
    private Button idTheoreticalBtn4;
    @FXML
    private Button idTheoreticalBtn5;
    @FXML
    private Button idTheoreticalBtn6;
    @FXML
    private Label idRaud;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getLastCharacter();
        if (character.getEnvironment()== Character.Environment.City || character.getEnvironment()== Character.Environment.Academic){
            idSpeechType.setText("("+character.getSkillset().getSpeech().getMotherTongue(character)+")");
        }
    }

    @FXML
    void buttonBack(ActionEvent event) {

    }

    @FXML
    void buttonContinue(ActionEvent event) {
        switch (character.getEnvironment()) {

            //-----------NATURE------------

            case Nature:
                if (idCombatBox.getText().isEmpty() && idRaudBox.getText().isEmpty() && idSurvivalBox.getText().isEmpty() && idSpeechBox.getText().isEmpty()
                        && idHPBox.getText().isEmpty() && idSeafaringBox.getText().isEmpty() && idNatureBox.getText().isEmpty() && idHuntingBox.getText().isEmpty()
                        && idGeographyBox.getText().isEmpty()) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Warning");
                    errorAlert.setContentText("Please Roll all values");
                    errorAlert.showAndWait();
                } else {
                    try {
                        character.getSkillset().getCombat().setSkillLevel(Integer.parseInt(idCombatBox.getText()));         //COMBAT
                        character.getSkillset().getSurvival().addSkillLevel(Integer.parseInt(idSurvivalBox.getText()));     //SURVIVAL
                        character.getSkillset().getSeafaring().setSkillLevel(Integer.parseInt(idSeafaringBox.getText()));   //SEAFARING
                        character.getSkillset().getHunting().setSkillLevel(Integer.parseInt(idHuntingBox.getText()));       //HUNTING
                        character.getSkillset().getNature().addHomeland(character, Integer.parseInt(idNatureBox.getText()));//NATURE
                        character.setRaud(Integer.parseInt(idRaudBox.getText()));                                           // RAUD

                        character.getSkillset().getSpeech().addMotherTongue(character, Integer.parseInt(idSpeechBox.getText())); //SPEECH
                        character.getSkillset().getGeography().addHomeland(character, Integer.parseInt(idGeographyBox.getText()));//GEOGRAPHY


                        Stage stage = (Stage) idContinue.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation5.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Warning");
                        errorAlert.setContentText("Invalid values");
                        errorAlert.showAndWait();
                    }
                }
                break;

            //-----------COUNTRY------------

            case Country:

                if (idRidingBox.getText().isEmpty() || idRaudBox.getText().isEmpty() || idManagementBox.getText().isEmpty() || idSpeechBox.getText().isEmpty()
                        || idHPBox.getText().isEmpty() || idCultureBox.getText().isEmpty() || idCraftingBox.getText().isEmpty()) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Warning");
                    errorAlert.setContentText("Please Roll all values");
                    errorAlert.showAndWait();
                } else {
                    try {
                        character.getSkillset().getRiding().setSkillLevel(Integer.parseInt(idRidingBox.getText()));         //COMBAT
                        character.getSkillset().getManagement().setFarm(Integer.parseInt(idManagementBox.getText()));     //MANAGEMENT
                        character.getSkillset().getSpeech().addMotherTongue(character, Integer.parseInt(idSpeechBox.getText()));   //SEAFARING
                        character.getSkillset().getCulture().addHomeland(character, Integer.parseInt(idCultureBox.getText()));       //HUNTING
                        character.setRaud(Integer.parseInt(idRaudBox.getText()));



                        Stage stage = (Stage) idContinue.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation5.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Warning");
                        errorAlert.setContentText("Invalid values");
                        errorAlert.showAndWait();
                    }
                }
                break;

            //-----------CITY------------

            case City:
                if (idGeographyBox.getText() != null && idTradeBox.getText() != null && idSpeechBox.getText() != null
                        && idSpeechChoiceBox.getText() != null && idCraftingBox.getText() != null && idHPBox.getText() != null
                        && idRaudBox.getText() != null) {
                    try {
                        character.getSkillset().getGeography().addHomeland(character, Integer.parseInt(idGeographyBox.getText()));
                        character.getSkillset().getSpeech().addMotherTongue(character, Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getTrade().addSkillLevel(Integer.parseInt(idTradeBox.getText()));
                        character.setRaud(Integer.parseInt(idRaudBox.getText()));

                        Stage stage = (Stage) idContinue.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation5.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Warning");
                        errorAlert.setContentText("Invalid values");
                        errorAlert.showAndWait();
                    }
                }
                break;

            //-----------ACADEMIC------------
            case Academic:
                if (idMedicineBox.getText() != null && idNatureBox.getText() != null && idSpeechBox.getText() != null
                        && idSpeechChoiceBox.getText() != null && idTheoreticalBox1.getText() != null && idHPBox.getText() != null
                        && idRaudBox.getText() != null && idTheoreticalBox2.getText() != null){
                    try {
                        character.getSkillset().getMedicine().setSkillLevel(Integer.parseInt(idMedicineBox.getText()));
                        character.getSkillset().getSpeech().addMotherTongue(character, Integer.parseInt(idSpeechBox.getText()));
                        character.getSkillset().getNature().addHomeland(character,Integer.parseInt(idNatureBox.getText()));
                        character.setRaud(Integer.parseInt(idRaudBox.getText()));

                        Stage stage = (Stage) idContinue.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation5.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Warning");
                        errorAlert.setContentText("Invalid values");
                        errorAlert.showAndWait();
                    }
                }
                break;
        }
    }

    //-------------------------------NATURE----------------------------------


    //---------------COMBAT------------------
    @FXML
    void rollCombat(ActionEvent event) {
        idCombatBox.setText(Integer.toString(rollDice(6)));
        idCombatBtn.setDisable(true);
        idCombatBox.setEditable(false);
    }

    //---------------GEOGRAPHY------------------
    @FXML
    void rollGeography(ActionEvent event) {
        idGeographyBox.setText(Integer.toString(rollDice(6)));
        idGeographyBtn.setDisable(true);
        idGeographyBox.setEditable(false);
    }

    //---------------HUNTING------------------
    @FXML
    void rollHunting(ActionEvent event) {
        idHuntingBox.setText(Integer.toString(rollDice(6)));
        idHuntingBtn.setDisable(true);
        idHuntingBox.setEditable(false);
    }

    //---------------NATURE------------------
    @FXML
    void rollNature(ActionEvent event) {
        idNatureBox.setText(Integer.toString(rollDice(6)));
        idNatureBtn.setDisable(true);
        idNatureBox.setEditable(false);
    }

    //---------------SEAFARING------------------
    @FXML
    void rollSeafaring(ActionEvent event) {
        idSeafaringBox.setText(Integer.toString(rollDice(6)));
        idSeafaringBtn.setDisable(true);
        idSeafaringBox.setEditable(false);
    }

    //---------------SPEECH------------------
    @FXML
    void rollSpeech(ActionEvent event) {
        idSpeechBox.setText(Integer.toString(rollDice(6)));
        idSpeechBtn.setDisable(true);
        idSpeechBox.setEditable(false);
    }

    //---------------SURVIVAL------------------
    @FXML
    void rollSurvival(ActionEvent event) {
        idSurvivalBox.setText(Integer.toString(rollDice(6)));
        idSurvivalBtn.setDisable(true);
        idSurvivalBox.setEditable(false);
    }


    //------------------------------COUNTRY---------------------------------


    //---------------MANAGEMENT------------------
    @FXML
    void rollManagement(ActionEvent event) {
        idManagementBox.setText(Integer.toString(rollDice(6)));
        idManagementBtn.setDisable(true);
        idManagementBox.setEditable(false);
    }

    //---------------CULTURE------------------
    @FXML
    void rollCulture(ActionEvent event) {
        idCultureBox.setText(Integer.toString(rollDice(6)));
        idCultureBtn.setDisable(true);
        idCultureBox.setEditable(false);
    }

    //---------------RIDING------------------
    @FXML
    void rollRiding(ActionEvent event) {
        idRidingBox.setText(Integer.toString(rollDice(6)));
        idRidingBtn.setDisable(true);
        idRidingBox.setEditable(false);
    }


    //---------------CRAFTING------------------

    void rollCrafting() {
        idMetalBtn.setDisable(true);
        idStoneBtn.setDisable(true);
        idSoftBtn.setDisable(true);
        idWoodBtn.setDisable(true);
        idCraftingBox.setEditable(false);
    }

    @FXML
    void rollMetal(ActionEvent event) {
        if (idCraftingBox.getText().isEmpty()) {
            idCraftingBox.setText(Integer.toString(rollDice(6)));
        }
        rollCrafting();

        character.getSkillset().getCrafting().setMetal(Integer.parseInt(idCraftingBox.getText()));
    }

    @FXML
    void rollStone(ActionEvent event) {
        if (idCraftingBox.getText().isEmpty()) {
            idCraftingBox.setText(Integer.toString(rollDice(6)));
        }
        rollCrafting();


        character.getSkillset().getCrafting().setStone(Integer.parseInt(idCraftingBox.getText()));
    }

    @FXML
    void rollWood(ActionEvent event) {
        if (idCraftingBox.getText().isEmpty()) {
            idCraftingBox.setText(Integer.toString(rollDice(6)));
        }
        rollCrafting();

        character.getSkillset().getCrafting().setWood(Integer.parseInt(idCraftingBox.getText()));
    }

    @FXML
    void rollSoft(ActionEvent event) {
        if (idCraftingBox.getText().isEmpty()) {
            idCraftingBox.setText(Integer.toString(rollDice(6)));
        }
        rollCrafting();

        character.getSkillset().getCrafting().setSoft(Integer.parseInt(idCraftingBox.getText()));
    }

    //-----------------------------------------

    //------------------------------CITY-----------------------------------


    //---------------TRADE------------------
    @FXML
    void rollTrade(ActionEvent event) {
        idTradeBox.setText(Integer.toString(rollDice(6)));
        idTradeBtn.setDisable(true);
        idTradeBox.setEditable(false);
    }


    //---------------MULTIPLE SPEECH CHOICE------------------

    void disableSpeech() {
        idVrokBtn.setDisable(true);
        idOrcishBtn.setDisable(true);
        idRonaBtn.setDisable(true);
        idFutharkBtn.setDisable(true);
        idEikaBtn.setDisable(true);
        idSpeechChoiceBox.setEditable(false);
    }

    @FXML
    void rollVrok(ActionEvent event) {
        if (idSpeechChoiceBox.getText().isEmpty()) {
            idSpeechChoiceBox.setText(Integer.toString(rollDice(6)));
            disableSpeech();
        } else {
            disableSpeech();
        }
        character.getSkillset().getSpeech().setVrok(Integer.parseInt(idSpeechChoiceBox.getText()));
    }

    @FXML
    void rollRona(ActionEvent event) {
        if (idSpeechChoiceBox.getText().isEmpty()) {
            idSpeechChoiceBox.setText(Integer.toString(rollDice(6)));
        }
        disableSpeech();
        character.getSkillset().getSpeech().setRona(Integer.parseInt(idSpeechChoiceBox.getText()));
    }

    @FXML
    void rollFuthark(ActionEvent event) {
        if (idSpeechChoiceBox.getText().isEmpty()) {
            idSpeechChoiceBox.setText(Integer.toString(rollDice(6)));
            disableSpeech();
        } else {
            disableSpeech();
        }
        character.getSkillset().getSpeech().setFuthark(Integer.parseInt(idSpeechChoiceBox.getText()));
    }

    @FXML
    void rollOrcish(ActionEvent event) {
        if (idSpeechChoiceBox.getText().isEmpty()) {
            idSpeechChoiceBox.setText(Integer.toString(rollDice(6)));
            disableSpeech();
        } else {
            disableSpeech();
        }
        character.getSkillset().getSpeech().setOrcish(Integer.parseInt(idSpeechChoiceBox.getText()));
    }

    @FXML
    void rollEika(ActionEvent event) {
        if (idSpeechChoiceBox.getText().isEmpty()) {
            idSpeechChoiceBox.setText(Integer.toString(rollDice(6)));
        }
        disableSpeech();

        character.getSkillset().getSpeech().setEika(Integer.parseInt(idSpeechChoiceBox.getText()));
    }

    //------------------------------ACADEMIC---------------------------------

    //---------------MEDICINE------------------
    @FXML
    void rollMedicine(ActionEvent event) {
        idMedicineBox.setText(Integer.toString(rollDice(6)));
        idMedicineBtn.setDisable(true);
        idMedicineBox.setEditable(false);
    }

    //---------------THEORETICAL SKILLS------------------

    //----ALCHEMY----
    @FXML
    void rollTheoretical1(ActionEvent event) {
        switch (firstPick) {
            case 0:                 //----ALCHEMY----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getAlchemy().setSkillLevel(Integer.parseInt(idTheoreticalBox1.getText()));
                    firstSkill = 1;
                    idSkill1.setText("Alchemy");

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    idTheoreticalBox2.setEditable(false);
                    character.getSkillset().getAlchemy().setSkillLevel(Integer.parseInt(idTheoreticalBox2.getText()));
                    disableButtons();
                    idSkill2.setText("Alchemy");

                }
                break;

            case 2:                 //----SPEECH > VROK----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpeech().setVrok(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();
                    firstSkill = 21;
                    firstPick = 0;

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getSpeech().setVrok(Integer.parseInt(idTheoreticalBox2.getText()));
                    disableButtons();

                }
                break;

            case 5:                 //----NATURE > WESTLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setWestlands(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();
                    firstSkill = 51;

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setWestlands(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstPick = 0;
                break;

            case 6:                 //----GEOGRAPHY > WESTLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setWestland(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();
                    firstSkill = 61;
                    firstPick = 0;



                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }character.getSkillset().getGeography().setWestland(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();

                }
        }
    }

    //----SPEECH----
    @FXML
    void rollTheoretical2(ActionEvent event) {
        switch (firstPick) {
            case 0:                     //----SPEECH > SHOW SUBSKILLS----
                speechButtons();
                firstPick = 2;
                if (firstSkill == 0) {
                    idSkill1.setText("Speech");
                } else {
                    idSkill2.setText("Speech");
                }
                break;

            case 5:                     //----NATURE > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setMidlands(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();


                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setMidlands(Integer.parseInt(idTheoreticalBox2.getText()));
                    disableButtons();
                }
                firstSkill = 52;
                firstPick = 0;
                break;

            case 6:                     //----GEOGRAPHY > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setMidland(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getGeography().setMidland(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 62;
                firstPick = 0;
                break;
        }
    }

    //----SPELLCASTING----
    @FXML
    void rollTheoretical3(ActionEvent event) {

        switch (firstPick) {
            case 0:                         //----SPELLCASTING----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpellcasting().setSkillLevel(Integer.parseInt(idTheoreticalBox1.getText()));
                    idSkill1.setText("Spellcasting");
                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getSpellcasting().setSkillLevel(Integer.parseInt(idTheoreticalBox2.getText()));
                    idSkill2.setText("Spellcasting");
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 3;
                firstPick = 0;
                idTheoreticalBtn3.setDisable(true);
                break;

            case 2:                     //----SPEECH > RONA---
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpeech().setRona(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setMidlands(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }

                firstSkill = 23;
                firstPick = 0;
                break;


            case 5:                     //----NATURE > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setMidlands(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setMidlands(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 53;
                firstPick = 0;
                break;

            case 6:                     //----GEOGRAPHY > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setMidland(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getGeography().setMidland(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();

                }
                firstSkill = 63;
                firstPick = 0;
                break;
        }
    }

    //----MEDICINE----
    @FXML
    void rollTheoretical4(ActionEvent event) {

        switch (firstPick) {
            case 0:
                if (firstSkill == 0) {                           //----MEDICINE----
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    idTheoreticalBtn4.setDisable(true);
                    character.getSkillset().getMedicine().setSkillLevel(Integer.parseInt(idTheoreticalBox1.getText()));
                    firstSkill = 4;
                    idTheoreticalBtn4.setDisable(true);
                    idSkill1.setText("Medicine");
                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                        idSkill2.setText("Medicine");
                    }
                    idTheoreticalBox2.setEditable(false);
                    character.getSkillset().getMedicine().setSkillLevel(Integer.parseInt(idTheoreticalBox2.getText()));
                    disableButtons();

                }
                break;
                case 2:                     //----SPEECH > EIKA---
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpeech().setEika(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getSpeech().setEika(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 24;
                firstPick = 0;
                break;


            case 5:                     //----NATURE > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setSoj(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setSoj(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();

                }
                firstSkill = 54;
                firstPick = 0;
                break;

            case 6:                     //----GEOGRAPHY > MIDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setSoj(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getGeography().setSoj(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 64;
                firstPick = 0;
                break;

        }
    }

    //----NATURE----
    @FXML
    void rollTheoretical5(ActionEvent event) {
        switch (firstPick) {            //----SHOW NATURE SUBSKILLS----
            case 0:
                natureButtons();
                firstPick = 5;
                if(firstSkill == 0) {
                    idSkill1.setText("Nature");
                } else {
                    idSkill2.setText("Nature");
                }
                break;
            case 2:                     //----SPEECH > EIKA---
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpeech().setFuthark(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getSpeech().setFuthark(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 25;
                firstPick = 0;
                break;


            case 5:                     //----NATURE > NHORDLANDS----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setNhordlands(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setNhordlands(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();

                }
                firstSkill = 55;
                firstPick = 0;
                break;

            case 6:                     //----GEOGRAPHY > SOJ----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setNhoordland(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getGeography().setNhoordland(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 65;
                firstPick = 0;
                break;

        }
    }

    //----GEOGRAPHY----
    @FXML
    void rollTheoretical6(ActionEvent event) {
        switch (firstPick) {            //----SHOW GEOGRAPHY SUBSKILLS----
            case 0:
                geographyButtons();
                firstPick = 6;
                if (firstSkill == 0){
                    idSkill1.setText("Geography");
                } else {
                    idSkill2.setText("Geography");
                }
                break;
            case 2:                     //----SPEECH > ORCISH---
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getSpeech().setOrcish(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getSpeech().setOrcish(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 26;
                firstPick = 0;
                break;


            case 5:                     //----NATURE > UNDERWORLD----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getNature().setUnderworld(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getNature().setUnderworld(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();

                }
                firstSkill = 56;
                firstPick = 0;
                break;

            case 6:                     //----GEOGRAPHY > UNDERWORLD----
                if (firstSkill == 0) {
                    if (idTheoreticalBox1.getText().isEmpty()) {
                        idTheoreticalBox1.setText(Integer.toString(rollDice(6)));
                    }
                    lockFirst();
                    character.getSkillset().getGeography().setUnderworld(Integer.parseInt(idTheoreticalBox1.getText()));
                    resetButtons();

                } else {
                    if (idTheoreticalBox2.getText().isEmpty()) {
                        idTheoreticalBox2.setText(Integer.toString(rollDice(6)));
                    }
                    character.getSkillset().getGeography().setUnderworld(Integer.parseInt(idTheoreticalBox2.getText()));
                    resetButtons();
                    disableButtons();
                }
                firstSkill = 66;
                firstPick = 0;
                break;

        }
    }



    void speechButtons(){
        enableButtons();
        idTheoreticalBtn1.setText("Vrok");
        idTheoreticalBtn2.setText("Speech");
        idTheoreticalBtn3.setText("Rona");
        idTheoreticalBtn4.setText("Eika");
        idTheoreticalBtn5.setText("Futhark");
        idTheoreticalBtn6.setText("Orcish");

        idTheoreticalBtn2.setDisable(true);

        switch (firstSkill){
            case 21:
                idTheoreticalBtn1.setDisable(true);
                break;
            case 23:
                idTheoreticalBtn3.setDisable(true);
                break;
            case 24:
                idTheoreticalBtn4.setDisable(true);
                break;
            case 25:
                idTheoreticalBtn5.setDisable(true);
                break;
            case 26:
                idTheoreticalBtn6.setDisable(true);
                break;
        }
    }

    void natureButtons(){
        enableButtons();
        idTheoreticalBtn1.setText("Westlands");
        idTheoreticalBtn2.setText("Midlands");
        idTheoreticalBtn3.setText("Eastheim");
        idTheoreticalBtn4.setText("Soj");
        idTheoreticalBtn5.setText("Nhordlands");
        idTheoreticalBtn6.setText("Underworld");

        switch (firstSkill){
            case 51:
                idTheoreticalBtn1.setDisable(true);
                break;
            case 52:
                idTheoreticalBtn3.setDisable(true);
                break;
            case 53:
                idTheoreticalBtn4.setDisable(true);
                break;
            case 54:
                idTheoreticalBtn5.setDisable(true);
                break;
            case 55:
                idTheoreticalBtn6.setDisable(true);
                break;
            case 56:
                idTheoreticalBtn6.setDisable(true);
                break;
        }
    }

    void geographyButtons(){
        enableButtons();
        idTheoreticalBtn1.setText("Westlands");
        idTheoreticalBtn2.setText("Midlands");
        idTheoreticalBtn3.setText("Eastheim");
        idTheoreticalBtn4.setText("Soj");
        idTheoreticalBtn5.setText("Nhordlands");
        idTheoreticalBtn6.setText("Underworld");

        switch (firstSkill){
            case 61:
                idTheoreticalBtn1.setDisable(true);
                break;
            case 62:
                idTheoreticalBtn3.setDisable(true);
                break;
            case 63:
                idTheoreticalBtn4.setDisable(true);
                break;
            case 64:
                idTheoreticalBtn5.setDisable(true);
                break;
            case 65:
                idTheoreticalBtn6.setDisable(true);
                break;
            case 66:
                idTheoreticalBtn6.setDisable(true);
                break;
        }
    }

    void disableButtons(){
        idTheoreticalBtn1.setDisable(true);
        idTheoreticalBtn2.setDisable(true);
        idTheoreticalBtn3.setDisable(true);
        idTheoreticalBtn4.setDisable(true);
        idTheoreticalBtn5.setDisable(true);
        idTheoreticalBtn6.setDisable(true);
        idTheoreticalBox2.setEditable(false);
    }

    void resetButtons(){
        idTheoreticalBtn1.setText("Alchemy");
        idTheoreticalBtn2.setText("Speech");
        idTheoreticalBtn3.setText("Spellcasting");
        idTheoreticalBtn4.setText("Medicine");
        idTheoreticalBtn5.setText("Nature");
        idTheoreticalBtn6.setText("Geography");
        enableButtons();
    }

    void enableButtons(){
        idTheoreticalBtn1.setDisable(false);
        idTheoreticalBtn2.setDisable(false);
        idTheoreticalBtn3.setDisable(false);
        idTheoreticalBtn4.setDisable(false);
        idTheoreticalBtn5.setDisable(false);
        idTheoreticalBtn6.setDisable(false);
    }

    void lockFirst(){
        idTheoreticalBox1.setEditable(false);
        idTheoreticalBox2.setDisable(false);
    }

    //------------------------------GLOBAL---------------------------------



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
        if (character.getGender()== Character.Gender.Female){
            raudValue++;
        }
        if (raudValue < 0){ raudValue = 0;}


        idRaud.setText(Integer.toString(raudValue));
        character.setRaud(raudValue);
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


    private int rollDice(int sides){
        return (int)((Math.random()*sides) + 1);
    }


}
