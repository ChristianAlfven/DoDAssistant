package ActiveChars;

import CharacterFile.Character;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Party {

    ObservableList<Integer> index;
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

    public Character getCharacter(int i){
        return party.get(i);
    }


    public void setIndex(ObservableList<Integer> index) {
        this.index = index;
    }

    public int getIndex() {
        return Integer.parseInt(String.valueOf(index));
    }

}
