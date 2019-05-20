package Database;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Health;
import CharacterFile.Armor;
import CharacterFile.Skillset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveCharacter {

    private DB_Connector connector = new DB_Connector();
    private Party partyInstance = Party.getParty();
    private ArrayList<Character> partyList;
    private Character player;
    private int index;
    private Skillset skills;


    private static SaveCharacter ourInstance = null;

    public static SaveCharacter charSaver() {
        if(ourInstance == null) {
            ourInstance = new SaveCharacter();
        }
        return ourInstance;
    }

    public void storeCharacters(){
        index = 0;
        partyList = partyInstance.getPartyList();

        while(index < partyList.size()){
            player = partyList.get(index);
            skills = player.getSkillset();
            if (characterExists(player.getDbCharId())){
                deleteCharacter(player.getDbCharId());
                storeCharacter(player);
            }else{
                storeCharacter(player);
            }
            index++;
        }
    }

    private void deleteCharacter(int dbCharId){
        String deleteSkills = "character_has_skill";
        String deleteHealth = "character_has_health";
        String deleteTraits = "character_has_trait";
        String deleteExperience = "experience";
        String deleteCharacter = "`character`";

        deleteTable(deleteSkills, dbCharId);
        deleteTable(deleteHealth, dbCharId);
        deleteTable(deleteTraits, dbCharId);
        deleteTable(deleteExperience, dbCharId);
        deleteTable(deleteCharacter, dbCharId);
    }

    private void deleteTable(String query, int dbCharId){
        try {
            connector.statement.execute(String.format("" +
                    " DELETE FROM "+query+"" +
                    " where charId = "+dbCharId+";"));
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Save - deleteTable)");
        }
    }

    private void storeCharacter(Character player){
        String queryC = queryCharacter(player);
        String queryE = queryExperience(player);
        String queryH = queryHealth(player);
        String queryT = queryTraits(player);
        String queryS = querySkills(player, skills);

        storeData(queryC);
        storeData(queryE);
        storeData(queryH);
        storeData(queryT);
        storeData(queryS);

    }

    private void storeData(String query){
        try {
            connector.statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Save - storeData: "+query);
        }
    }

    private String queryCharacter(Character player){
        String query = "" +
                " INSERT INTO `character` (" +
                " charId," +
                " player," +
                " name," +
                " profession," +
                " gender," +
                " race," +
                " subRace," +
                " weaponhand," +
                " nationality," +
                " environment," +
                " region," +
                " height," +
                " weight," +
                " age," +
                " combatPoints," +
                " background," +
                " characteristics," +
                " raud," +
                " movement," +
                " religion)" +
                " VALUES" +
                "("+player.getDbCharId()+
                ", '"+player.getPlayerName()+
                "', '"+player.getName()+
                "', '"+player.getProfession()+
                "', '"+player.getGender()+
                "', '"+player.getRace()+
                "', '"+player.getSubrace()+
                "', '"+player.getWeaponHand()+
                "', '"+player.getNationality()+
                "', '"+player.getEnvironment()+
                "', '"+player.getRegion()+
                "', "+player.getHeight()+
                ", "+player.getWeight()+
                ", "+player.getAge()+
                ", "+player.getCombatPoints()+
                ", '"+player.getBackground()+ "" +
                "', '"+player.getCharacteristics()+ "" +
                "', "+player.getRaud()+
                ", "+player.getMovement()+
                ", '"+player.getReligion()+"');";
        //System.out.println(query);
        return query;
    }

    private String queryExperience(Character player){
        String query = "" +
                " INSERT INTO experience (" +
                " charId," +
                " total," +
                " unused)" +
                " VALUES" +
                " ("+player.getDbCharId()+
                ", "+player.getTotalExp()+
                ", "+player.getUnusedExp()+");";
        //System.out.println(query);
        return query;
    }

    private String queryHealth(Character player){
        Health hp = player.getHealth();
        Armor armor = player.getArmor();
        String query = "" +
                " INSERT INTO character_has_health (" +
                " character_has_health.charId," +
                " character_has_health.bodypart," +
                " current," +
                " maximum," +
                " armor)" +
                " VALUES" +
                " ("+player.getDbCharId()+",'Total', "+hp.getTotal()+", "+hp.getMaxTotal()+", "+armor.getTotal()+")," +
                " ("+player.getDbCharId()+",'Head', "+hp.getHead()+", "+hp.getMaxHead()+", "+armor.getHead()+")," +
                " ("+player.getDbCharId()+",'RightArm', "+hp.getRightArm()+", "+hp.getMaxRightArm()+", "+armor.getRightArm()+")," +
                " ("+player.getDbCharId()+",'LeftArm', "+hp.getLeftArm()+", "+hp.getMaxLeftArm()+", "+armor.getLeftArm()+")," +
                " ("+player.getDbCharId()+",'Chest', "+hp.getChest()+", "+hp.getMaxChest()+", "+armor.getChest()+")," +
                " ("+player.getDbCharId()+",'Stomach', "+hp.getStomach()+", "+hp.getMaxStomach()+", "+armor.getStomach()+")," +
                " ("+player.getDbCharId()+",'RightLeg', "+hp.getRightLeg()+", "+hp.getMaxRightLeg()+", "+armor.getRightLeg()+")," +
                " ("+player.getDbCharId()+",'LeftLeg', "+hp.getLeftLeg()+", "+hp.getMaxLeftLeg()+", "+armor.getLeftLeg()+");";
        //System.out.println(query);
        return query;
    }

    private String queryTraits(Character player){
        String query = "" +
                " INSERT INTO character_has_trait (" +
                " character_has_trait.charId," +
                " character_has_trait.traitId," +
                " value)" +
                " VALUES" +
                " ("+player.getDbCharId()+", '"+player.getPositiveTrait1()+"', "+player.getPosTrait1Level()+")," +
                " ("+player.getDbCharId()+", '"+player.getPositiveTrait2()+"', "+player.getPosTrait2Level()+")," +
                " ("+player.getDbCharId()+", '"+player.getNegativeTrait()+"', "+player.getNegTraitLevel()+");";
        //System.out.println(query);
        return query;
    }

    private String querySkills(Character player, Skillset skills){
        String query = "" +
                " INSERT INTO character_has_skill(" +
                " character_has_skill.charId," +
                " character_has_skill.skillId," +
                " value)" +
                " VALUES" +
                " ("+player.getDbCharId()+", 1, "+skills.getAlchemy().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 2, "+skills.getCombat().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 3, "+skills.getCrafting().getMetal()+")," +
                " ("+player.getDbCharId()+", 4, "+skills.getCrafting().getSoft()+")," +
                " ("+player.getDbCharId()+", 5, "+skills.getCrafting().getStone()+")," +
                " ("+player.getDbCharId()+", 6, "+skills.getCrafting().getWood()+")," +
                " ("+player.getDbCharId()+", 7, "+skills.getCrime().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 8, "+skills.getCulture().getElvish()+")," +
                " ("+player.getDbCharId()+", 9, "+skills.getCulture().getDwarfish()+")," +
                " ("+player.getDbCharId()+", 10, "+skills.getCulture().getWestlands()+")," +
                " ("+player.getDbCharId()+", 11, "+skills.getCulture().getMidlands()+")," +
                " ("+player.getDbCharId()+", 12, "+skills.getCulture().getEastheim()+")," +
                " ("+player.getDbCharId()+", 13, "+skills.getCulture().getOrcish()+")," +
                " ("+player.getDbCharId()+", 14, "+skills.getEntertainment().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 15, "+skills.getGeography().getWestland()+")," +
                " ("+player.getDbCharId()+", 16, "+skills.getGeography().getMidland()+")," +
                " ("+player.getDbCharId()+", 17, "+skills.getGeography().getEastheim()+")," +
                " ("+player.getDbCharId()+", 18, "+skills.getGeography().getSoj()+")," +
                " ("+player.getDbCharId()+", 19, "+skills.getGeography().getNhoordland()+")," +
                " ("+player.getDbCharId()+", 20, "+skills.getGeography().getUnderworld()+")," +
                " ("+player.getDbCharId()+", 21, "+skills.getHunting().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 22, "+skills.getJester().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 23, "+skills.getManagement().getFarm()+")," +
                " ("+player.getDbCharId()+", 24, "+skills.getManagement().getCity()+")," +
                " ("+player.getDbCharId()+", 25, "+skills.getManagement().getWar()+")," +
                " ("+player.getDbCharId()+", 26, "+skills.getMedicine().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 27, "+skills.getMobility().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 28, "+skills.getNature().getWestlands()+")," +
                " ("+player.getDbCharId()+", 29, "+skills.getNature().getMidlands()+")," +
                " ("+player.getDbCharId()+", 30, "+skills.getNature().getEastheim()+")," +
                " ("+player.getDbCharId()+", 31, "+skills.getNature().getSoj()+")," +
                " ("+player.getDbCharId()+", 32, "+skills.getNature().getNhordlands()+")," +
                " ("+player.getDbCharId()+", 33, "+skills.getNature().getUnderworld()+")," +
                " ("+player.getDbCharId()+", 34, "+skills.getReligion().getGerbanis()+")," +
                " ("+player.getDbCharId()+", 35, "+skills.getReligion().getOstroseden()+")," +
                " ("+player.getDbCharId()+", 36, "+skills.getReligion().getNidendomen()+")," +
                " ("+player.getDbCharId()+", 37, "+skills.getReligion().getHamingjes()+")," +
                " ("+player.getDbCharId()+", 38, "+skills.getReligion().getThuldom()+")," +
                " ("+player.getDbCharId()+", 39, "+skills.getRiding().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 40, "+skills.getSeafaring().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 41, "+skills.getSpeech().getVrok()+")," +
                " ("+player.getDbCharId()+", 42, "+skills.getSpeech().getRona()+")," +
                " ("+player.getDbCharId()+", 43, "+skills.getSpeech().getEika()+")," +
                " ("+player.getDbCharId()+", 44, "+skills.getSpeech().getFuthark()+")," +
                " ("+player.getDbCharId()+", 45, "+skills.getSpeech().getOrcish()+")," +
                " ("+player.getDbCharId()+", 46, "+skills.getSpellcasting().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 47, "+skills.getSurvival().getSkillLevel()+")," +
                " ("+player.getDbCharId()+", 48, "+skills.getTrade().getSkillLevel()+");";
        //System.out.println(query);
        return query;
    }

    private boolean characterExists(int dbCharId){
        String searchScript = String.format("" +
                " SELECT charId" +
                " FROM `character`" +
                " WHERE charId = "+dbCharId+";");

        try {
            ResultSet rs = connector.statement.executeQuery(searchScript);
            while(rs.next()){
                if (rs.getInt(1) == dbCharId){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Save - characterExists)");
        }
        return false;
    }
}
