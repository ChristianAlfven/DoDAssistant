import CharacterFile.Character;
import CharacterFile.Armor;
import  CharacterFile.Health;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import CharacterFile.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CharacterCreator{

    Image image = new Image("sample/sample.fxml");
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
    @FXML private ToggleButton idBuratja;
    @FXML private ToggleGroup Subrace;
    @FXML private ToggleButton idZvorda;
    @FXML private ToggleButton idBorjornikka;
    @FXML private RadioButton idNature;
    @FXML private ToggleGroup Environment;
    @FXML private RadioButton idAcademic;
    @FXML private RadioButton idCity;
    @FXML private RadioButton idCountry;
    @FXML private RadioButton idMale;
    @FXML private ToggleGroup Gender;
    @FXML private RadioButton idFemale;



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
    Scanner Scan = new Scanner(System.in);



    public Character createCharacter(){
        System.out.println("CharacterFile Creation:\n");

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
    }
    public void setDwarf(){
        character.setRace(Character.Race.Human);

    }
    public void setElf(){
        character.setRace(Character.Race.Elf);
    }
    public void setHalfBlood(){
        character.setRace(Character.Race.HalfBlood);
    }

    // SUBRACE METHODS
    public void setKorpikalla(){
        character.setSubrace(Character.SubRace.Korpikalla);
    }
    public void setIllmalaina(){
        character.setSubrace(Character.SubRace.Illmalaina);
    }
    public void setBorjornikka(){
        character.setSubrace(Character.SubRace.Borjornikka);
    }
    public void setZvorda(){
        character.setSubrace(Character.SubRace.Zvorda);
    }
    public void setBuratja(){
        character.setSubrace(Character.SubRace.Buratja);
    }
    public void setStormlander(){
        character.setSubrace(Character.SubRace.Stormlander);
    }
    public void setMidlander(){
        character.setSubrace(Character.SubRace.Midlander);
    }
    public void setVirann(){
        character.setSubrace(Character.SubRace.Virann);
    }
    public void setHalfOrc(){
        character.setSubrace(Character.SubRace.HalfOrc);
    }
    public void setHalfElf(){
        character.setSubrace(Character.SubRace.HalfElf);
    }

    // NATIONALITY METHODS (HALF BLOOD ONLY)
    public void setNationalityHuman(){character.setNationality(Character.Nationality.Human);}
    public void setNationalityElf(){character.setNationality(Character.Nationality.Elf);}
    public void setNationalityOrc(){character.setNationality(Character.Nationality.Orc);}

    // PROFESSION METHODS
    public void setWarrior(){character.setProfession(Character.Profession.Warrior);}
    public void setMage(){character.setProfession(Character.Profession.Mage);}
    public void setPeasant(){character.setProfession(Character.Profession.Peasant);}
    public void setRogue(){character.setProfession(Character.Profession.Rogue);}
    public void setPriest(){character.setProfession(Character.Profession.Priest);}
    public void setBard(){character.setProfession(Character.Profession.Bard);}
    public void setScholar(){character.setProfession(Character.Profession.Warrior);}

    // ENVIRONMENT METHODS
    /*
    public void setNature(){character.setEnvironment(CharacterFile.Profession.Warrior);}
    public void setCity(){character.environment = Environment.City;}
    public void setCountry(){character.environment = Environment.Country;}
    public void setAcademic(){environment = Environment.Academic;}
    */


    // BACKGROUND METHODS
    //public void setBackground(){}

    // NAME / AGE / HEIGHT / WEIGHT / GENDER METHODS
    //public void setName(String name){this.name = name;}
    //public void setAge(int age){this.age = age;}
    //public void setHeight(int height){this.height = height;}
    //public void setWeight(int weight){this.weight = weight;}
    //public void setGender(boolean isMale){
    //    if(isMale){gender = Gender.Male;}
     //   else {gender = Gender.Female;}

    //}








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
