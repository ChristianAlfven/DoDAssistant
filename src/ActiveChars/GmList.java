package ActiveChars;

import CharacterFile.Combatant;
import CharacterFile.Health;

import java.util.ArrayList;

public class GmList {
    private ArrayList<Combatant> gmList;
    private boolean playersAdded = false;

    private static GmList ourInstance = null;


    public static GmList createGmList() {
        if(ourInstance == null) {
            ourInstance = new GmList();
        }
        return ourInstance;
    }

    private GmList() {
        gmList = new ArrayList<Combatant>();
        createTestUnits();

    }

    public void addCombatant(Combatant combatant){
        gmList.add(combatant);
    }

    public Combatant getCombatant(int i){ return gmList.get(i); }

    public ArrayList<Combatant> getGmList(){
        return gmList;
    }

    public void setGmList(ArrayList<Combatant> gmList){
        this.gmList = gmList;
    }

    private void createTestUnits(){
        Health hp = new Health(25);
        Combatant orc = new Combatant("Orc1", 20, hp, false);
        gmList.add(orc);
        orc = new Combatant("Orc2", 20, hp, false);
        gmList.add(orc);
        orc = new Combatant("Orc3", 20, hp, false);
        gmList.add(orc);
    }

    public boolean isPlayersAdded() { return playersAdded; }

    public void setPlayersAdded(boolean playersAdded) { this.playersAdded = playersAdded; }
}
