package Lobby;

import ActiveChars.NPCList;
import ActiveChars.Party;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Lobby extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        Party party = Party.getParty();
        NPCList npcList = NPCList.createNPCList();


        Pane root = FXMLLoader.load(getClass().getResource("/Lobby/GUINewGame.fxml"));
        primaryStage.setTitle("Lobby");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
