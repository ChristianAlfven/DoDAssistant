package Creator;

import ActiveChars.Party;
import CharacterFile.Armor;
import CharacterFile.Character;
import CharacterFile.Health;
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
import java.util.ResourceBundle;
import java.util.Scanner;

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
        root = FXMLLoader.load(getClass().getResource("GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonContinue(ActionEvent event) throws IOException {

        System.out.println(character.debug());

        if ((idNamebox.getText()!=null)&&(idAgeBox.getText()!=null)
                &&(idBackgroundBox.getText()!=null)&&(idHeightBox.getText()!=null)
                &&(idWeightBox.getText()!=null)&&(character.getProfession()!=null)
                &&(character.getRace()!=null)&&(character.getSubrace()!=null)
                &&(idNature.isSelected()||idCity.isSelected()||idCountry.isSelected()||idAcademic.isSelected())
                &&(idMale.isSelected()||idFemale.isSelected()))
        {
            try {
                character.setName(idNamebox.getText());
                character.setBackground(idBackgroundBox.getText());
                character.setHeight(Integer.parseInt(idHeightBox.getText()));
                character.setWeight(Integer.parseInt(idWeightBox.getText()));
                character.setAge(Integer.parseInt(idAgeBox.getText()));

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

                System.out.println(character.toString());

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




    public Character createCharacter(){
//        System.out.println("CharacterFile Creation:\n");


        /*
        chooseName();
        chooseGender();
        chooseRace();
        chooseSkills();
        chooseEnvironment();
        chooseBackground();
        chooseProfession();
         */

        return character;
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
        idSubraceLabel.setText("Subrace");
    }

    // SUBRACE METHODS
    public void setSubrace1(ActionEvent event){
        if(character.getRace()== Character.Race.Human) {
            character.setSubrace(Character.SubRace.Stormlander);
        }else if (character.getRace()== Character.Race.Elf) {
            character.setSubrace(Character.SubRace.Korpikalla);
        }else if (character.getRace()== Character.Race.Dwarf) {
            character.setSubrace(Character.SubRace.Borjornikka);
        }
        else if ((character.getRace()==Character.Race.HalfBlood)&&(character.getSubrace()==null)){
            character.setSubrace(Character.SubRace.HalfElf);
            idSubrace1.setSelected(false);
            idSubrace3.setDisable(true);
            idSubrace3.setText("");
            idSubrace1.setText("Human");
            idSubrace2.setText("Elf");
            idSubraceLabel.setText("Nationality");
        }else if ((character.getRace()==Character.Race.HalfBlood) && (character.getSubrace()== Character.SubRace.HalfElf)) {
            character.setNationality(Character.Nationality.Human);
        }else if ((character.getRace()==Character.Race.HalfBlood) && (character.getSubrace()== Character.SubRace.HalfOrc)) {
            character.setNationality(Character.Nationality.Human);
        }
    }
    public void setSubrace2(ActionEvent event){
            if (character.getRace() == Character.Race.Human) {
                character.setSubrace(Character.SubRace.Midlander);
            } else if (character.getRace() == Character.Race.Elf) {
                character.setSubrace(Character.SubRace.Illmalaina);
            } else if (character.getRace() == Character.Race.Dwarf) {
                character.setSubrace(Character.SubRace.Zvorda);
            } else if ((character.getRace() == Character.Race.HalfBlood)&&(character.getSubrace()==null)) {
                character.setSubrace(Character.SubRace.HalfOrc);
                idSubrace2.setSelected(false);
                idSubrace3.setDisable(true);
                idSubrace3.setText("");
                idSubrace1.setText("Human");
                idSubrace2.setText("Orc");
                idSubraceLabel.setText("Nationality");
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfElf)) {
                character.setNationality(Character.Nationality.Elf);
            } else if ((character.getRace() == Character.Race.HalfBlood) && (character.getSubrace() == Character.SubRace.HalfOrc)) {
                character.setNationality(Character.Nationality.Orc);
            }
        }

    public void setSubrace3(ActionEvent event){
        if(character.getRace()== Character.Race.Human) {
            character.setSubrace(Character.SubRace.Virann);
        }else if (character.getRace()== Character.Race.Dwarf) {
            character.setSubrace(Character.SubRace.Buratja);
        }
    }


    // NATIONALITY METHODS (HALF BLOOD ONLY)
    public void setNationalityHuman(ActionEvent event){character.setNationality(Character.Nationality.Human);}
    public void setNationalityElf(ActionEvent event){character.setNationality(Character.Nationality.Elf);}
    public void setNationalityOrc(ActionEvent event){character.setNationality(Character.Nationality.Orc);}

    // PROFESSION METHODS
    public void setWarrior(ActionEvent event){character.setProfession(Character.Profession.Warrior);}
    public void setMage(ActionEvent event){character.setProfession(Character.Profession.Mage);}
    public void setPeasant(ActionEvent event){character.setProfession(Character.Profession.Peasant);}
    public void setRogue(ActionEvent event){character.setProfession(Character.Profession.Rogue);}
    public void setPriest(ActionEvent event){character.setProfession(Character.Profession.Priest);}
    public void setBard(ActionEvent event){character.setProfession(Character.Profession.Bard);}
    public void setScholar(ActionEvent event){character.setProfession(Character.Profession.Warrior);}


    //CONTINUE BUTTON
//    @FXML
//    void buttonContinue(ActionEvent event) {
//
//    }

    // ENVIRONMENT METHODS
    /*
    public void setNature(){character.setEnvironment(CharacterFile.Profession.Warrior);}
    public void setCity(){character.environment = Environment.City;}
    public void setCountry(){character.environment = Environment.Country;}
    public void setAcademic(){environment = Environment.Academic;}
    */


    // BACKGROUND METHODS
    //public void setBackground(){}

//     NAME / AGE / HEIGHT / WEIGHT / GENDER METHODS
//    public void setName(String name){this.name = name;}
//    public void setAge(int age){this.age = age;}
//    public void setHeight(int height){this.height = height;}
//    public void setWeight(int weight){this.weight = weight;}
//    public void setGender(boolean isMale){
//        if(isMale){gender = Gender.Male;}
//        else {gender = Gender.Female;}
//
//    }








/*
    public void chooseName(){
        System.out.println("Name: ");
        name = Scan.nextLine();
    }

    public void chooseGender(){
        boolean accepted = true;

        do {
            System.out.println("Gender: <Male / Female>");
            switch (Scan.nextLine()) {
                case "Male":
                    gender = Gender.Female;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Female":
                    gender = Gender.Male;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void chooseRace(){
        boolean accepted = true;

        do {
            System.out.println("Choose a Race <Human / Dwarf / Elf / HalfBlood>");
            switch (Scan.nextLine()) {
                case "Human":
                    race = Race.Human;
                    accepted = true;
                    chooseHumanSub();
                    //TODO: Bonuses
                    break;
                case "Dwarf":
                    race = Race.Dwarf;
                    accepted = true;
                    chooseDwarfSub();
                    //TODO: Bonuses
                    break;
                case "Elf":
                    race = Race.Elf;
                    accepted = true;
                    chooseElfSub();
                    //TODO: Bonuses
                    break;
                case "HalfBlood":
                    race = Race.HalfBlood;
                    accepted = true;
                    chooseHalfBloodSub();
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void chooseSkills(){
        //TODO: Skillset
    }

    public void chooseEnvironment(){
        boolean accepted = true;

        do {
            System.out.println("Background Environment:" +
                    "\n<Nature / Country / City / Academic");
            switch (Scan.nextLine()) {
                case "Nature":
                    environment = Environment.Nature;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Country":
                    environment = Environment.Country;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "City":
                    environment = Environment.City;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Academic":
                    environment = Environment.Academic;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
        //TODO: Environment bonuses
    }

    public void chooseBackground(){
        System.out.println("Write a background for your character:");
        background = Scan.nextLine();
    }

    public void chooseProfession(){
        int option = 0;
        boolean accepted;
        System.out.println("Choose a profession: " +
                "\n1. Warrior" +
                "\n2. Peasant" +
                "\n3. Mage" +
                "\n4. Rogue" +
                "\n5. Priest" +
                "\n6. Bard" +
                "\n7. Scholar");
        do {
            try {
                option = Scan.nextInt();
                accepted = true;
                switch (option) {
                    case 1:
                        profession = Profession.Warrior;
                        accepted = true;
                        break;
                    case 2:
                        profession = Profession.Peasant;
                        accepted = true;
                        break;
                    case 3:
                        profession = Profession.Mage;
                        accepted = true;
                        break;
                    case 4:
                        profession = Profession.Rogue;
                        accepted = true;
                        break;
                    case 5:
                        profession = Profession.Priest;
                        accepted = true;
                        break;
                    case 6:
                        profession = Profession.Bard;
                        accepted = true;
                        break;
                    case 7:
                        profession = Profession.Scholar;
                        accepted = true;
                        break;
                    default:
                        System.out.println("Invalid Input");
                        accepted = false;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid Input");
                accepted = false;
            }
        }while (!accepted) ;
    }

    public void chooseHumanSub(){

        boolean accepted = true;

        do {
            System.out.println("Choose a Subrace \n" +
                    "<Stormlander / Midlander / Virann>");
            switch (Scan.nextLine()) {
                case "Stormlander":
                    race = Race.Human;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Midlander":
                    race = Race.Dwarf;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Virann":
                    race = Race.Elf;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void chooseElfSub(){

        boolean accepted = true;

        do {
            System.out.println("Choose a Subrace \n" +
                    "<Korpikalla / Illmalaina>");
            switch (Scan.nextLine()) {
                case "Korpikalla":
                    race = Race.Human;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Illmalaina":
                    race = Race.Dwarf;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void chooseDwarfSub(){

        boolean accepted = true;

        do {
            System.out.println("Choose a Subrace \n" +
                    "<Buratja / Borjornikka / Zvorda>");
            switch (Scan.nextLine()) {
                case "Buratja":
                    race = Race.Human;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Borjornikka":
                    race = Race.Dwarf;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                case "Zvorda":
                    race = Race.Dwarf;
                    accepted = true;
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void chooseHalfBloodSub(){

        boolean accepted = true;

        do {
            System.out.println("Choose a Subrace \n" +
                    "<HalfElf / HalfOrc>");
            switch (Scan.nextLine()) {
                case "HalfElf":
                    race = Race.Human;
                    accepted = true;
                    halfElfNationality();
                    //TODO: Bonuses
                    break;
                case "HalfOrc":
                    race = Race.Dwarf;
                    accepted = true;
                    halfOrcNationality();
                    //TODO: Bonuses
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void halfOrcNationality(){

        boolean accepted = true;

        do {
            System.out.println("Choose a nationionality \n" +
                    "<Human / Orc>");
            switch (Scan.nextLine()) {
                case "Human":
                    //TODO: Bonuses for human
                    break;
                case "Orc":
                    //TODO: Bonuses for elf
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

    public void halfElfNationality(){

        boolean accepted = true;

        do {
            System.out.println("Choose a nationionality \n" +
                    "<Human / Elf>");
            switch (Scan.nextLine()) {
                case "Human":
                    //TODO: Bonuses for human
                    break;
                case "Elf":
                    //TODO: Bonuses for elf
                    break;
                default:
                    System.out.println("Incorrect input. Try again");
                    accepted = false;
                    break;
            }
        }while (!accepted);
    }

*/





}
