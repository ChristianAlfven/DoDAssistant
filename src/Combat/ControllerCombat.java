package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Combatant;
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

import java.io.IOException;

public class ControllerCombat {

    //Labels
    @FXML private Label idCombatHeader;
    @FXML private Label idAttackerLabel;
    @FXML private Label idDefenderLabel;
    @FXML private Label idCombatPointsLabel;
    @FXML private Label idPointsUsedLabel;
    @FXML private Label idDiceValueLabel;
    @FXML private Label idAttackLocationLabel;
    @FXML private Label idDamageValueLabel;
    @FXML private Label idAttackerHealthLabel;
    @FXML private Label idDefenderHealthLabel;
    @FXML private Label idAttackInfoLabel;

    //Text
    @FXML private TextField idAttackerText;
    @FXML private TextField idDefenderText;
    @FXML private TextField idTotAttackerPointsText;
    @FXML private TextField idTotDefenderPointsText;
    @FXML private TextField idUseAttackerPointsText;
    @FXML private TextField idUseDefenderPointsText;
    @FXML private TextField idDiceValueText;
    @FXML private TextField idAttackLocationText;
    @FXML private TextField idDamageValueText;
    @FXML private TextArea idAttackerHealthText;
    @FXML private TextArea idDefenderHealthText;
    @FXML private TextField idAttackInfoText;
    @FXML private TextField idCombatOrderLabel;

    //Button
    @FXML private Button idCombatPointsButton;
    @FXML private Button idAttackButton;
    @FXML private Button idParryButton;
    @FXML private Button idDamageButton;
    @FXML private Button idNewAttackButton;
    @FXML private Button idNextAttackerButton;
    @FXML private Button idFinishTurnButton;
    @FXML private Button idEndCombatButton;

    //Table
    @FXML private TableView<Combatant> idCombatOrderTable;
    @FXML private TableColumn<String, Combatant> idCombatantColumn;
    @FXML private TableColumn<Integer, Combatant> idInitiativeColumn;

    private Stage stage;
    private Parent root;
    private Party party = Party.getParty();
    private GmList gmInstance = GmList.createGmList();
    private ObservableList<Combatant> combatList;

    private int attackerIndex;
    private int defenderIndex;
    private String input;
    private String output;
    private Combatant defender;
    //private boolean attackHit = false;
    //private boolean attackDmg = false;
    private int pointReduction;

    public void initialize() {
        combatList = FXCollections.observableArrayList();
        combatList.addAll(gmInstance.getGmList());
        setAttacker();

        idCombatOrderTable.setItems(combatList);

        for(int i=0; i<combatList.size(); i++) {
            idCombatantColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            idInitiativeColumn.setCellValueFactory(new PropertyValueFactory<>("initiative"));
        }
    }

    @FXML
    void confirmAttack(ActionEvent event) {
        pointReduction = combatList.get(attackerIndex).getRemainingCombatPoints() - Integer.parseInt(idUseAttackerPointsText.getText());
        combatList.get(attackerIndex).setRemainingCombatPoints(pointReduction);

        if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseAttackerPointsText.getText())){
            successfulAttack();
        }else{
            idAttackInfoText.setText("Attack missed!");
        }
    }

    @FXML
    void confirmParry(ActionEvent event) {
        pointReduction = combatList.get(defenderIndex).getRemainingCombatPoints() - Integer.parseInt(idUseDefenderPointsText.getText());
        combatList.get(defenderIndex).setRemainingCombatPoints(pointReduction);
        if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseDefenderPointsText.getText())){
            successfulParry();
        }else{
            idAttackInfoText.setText("Parry failed!");
        }
    }

    @FXML
    void confirmDamage(ActionEvent event) {

    }

    public int getDefenderIndex(){
        int i = 0;
        while(i < combatList.size()){
            if(idDefenderText.getText().equals(combatList.get(i).getName())){
                return i;
            }
            i++;
        }
        idAttackInfoText.setText("No opponent with that name!");
        return 0; //This has to be changed later
    }

    public void successfulAttack(){
        idAttackInfoText.setText("Attack Successful!");
        defenderIndex = getDefenderIndex();
        idTotDefenderPointsText.setText(String.valueOf(combatList.get(defenderIndex).getRemainingCombatPoints()));
        idTotAttackerPointsText.clear();
        idUseAttackerPointsText.clear();
        idDiceValueText.clear();
    }

    public void successfulParry(){
        idAttackInfoText.setText("Parry Successful!");
        idTotDefenderPointsText.clear();
        idUseDefenderPointsText.clear();
        idDiceValueText.clear();
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
        setAttacker();
    }

    @FXML
    void nextAttacker(ActionEvent event) {
        attackerIndex++;
        setAttacker();
    }

    public void setAttacker(){
        idAttackerText.setText(combatList.get(attackerIndex).getName());
        idTotAttackerPointsText.setText(String.valueOf(combatList.get(attackerIndex).getRemainingCombatPoints()));
    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {
        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Game/GUIGameLobby.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void startAttack(){
        idAttackerText.setText("");
        idTotAttackerPointsText.setText("");

    }

    public void printHealthPoints(int index){
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
