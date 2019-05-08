package ActiveChars;

import CharacterFile.Character;

import java.util.ArrayList;

public class Party {

    int index;
    ArrayList<Character> party;
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


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
