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

    private int attackerIndex;
    private int defenderIndex;
    private String input;
    private String output;
    private Combatant defender;
    private boolean attackHit = false;
    private boolean attackDmg = false;
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
        attackHit = false;
    }

    @FXML
    void confirmCombatPoints(ActionEvent event) {
        if(attackHit){
            if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseDefenderPointsText.getText())){
                successfulParry();
            }else{
                idAttackInfoText.setText("Parry failed!");
                idAttackButton.setDisable(false);
            }
        }else{
            if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseAttackerPointsText.getText())){
                successfulAttack();
            }else{
                idAttackInfoText.setText("Attack missed!");
            }
            pointReduction = combatList.get(attackerIndex).getRemainingCombatPoints() - Integer.parseInt(idUseAttackerPointsText.getText());
            combatList.get(attackerIndex).setRemainingCombatPoints(pointReduction);
        }
    }

    public int getDefenderIndex(){
        int i = 0;
        while(i < combatList.size()){
            if(idDefenderText.equals(combatList.get(i).getName())){
                return i;
            }
            i++;
        }
        idAttackInfoText.setText("No opponent with that name!");
        return 0; //This has to be changed later
    }

    public void successfulAttack(){
        attackHit = true;
        idAttackInfoText.setText("Attack Successful!");
        defenderIndex = getDefenderIndex();
        idTotDefenderPointsText.setText(String.valueOf(combatList.get(defenderIndex).getRemainingCombatPoints()));
        idTotAttackerPointsText.clear();
        idUseAttackerPointsText.clear();
        idDiceValueText.clear();
    }
    public void successfulParry(){
        attackHit = false;
        idAttackInfoText.setText("Parry Successful!");
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
        idAttackButton.setDisable(true);
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
