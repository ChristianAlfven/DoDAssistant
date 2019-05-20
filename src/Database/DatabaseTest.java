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
    }

    public static void main(String[] args) {
        DatabaseTest myApp = new DatabaseTest();
        myApp.startProgram();
    }


    void loadSkills(){
        /*
        alchemy = character.getSkillset().getAlchemy().getSkillLevel();
        combat = character.getSkillset().getCombat().getSkillLevel();
        metal = character.getSkillset().getCrafting().getMetal();
        soft = character.getSkillset().getCrafting().getSoft();
        stone = character.getSkillset().getCrafting().getStone();
        wood = character.getSkillset().getCrafting().getWood();
        crime = character.getSkillset().getCrime().getSkillLevel();
        cultDwarfish = character.getSkillset().getCulture().getDwarfish();
        cultEastheim = character.getSkillset().getCulture().getEastheim();
        cultElvish = character.getSkillset().getCulture().getElvish();
        cultMidlands = character.getSkillset().getCulture().getMidlands();
        cultWestlands = character.getSkillset().getCulture().getWestlands();
        cultOrcish = character.getSkillset().getCulture().getOrcish();
        entertainment = character.getSkillset().getEntertainment().getSkillLevel();
        geoEastheim = character.getSkillset().getGeography().getEastheim();
        geoMidlands = character.getSkillset().getGeography().getMidlands();
        geoNhordlands = character.getSkillset().getGeography().getNhoordland();
        geoSoj = character.getSkillset().getGeography().getSoj();
        geoUnderworld = character.getSkillset().getGeography().getUnderworld();
        geoWestlands = character.getSkillset().getGeography().getWestland();
        hunting = character.getSkillset().getHunting().getSkillLevel();
        jester = character.getSkillset().getJester().getSkillLevel();
        manCity = character.getSkillset().getManagement().getCity();
        manFarm = character.getSkillset().getManagement().getFarm();
        manWar = character.getSkillset().getManagement().getWar();
        medicine = character.getSkillset().getMedicine().getSkillLevel();
        mobility = character.getSkillset().getMobility().getSkillLevel();
        natEastheim = character.getSkillset().getNature().getEastheim();
        natMidlands = character.getSkillset().getNature().getMidlands();
        natNhordlands = character.getSkillset().getNature().getNhordlands();
        natSoj = character.getSkillset().getNature().getSoj();
        natUnderworld = character.getSkillset().getNature().getUnderworld();
        natWestlands = character.getSkillset().getNature().getWestlands();
        religion = character.getSkillset().getReligion().getMain();
        riding = character.getSkillset().getRiding().getSkillLevel();
        seafaring = character.getSkillset().getSeafaring().getSkillLevel();
        spellcasting = character.getSkillset().getSpellcasting().getSkillLevel();
        survival = character.getSkillset().getSurvival().getSkillLevel();
        trade = character.getSkillset().getTrade().getSkillLevel();
        vrok = character.getSkillset().getSpeech().getVrok();
        rona = character.getSkillset().getSpeech().getRona();
        futhark = character.getSkillset().getSpeech().getFuthark();
        eika = character.getSkillset().getSpeech().getEika();
        orcish = character.getSkillset().getSpeech().getOrcish();
*/
    }
}
