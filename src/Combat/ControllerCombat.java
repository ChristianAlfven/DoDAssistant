package Combat;

        import CharacterFile.NPC;
        import ActiveChars.NPCList;
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
        import javafx.scene.control.ToggleButton;
        import javafx.scene.control.ToggleGroup;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.ResourceBundle;


public class ControllerCombat {

    @FXML private Label idActiveCharLabel;
    @FXML private TextField idActiveCharText;
    @FXML private Label idPhaseLabel;
    @FXML private Label idActionLabel;
    @FXML private Label idCombatPointsLabel;
    @FXML private TextField idCombatPhaseText;
    @FXML private TextField idTotPointsText;
    @FXML private TextArea idHealthText;
    @FXML private Label idBackgroundLabel;
    @FXML private Button idInitiativeButton;
    @FXML private ToggleButton idAction2;
    @FXML private ToggleGroup Action;
    @FXML private ToggleButton idAction1;
    @FXML private TableView<?> idCombatTable;
    @FXML private TableColumn<?, ?> idCharTypeColumn;
    @FXML private TableColumn<?, ?> idCharNameColumn;
    @FXML private TableColumn<?, ?> idCharInitiativeColumn;
    @FXML private TextField idCombatOrder;
    @FXML private Button idAttackPhaseButton;
    @FXML private Button idFinishTurnButton;
    @FXML private Button idEndCombatButton;
    @FXML private Button idContinueButton;
    @FXML private Label idPointsUsedLabel;
    @FXML private TextField idActionPointsText;
    @FXML private Label idOpponentLabel;
    @FXML private TextField idOpponentText;
    @FXML private TextField idDiceValueText;
    @FXML private Label idDiceValueLabel;

    ArrayList<NPC> npcList;
    NPCList instance = NPCList.createNPCList();


    public void initialize(URL url, ResourceBundle rb) {
    npcList = instance.getNpcList();
    }

    @FXML
    void continueTurn(ActionEvent event) {

    }


    @FXML
    void finishTurn(ActionEvent event) {


    }

    @FXML
    void initiativePhase(ActionEvent event) {

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

