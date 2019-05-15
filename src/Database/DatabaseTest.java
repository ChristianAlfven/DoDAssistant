package Database;

import ActiveChars.Party;
import CharacterFile.Character;

public class DatabaseTest {
    private Party partyInstance = Party.getParty();
    private LoadCharacter charLoader;
    private Character player;

    public void startProgram(){
        charLoader = LoadCharacter.charLoader();
        charLoader.loadCharacter(1);
        player = partyInstance.getCharacter(0);
        System.out.println(player.toString());
    }

    public static void main(String[] args) {
        DatabaseTest myApp = new DatabaseTest();
        myApp.startProgram();
    }
}
