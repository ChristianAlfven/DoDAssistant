package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Armor;
import CharacterFile.Combatant;
import CharacterFile.Character;


import CharacterFile.Health;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ControllerInitiative {

    @FXML private Label idInitiativeHeading;
    @FXML private Label idInitiativeLabel;
    @FXML private TextField idInitiativeText;
    @FXML private Label idInitiativeDiceLabel;
    @FXML private TextField idInitiativeValueText;
    @FXML private Button idInitiativeButton;
    @FXML private TextField idActivityText;
    @FXML private Button idAttackButton;
    @FXML private Button idStandbyButton;
    @FXML private Button idAttackPhaseButton;
    @FXML private Button idEndCombatButton;

    @FXML private TableView<Combatant> idPlayerTable;
    @FXML private TableColumn<String, Combatant> idPlayerNameColumn;
    @FXML private TableColumn<Integer, Combatant> idPlayerCombatPointColumn;
    @FXML private TableView<Combatant> idCombatantTable;
    @FXML private TableColumn<String, Combatant> idCombatantNameColumn;
    @FXML private TableColumn<Integer, Combatant> idCombatantCombatPointColumn;


    private Party partyInstance;
    private GmList gmInstance;

    public ArrayList<Combatant> combatList;
    public ArrayList<Character> partyList;


    public Combatant[] combatOrder;
    private Combatant combatant;
    private int input;
    private Character player;

    private Stage stage;
    private Parent root;

    private int i = 0;
    private int j = 0;
    private int k = 0;


    public void initialize() {
        partyInstance = Party.getParty();
        gmInstance = GmList.createGmList();
        combatList = gmInstance.getGmList();
        partyList = partyInstance.getPartyList();

        i = 0;

        combatOrder = new Combatant[combatList.size()+partyList.size()];
        gatherGmList();
        if (!gmInstance.isPlayersAdded()) {
            gatherParty();
        }

        idInitiativeText.setText(combatList.get(i).getName());
        j = combatList.size() - 1;

        idAttackPhaseButton.setDisable(true);
        idAttackButton.setDisable(true);
        idStandbyButton.setDisable(true);

        setPlayerTable();
        setCombatantTable();
    }

    private void setPlayerTable(){
        ObservableList<Combatant> playerTableList = FXCollections.observableArrayList();
        for(int i=0; i<combatList.size(); i++) {
            combatant = combatList.get(i);
            if(combatant.isPlayer()){
                playerTableList.add(combatant);
            }
        }

        idPlayerTable.setItems(playerTableList);
        for(int i=0; i<playerTableList.size(); i++) {
            idPlayerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            idPlayerCombatPointColumn.setCellValueFactory(new PropertyValueFactory<>("totCombatPoints"));
        }
    }
    private void setCombatantTable(){
        ObservableList<Combatant> combatantTableList = FXCollections.observableArrayList();
        for(int i=0; i<combatList.size(); i++) {
            combatant = combatList.get(i);
            if(!combatant.isPlayer()){
                combatantTableList.add(combatant);
            }
        }

        idCombatantTable.setItems(combatantTableList);
        for(int i=0; i<combatantTableList.size(); i++) {
            idCombatantNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            idCombatantCombatPointColumn.setCellValueFactory(new PropertyValueFactory<>("totCombatPoints"));
        }
    }

    @FXML
    void confirmInitiative(ActionEvent event) {
        input = Integer.parseInt(idInitiativeValueText.getText());
        combatList.get(i).setInitiative(input);
        i += 1;

        if(i == combatList.size()) {
            idInitiativeText.clear();
            idInitiativeValueText.clear();
            idInitiativeButton.setDisable(true);
            idAttackButton.setDisable(false);
            idStandbyButton.setDisable(false);
            orderList();

            i = 0;
            idActivityText.setText(combatList.get(k).getName());

        }else{
            idInitiativeText.setText(combatList.get(i).getName());
            idInitiativeValueText.clear();
        }
    }

    @FXML
    void attacking(ActionEvent event) {
        actionChoice(true);
    }

    @FXML
    void standby(ActionEvent event) {
        actionChoice(false);
    }

    private void actionChoice(boolean attacking){
        if(k < combatList.size()-1 && attacking){
            combatOrder[i] = combatList.get(k);
            i++;
            k += 1;
            idActivityText.setText(combatList.get(k).getName());


        }else if(k < combatList.size()-1 && !attacking){
            combatOrder[j] = combatList.get(k);
            j--;
            k += 1;
            idActivityText.setText(combatList.get(k).getName());

        }else{
            combatOrder[i] = combatList.get(k);
            idActivityText.clear();
            idAttackButton.setDisable(true);
            idStandbyButton.setDisable(true);
            idAttackPhaseButton.setDisable(false);
        }
    }

    private void gatherParty(){
        gmInstance.setPlayersAdded(true);
        i = 0;
        while (i < partyList.size()){
            player = partyList.get(i);
            if(player != null) {
                combatant = new Combatant(player.getName(), player.getCombatPoints(), player.getHealth(), true);
                combatant.setPlayerIndex(i);
                combatant.setArmor(player.getArmor());
                combatant.setTotCombatPoints(player.getSkillset().getCombat().getSkillLevel());
                combatant.setRemainingCombatPoints(player.getSkillset().getCombat().getSkillLevel());
                combatList.add(combatant);
            }
            i++;
        }
        i = 0;
    }

    private void gatherGmList() {
        combatList = gmInstance.getGmList();
    }

    private void orderList(){
        for(int m=0; m<combatList.size(); m++){
            for(int n=0; n<combatList.size(); n++){
                if(m != n){
                    if(combatList.get(m).getInitiative() < combatList.get(n).getInitiative()){
                        Collections.swap(combatList, m, n);
                    }
                }
            }
        }
    }

    @FXML
    void enterAttackPhase(ActionEvent event) throws IOException {
        combatList.clear();
        for(i=0; i<combatOrder.length; i++){
            if(combatOrder[i] != null){
                combatList.add(combatOrder[i]);
            }
        }
        gmInstance.setGmList(combatList);

        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUICombat.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {
        int playerIndex;
        for(int i = 0; i < combatList.size(); i++){
            //combatList.get(i).setRemainingCombatPoints(combatList.get(i).getTotCombatPoints());
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
}
