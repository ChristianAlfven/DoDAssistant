package Creator;

import ActiveChars.GmList;
import CharacterFile.Armor;
import CharacterFile.Combatant;
import CharacterFile.Health;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CombatantCreation {
    Stage stage;
    Parent root;
    private GmList gmInstance;

    private String name;
    private String race;
    private int combatPoints;
    private int damageBonus;
    private Health health;
    private Armor armor;
    private int initiative;
    private boolean isPlayer;
    private Combatant combatant;


    @FXML private Button idConfirmButton;
    @FXML private Button idBackButton;
    @FXML private TextField idHealthTotal;
    @FXML private TextField idArmorHead;
    @FXML private TextField idArmorRightArm;
    @FXML private TextField idArmorLeftArm;
    @FXML private TextField idArmorChest;
    @FXML private TextField idArmorStomach;
    @FXML private TextField idArmorRightLeg;
    @FXML private TextField idArmorLeftLeg;
    @FXML private TextField idNameText;
    @FXML private TextField idRaceText;
    @FXML private TextField idCombatPointText;
    @FXML private TextField idDamageBonusText;

    @FXML
    public void initialize() {
        gmInstance = GmList.createGmList();
    }

    @FXML
    void buttonBack(ActionEvent event) throws IOException {
        stage = (Stage) idBackButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createCombatant(ActionEvent event) throws IOException {
        name = idNameText.getText();
        combatPoints = Integer.parseInt(idCombatPointText.getText());
        health = new Health(Integer.parseInt(idHealthTotal.getText()));

        race = idRaceText.getText();
        damageBonus = Integer.parseInt(idDamageBonusText.getText());
        armor = combatantArmor();

        combatant = new Combatant(name, combatPoints, health, false);
        combatant.setRace(race);
        combatant.setDamageBonus(damageBonus);
        combatant.setArmor(armor);

        gmInstance.addCombatant(combatant);

        stage = (Stage) idBackButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private Armor combatantArmor(){
        armor = new Armor();
        armor.setHead(Integer.parseInt(idArmorHead.getText()));
        armor.setRightArm(Integer.parseInt(idArmorRightArm.getText()));
        armor.setLeftArm(Integer.parseInt(idArmorLeftArm.getText()));
        armor.setChest(Integer.parseInt(idArmorChest.getText()));
        armor.setStomach(Integer.parseInt(idArmorStomach.getText()));
        armor.setRightLeg(Integer.parseInt(idArmorRightLeg.getText()));
        armor.setLeftLeg(Integer.parseInt(idArmorLeftLeg.getText()));

        return armor;
    }
}

