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

    public boolean isPlayersAdded() { return playersAdded; }

    public void setPlayersAdded(boolean playersAdded) { this.playersAdded = playersAdded; }
}
