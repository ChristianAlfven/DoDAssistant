package Combat;

import ActiveChars.GmList;
import ActiveChars.Party;
import CharacterFile.Combatant;
import CharacterFile.Character;


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

    private Party party = Party.getParty();
    private GmList gmInstance = GmList.createGmList();

    public ArrayList<Combatant> combatList;
    public Combatant[] combatOrder;
    private Combatant combatant;
    int input;
    Stage stage;
    Parent root;

    Character player;


    private int i = 0;
    private int j = 0;
    private int k = 0;

    private boolean isAttacking;


    public void initialize() {
        i = 0;
        combatList = gmInstance.getGmList();
        combatOrder = new Combatant[combatList.size()];
        gatherGmList();

        idInitiativeText.setText(combatList.get(i).getName());
        j = combatList.size() - 1;
    }

    @FXML
    void confirmInitiative(ActionEvent event) {
        input = Integer.parseInt(idInitiativeValueText.getText());
        combatList.get(i).setInitiative(input);
        i += 1;
        System.out.println(i);

        if(i == combatList.size()) {
            idInitiativeText.clear();
            idInitiativeValueText.clear();
            idInitiativeButton.setDisable(true);
            orderList();
            System.out.println(combatList.get(0).getName() +
                    "\n" + combatList.get(1).getName()+
                    "\n" + combatList.get(2).getName());
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
        System.out.println("i = " + i +
                "j = " + j +
                "k = " + k);
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

            System.out.println(combatOrder[0].getName());
            System.out.println(combatOrder[1].getName());
            System.out.println(combatOrder[2].getName());
        }
    }

    private void gatherParty(){
        while (party.getCharacter(i) != null){
            player = Party.getParty().getCharacter(i);
            combatant = new Combatant(player.getName(), player.getCombatPoints(), player.getHealth().getTotal(), true);
            combatant.setPlayerIndex(i);
            combatant.setArmor(player.getArmor());
            combatList.add(combatant);
            i += i;
        }
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
        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Game/GUIGameLobby.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
