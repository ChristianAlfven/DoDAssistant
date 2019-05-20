package ActiveChars;

import CharacterFile.Character;

import java.util.ArrayList;

public class Party {

    private int index;
    private int nextCharId;
    private ArrayList<Character> party;
    private static Party ourParty = null;

    public static Party getParty() {
        if (ourParty == null) {
            ourParty = new Party();
        }
        return ourParty;
    }

    public int getArray() {
        return party.size();
    }

    private Party() {
        party = new ArrayList<Character>(6);
    }

    public void addCharacter(Character character){
        party.add(character);
    }

    public void removeCharacter(int character) {
        party.remove(character);
    }

    public Character getCharacter(int i){
        return party.get(i);
    }

    public Character getLastCharacter() { return party.get(party.size()-1);}

    public void setPartyList(ArrayList<Character> party) { this.party = party; }

    public ArrayList<Character> getPartyList(){ return party; }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getNextCharId() {
        return nextCharId;
    }

    public void setNextCharId(int nextCharId) {
        this.nextCharId = nextCharId;
    }
}
