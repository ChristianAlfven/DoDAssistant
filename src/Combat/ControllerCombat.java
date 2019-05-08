package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Combatant;
import com.sun.jdi.Value;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
    @FXML private TableView<Combatant> idCombatOrderTable;
    @FXML private TableColumn<String, Combatant> idCombatantColumn;
    @FXML private TableColumn<Integer, Combatant> idInitiativeColumn;

    private Stage stage;
    private Parent root;
    private Party party = Party.getParty();
    private GmList gmInstance = GmList.createGmList();
    private ObservableList<Combatant> combatList;

    private int listIndex;
    private String input;
    private String output;

    public void initialize() {
        combatList = FXCollections.observableArrayList();
        combatList.addAll(gmInstance.getGmList());
        idAttackerText.setText(combatList.get(listIndex).getName());
        idTotAttackerPointsText.setText(String.valueOf(combatList.get(listIndex).getTotCombatPoints()));

        idCombatOrderTable.setItems(combatList);

        //idCombatantColumn = new TableColumn<>("Name");
        //idCombatantColumn.setCellFactory(new PropertyValueFactory<>("name"));

        //idInitiativeColumn = new TableColumn<>("Initiative");


        for(int i=0; i<combatList.size(); i++) {

            idCombatantColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            //idCombatantColumn.setText(combatList.get(i).getName());
            idInitiativeColumn.setCellValueFactory(new PropertyValueFactory<>("initiative"));
            //idInitiativeColumn.setText(String.valueOf(combatList.get(i).getInitiative()));

        }
        listIndex++;
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
