package Combat;

        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.control.ToggleButton;
        import javafx.scene.control.ToggleGroup;

public class Initiative {

    @FXML
    private Label idActiveCharLabel;
    @FXML
    private TextField idActiveCharText;
    @FXML
    private Label idPhaseLabel;
    @FXML
    private Label idActionLabel;
    @FXML
    private Label idCombatPointsLabel;
    @FXML
    private TextField idCombatPhaseText;
    @FXML
    private TextField idTotPointsText;
    @FXML
    private TextArea idHealthText;
    @FXML
    private Label idBackgroundLabel;
    @FXML
    private Button idInitiativeButton;
    @FXML
    private ToggleButton idAction2;
    @FXML
    private ToggleGroup Action;
    @FXML
    private ToggleButton idAction1;
    @FXML
    private TableView<?> idCombatTable;
    @FXML
    private TableColumn<?, ?> idCharTypeColumn;
    @FXML
    private TableColumn<?, ?> idCharNameColumn;
    @FXML
    private TableColumn<?, ?> idCharInitiativeColumn;
    @FXML
    private TextField idCombatOrder;
    @FXML
    private Button idAttackPhaseButton;
    @FXML
    private Button idFinishTurnButton;
    @FXML
    private Button idEndCombatButton;
    @FXML
    private Button idContinueButton;
    @FXML
    private Label idPointsUsedLabel;
    @FXML
    private TextField idActionPointsText;
    @FXML
    private Label idOpponentLabel;
    @FXML
    private TextField idOpponentText;
    @FXML
    private TextField idDiceValueText;
    @FXML
    private Label idDiceValueLabel;
    @FXML

    void continueTurn(ActionEvent event) {


    }

    @FXML
    void endCombat(ActionEvent event) {

    }

    @FXML
    void finishTurn(ActionEvent event) {

    }

    @FXML
    void initiativePhase(ActionEvent event) {

    }

}

