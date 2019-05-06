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
    public LinkedList<Combatant> combatOrder;
    private Combatant combatant;
    int input;
    Stage stage;
    Parent root;

    Character player;


    private int i = 0;
    private int m = 0;
    private int n = 0;


    public void initialize() {
        combatList = gmInstance.getGmList();
        combatOrder = new LinkedList<>();
        gatherGmList();

        idInitiativeText.setText(combatList.get(i).getName());
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
            System.out.println(combatList.get(0).getName() + "\n" + combatList.get(1).getName() + "\n" + combatList.get(2).getName());

        }else{
            idInitiativeText.setText(combatList.get(i).getName());
            idInitiativeValueText.clear();

            actionChoice();

        }
    }

    @FXML
    void attacking(ActionEvent event) {

    }

    @FXML
    void standby(ActionEvent event) {

    }

    @FXML
    void enterAttackPhase(ActionEvent event) throws IOException {
        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUICombat.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {
        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void gatherParty(){
        while (party.getCharacter(i) != null){
            player = Party.getParty().getCharacter(i);
            combatant = new Combatant(player.getName(), player.getCombatPoints(), player.getHealth().getTotal());
            combatant.setArmor(player.getArmor());
            combatList.add(combatant);
            i += i;
        }
    }

    private void gatherGmList() {
        combatList = gmInstance.getGmList();
        /*
        i = 0;
        while (gmList.getCombatant(i) != null){
            combatant = GmList.createGmList().getCombatant(i);
            combatantList.add(combatant);
            i += i;
        }
        i = 0;
        */
    }

    private void actionChoice(){

    }

    private void orderList(){
        combatList.sort(combatList, combatant.getInitiative());
        Combatant a;
        Combatant b;
        for(m=0; m<combatList.size(); m++){
            a = combatList.get(m);
            for(n=0; n<combatList.size(); n++){
                b = combatList.get(n);
                if(m != n){
                    if(a.getInitiative() < b.getInitiative()){
                        combatList.add(n, a);
                        combatList.add(m, b);
                    }
                }
            }
        }
    }
}
