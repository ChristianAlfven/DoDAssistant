import java.io.IOException;
import CharacterFile.Character;
import CharacterFile.Armor;
import CharacterFile.Health;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class ControllerNewGame {
    @FXML private Button idRemove;
    @FXML private TableView<Character> idCharacterTable;
    @FXML private TableColumn<Character, String> firstCol;
    @FXML private TableColumn<Character, String> secondCol;
    @FXML private TableColumn<Character, String> thirdtCol;
    @FXML private Button idNewCharacter;
    @FXML private Button idStartGame;
    @FXML private Button idExit;
    @FXML private Button idLoadCharacter;
    @FXML private Button idEdit;



    public void initialize(URL url, ResourceBundle rb) {

    }


    String name;
    int age;
    int height;
    int weight;
    int counter;

    Character[] characterIndex;

    @FXML
    void buttonDummy(ActionEvent event) {
        Character character = new Character();
        character.setName("Bo");
        characterIndex = new Character[5];
        characterIndex[counter] = character;

        idCharacterTable.getItems().add(character);

        counter++;

    }

    @FXML
    void buttonStartGame(ActionEvent event) {

    }

    @FXML
    void buttonNewCharacter(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idNewCharacter.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUICharacterCreation.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonLoadCharacter(ActionEvent event) {

    }

    @FXML
    void buttonEdit(ActionEvent event) {

    }

    @FXML
    void buttonRemove(ActionEvent event) {

    }

    @FXML
    void buttonExit(ActionEvent event) {
        Runtime.getRuntime().exit(0);
    }

}