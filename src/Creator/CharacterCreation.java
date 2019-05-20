package Creator;

import ActiveChars.Party;
import CharacterFile.Armor;
import CharacterFile.Character;
import CharacterFile.Health;
import Database.DB_Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import static CharacterFile.Character.Nationality.*;

public class CharacterCreation implements Initializable {

//    Image image = new Image("sample/sample.fxml");

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Label idNameLabel;
    @FXML private TextField idNamebox;
    @FXML private Label idRaceLabel;
    @FXML private Label idSubraceLabel;
    @FXML private Label idProfessionLabel;
    @FXML private Label idHeightLabel;
    @FXML private Label idWeightLabel;
    @FXML private TextField idAgeBox;
    @FXML private TextField idHeightBox;
    @FXML private TextArea idBackgroundBox;
    @FXML private Label idBackgroundLabel;
    @FXML private Button idContinue;
    @FXML private Label idAgeLabel;
    @FXML private TextField idWeightBox;
    @FXML private ToggleButton idWarrior;
    @FXML private ToggleGroup Profession;
    @FXML private ToggleButton idScholar;
    @FXML private ToggleButton idBard;
    @FXML private ToggleButton idPriest;
    @FXML private ToggleButton idRogue;
    @FXML private ToggleButton idMage;
    @FXML private ToggleButton idPeasant;
    @FXML private ToggleButton idHuman;
    @FXML private ToggleGroup Race;
    @FXML private ToggleButton idHalfBlood;
    @FXML private ToggleButton idElf;
    @FXML private ToggleButton idDwarf;
    @FXML private ToggleButton idSubrace1;
    @FXML private ToggleGroup Subrace;
    @FXML private ToggleButton idSubrace2;
    @FXML private ToggleButton idSubrace3;
    @FXML private RadioButton idNature;
    @FXML private ToggleGroup Environment;
    @FXML private RadioButton idAcademic;
    @FXML private RadioButton idCity;
    @FXML private RadioButton idCountry;
    @FXML private RadioButton idMale;
    @FXML private ToggleGroup Gender;
    @FXML private RadioButton idFemale;
    @FXML private RadioButton idGerbanis;
    @FXML private RadioButton idNidendomen;
    @FXML private RadioButton idOstroseden;
    @FXML private RadioButton idThuldom;
    @FXML private RadioButton idHamingjes;
    @FXML private ToggleGroup Religion;
    @FXML private TableView<Character> idCharacterTable;
    @FXML private Button idBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Stage stage;
        Parent root;
        Scene scene;
        character = new Character();
    }


    enum Profession{Warrior, Peasant, Mage, Rogue, Priest, Bard, Scholar}
    enum Gender{Male, Female}
    enum Race{Human, Elf, Dwarf, HalfBlood}
    enum SubRace{Stormlander, Midlander, Virann, Illmalaina, Korpikalla, Buratja, Borjornikka, Zvorda, HalfOrc, HalfElf}
    enum WeaponHand{Right, Left, Both}
    enum Environment{Nature, Country, City, Academic}
    enum Nationality{Human, Orc, Elf}

    Character character;
    String name;
    Health health;
    Armor armor;
    //Skillset skillset;
    //SpecialTrait[] specialTraits;
    //Inventory inventory;
    Profession profession;
    Gender gender;
    Race race;
    Nationality nationality;
    Environment environment;
    SubRace subrace;
    WeaponHand weaponHand;
    int height;
    int weight;
    int age;
    int combatPoints;
    String background;
    String Characteristics;
    int raud;
    int totalExp;
    int unusedExp;
    String male;
    Scanner Scan = new Scanner(System.in);




    @FXML
    void buttonBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonContinue(ActionEvent event) throws IOException {

        if ((idNamebox.getText()!=null)&&(idAgeBox.getText()!=null)
                &&(idBackgroundBox.getText()!=null)&&(idHeightBox.getText()!=null)
                &&(idWeightBox.getText()!=null)&&(character.getProfession()!=null)
                &&(character.getRace()!=null)&&(character.getSubrace()!=null)
                &&(idNature.isSelected()||idCity.isSelected()||idCountry.isSelected()||idAcademic.isSelected())
                &&(idMale.isSelected()||idFemale.isSelected())&&(idGerbanis.isSelected() || idOstroseden.isSelected()
                || idThuldom.isSelected() || idNidendomen.isSelected() || idHamingjes.isSelected()))
        {
            try {
                character.setName(idNamebox.getText());
                character.setBackground(idBackgroundBox.getText());
                character.setHeight(Integer.parseInt(idHeightBox.getText()));
                character.setWeight(Integer.parseInt(idWeightBox.getText()));
                character.setAge(Integer.parseInt(idAgeBox.getText()));
                character.constructArmor();

                if (idMale.isSelected()) {
                    character.setGender(Character.Gender.Male);
                } else if (idFemale.isSelected()) {
                    character.setGender(Character.Gender.Female);
                }

                if (idCountry.isSelected()) {
                    character.setEnvironment(Character.Environment.Country);
                } else if (idCity.isSelected()) {
                    character.setEnvironment(Character.Environment.City);
                } else if (idAcademic.isSelected()) {
                    character.setEnvironment(Character.Environment.Academic);
                } else if (idNature.isSelected()) {
                    character.setEnvironment(Character.Environment.Nature);
                }

                if (idGerbanis.isSelected()) {
                    character.getSkillset().getReligion().chooseMain(1);
                } else if (idOstroseden.isSelected()){
                    character.getSkillset().getReligion().chooseMain(2);
                } else if (idNidendomen.isSelected()){
                    character.getSkillset().getReligion().chooseMain(3);
                } else if (idHamingjes.isSelected()){
                    character.getSkillset().getReligion().chooseMain(4);
                } else if (idThuldom.isSelected()){
                    character.getSkillset().getReligion().chooseMain(5);
                } else {
                    character.getSkillset().getReligion().chooseMain(1);
                }

                System.out.println(character.debug());
                character.setDbCharId(getNextDbCharId());

                Party.getParty().addCharacter(character);

            }catch(Exception exception){
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setHeaderText("Error");
                errorAlert.setContentText("Please choose correct attributes");
                errorAlert.showAndWait();
            }

            Stage stage = (Stage) idContinue.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("GUICharacterCreation2.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Please choose all attributes");
            errorAlert.showAndWait();

        }
    }

    // RACE METHODS
    public void setHuman(ActionEvent event){
        character.setRace(Character.Race.Human);
        idSubraceLabel.setDisable(false);
        idSubrace1.setDisable(false);
        idSubrace1.setSelected(false);
        idSubrace2.setDisable(false);
        idSubrace2.setSelected(false);
        idSubrace3.setSelected(false);
        idSubrace3.setDisable(false);
        idSubrace1.setText("Stormlander");
        idSubrace2.setText("Midlander");
        idSubrace3.setText("Virann");
        character.setSubrace(null);
        character.setNationality(null);
        character.setRegion(null);
        idSubraceLabel.setText("Subrace");
    }
    public void setDwarf(ActionEvent event){
        character.setRace(Character.Race.Dwarf);
        idSubraceLabel.setDisable(false);
        idSubrace1.setDisable(false);
        idSubrace1.setSelected(false);
        idSubrace2.setDisable(false);
        idSubrace2.setSelected(false);
        idSubrace3.setSelected(false);
        idSubrace3.setDisable(false);
        idSubrace1.setText("Borjornikka");
        idSubrace2.setText("Zvorda");
        idSubrace3.setDisable(false);
        idSubrace3.setText("Buratja");
        character.setSubrace(null);
        idSubraceLabel.setText("Subrace");
        character.setNationality(null);
        character.setRegion(null);
    }
    public void setElf(ActionEvent event){
        character.setRace(Character.Race.Elf);
        idSubraceLabel.setDisable(false);
        idSubrace1.setDisable(false);
        idSubrace1.setSelected(false);
        idSubrace2.setDisable(false);
        idSubrace2.setSelected(false);
        idSubrace3.setSelected(false);
        idSubrace3.setDisable(true);
        idSubrace1.setText("Korpikalla");
        idSubrace2.setText("Illmalaina");
        idSubrace3.setText("");
        character.setSubrace(null);
        character.setNationality(null);
        character.setRegion(null);
        idSubraceLabel.setText("Subrace");
    }
    public void setHalfBlood(ActionEvent event){
        character.setRace(Character.Race.HalfBlood);
        idSubraceLabel.setDisable(false);
        idSubrace1.setDisable(false);
        idSubrace1.setSelected(false);
        idSubrace2.setDisable(false);
        idSubrace2.setSelected(false);
        idSubrace3.setSelected(false);
        idSubrace3.setDisable(true);
        idSubrace1.setText("Half-Elf");
        idSubrace2.setText("Half-Orc");
        idSubrace3.setDisable(true);
        idSubrace3.setText("");
        character.setSubrace(null);
        character.setNationality(null);
        character.setRegion(null);
        idSubraceLabel.setText("Subrace");
    }

    // SUBRACE METHODS
    public void setSubrace1(ActionEvent event) {
        if (character.getRace() == Character.Race.Human) {              //HUMAN STORMLANDER
            character.setSubrace(Character.SubRace.Stormlander);
            character.setNationality(Human);
            character.setRegion(Character.Region.Westlands);

        } else if (character.getRace() == Character.Race.Elf) {         //ELF KORPIKALLA
            character.setSubrace(Character.SubRace.Korpikalla);
            character.setNationality(Elf);
            character.setRegion(Character.Region.Soj);

        } else if (character.getRace() == Character.Race.Dwarf) {       //DWARF BORJORNIKKA
            character.setSubrace(Character.SubRace.Borjornikka);
            character.setNationality(Dwarf);
            character.setRegion(Character.Region.Underworld);

        } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == null)) {
            character.setSubrace(Character.SubRace.HalfElf);            //HALFBLOOD HALF ELF
            idSubrace1.setSelected(false);
            idSubrace3.setDisable(true);
            idSubrace3.setText("");
            idSubrace1.setText("Human");
            idSubrace2.setText("Elf");
            idSubraceLabel.setText("Nationality");

        } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf)&& (character.getNationality() == null)) {
            character.setNationality(Human);                            //HALF ELF - HUMAN
            idSubrace2.setSelected(false);
            idSubrace3.setDisable(false);
            idSubrace3.setText("Eastheim");
            idSubrace1.setText("Westlands");
            idSubrace2.setText("Midlands");
            idSubraceLabel.setText("Region");

        } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc) && (character.getNationality() == null)) {
            character.setNationality(Human);                            //HALF ORC- HUMAN
            idSubrace2.setSelected(false);
            idSubrace3.setDisable(false);
            idSubrace3.setText("Eastheim");
            idSubrace1.setText("Westlands");
            idSubrace2.setText("Midlands");
            idSubraceLabel.setText("Region");

                                                                        //REGION WESTLANDS
        } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc) && (character.getNationality() == Character.Nationality.Human)) {
            character.setRegion(Character.Region.Westlands);
            //System.out.println("Set Region westlands");
        } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf) && (character.getNationality() == Character.Nationality.Human)) {
            character.setRegion(Character.Region.Westlands);
            //System.out.println("Set Region westlands");
        }
    }

    public void setSubrace2 (ActionEvent event){
            if (character.getRace() == Character.Race.Human) {
                character.setSubrace(Character.SubRace.Midlander);
                character.setNationality(Human);
                character.setRegion(Character.Region.Midlands);
            } else if (character.getRace() == Character.Race.Elf) {
                character.setSubrace(Character.SubRace.Illmalaina);
                character.setNationality(Elf);
                character.setRegion(Character.Region.Soj);
            } else if (character.getRace() == Character.Race.Dwarf) {
                character.setSubrace(Character.SubRace.Zvorda);
                character.setNationality(Dwarf);
                character.setRegion(Character.Region.Underworld);

            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == null)) {
                character.setSubrace(Character.SubRace.HalfOrc);
                idSubrace2.setSelected(false);
                idSubrace3.setDisable(true);
                idSubrace3.setText("");
                idSubrace1.setText("Human");
                idSubrace2.setText("Orc");
                idSubraceLabel.setText("Nationality");

            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf)&& (character.getNationality() == null)) {
                character.setNationality(Elf);
                character.setRegion(Character.Region.Soj);

            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc)&& (character.getNationality() == null)) {
                character.setNationality(Character.Nationality.Orc);
                character.setSubrace(Character.SubRace.HalfOrc);
                idSubrace2.setSelected(false);
                idSubrace3.setDisable(false);
                idSubrace3.setText("Eastheim");
                idSubrace1.setText("Westlands");
                idSubrace2.setText("Midlands");
                idSubraceLabel.setText("Region");
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc) && (character.getNationality() == Character.Nationality.Human)) {
                character.setRegion(Character.Region.Midlands);
                //System.out.println("Set Region midlands");
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf) && (character.getNationality() == Character.Nationality.Human)) {
                character.setRegion(Character.Region.Midlands);
                //System.out.println("Set Region midlands");
            }
        }

    public void setSubrace3 (ActionEvent event){
            if (character.getRace() == Character.Race.Human) {
                character.setSubrace(Character.SubRace.Virann);
                character.setNationality(Human);
                character.setRegion(Character.Region.Eastheim);

            } else if (character.getRace() == Character.Race.Dwarf) {
                character.setSubrace(Character.SubRace.Buratja);
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc) && (character.getNationality() == Character.Nationality.Human)) {
                character.setRegion(Character.Region.Eastheim);
                //System.out.println("Set Region eastheim");
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf) && (character.getNationality() == Character.Nationality.Human)) {
                character.setRegion(Character.Region.Eastheim);
                //System.out.println("Set Region eastheim");
            }
        }

    // PROFESSION METHODS
    public void setWarrior(ActionEvent event){character.setProfession(Character.Profession.Warrior);}
    public void setMage(ActionEvent event){character.setProfession(Character.Profession.Mage);}
    public void setPeasant(ActionEvent event){character.setProfession(Character.Profession.Peasant);}
    public void setRogue(ActionEvent event){character.setProfession(Character.Profession.Rogue);}
    public void setPriest(ActionEvent event){character.setProfession(Character.Profession.Priest);}
    public void setBard(ActionEvent event){character.setProfession(Character.Profession.Bard);}
    public void setScholar(ActionEvent event){character.setProfession(Character.Profession.Scholar);}


    public int getNextDbCharId(){
        int nextCharId;
        nextCharId = Party.getParty().getNextCharId();
        Party.getParty().setNextCharId(nextCharId + 1);
        return nextCharId + 1;
    }
}
