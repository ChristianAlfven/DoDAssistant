package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Armor;
import CharacterFile.Combatant;
import CharacterFile.Character;


import CharacterFile.Health;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ControllerInitiative {

    @FXML private TableView<?> idPlayerTable;
    @FXML private TableColumn<?, ?> idPlayerNameColumn;
    @FXML private TableColumn<?, ?> idPlayerInitiativeColumn;
    @FXML private TableView<?> idCombatantTable;
    @FXML private TableColumn<?, ?> idCombatantNameColumn;
    @FXML private TableColumn<?, ?> idCombatantInitiativeColumn;
    @FXML private Label idInitiativeHeading;
    @FXML private Label idInitiativeLabel;
    @FXML private TextField idInitiativeText;
    @FXML private Label idInitiativeDiceLabel;
    @FXML private TextField idInitiativeValueText;
    @FXML private Button idInitiativeButton;
    @FXML private Label idInitiativeInfoLabel;
    @FXML private TextField idActivityText;
    @FXML private Button idAttackButton;
    @FXML private Button idStandbyButton;
    @FXML private Button idAttackPhaseButton;
    @FXML private Button idEndCombatButton;

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

        //dummyPlayer();

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

    public void dummyPlayer(){
        Health hp = new Health(30);
        Armor armor = new Armor();
        armor.setHead(10);
        armor.setRightArm(5);
        armor.setLeftArm(5);
        armor.setChest(10);
        armor.setStomach(8);
        armor.setRightLeg(7);
        armor.setLeftLeg(7);

        Character character1 = new Character();

        character1.setName("Pelle2");
        character1.setGender(Character.Gender.Female);
        character1.setAge(12);
        character1.setHeight(123);
        character1.setWeight(10);
        character1.setRace(Character.Race.Human);
        character1.setSubrace(Character.SubRace.Borjornikka);
        character1.setProfession(Character.Profession.Priest);
        character1.setEnvironment(Character.Environment.City);
        character1.setBackground("Hej");
        character1.setCombatPoints(100);
        character1.setHealth(hp);
        character1.setArmor(armor);

        partyList.add(character1);
        partyInstance.setPartyList(partyList);
    }
}
