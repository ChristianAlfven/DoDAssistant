package Combat;

import ActiveChars.NpcList;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private NpcList npcList = NpcList.getNpcList();

    public ArrayList<Combatant> CombatantList = new ArrayList<>();
    private Combatant combatant;
    int input;


    private int i = 0;
    private int m = 0;
    private int n = 0;


    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        Character player;

        while (party.getCharacter(i) != null){
            player = Party.getParty().getCharacter(i);
            combatant = new Combatant(player.getName(), player.getCombatPoints(), player.getHealth().getTotal());
            combatant.setArmor(player.getArmor());
            CombatantList.add(combatant);
            i += i;
        }
        i = 0;
        combatant = CombatantList.get(i);
        idInitiativeText.setText(combatant.getName());
        i += i;
    }

    @FXML
    void confirmInitiative(ActionEvent event) {
        input = Integer.parseInt(idInitiativeValueText.getText());
        combatant.setInitiative(input);
    }

    @FXML
    void attacking(ActionEvent event) {

    }

    @FXML
    void standby(ActionEvent event) {

    }

    @FXML
    void enterAttackPhase(ActionEvent event) {

    }

    @FXML
    void endCombat(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) idEndCombatButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
