package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Combatant;
import CharacterFile.Health;
import CharacterFile.Armor;
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
import java.util.ArrayList;

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
    private Party partyInstance = Party.getParty();
    private GmList gmInstance = GmList.createGmList();

    private ObservableList<Combatant> combatList;
    public ArrayList<Character> partyList;

    private int attackerIndex;
    private int defenderIndex;
    private int pointReduction;

    public void initialize() {
        combatList = FXCollections.observableArrayList();
        combatList.addAll(gmInstance.getGmList());
        partyList = partyInstance.getPartyList();
        setAttacker();

        idCombatOrderTable.setItems(combatList);

        for(int i=0; i<combatList.size(); i++) {
            idCombatantColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            idInitiativeColumn.setCellValueFactory(new PropertyValueFactory<>("initiative"));
        }
    }

    @FXML
    void confirmAttack(ActionEvent event) {
        idAttackButton.setDisable(true);
        if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseAttackerPointsText.getText())){
            idParryButton.setDisable(false);
            successfulAttack();
        }else{
            pointReduction = combatList.get(attackerIndex).getRemainingCombatPoints() - Integer.parseInt(idUseAttackerPointsText.getText());
            combatList.get(attackerIndex).setRemainingCombatPoints(pointReduction);
            idAttackInfoText.setText("Attack missed!");
        }
    }

    @FXML
    void confirmParry(ActionEvent event) {
        idParryButton.setDisable(true);
        pointReduction = combatList.get(defenderIndex).getRemainingCombatPoints() - Integer.parseInt(idUseDefenderPointsText.getText());
        combatList.get(defenderIndex).setRemainingCombatPoints(pointReduction);
        if(Integer.parseInt(idDiceValueText.getText()) <= Integer.parseInt(idUseDefenderPointsText.getText())){
            successfulParry();
        }else{
            idAttackInfoText.setText("Parry failed!");
            idDamageButton.setDisable(false);
        }
    }

    @FXML
    void confirmDamage(ActionEvent event) {
        idDamageButton.setDisable(true);
        int damage;
        int hitPlace;

        damage = Integer.parseInt(idDamageValueText.getText());
        hitPlace = Integer.parseInt(idAttackLocationText.getText());
        combatList.get(defenderIndex).setHealth(hitTable(hitPlace, damage));

        printDefenderHealth(combatList.get(defenderIndex));
    }

    public void getDefenderIndex(){
        int i = 0;
        while(i < combatList.size()){
            if(idDefenderText.getText().equals(combatList.get(i).getName())){
                defenderIndex = i;
                i = combatList.size();
                pointReduction = combatList.get(attackerIndex).getRemainingCombatPoints() - Integer.parseInt(idUseAttackerPointsText.getText());
                combatList.get(attackerIndex).setRemainingCombatPoints(pointReduction);
            }else if(i == combatList.size()-1){
                idAttackInfoText.setText("No opponent with that name!");
            }
            i++;
        }
    }

    public void successfulAttack(){
        idAttackInfoText.setText("Attack Successful!");
        getDefenderIndex();
        idTotDefenderPointsText.setText(String.valueOf(combatList.get(defenderIndex).getRemainingCombatPoints()));
        idTotAttackerPointsText.clear();
        idUseAttackerPointsText.clear();
        idDiceValueText.clear();

        printDefenderHealth(combatList.get(defenderIndex));
    }

    public void successfulParry(){
        idAttackInfoText.setText("Parry Successful!");
        idTotDefenderPointsText.clear();
        idUseDefenderPointsText.clear();
        idDiceValueText.clear();
    }

    @FXML
    void finishTurn(ActionEvent event) throws IOException {
        for(int i = 0; i < combatList.size(); i++) {
            combatList.get(i).setRemainingCombatPoints(combatList.get(i).getTotCombatPoints());
        }

        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUIInitiative.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void newAttack(ActionEvent event) {
        idTotDefenderPointsText.clear();
        setAttacker();
    }

    @FXML
    void nextAttacker(ActionEvent event) {
        attackerIndex++;
        setAttacker();
        idDefenderText.clear();

        if(attackerIndex >= combatList.size()-1){
            idNextAttackerButton.setDisable(true);
        }
    }

    public void setAttacker(){
        idAttackButton.setDisable(false);
        idParryButton.setDisable(true);
        idDamageButton.setDisable(true);
        idTotDefenderPointsText.clear();
        idUseDefenderPointsText.clear();
        idUseAttackerPointsText.clear();
        idDiceValueText.clear();
        idDamageValueText.clear();
        idAttackLocationText.clear();

        idAttackerText.setText(combatList.get(attackerIndex).getName());
        idTotAttackerPointsText.setText(String.valueOf(combatList.get(attackerIndex).getRemainingCombatPoints()));

        printAttackerHealth(combatList.get(attackerIndex));
    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {
        int playerIndex;
        for(int i = 0; i < combatList.size(); i++){
            combatList.get(i).setRemainingCombatPoints(combatList.get(i).getTotCombatPoints());
            if(combatList.get(i).isPlayer()){
                playerIndex = combatList.get(i).getPlayerIndex();
                partyInstance.getCharacter(playerIndex).setHealth(combatList.get(i).getHealth());

                combatList.remove(i);
                gmInstance.getGmList().remove(i);
            }
        }

        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Game/GUIGameLobby.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void printAttackerHealth(Combatant combatant){
        idAttackerHealthText.setText("" +
                "Total:     " + combatant.getHealth().getTotal() +
                "\nHead:      " + combatant.getHealth().getHead() +
                "\nRight Arm: " + combatant.getHealth().getRightArm() +
                "\nLeft Arm:  " + combatant.getHealth().getLeftArm() +
                "\nChest:     " + combatant.getHealth().getChest() +
                "\nStomach:   " + combatant.getHealth().getStomach() +
                "\nRight Leg: " + combatant.getHealth().getRightLeg() +
                "\nLeft Leg:  " + combatant.getHealth().getLeftLeg());
    }

    public void printDefenderHealth(Combatant combatant){
        idDefenderHealthText.setText("" +
                "Total:     " + combatant.getHealth().getTotal() +
                "\nHead:      " + combatant.getHealth().getHead() +
                "\nRight Arm: " + combatant.getHealth().getRightArm() +
                "\nLeft Arm:  " + combatant.getHealth().getLeftArm() +
                "\nChest:     " + combatant.getHealth().getChest() +
                "\nStomach:   " + combatant.getHealth().getStomach() +
                "\nRight Leg: " + combatant.getHealth().getRightLeg() +
                "\nLeft Leg:  " + combatant.getHealth().getLeftLeg());
    }

    public Health hitTable(int diceValue, int dmg) {
        Health hp = combatList.get(defenderIndex).getHealth();
        Armor armor = combatList.get(defenderIndex).getArmor();
        switch (diceValue) {
            case 1:
            case 2:
                dmg = dmg - armor.getHead();
                hp.setHead(hp.getHead()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Head!");
                break;
            case 3:
            case 4:
                dmg = dmg - armor.getRightArm();
                hp.setRightArm(hp.getRightArm()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Right Arm!");
                break;
            case 5:
            case 6:
                dmg = dmg - armor.getLeftArm();
                hp.setLeftArm(hp.getLeftArm()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Left Arm!");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                dmg = dmg - armor.getChest();
                hp.setChest(hp.getChest()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Chest!");
                break;
            case 12:
            case 13:
            case 14:
                dmg = dmg - armor.getStomach();
                hp.setStomach(hp.getStomach()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Stomach!");
                break;
            case 15:
            case 16:
            case 17:
                dmg = dmg - armor.getRightLeg();
                hp.setRightLeg(hp.getRightLeg()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Right Leg!");
                break;
            case 18:
            case 19:
            case 20:
                dmg = dmg - armor.getLeftLeg();
                hp.setLeftLeg(hp.getLeftLeg()-dmg);
                idAttackInfoText.setText(dmg + " damage dealt to Left Leg!");
                break;
            default:
                return hp;
        }
        hp.setTotal(hp.getTotal()-dmg);
        return hp;
    }
}
