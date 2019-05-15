package Database;

import ActiveChars.Party;
import CharacterFile.Character;

public class DatabaseTest {
    private Party partyInstance = Party.getParty();
    private LoadCharacter charLoader;
    private SaveCharacter charSaver;
    private Character player;

    public void startProgram(){
        testLoadCharacter();
        testSaveCharacter();
    }

    private void testSaveCharacter(){
        charSaver = SaveCharacter.charSaver();
        charSaver.storeCharacters();
    }

    private void testLoadCharacter(){
        charLoader = LoadCharacter.charLoader();
        charLoader.loadCharacter(1);
        player = partyInstance.getCharacter(0);
        System.out.println(player.toString());
        charLoader.loadCharacter(2);
        player = partyInstance.getCharacter(1);
        System.out.println(player.toString());
    }

    public static void main(String[] args) {
        DatabaseTest myApp = new DatabaseTest();
        myApp.startProgram();
    }
}
