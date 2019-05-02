import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class Controller {


    CharacterCreator characterCreator = new CharacterCreator();

    @FXML

    void initialize() {

    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label idNameLabel;

    @FXML
    private TextField idNamebox;

    @FXML
    private Label idRaceLabel;

    @FXML
    private Label idSubraceLabel;

    @FXML
    private Label idProfessionLabel;

    @FXML
    private Label idHeightLabel;

    @FXML
    private Label idWeightLabel;

    @FXML
    private TextField idAgeBox;

    @FXML
    private TextField idHeightBox;

    @FXML
    private TextArea idBackgroundBox;

    @FXML
    private Label idBackgroundLabel;

    @FXML
    private Button idContinue;

    @FXML
    private Label idAgeLabel;

    @FXML
    private TextField idWeightBox;

    @FXML
    private ToggleButton idWarrior;

    @FXML
    private ToggleGroup Profession;

    @FXML
    private ToggleButton idScholar;

    @FXML
    private ToggleButton idBard;

    @FXML
    private ToggleButton idPriest;

    @FXML
    private ToggleButton idRogue;

    @FXML
    private ToggleButton idMage;

    @FXML
    private ToggleButton idPeasant;

    @FXML
    private ToggleButton idHuman;

    @FXML
    private ToggleGroup Race;

    @FXML
    private ToggleButton idHalfBlood;

    @FXML
    private ToggleButton idElf;

    @FXML
    private ToggleButton idDwarf;

    @FXML
    private ToggleButton idBuratja;

    @FXML
    private ToggleGroup Subrace;

    @FXML
    private ToggleButton idZvorda;

    @FXML
    private ToggleButton idBorjornikka;

    @FXML
    private RadioButton idNature;

    @FXML
    private ToggleGroup Environment;

    @FXML
    private RadioButton idAcademic;

    @FXML
    private RadioButton idCity;

    @FXML
    private RadioButton idCountry;

    @FXML
    private RadioButton idMale;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton idFemale;


}