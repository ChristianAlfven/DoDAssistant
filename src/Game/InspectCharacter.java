package Game;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Skillset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InspectCharacter implements Initializable {
    Character character;
    Skillset skillset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        character = Party.getParty().getCharacter(Party.getParty().getIndex());
        skillset = character.getSkillset();

        //TOP LEFT
        idCharacter.setText(String.valueOf(character.toString()));
        idGenderText.setText(String.valueOf(character.getGender()));
        idSubRaceText.setText(String.valueOf(character.getSubrace()));
//        idReligion.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getReligion));
        idEnvironmentText.setText(String.valueOf(character.getEnvironment()));
        idWeaponHand.setText(String.valueOf(character.getWeaponHand()));
        idAgeText.setText(String.valueOf(character.getAge()));
        idHeightText.setText(String.valueOf(character.getHeight()));
        idWeightText.setText(String.valueOf(character.getWeight()));
//        idMovement.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getMovement()));
        idPointsTotalText.setText(String.valueOf(character.getCombatPoints()));

        //MIDDLE
        idRaud.setText(String.valueOf(character.getRaud()));

        //TOP RIGHT
        idSpcTraitPlus1.setText(String.valueOf(character.getPositiveTrait1()));
        idSpcTraitPlus1Value.setText(String.valueOf(character.getPosTrait1Level()));
        idSpcTraitPlus2.setText(String.valueOf(character.getPositiveTrait2()));
        idSpcTraitPlus2Value.setText(String.valueOf(character.getPosTrait2Level()));
        idSpcTraitMinus.setText(String.valueOf(character.getNegativeTrait()));
        idSpcTraitMinusValue.setText(String.valueOf(character.getNegTraitLevel()));
        idBackground.setText(String.valueOf(character.getBackground()));

        //SKILLS
        idSpellCasting.setText(String.valueOf(skillset.getSpellcasting().getSkillLevel()));
        idAlchemy.setText(String.valueOf(skillset.getAlchemy().getSkillLevel()));
        idGeographySub.setText(skillset.getGeography().getHomeland());
        idGeography.setText(String.valueOf(skillset.getGeography().getSkillLevel()));
        idJester.setText(String.valueOf(skillset.getJester().getSkillLevel()));
        idTrade.setText(String.valueOf(skillset.getTrade().getSkillLevel()));
        idCraftingMetal.setText(String.valueOf(skillset.getCrafting().getMetal()));
        idCraftingSoft.setText(String.valueOf(skillset.getCrafting().getSoft()));
        idCraftingStone.setText(String.valueOf(skillset.getCrafting().getStone()));
        idCraftingWood.setText(String.valueOf(skillset.getCrafting().getWood()));
        idHunting.setText(String.valueOf(skillset.getHunting().getSkillLevel()));
        idCultureSub.setText(skillset.getCulture().getHomeland());
        idCulture.setText(String.valueOf(skillset.getCulture().getSkillLevel()));
        idMedicine.setText(String.valueOf(skillset.getMedicine().getSkillLevel()));
        idCrime.setText(String.valueOf(skillset.getCrime().getSkillLevel()));
//        RELIGION
        idRiding.setText(String.valueOf(skillset.getRiding().getSkillLevel()));
        idMobility.setText(String.valueOf(skillset.getMobility().getSkillLevel()));
        idSeafaring.setText(String.valueOf(skillset.getSeafaring().getSkillLevel()));
        idManagementFarm.setText(String.valueOf(skillset.getManagement().getFarm()));
        idManagementCity.setText(String.valueOf(skillset.getManagement().getCity()));
        idManagementWar.setText(String.valueOf(skillset.getManagement().getWar()));
        idCombat.setText(String.valueOf(skillset.getCombat().getSkillLevel()));
        idSpeechSub.setText(skillset.getSpeech().getMotherTongue(character));
        idSpeech.setText(String.valueOf(skillset.getSpeech().getSkillLevel()));
        idEntertainment.setText(String.valueOf(skillset.getEntertainment().getSkillLevel()));
        idNatureSub.setText(skillset.getNature().getHomeland());
        idNature.setText(String.valueOf(skillset.getNature().getSkillLevel()));
        idSurvival.setText(String.valueOf(skillset.getSurvival().getSkillLevel()));
    }

    @FXML
    private TextField idGenderText;

    @FXML
    private TextField idReligionSub;

    @FXML
    private TextField idCombat;

    @FXML
    private TextField idCulture;

    @FXML
    private TextField idReligionSub1;

    @FXML
    private TextField idCultureSub;

    @FXML
    private TextField idAlchemy;

    @FXML
    private TextField idManagementCity;

    @FXML
    private TextField idSpcTraitMinus;

    @FXML
    private TextField idSpeech;

    @FXML
    private TextField idRiding;

    @FXML
    private TextField idEnvironmentText;

    @FXML
    private TextField idSpeechSub;

    @FXML
    private TextField idCraftingStone;

    @FXML
    private TextField idSpcTraitMinusValue;

    @FXML
    private TextField idSpcTraitPlus2Value;

    @FXML
    private TextField idEntertainment;

    @FXML
    private TextArea idBackground;

    @FXML
    private TextField idHeightText;

    @FXML
    private TextField idSurvival;

    @FXML
    private TextField idManagementWar;

    @FXML
    private TextField idSpellCasting;

    @FXML
    private TextField idSeafaring;

    @FXML
    private TextField idGeographySub;

    @FXML
    private TextField idAgeText;

    @FXML
    private TextField idManagementFarm;

    @FXML
    private TextField idPointsTotalText;

    @FXML
    private TextField idJester;

    @FXML
    private TextField idNature;

    @FXML
    private TextField idCraftingSoft;

    @FXML
    private TextField idCraftingWood;

    @FXML
    private TextField idCharacter;

    @FXML
    private TextField idWeightText;

    @FXML
    private TextField idCraftingMetal;

    @FXML
    private TextField idHunting;

    @FXML
    private Button idClose;

    @FXML
    private TextField idWeaponHand;

    @FXML
    private TextField idSubRaceText;

    @FXML
    private TextField idNatureSub;

    @FXML
    private TextField idRaud;

    @FXML
    private TextField idMovement;

    @FXML
    private TextField idTrade;

    @FXML
    private TextField idCrime;

    @FXML
    private TextField idSpcTraitPlus2;

    @FXML
    private TextField idMedicine;

    @FXML
    private TextField idSpcTraitPlus1;

    @FXML
    private TextField idSpcTraitPlus1Value;

    @FXML
    private TextField idMobility;

    @FXML
    private TextField idGeography;

    @FXML
    private TextField idReligion;
    @FXML
    void buttonClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
