package Game;

import ActiveChars.Party;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InspectCharacter implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("Skillset: " +Party.getParty().getCharacter(Party.getParty().getIndex()).getSkillset());
        System.out.println("Characteristics: " +Party.getParty().getCharacter(Party.getParty().getIndex()).getCharacteristics());
        System.out.println("Armor: " +Party.getParty().getCharacter(Party.getParty().getIndex()).getArmor());
        System.out.println("Raud: " +Party.getParty().getCharacter(Party.getParty().getIndex()).getRaud());

        idCharacter.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).toString()));
        idAgeText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getAge()));
        idHeightText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getHeight()));
        idWeightText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getWeight()));
        idEnvironmentText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getEnvironment()));
        idGenderText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getGender()));
        idSubRaceText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getSubrace()));
        idSpcTraitPlus1.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getPositiveTrait1()));
        idSpcTraitPlus2.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getPositiveTrait2()));
        idSpcTraitMinus.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getNegativeTrait()));
        idPointsTotalText.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getCombatPoints()));
        idBackground.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getBackground()));
        idSkillset.setText(String.valueOf(Party.getParty().getCharacter(Party.getParty().getIndex()).getSkillset()));

    }

    @FXML
    private TextField idSkillset;

    @FXML
    private TextArea idBackground;

    @FXML
    private TextField idCharacter;

    @FXML
    private TextField idEnvironmentText;

    @FXML
    private TextField idGenderText;

    @FXML
    private TextField idSpcTraitPlus1;

    @FXML
    private TextField idSpcTraitPlus2;

    @FXML
    private TextField idSpcTraitMinus;

    @FXML
    private TextField idHeightText;

    @FXML
    private TextField idAgeText;

    @FXML
    private TextField idWeightText;

    @FXML
    private TextField idPointsUsedText;

    @FXML
    private TextField idSubRaceText;

    @FXML
    private TextField idPointsTotalText;

    @FXML
    private Button idClose;

    @FXML
    void buttonClose(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
