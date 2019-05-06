package ActiveChars;

import CharacterFile.Character;

import java.util.ArrayList;

public class Party {



    private static Party ourParty = null;

    public static Party getParty() {
        if (ourParty == null) {
            ourParty = new Party();
        }
        return ourParty;
    }


    ArrayList<Character> party;

    public int getArray() {
        return party.size();
    }

    private Party() {
        party = new ArrayList<Character>(6);
    }

    public void addCharacter(Character character){
        party.add(character);
    }

    public Character getCharacter(int i){
        return party.get(i);
    }

}
