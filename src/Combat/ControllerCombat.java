package Combat;

import CharacterFile.Combatant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerCombat {

    @FXML private Label idCombatHeader;
    @FXML private Label idAttackerLabel;
    @FXML private Label idDefenderLabel;
    @FXML private TextField idAttackerText;
    @FXML private TextField idDefenderText;

    @FXML private Label idCombatPointsLabel;
    @FXML private TextField idTotAttackerPointsText;
    @FXML private TextField idTotDefenderPointsText;
    @FXML private Label idPointsUsedLabel;
    @FXML private TextField idUseAttackerPointsText;
    @FXML private TextField idUseDefenderPointsText;
    @FXML private Button idCombatPointsButton;

    @FXML private Label idDiceValueLabel;
    @FXML private TextField idDiceValueText;
    @FXML private Label idAttackLocationLabel;
    @FXML private TextField idAttackLocationText;
    @FXML private Label idDamageValueLabel;
    @FXML private TextField idDamageValueText;
    @FXML private Button idAttackButton;

    @FXML private Label idAttackerHealthLabel;
    @FXML private TextArea idAttackerHealthText;
    @FXML private Label idDefenderHealthLabel;
    @FXML private TextArea idDefenderHealthText;
    @FXML private Label idAttackInfoLabel;
    @FXML private TextField idAttackInfoText;

    @FXML private Button idNewAttackButton;
    @FXML private Button idNextAttackerButton;
    @FXML private Button idFinishTurnButton;
    @FXML private Button idEndCombatButton;

    @FXML private TextField idCombatOrderLabel;
    @FXML private TableView<?> idCombatOrderTable;
    @FXML private TableColumn<?, ?> idCombatantColumn;
    @FXML private TableColumn<?, ?> idInitiativeColumn;

    private Stage stage;
    private Parent root;
    public Combatant[] combatOrder;

    public void initialize() {

    }

    @FXML
    void confirmAttack(ActionEvent event) {

    }

    @FXML
    void confirmCombatPoints(ActionEvent event) {

    }

    @FXML
    void finishTurn(ActionEvent event) throws IOException {
        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUIInitiative.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void newAttack(ActionEvent event) {

    }

    @FXML
    void nextAttacker(ActionEvent event) {

    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {


        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void startAttack(){
        idAttackerText.setText("");
        idTotAttackerPointsText.setText("");

    }

    public void printHealthPoints(){
        idAttackerHealthText.setText("" +
                "Total:     " +
                "Head:      " +
                "Right Arm: " +
                "Left Arm:  " +
                "Chest:     " +
                "Stomach:   " +
                "Right Leg: " +
                "Left Leg:  ");
    }
}
