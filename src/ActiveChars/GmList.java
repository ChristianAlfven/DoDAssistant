package ActiveChars;

import CharacterFile.Combatant;

import java.util.ArrayList;

public class GmList {
    ArrayList<Combatant> gmList;

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
        Combatant orc = new Combatant("Orc1", 20, 25);
        gmList.add(orc);
        orc = new Combatant("Orc2", 20, 25);
        gmList.add(orc);
        orc = new Combatant("Orc3", 20, 25);
        gmList.add(orc);
    }
}
