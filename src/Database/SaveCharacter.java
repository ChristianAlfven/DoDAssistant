package Database;

import ActiveChars.Party;
import CharacterFile.Character;
import CharacterFile.Health;
import CharacterFile.Armor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveCharacter {

    private DB_Connector connector = new DB_Connector();
    private Party partyInstance = Party.getParty();
    private ArrayList<Character> partyList;
    private Character player;
    private int index;


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
            System.out.println("error on executing the query");
        }
    }

    private void storeCharacter(Character player){
        String queryC = queryCharacter(player);
        String queryE = queryExperience(player);
        String queryH = queryHealth(player);
        String queryT = queryTraits(player);
        String queryS = querySkills(player);

        storeData(queryC);
        storeData(queryE);
        storeData(queryH);
        storeData(queryT);
        //storeData(queryS);

    }

    private void storeData(String query){
        try {
            connector.statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("error on executing the query");
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
                //" background," +
                //" characteristics," +
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
                //", '"+player.getBackground()+
                //"', '"+player.getCharacteristics()+ "', " +
                ", "+player.getRaud()+
                ", "+player.getMovement()+
                ", '"+player.getReligion()+"');";
        System.out.println(query);
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
        System.out.println(query);
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
        System.out.println(query);
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
        System.out.println(query);
        return query;
    }

    private String querySkills(Character player){
        String query = "" +
                " INSERT INTO character_has_skill(" +
                " character_has_skill.charId," +
                " character_has_skill.skillId," +
                " value)" +
                " VALUES" +
                " ("+player.getDbCharId()+", 1, 0)," +
                " ("+player.getDbCharId()+", 2, 0)," +
                " ("+player.getDbCharId()+", 3, 16)," +
                " ("+player.getDbCharId()+", 4, 0)," +
                " ("+player.getDbCharId()+", 5, 6)," +
                " ("+player.getDbCharId()+", 6, 18)," +
                " ("+player.getDbCharId()+", 7, 4)," +
                " ("+player.getDbCharId()+", 8, 3)," +
                " ("+player.getDbCharId()+", 9, 5)," +
                " ("+player.getDbCharId()+", 10, 3)," +
                " ("+player.getDbCharId()+", 11, 6)," +
                " ("+player.getDbCharId()+", 12, 0)," +
                " ("+player.getDbCharId()+", 13, 6)," +
                " ("+player.getDbCharId()+", 14, 0)," +
                " ("+player.getDbCharId()+", 15, 8)," +
                " ("+player.getDbCharId()+", 16, 12)," +
                " ("+player.getDbCharId()+", 17, 0)," +
                " ("+player.getDbCharId()+", 18, 0)," +
                " ("+player.getDbCharId()+", 19, 6)," +
                " ("+player.getDbCharId()+", 20, 0)," +
                " ("+player.getDbCharId()+", 21, 20)," +
                " ("+player.getDbCharId()+", 22, 8)," +
                " ("+player.getDbCharId()+", 23, 3)," +
                " ("+player.getDbCharId()+", 24, 1)," +
                " ("+player.getDbCharId()+", 25, 5),";
        System.out.println(query);
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
            System.out.println("error on executing the query");
        }
        return false;
    }
}
