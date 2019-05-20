package Database;

import ActiveChars.Party;
import CharacterFile.*;
import CharacterFile.Character;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadCharacter {
    private DB_Connector connector = new DB_Connector();
    private Party partyInstance = Party.getParty();
    private Character player;

    // Character table
    private int dbCharId;
    private String playerName;
    private String name;
    private Character.Profession profession;
    private Character.Gender gender;
    private Character.Race race;
    private Character.SubRace subrace;
    private Character.WeaponHand weaponHand;
    private Character.Nationality nationality;
    private Character.Environment environment;
    private Character.Region region;
    private int height;
    private int weight;
    private int age;
    private int combatPoints;
    private String background;
    //private String characteristics;
    private int raud;
    private int movement;
    private String religion;

    // Trait table
    private Character.SpecialTrait trait1;
    private Character.SpecialTrait trait2;
    private Character.SpecialTrait trait3;
    private int trait1Value;
    private int trait2Value;
    private int trait3Value;

    // Experience table
    private int totalExp;
    private int unusedExp;

    // Health & Armor table
    private enum BODYPART{Total, Head, RightArm, LeftArm, Chest, Stomach, RightLeg, LeftLeg}
    private BODYPART bodypart;
    private Health hp;
    private Armor armor;

    // Skills table
    private Skillset skills;

    // MySQL script
    private String scriptBackpack;
    private String scriptCharacter;
    private String scriptHealthArmor;
    private String scriptSkills;
    private String scriptTraits;
    private String scriptExperience;


    private static LoadCharacter ourInstance = null;

    public static LoadCharacter charLoader() {
        if(ourInstance == null) {
            ourInstance = new LoadCharacter();
        }
        return ourInstance;
    }

    public void loadCharacter(int index){
        player = new Character();
        hp = new Health(0);
        armor = new Armor();
        skills = new Skillset();
        writeScripts(index);
        getValues();
        setValues();

        partyInstance.addCharacter(player);
    }

    private void writeScripts(int index){
        scriptCharacter = String.format("SELECT * FROM `character` WHERE charId = "+index+";");

        scriptHealthArmor = String.format("SELECT * FROM character_has_health WHERE charId = "+index+";");

        scriptExperience = String.format("SELECT * FROM experience WHERE charId = "+index+";");

        scriptSkills = String.format("" +
                " SELECT skill.name, character_has_skill.value" +
                " FROM `character`" +
                " JOIN character_has_skill" +
                " ON `character`.charId = character_has_skill.charId" +
                " JOIN skill" +
                " ON character_has_skill.skillId=skill.skillId" +
                " WHERE `character`.charId = "+index+";");

        scriptTraits = String.format("" +
                " SELECT trait.traitId, character_has_trait.value" +
                " FROM `character`" +
                " JOIN character_has_trait" +
                " ON `character`.charId = character_has_trait.charId" +
                " JOIN trait" +
                " ON character_has_trait.traitId = trait.traitId" +
                " WHERE `character`.charId = "+index+"" +
                " ORDER BY character_has_trait.value DESC;");

    }

    private void getValues(){
        loadPlayerCharacterTable();
        loadPlayerExperienceTable();
        loadPlayerHealthArmorTable();
        loadPlayerTraitTable();
        loadPlayerSkillsTable();
    }

    private void loadPlayerCharacterTable() {
        try {
            ResultSet rs = connector.statement.executeQuery(scriptCharacter);
            while(rs.next()) {
                dbCharId = rs.getInt(1);
                playerName = rs.getString(2);
                name = rs.getString(3);
                profession = Character.Profession.valueOf(rs.getString(4));
                gender = Character.Gender.valueOf(rs.getString(5));
                race = Character.Race.valueOf(rs.getString(6));
                subrace = Character.SubRace.valueOf(rs.getString(7));
                weaponHand = Character.WeaponHand.valueOf(rs.getString(8));
                nationality = Character.Nationality.valueOf(rs.getString(9));
                environment = Character.Environment.valueOf(rs.getString(10));
                region = Character.Region.valueOf(rs.getString(11));
                height = rs.getInt(12);
                weight = rs.getInt(13);
                age = rs.getInt(14);
                combatPoints = rs.getInt(15);
                background = rs.getString(16);
                //characteristics = rs.getString(17);
                raud = rs.getInt(18);
                movement = rs.getInt(19);
                religion = rs.getString(20);
            }

        } catch (SQLException ex) {
            System.out.println("error on executing the query (Load - loadPlayerCharacterTable)");
        }
    }

    private void loadPlayerExperienceTable(){
        try {
            ResultSet rs = connector.statement.executeQuery(scriptExperience);
            while(rs.next()){
                totalExp = rs.getInt(2);
                unusedExp = rs.getInt(3);
            }
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Load - loadPlayerExperienceTable)");
        }
    }

    private void loadPlayerHealthArmorTable(){
        try {
            ResultSet rs = connector.statement.executeQuery(scriptHealthArmor);
            while (rs.next()){
                bodypart = BODYPART.valueOf(rs.getString(2));
                switch (bodypart){
                    case Total:
                        hp.setTotal(rs.getInt(3));
                        hp.setMaxTotal(rs.getInt(4));
                        break;
                    case Head:
                        hp.setHead(rs.getInt(3));
                        hp.setMaxHead(rs.getInt(4));
                        armor.setHead(rs.getInt(5));
                        break;
                    case RightArm:
                        hp.setRightArm(rs.getInt(3));
                        hp.setMaxRightArm(rs.getInt(4));
                        armor.setRightArm(rs.getInt(5));
                        break;
                    case LeftArm:
                        hp.setLeftArm(rs.getInt(3));
                        hp.setMaxLeftArm(rs.getInt(4));
                        armor.setLeftArm(rs.getInt(5));
                        break;
                    case Chest:
                        hp.setChest(rs.getInt(3));
                        hp.setMaxChest(rs.getInt(4));
                        armor.setChest(rs.getInt(5));
                        break;
                    case Stomach:
                        hp.setStomach(rs.getInt(3));
                        hp.setMaxStomach(rs.getInt(4));
                        armor.setStomach(rs.getInt(5));
                        break;
                    case RightLeg:
                        hp.setRightLeg(rs.getInt(3));
                        hp.setMaxRightLeg(rs.getInt(4));
                        armor.setRightLeg(rs.getInt(5));
                        break;
                    case LeftLeg:
                        hp.setLeftLeg(rs.getInt(3));
                        hp.setMaxLeftLeg(rs.getInt(4));
                        armor.setLeftLeg(rs.getInt(5));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Load - loadPlayerHealthArmorTable)");
        }
    }

    private void loadPlayerSkillsTable(){
        try {
            ResultSet rs = connector.statement.executeQuery(scriptSkills);
            rs.next(); skills.getAlchemy().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getCombat().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getCrafting().addMetal(rs.getInt(2));
            rs.next(); skills.getCrafting().addSoft(rs.getInt(2));
            rs.next(); skills.getCrafting().addStone(rs.getInt(2));
            rs.next(); skills.getCrafting().addWood(rs.getInt(2));
            rs.next(); skills.getCrime().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getCulture().addElvish(rs.getInt(2));
            rs.next(); skills.getCulture().addDwarfish(rs.getInt(2));
            rs.next(); skills.getCulture().addWestlands(rs.getInt(2));
            rs.next(); skills.getCulture().addMidlands(rs.getInt(2));
            rs.next(); skills.getCulture().addEastheim(rs.getInt(2));
            rs.next(); skills.getCulture().addOrcish(rs.getInt(2));
            rs.next(); skills.getEntertainment().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getGeography().addWestland(rs.getInt(2));
            rs.next(); skills.getGeography().addMidlands(rs.getInt(2));
            rs.next(); skills.getGeography().addEastheim(rs.getInt(2));
            rs.next(); skills.getGeography().addSoj(rs.getInt(2));
            rs.next(); skills.getGeography().addNhoordland(rs.getInt(2));
            rs.next(); skills.getGeography().addUnderworld(rs.getInt(2));
            rs.next(); skills.getHunting().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getJester().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getManagement().addFarm(rs.getInt(2));
            rs.next(); skills.getManagement().addCity(rs.getInt(2));
            rs.next(); skills.getManagement().addWar(rs.getInt(2));
            rs.next(); skills.getMedicine().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getMobility().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getNature().addWestlands(rs.getInt(2));
            rs.next(); skills.getNature().addMidlands(rs.getInt(2));
            rs.next(); skills.getNature().addEastheim(rs.getInt(2));
            rs.next(); skills.getNature().addSoj(rs.getInt(2));
            rs.next(); skills.getNature().addNhordlands(rs.getInt(2));
            rs.next(); skills.getNature().addUnderworld(rs.getInt(2));
            rs.next(); skills.getReligion().addGerbanis(rs.getInt(2));
            rs.next(); skills.getReligion().addOstroseden(rs.getInt(2));
            rs.next(); skills.getReligion().addNidendomen(rs.getInt(2));
            rs.next(); skills.getReligion().addHamingjes(rs.getInt(2));
            rs.next(); skills.getReligion().addThuldom(rs.getInt(2));
            rs.next(); skills.getRiding().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getSeafaring().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getSpeech().addVrok(rs.getInt(2));
            rs.next(); skills.getSpeech().addRona(rs.getInt(2));
            rs.next(); skills.getSpeech().addEika(rs.getInt(2));
            rs.next(); skills.getSpeech().addFuthark(rs.getInt(2));
            rs.next(); skills.getSpeech().addOrcish(rs.getInt(2));
            rs.next(); skills.getSpellcasting().addSkillLevel(rs.getInt(2));
            rs.next(); skills.getSurvival().setSkillLevel(rs.getInt(2));
            rs.next(); skills.getTrade().setSkillLevel(rs.getInt(2));
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Load - loadPlayerSkillsTable)");
        }
    }

    private void loadPlayerTraitTable(){
        int traitIndex = 1;
        try {
            ResultSet rs = connector.statement.executeQuery(scriptTraits);
            while(rs.next()){
                switch(traitIndex){
                    case 1:
                        trait1 = Character.SpecialTrait.valueOf(rs.getString(1));
                        trait1Value = rs.getInt(2);
                        break;
                    case 2:
                        trait2 = Character.SpecialTrait.valueOf(rs.getString(1));
                        trait2Value = rs.getInt(2);
                        break;
                    case 3:
                        trait3 = Character.SpecialTrait.valueOf(rs.getString(1));
                        trait3Value = rs.getInt(2);
                        break;
                }
                traitIndex++;
            }
        } catch (SQLException ex) {
            System.out.println("error on executing the query (Load - loadPlayerTraitTable)");
        }
    }

    private void setValues() {

        //Set Character values
        player.setDbCharId(dbCharId);
        player.setPlayerName(playerName);
        player.setName(name);
        player.setProfession(profession);
        player.setGender(gender);
        player.setRace(race);
        player.setSubrace(subrace);
        player.setWeaponHand(weaponHand);
        player.setNationality(nationality);
        player.setEnvironment(environment);
        player.setRegion(region);
        player.setHeight(height);
        player.setWeight(weight);
        player.setAge(age);
        player.setCombatPoints(combatPoints);
        player.setBackground(background);
        //player.setCharacteristics(characteristics);
        player.setRaud(raud);
        player.setMovement(movement);
        player.setReligion(religion);


        //Set Health & Armor values
        player.setHealth(hp);
        player.setArmor(armor);


        //Set Experience values
        player.setTotalExp(totalExp);
        player.setUnusedExp(unusedExp);


        //Set Trait values
        player.setPositiveTrait1(trait1);
        player.setPosTrait1Level(trait1Value);
        player.setPositiveTrait2(trait2);
        player.setPosTrait2Level(trait2Value);
        player.setNegativeTrait(trait3);
        player.setNegTraitLevel(trait3Value);


        //Set Skill values
        player.setSkillset(skills);
    }
}
