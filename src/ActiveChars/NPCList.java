package ActiveChars;

import CharacterFile.NPC;

import java.util.ArrayList;

public class NPCList {
    ArrayList<NPC> npcList;

    private static NPCList ourInstance = null;

    public static NPCList createNPCList() {
        if(ourInstance == null) {
            ourInstance = new NPCList();
        }
        return ourInstance;
    }

    private NPCList() {
       npcList = new ArrayList<NPC>();
    }

    public void addNPC(NPC npc){
        npcList.add(npc);
    }

    public ArrayList<NPC> getNpcList(){
        return npcList;
    }
}
