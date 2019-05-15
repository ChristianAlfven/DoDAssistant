package Creator;

import ActiveChars.Party;
import CharacterFile.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterCreation5 implements Initializable {

    Character character;
    private int skillPoints = 100;
    private int alchemy;
    private int combat;
    private int crime;
    private int entertainment;
    private int religion;
    private int riding;
    private int seafaring;
    private int spellcasting;
    private int survival;
    private int trade;
    private int hunting;
    private int jester;
    private int manFarm;
    private int manWar;
    private int manCity;
    private int medicine;
    private int mobility;

    //Geography
    private int geoWestlands;
    private int geoMidlands;
    private int geoEastheim;
    private int geoNhordlands;
    private int geoSoj;
    private int geoUnderworld;

    //Culture
    private int cultWestlands;
    private int cultMidlands;
    private int cultEastheim;
    private int cultElvish;
    private int cultDwarfish;
    private int cultOrcish;

    //Nature
    private int natWestlands;
    private int natEastheim;
    private int natMidlands;
    private int natSoj;
    private int natUnderworld;
    private int natNhordlands;

    //Speech
    private int vrok;
    private int rona;
    private int futhark;
    private int orcish;
    private int eika;

    //Crafting
    private int metal;
    private int stone;
    private int wood;
    private int soft;



    @FXML
    private Button idContinue;
    @FXML
    private Label idRaceLabel2;
    @FXML
    private Label idRaceLabel131;
    @FXML
    private Label idHunting;
    @FXML
    private Label idSeafaring;
    @FXML
    private Label idSurvival;
    @FXML
    private Label idCrime;
    @FXML
    private Label idRaceLabel138;
    @FXML
    private Label idRaceLabel211;
    @FXML
    private TextField idSkillPoints;
    @FXML
    private ProgressBar idSeafaringProgress;
    @FXML
    private Label idRaceLabel13;
    @FXML
    private Label idCombat;
    @FXML
    private Label idEntertainment;
    @FXML
    private Label idJester;
    @FXML
    private Label idSpellcasting;
    @FXML
    private Label idMedicine;
    @FXML
    private Label idMobility;
    @FXML
    private Label idReligion;
    @FXML
    private Label idRiding;
    @FXML
    private ProgressBar idAlchemyProgress;
    @FXML
    private ProgressBar idSpellcastingProgress;
    @FXML
    private ProgressBar idCrimeProgress;
    @FXML
    private Label idAlchemy;
    @FXML
    private Button idSpellcastingBtn;
    @FXML
    private Button idCrimeBtn;
    @FXML
    private ProgressBar idCombatProgress;
    @FXML
    private ProgressBar idMedicineProgress;
    @FXML
    private ProgressBar idEntertainmentProgress;
    @FXML
    private Button idCombatBtn;
    @FXML
    private Button idAlchemyBtn;
    @FXML
    private Button idMedicineBtn;
    @FXML
    private ProgressBar idReligionProgress;
    @FXML
    private ProgressBar idMobilityProgress;
    @FXML
    private ProgressBar idRidingProgress;
    @FXML
    private ProgressBar idHuntingProgress;
    @FXML
    private ProgressBar idJesterProgress;
    @FXML
    private ProgressBar idSurvivalProgress;
    @FXML
    private Button idReligionBtn;
    @FXML
    private Button idEntertainmentBtn;
    @FXML
    private Button idMobilityBtn;
    @FXML
    private Button idRidingBtn;
    @FXML
    private Button idHuntingBtn;
    @FXML
    private Button idJesterBtn;
    @FXML
    private Button idSeafaringBtn;
    @FXML
    private Label idManWar;
    @FXML
    private Label idManFarm;
    @FXML
    private Label idManCity;
    @FXML
    private ProgressBar idManFarmProgress;
    @FXML
    private ProgressBar idManWarProgress;
    @FXML
    private ProgressBar idManCityProgress;
    @FXML
    private Button idSurvivalBtn;
    @FXML
    private Button idManFarmBtn;
    @FXML
    private Button idManWarBtn;
    @FXML
    private Button idManCityBtn;
    @FXML
    private Label idGeoWestlands;
    @FXML
    private ProgressBar idGeoWestlandsProgress;
    @FXML
    private Button idGeoWestlandsBtn;
    @FXML
    private Label idGeoMidlands;
    @FXML
    private ProgressBar idGeoMidlandsProgress;
    @FXML
    private Button idGeoMidlandsBtn;
    @FXML
    private Label idGeoEastheim;
    @FXML
    private Label idGeoNhordlands;
    @FXML
    private Label idGeoSoj;
    @FXML
    private Label idGeoUnderworld;
    @FXML
    private ProgressBar idGeoEastheimProgress;
    @FXML
    private ProgressBar idGeoNhordlandsProgress;
    @FXML
    private ProgressBar idGeoSojProgress;
    @FXML
    private ProgressBar idGeoUnderworldProgress;
    @FXML
    private Button idGeoEastheimBtn;
    @FXML
    private Button idGeoNhordlandsBtn;
    @FXML
    private Button idGeoSojBtn;
    @FXML
    private Button idGeoUnderworldBtn;
    @FXML
    private Label idRaceLabel1382;
    @FXML
    private Label idNatWestlands;
    @FXML
    private Label idNatMidlands;
    @FXML
    private Label idNatEastheim;
    @FXML
    private Label idNatNhordland;
    @FXML
    private Label idNatSoj;
    @FXML
    private Label idNatUnderworld;
    @FXML
    private ProgressBar idNatWestlandsProgress;
    @FXML
    private ProgressBar idNatMidlandsProgress;
    @FXML
    private ProgressBar idNatEastheimProgress;
    @FXML
    private ProgressBar idNatNhordlandProgress;
    @FXML
    private ProgressBar idNatSojProgress;
    @FXML
    private ProgressBar idNatUnderworldProgress;
    @FXML
    private Button idNatWestlandsBtn;
    @FXML
    private Button idNatEastheimBtn;
    @FXML
    private Button idNatSojBtn;
    @FXML
    private Button idNatMidlandsBtn;
    @FXML
    private Button idNatNhordlandBtn;
    @FXML
    private Button idNatUnderworldBtn;
    @FXML
    private Label idCultWestlands;
    @FXML
    private Label idCultMidlands;
    @FXML
    private Label idCultEastheim;
    @FXML
    private Label idCultElvish;
    @FXML
    private Label idCultDwarfish;
    @FXML
    private Label idCultOrcish;
    @FXML
    private ProgressBar idCultWestlandsProgress;
    @FXML
    private ProgressBar idCultEastheimProgress;
    @FXML
    private ProgressBar idCultMidlandsProgress;
    @FXML
    private ProgressBar idCultElvishProgress;
    @FXML
    private ProgressBar idCultDwarfishProgress;
    @FXML
    private ProgressBar idCultOrcishProgress;
    @FXML private Label idCraftingMetal;
    @FXML private Label idCraftingStone;
    @FXML private Label idCraftingWood;
    @FXML private Label idCraftingSoft;
    @FXML private Label idTrade;
    @FXML private ProgressBar idCraftingWoodProgress;
    @FXML private ProgressBar idCraftingStoneProgress;
    @FXML private ProgressBar idCraftingMetalProgress;
    @FXML private ProgressBar idCraftingSoftProgress;
    @FXML private ProgressBar idTradeProgress;
    @FXML private Button idCraftingWoodBtn;
    @FXML private Button idCraftingStoneBtn;
    @FXML private Button idCraftingMetalBtn;
    @FXML private Button idCraftingSoftBtn;
    @FXML private Button idTradeBtn;
    @FXML
    private Label idRaceLabel135;
    @FXML
    private Label idSpeechVrok;
    @FXML
    private Label idSpeechRona;
    @FXML
    private Label idSpeechEika;
    @FXML
    private Label idSpeechFuthark;
    @FXML
    private Label idSpeechOrcish;
    @FXML
    private ProgressBar idSpeechVrokProgress;
    @FXML
    private Button idSpeechVrokBtn;
    @FXML
    private ProgressBar idSpeechRonaProgress;
    @FXML
    private ProgressBar idSpeechEikaProgress;
    @FXML
    private ProgressBar idSpeechFutharkProgress;
    @FXML
    private ProgressBar idSpeechOrcishProgress;
    @FXML
    private Button idSpeechRonaBtn;
    @FXML
    private Button idSpeechEikaBtn;
    @FXML
    private Button idSpeechFutharkBtn;
    @FXML
    private Button idSpeechOrcishBtn;
    @FXML
    private Button idCultWestlandsBtn;
    @FXML
    private Button idCultEastheimBtn;
    @FXML
    private Button idCultDwarfishBtn;
    @FXML
    private Button idCultMidlandsBtn;
    @FXML
    private Button idCultElvishBtn;
    @FXML
    private Button idCultOrcishBtn;

    @FXML
    void addAlchemy(ActionEvent event) {
        if (skillPoints >= (alchemy + 1)){
            alchemy++;
            skillPoints -= alchemy;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCombat(ActionEvent event) {
        if (skillPoints >= (combat + 1)){
            combat++;
            showSkills();
            skillPoints -= combat;
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCraftingMetal(ActionEvent event) {
        if (skillPoints >= (metal + 1)){
            metal++;
            skillPoints -= metal;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCraftingStone(ActionEvent event) {
        if (skillPoints >= (stone + 1)){
            stone++;
            skillPoints -= stone;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCraftingWood(ActionEvent event) {
        if (skillPoints >= (wood + 1)){
            wood++;
            skillPoints -= wood;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCraftingSoft(ActionEvent event) {
        if (skillPoints >= (soft + 1)){
            soft++;
            skillPoints -= soft;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addTrade(ActionEvent event) {
        if (skillPoints >= (trade + 1)){
            trade++;
            skillPoints -= trade;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCrime(ActionEvent event) {
        if (skillPoints >= (crime + 1)){
            crime++;
            skillPoints -= crime;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultDwarfish(ActionEvent event) {
        if (skillPoints >= (cultDwarfish + 1)){
            cultDwarfish++;
            skillPoints -= cultDwarfish;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultEastheim(ActionEvent event) {
        if (skillPoints >= (cultEastheim + 1)){
            cultEastheim++;
            skillPoints -= cultEastheim;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultElvish(ActionEvent event) {
        if (skillPoints >= (cultElvish + 1)){
            cultElvish++;
            skillPoints -= cultElvish;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultMidlands(ActionEvent event) {
        if (skillPoints >= (cultMidlands + 1)){
            cultMidlands++;
            skillPoints -= cultMidlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultOrcish(ActionEvent event) {
        if (skillPoints >= (cultOrcish + 1)){
            cultOrcish++;
            skillPoints -= cultOrcish;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addCultWestlands(ActionEvent event) {
        if (skillPoints >= (cultWestlands + 1)){
            cultWestlands++;
            skillPoints -= cultWestlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addEntertainment(ActionEvent event) {
        if (skillPoints >= (entertainment + 1)){
            entertainment++;
            skillPoints -= entertainment;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoEastheim(ActionEvent event) {
        if (skillPoints >= (geoEastheim + 1)){
            geoEastheim++;
            skillPoints -= geoEastheim;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoMidlands(ActionEvent event) {
        if (skillPoints >= (geoMidlands + 1)){
            geoMidlands++;
            skillPoints -= geoMidlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoNhordlands(ActionEvent event) {
        if (skillPoints >= (geoNhordlands + 1)){
            geoNhordlands++;
            skillPoints -= geoNhordlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoSoj(ActionEvent event) {
        if (skillPoints >= (geoSoj + 1)){
            geoSoj++;
            skillPoints -= geoSoj;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoUnderworld(ActionEvent event) {
        if (skillPoints >= (geoUnderworld + 1)){
            geoUnderworld++;
            skillPoints -= geoUnderworld;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addGeoWestlands(ActionEvent event) {
        if (skillPoints >= (geoWestlands + 1)){
            geoWestlands++;
            skillPoints -= geoWestlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addHunting(ActionEvent event) {
        if (skillPoints >= (hunting + 1)){
            hunting++;
            skillPoints -= hunting;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addJester(ActionEvent event) {
        if (skillPoints >= (jester + 1)){
            jester++;
            skillPoints -= jester;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addManCity(ActionEvent event) {
        if (skillPoints >= (manCity + 1)){
            manCity++;
            skillPoints -= manCity;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addManFarm(ActionEvent event) {
        if (skillPoints >= (manFarm + 1)){
            manFarm++;
            skillPoints -= manFarm;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addManWar(ActionEvent event) {
        if (skillPoints >= (manWar + 1)){
            manWar++;
            skillPoints -= manWar;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addMedicine(ActionEvent event) {
        if (skillPoints >= (medicine + 1)){
            medicine++;
            skillPoints -= medicine;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addMobility(ActionEvent event) {
        if (skillPoints >= (mobility + 1)){
            mobility++;
            skillPoints -= mobility;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatEastheim(ActionEvent event) {
        if (skillPoints >= (natEastheim + 1)){
            natEastheim++;
            skillPoints -= natEastheim;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatMidlands(ActionEvent event) {
        if (skillPoints >= (natMidlands + 1)){
            natMidlands++;
            skillPoints -= natMidlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatNhordlands(ActionEvent event) {
        if (skillPoints >= (natNhordlands + 1)){
            natNhordlands++;
            skillPoints -= natNhordlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatSoj(ActionEvent event) {
        if (skillPoints >= (natSoj + 1)){
            natSoj++;
            skillPoints -= natSoj;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatUnderworld(ActionEvent event) {
        if (skillPoints >= (natUnderworld + 1)){
            natUnderworld++;
            skillPoints -= natUnderworld;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addNatWestlands(ActionEvent event) {
        if (skillPoints >= (natWestlands + 1)){
            natWestlands++;
            skillPoints -= natWestlands;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addReligion(ActionEvent event) {
        if (skillPoints >= (religion + 1)){
            religion++;
            skillPoints -= religion;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addRiding(ActionEvent event) {
        if (skillPoints >= (riding + 1)){
            riding++;
            skillPoints -= riding;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSeafaring(ActionEvent event) {
        if (skillPoints >= (seafaring + 1)){
            seafaring++;
            skillPoints -= seafaring;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpeechEika(ActionEvent event) {
        if (skillPoints >= (eika + 1)){
            eika++;
            skillPoints -= eika;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpeechFuthark(ActionEvent event) {
        if (skillPoints >= (futhark + 1)){
            futhark++;
            skillPoints -= futhark;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpeechOrcish(ActionEvent event) {
        if (skillPoints >= (orcish + 1)){
            orcish++;
            skillPoints -= orcish;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpeechRona(ActionEvent event) {
        if (skillPoints >= (rona + 1)){
            rona++;
            skillPoints -= rona;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpeechVrok(ActionEvent event) {
        if (skillPoints >= (vrok + 1)){
            vrok++;
            skillPoints -= vrok;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSpellcasting(ActionEvent event) {
        if (skillPoints >= (spellcasting + 1)){
            spellcasting++;
            skillPoints -= spellcasting;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void addSurvival(ActionEvent event) {
        if (skillPoints >= (survival + 1)){
            survival++;
            skillPoints -= survival;
            showSkills();
        } else {
            notEnoughSkillPoints();
        }
    }

    @FXML
    void buttonContinue(ActionEvent event) {
        saveSkills();
        try {
            Stage stage = (Stage) idContinue.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../Lobby/GUINewGame.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = Party.getParty().getLastCharacter();
        loadSkills();
        showSkills();

    }

    void showSkills(){
        idSkillPoints.setText(Integer.toString(skillPoints));

        idAlchemy.setText("Alchemy (" + alchemy + "/20)");
        idAlchemyProgress.setProgress((double)alchemy / 20);

        idCombat.setText("Combat (" + combat + "/20)");
        idCombatProgress.setProgress((double)combat / 20);

        idCrime.setText("Combat (" + crime + "/20)");
        idCrimeProgress.setProgress((double)crime / 20);

        idEntertainment.setText("Entertainment (" + entertainment + "/20)");
        idEntertainmentProgress.setProgress((double)entertainment / 20);

        idHunting.setText("Hunting (" + hunting + "/20)");
        idHuntingProgress.setProgress((double)hunting / 20);

        idJester.setText("Jestering (" + jester + "/20)");
        idJesterProgress.setProgress((double)jester / 20);

        idManCity.setText("Man. City (" + manCity + "/20)");
        idManCityProgress.setProgress((double)manCity / 20);

        idManFarm.setText("Man. Farm (" + manFarm + "/20)");
        idManFarmProgress.setProgress((double)manFarm / 20);

        idManWar.setText("Man. City (" + manWar + "/20)");
        idManWarProgress.setProgress((double)manWar / 20);

        idMedicine.setText("Medicine (" + medicine + "/20)");
        idMedicineProgress.setProgress((double)medicine / 20);

        idMobility.setText("Mobility (" + mobility + "/20)");
        idMobilityProgress.setProgress((double)mobility / 20);

        idReligion.setText("Religion (" + religion + "/20)");
        idReligionProgress.setProgress((double)religion / 20);

        idRiding.setText("Riding (" + riding + "/20)");
        idRidingProgress.setProgress((double)riding / 20);

        idSeafaring.setText("Seafaring (" + seafaring + "/20)");
        idSeafaringProgress.setProgress((double)seafaring / 20);

        idSpellcasting.setText("Spellcasting (" + spellcasting + "/20)");
        idSpellcastingProgress.setProgress((double)spellcasting / 20);

        idSurvival.setText("Survival (" + survival + "/20)");
        idSurvivalProgress.setProgress((double)survival / 20);

        idTrade.setText("Trade (" + trade + "/20)");
        idTradeProgress.setProgress((double)trade / 20);

        //Culture

        idCultDwarfish.setText("Dwarfish (" + cultDwarfish + "/20)");
        idCultDwarfishProgress.setProgress((double)cultDwarfish / 20);

        idCultEastheim.setText("Eastheim (" + cultEastheim + "/20)");
        idCultEastheimProgress.setProgress((double)cultEastheim / 20);

        idCultWestlands.setText("Westlands (" + cultWestlands + "/20)");
        idCultWestlandsProgress.setProgress((double)cultWestlands / 20);

        idCultElvish.setText("Elvish (" + cultElvish + "/20)");
        idCultElvishProgress.setProgress((double)cultElvish / 20);

        idCultMidlands.setText("Midlands (" + cultMidlands + "/20)");
        idCultMidlandsProgress.setProgress((double)cultMidlands / 20);

        idCultOrcish.setText("Orcish (" + cultOrcish + "/20)");
        idCultOrcishProgress.setProgress((double)cultOrcish / 20);


        //Nature

        idNatWestlands.setText("Westlands (" + natWestlands + "/20)");
        idNatWestlandsProgress.setProgress((double)natWestlands / 20);

        idNatEastheim.setText("Eastheim (" + natEastheim + "/20)");
        idNatEastheimProgress.setProgress((double)natEastheim / 20);

        idNatSoj.setText("Soj (" + natSoj + "/20)");
        idNatSojProgress.setProgress((double)natSoj / 20);

        idNatNhordland.setText("Nhordlands (" + natNhordlands + "/20)");
        idNatNhordlandProgress.setProgress((double)natNhordlands / 20);

        idNatMidlands.setText("Midlands (" + natMidlands + "/20)");
        idNatMidlandsProgress.setProgress((double)natMidlands / 20);

        idNatUnderworld.setText("Underworld (" + natUnderworld + "/20)");
        idNatUnderworldProgress.setProgress((double)natUnderworld / 20);


        //Geography

        idGeoEastheim.setText("Eastheim (" + geoEastheim + "/20)");
        idGeoEastheimProgress.setProgress((double)geoEastheim / 20);

        idGeoWestlands.setText("Westlands (" + geoWestlands + "/20)");
        idGeoWestlandsProgress.setProgress((double)geoWestlands / 20);

        idGeoSoj.setText("Soj (" + geoSoj + "/20)");
        idGeoSojProgress.setProgress((double)geoSoj / 20);

        idGeoNhordlands.setText("Nhordlands (" + geoNhordlands + "/20)");
        idGeoNhordlandsProgress.setProgress((double)geoNhordlands / 20);

        idGeoMidlands.setText("Midlands (" + geoMidlands + "/20)");
        idGeoMidlandsProgress.setProgress((double)geoMidlands / 20);

        idGeoUnderworld.setText("Underworld (" + geoUnderworld + "/20)");
        idGeoUnderworldProgress.setProgress((double)geoUnderworld / 20);

        //Speech

        idSpeechVrok.setText("Vrok (" + vrok + "/20)");
        idSpeechVrokProgress.setProgress((double)vrok / 20);

        idSpeechRona.setText("Rona (" + rona + "/20)");
        idSpeechRonaProgress.setProgress((double)rona / 20);

        idSpeechFuthark.setText("Futhark (" + futhark + "/20)");
        idSpeechFutharkProgress.setProgress((double)futhark / 20);

        idSpeechEika.setText("Eika (" + eika + "/20)");
        idSpeechEikaProgress.setProgress((double)eika / 20);

        idSpeechOrcish.setText("Orcish (" + orcish + "/20)");
        idCultOrcishProgress.setProgress((double)orcish / 20);


        //Crafting

        idCraftingMetal.setText("Metal (" + metal + "/20)");
        idCraftingMetalProgress.setProgress((double)metal / 20);

        idCraftingSoft.setText("Soft (" + soft + "/20)");
        idCraftingSoftProgress.setProgress((double)soft / 20);

        idCraftingWood.setText("Wood (" + wood + "/20)");
        idCraftingWoodProgress.setProgress((double)wood / 20);

        idCraftingStone.setText("Stone (" + stone + "/20)");
        idCraftingStoneProgress.setProgress((double)stone / 20);

    }

    void loadSkills(){
        alchemy = character.getSkillset().getAlchemy().getSkillLevel();
        combat = character.getSkillset().getCombat().getSkillLevel();
        metal = character.getSkillset().getCrafting().getMetal();
        soft = character.getSkillset().getCrafting().getSoft();
        stone = character.getSkillset().getCrafting().getStone();
        wood = character.getSkillset().getCrafting().getWood();
        crime = character.getSkillset().getCrime().getSkillLevel();
        cultDwarfish = character.getSkillset().getCulture().getDwarfish();
        cultEastheim = character.getSkillset().getCulture().getEastheim();
        cultElvish = character.getSkillset().getCulture().getElvish();
        cultMidlands = character.getSkillset().getCulture().getMidlands();
        cultWestlands = character.getSkillset().getCulture().getWestlands();
        cultOrcish = character.getSkillset().getCulture().getOrcish();
        entertainment = character.getSkillset().getEntertainment().getSkillLevel();
        geoEastheim = character.getSkillset().getGeography().getEastheim();
        geoMidlands = character.getSkillset().getGeography().getMidland();
        geoNhordlands = character.getSkillset().getGeography().getNhoordland();
        geoSoj = character.getSkillset().getGeography().getSoj();
        geoUnderworld = character.getSkillset().getGeography().getUnderworld();
        geoWestlands = character.getSkillset().getGeography().getWestland();
        hunting = character.getSkillset().getHunting().getSkillLevel();
        jester = character.getSkillset().getJester().getSkillLevel();
        manCity = character.getSkillset().getManagement().getCity();
        manFarm = character.getSkillset().getManagement().getFarm();
        manWar = character.getSkillset().getManagement().getWar();
        medicine = character.getSkillset().getMedicine().getSkillLevel();
        mobility = character.getSkillset().getMobility().getSkillLevel();
        natEastheim = character.getSkillset().getNature().getEastheim();
        natMidlands = character.getSkillset().getNature().getMidlands();
        natNhordlands = character.getSkillset().getNature().getNhordlands();
        natSoj = character.getSkillset().getNature().getSoj();
        natUnderworld = character.getSkillset().getNature().getUnderworld();
        natWestlands = character.getSkillset().getNature().getWestlands();
        religion = character.getSkillset().getReligion().getMain();
        riding = character.getSkillset().getRiding().getSkillLevel();
        seafaring = character.getSkillset().getSeafaring().getSkillLevel();
        spellcasting = character.getSkillset().getSpellcasting().getSkillLevel();
        survival = character.getSkillset().getSurvival().getSkillLevel();
        trade = character.getSkillset().getTrade().getSkillLevel();
        vrok = character.getSkillset().getSpeech().getVrok();
        rona = character.getSkillset().getSpeech().getRona();
        futhark = character.getSkillset().getSpeech().getFuthark();
        eika = character.getSkillset().getSpeech().getEika();
        orcish = character.getSkillset().getSpeech().getOrcish();

    }

    void notEnoughSkillPoints(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Warning");
        errorAlert.setContentText("Not enough Skill Points");
        errorAlert.showAndWait();
    }

    void saveSkills(){
        character.getSkillset().getAlchemy().setSkillLevel(alchemy);
        character.getSkillset().getReligion().setMainReligion(religion);
        character.getSkillset().getCombat().setSkillLevel(combat);
        character.getSkillset().getCrime().setSkillLevel(crime);
        character.getSkillset().getEntertainment().setSkillLevel(entertainment);
        character.getSkillset().getHunting().setSkillLevel(hunting);
        character.getSkillset().getJester().setSkillLevel(jester);
        character.getSkillset().getMedicine().setSkillLevel(medicine);
        character.getSkillset().getMobility().setSkillLevel(mobility);
        character.getSkillset().getRiding().setSkillLevel(riding);
        character.getSkillset().getSeafaring().setSkillLevel(seafaring);
        character.getSkillset().getSpellcasting().setSkillLevel(spellcasting);
        character.getSkillset().getSurvival().setSkillLevel(survival);
        character.getSkillset().getTrade().setSkillLevel(trade);
        character.getSkillset().getManagement().setFarm(manFarm);
        character.getSkillset().getManagement().setCity(manCity);
        character.getSkillset().getManagement().setWar(manWar);

        character.getSkillset().getNature().setUnderworld(natUnderworld);
        character.getSkillset().getNature().setNhordlands(natNhordlands);
        character.getSkillset().getNature().setWestlands(natWestlands);
        character.getSkillset().getNature().setSoj(natSoj);
        character.getSkillset().getNature().setMidlands(natMidlands);
        character.getSkillset().getNature().setEastheim(natEastheim);

        character.getSkillset().getSpeech().setOrcish(orcish);
        character.getSkillset().getSpeech().setFuthark(futhark);
        character.getSkillset().getSpeech().setEika(eika);
        character.getSkillset().getSpeech().setRona(rona);
        character.getSkillset().getSpeech().setVrok(vrok);

        character.getSkillset().getGeography().setUnderworld(geoUnderworld);
        character.getSkillset().getGeography().setNhoordland(geoNhordlands);
        character.getSkillset().getGeography().setSoj(geoSoj);
        character.getSkillset().getGeography().setWestland(geoWestlands);
        character.getSkillset().getGeography().setEastheim(geoEastheim);
        character.getSkillset().getGeography().setMidland(geoMidlands);

        character.getSkillset().getCrafting().setSoft(soft);
        character.getSkillset().getCrafting().setWood(wood);
        character.getSkillset().getCrafting().setMetal(metal);
        character.getSkillset().getCrafting().setStone(stone);

        character.getSkillset().getCulture().setMidlands(cultMidlands);
        character.getSkillset().getCulture().setEastheim(cultEastheim);
        character.getSkillset().getCulture().setElvish(cultElvish);
        character.getSkillset().getCulture().setWestlands(cultWestlands);
        character.getSkillset().getCulture().setDwarfish(cultDwarfish);
        character.getSkillset().getCulture().setOrcish(cultOrcish);

    }
}
