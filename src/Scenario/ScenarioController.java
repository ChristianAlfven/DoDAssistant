package Scenario;
import ActiveChars.Party;
import CharacterFile.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ScenarioController implements Initializable {

    private Party party = Party.getParty();
    private int requiredValue;

    private int[] playerValues;
    private int[] rollValues;

    private boolean[] active;


    @FXML
    private TextArea idResultsTextArea;

    @FXML
    private Label idBackgroundLabel;

    @FXML
    private Button idRoll;

    @FXML
    private ToggleButton idScholar;

    @FXML
    private ToggleGroup Profession;

    @FXML
    private RadioButton idSelectSkills;

    @FXML
    private ToggleGroup Environment;

    @FXML
    private RadioButton idSelectTraits;

    @FXML
    private Button idBack;

    @FXML
    private CheckBox idCheckbox1;

    @FXML
    private ChoiceBox<String> idSkillChoice;

    @FXML
    private ChoiceBox<String> idTraitChoice;

    @FXML
    private CheckBox idCheckbox2;

    @FXML
    private CheckBox idCheckbox3;

    @FXML
    private CheckBox idCheckbox4;

    @FXML
    private CheckBox idCheckbox5;

    @FXML
    private CheckBox idCheckbox6;

    @FXML
    private CheckBox idCheckbox7;

    @FXML
    private CheckBox idCheckbox8;

    @FXML
    private Label idBackgroundLabel1;

    @FXML
    private TextField idRequiredValueText;

    @FXML
    void buttonBack(ActionEvent event) {

    }

    @FXML
    void buttonRoll(ActionEvent event) {

        try {
            setActive();
            if (idSelectSkills.isSelected()){

                rollSkills(idSkillChoice.getSelectionModel().getSelectedItem());

            } else if (idSelectTraits.isSelected()){

                requiredValue = Integer.parseInt(idRequiredValueText.getText());
                rollTraits(idTraitChoice.getSelectionModel().getSelectedItem());

            } else {
                System.out.println("Please select either a skill or a trait.");
            }


        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Please enter a required value");
        }
    }

    @FXML
    void selectSkills(ActionEvent event) {
        idSkillChoice.setDisable(false);
        idTraitChoice.setDisable(true);
    }

    @FXML
    void selectTraits(ActionEvent event) {
        idSkillChoice.setDisable(true);
        idTraitChoice.setDisable(false);
    }

    void setActive(){
        switch (party.getArray()){
            case 8:
                if (idCheckbox8.isSelected()) {
                    active[7] = true;
                }else {
                    active[7] = false;
                }
            case 7:
                if (idCheckbox7.isSelected()) {
                    active[6] = true;
                }else {
                    active[6] = false;
                }
            case 6:
                if (idCheckbox6.isSelected()) {
                    active[5] = true;
                }else {
                    active[5] = false;
                }
            case 5:
                if (idCheckbox5.isSelected()) {
                    active[4] = true;
                }else {
                    active[4] = false;
                }
            case 4:
                if (idCheckbox4.isSelected()) {
                    active[3] = true;
                }else {
                    active[3] = false;
                }
            case 3:
                if (idCheckbox3.isSelected()) {
                    active[2] = true;
                }else {
                    active[2] = false;
                }
            case 2:
                if (idCheckbox2.isSelected()) {
                    active[1] = true;
                }else {
                    active[1] = false;
                }
            default:
                if (idCheckbox1.isSelected()) {
                    active[0] = true;
                }else {
                    active[0] = false;
                }
                break;

        }
    }

    void rollSkills(String skillName){

        switch (skillName){
            case "Alchemy":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getAlchemy().getSkillLevel();
                }
                break;
            case "Combat":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCombat().getSkillLevel();
                }
                break;
            case "Crime":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCrime().getSkillLevel();
                }
                break;
            case "Entertainment":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getEntertainment().getSkillLevel();
                }
                break;
            case "Hunting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getHunting().getSkillLevel();
                }
                break;
            case "Jester":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getJester().getSkillLevel();
                }
                break;
            case "Medicine":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getMedicine().getSkillLevel();
                }
                break;
            case "Mobility":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getMobility().getSkillLevel();
                }
                break;
            case "Religion":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getReligion().getMainReligion();
                }
                break;
            case "Riding":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getRiding().getSkillLevel();
                }
                break;
            case "Seafaring":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSeafaring().getSkillLevel();
                }
                break;
            case "Spellcasting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpellcasting().getSkillLevel();
                }
                break;
            case "Survival":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSurvival().getSkillLevel();
                }
                break;
            case "Trade":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getTrade().getSkillLevel();
                }
                break;

            case "Metal Crafting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCrafting().getMetal();
                }
                break;
            case "Wood Crafting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCrafting().getWood();
                }
                break;
            case "Stone Crafting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCrafting().getStone();
                }
                break;
            case "Soft Crafting":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCrafting().getSoft();
                }
                break;

            case "Management: Farm":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getManagement().getFarm();
                }
                break;
            case "Management: City":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getManagement().getCity();
                }
                break;
            case "Management: War":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getManagement().getWar();
                }
                break;

            case "Culture: Westlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getWestlands();
                }
                break;
            case "Culture: Eastheim":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getEastheim();
                }
                break;
            case "Culture: Midlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getMidlands();
                }
                break;
            case "Culture: Elvish":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getElvish();
                }
                break;
            case "Culture: Dwarfish":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getDwarfish();
                }
                break;
            case "Culture: Orcish":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getCulture().getOrcish();
                }
                break;

            case "Speech: Vrok":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpeech().getVrok();
                }
                break;
            case "Speech: Rona":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpeech().getRona();
                }
                break;
            case "Speech: Eika":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpeech().getEika();
                }
                break;
            case "Speech: Futhark":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpeech().getFuthark();
                }
                break;
            case "Speech: Orcish":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getSpeech().getOrcish();
                }
                break;

            case "Geography: Westlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getWestland();
                }
                break;
            case "Geography: Eastheim":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getEastheim();
                }
                break;
            case "Geography: Midlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getMidland();
                }
                break;
            case "Geography: Nhordlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getNhoordland();
                }
                break;
            case "Geography: Soj":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getSoj();
                }
                break;
            case "Geography: Underworld":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getGeography().getUnderworld();
                }
                break;

            case "Nature: Westlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getWestlands();
                }
                break;
            case "Nature: Eastheim":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getEastheim();
                }
                break;
            case "Nature: Midlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getMidlands();
                }
                break;
            case "Nature: Soj":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getSoj();
                }
                break;
            case "Nature: Nhordlands":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getNhordlands();
                }
                break;
            case "Nature: Underworld":
                for (int i = 0; i < party.getArray(); i++){
                    playerValues[i] = party.getCharacter(i).getSkillset().getNature().getUnderworld();
                }
                break;
        }

        for (int i = 0; i < party.getArray(); i++) {
            if (active[i]) {
                rollValues[i] = rollDice(20);

                if (rollValues[i] <= playerValues[i]) {
                    idResultsTextArea.appendText(party.getCharacter(i).toString() + ": PASSED (" + rollValues[i] + " / " + playerValues[i] + ")\n");
                } else {
                    idResultsTextArea.appendText(party.getCharacter(i).toString() + ": FAILED (" + rollValues[i] + " / " + playerValues[i] + ")\n");
                }
            }
        }
    }

    void rollTraits(String traitName){

        switch (traitName){
            case "Strength":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Strength) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Strength) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Strength) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Physique":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Physique) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Physique) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Physique) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Agility":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Agility) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Agility) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Agility) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Spirituality":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Spirituality) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Spirituality) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Spirituality) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Intelligence":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Intelligence) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Intelligence) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Intelligence) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Psyche":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Psyche) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Psyche) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Psyche) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;
            case "Charisma":
                for (int i = 0; i < party.getArray(); i++){
                    if (party.getCharacter(i).getPositiveTrait1() == Character.SpecialTrait.Charisma) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getPositiveTrait2() == Character.SpecialTrait.Charisma) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else if (party.getCharacter(i).getNegativeTrait() == Character.SpecialTrait.Charisma) {
                        playerValues[i] = party.getCharacter(i).getPosTrait1Level();
                    } else {
                        playerValues[i] = 0;
                    }
                }
                break;

        }

        for (int i = 0; i < party.getArray(); i++) {
            if (active[i]) {
                rollValues[i] = rollDice(20);
                playerValues[i] += requiredValue;

                if (rollValues[i] <= (playerValues[i])) {
                    idResultsTextArea.appendText(party.getCharacter(i).toString() + ": PASSED (" + rollValues[i] + " / " + playerValues[i] + ") \n");
                } else {
                    idResultsTextArea.appendText(party.getCharacter(i).toString() + ": FAILED (" + rollValues[i] + " / " + playerValues[i] + ") \n");
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerValues = new int[party.getArray()];
        rollValues = new int[party.getArray()];
        active = new boolean[party.getArray()];
        String name;

        switch (party.getArray()){
            case 8:
                idCheckbox8.setDisable(false);
                idCheckbox8.setOpacity(100);
                idCheckbox8.setText(party.getCharacter(7).toString());
            case 7:
                idCheckbox7.setDisable(false);
                idCheckbox7.setOpacity(100);
                idCheckbox7.setText(party.getCharacter(6).toString());
            case 6:
                idCheckbox6.setDisable(false);
                idCheckbox6.setOpacity(100);
                idCheckbox6.setText(party.getCharacter(5).toString());
            case 5:
                idCheckbox5.setDisable(false);
                idCheckbox5.setOpacity(100);
                idCheckbox5.setText(party.getCharacter(4).toString());
            case 4:
                idCheckbox4.setDisable(false);
                idCheckbox4.setOpacity(100);
                idCheckbox4.setText(party.getCharacter(3).toString());
            case 3:
                idCheckbox3.setDisable(false);
                idCheckbox3.setOpacity(100);
                idCheckbox3.setText(party.getCharacter(2).toString());
            case 2:
                idCheckbox2.setDisable(false);
                idCheckbox2.setOpacity(100);
                idCheckbox2.setText(party.getCharacter(1).toString());
            case 1:
                idCheckbox1.setDisable(false);
                idCheckbox1.setOpacity(100);
                idCheckbox1.setText(party.getCharacter(0).toString());
        }

        ObservableList<String> skillChoices = FXCollections.observableArrayList(
                "Alchemy", "Combat", "Crime", "Entertainment", "Hunting", "Jester", "Medicine", "Mobility",
                "Religion", "Riding", "Seafaring", "Spellcasting", "Survival", "Trade", "Management: Farm",
                "Management: City", "Management War", "Metal Crafting", "Wood Crafting", "Stone Crafting", "Soft Crafting",
                "Culture: Westlands", "Culture: Eastheim", "Culture: Midlands", "Culture: Elvish", "Culture: Dwarfish", "Culture: Orcish",
                "Speech: Vrok", "Speech: Rona", "Speech: Eika", "Speech: Futhark", "Speech: Orcish",
                "Geography: Westlands", "Geography: Eastheim", "Geography: Midlands", "Geography: Soj", "Geography: Nhordlands", "Geography: Underworld",
                "Nature: Westlands", "Nature: Eastheim", "Nature: Midlands", "Nature: Soj", "Nature: Nhordlands", "Nature: Underworld");

        idSkillChoice.setItems(skillChoices);

        ObservableList<String> traitChoices = FXCollections.observableArrayList(
                "Strength", "Agility", "Physique", "Intelligence", "Spirituality", "Psyche", "Charisma");

        idTraitChoice.setItems(traitChoices);

        idSkillChoice.setDisable(true);
        idTraitChoice.setDisable(true);


    }
    private int rollDice(int sides){
        return (int)((Math.random()*sides) + 1);
    }
}
