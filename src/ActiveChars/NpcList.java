package ActiveChars;

import CharacterFile.Combatant;

import java.util.ArrayList;

public class NpcList {
    ArrayList<Combatant> combatantList;

    private static NpcList ourInstance = null;

    public static NpcList getNpcList() {
        if(ourInstance == null) {
            ourInstance = new NpcList();
        }
        return ourInstance;
    }

    private NpcList() {
       combatantList = new ArrayList<Combatant>();
    }

    public void addNPC(Combatant combatant){
        combatantList.add(combatant);
    }

    public Combatant getNpc(int i){ return combatantList.get(i); }
}
