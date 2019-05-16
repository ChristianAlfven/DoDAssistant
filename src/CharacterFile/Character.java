package CharacterFile;

public class Character {

    public enum Profession {Warrior, Peasant, Mage, Rogue, Priest, Bard, Scholar}
    public enum Gender {Male, Female}
    public enum Race {Human, Elf, Dwarf, HalfBlood}
    public enum SubRace {Stormlander, Midlander, Virann, Illmalaina, Korpikalla, Buratja, Borjornikka, Zvorda, HalfOrc, HalfElf}
    public enum WeaponHand {Right, Left, Dual}
    public enum Nationality {Human, Orc, Elf, Dwarf}
    public enum Environment{Nature, Country, City, Academic}
    public enum Region {Eastheim, Midlands, Westlands}
    public enum SpecialTrait{Strength, Physique, Agility, Spirituality, Intelligence, Psyche, Charisma}


    Health health;
    Armor armor;
    Skillset skillset = new Skillset();
    //Inventory inventory;

    private Region region;
    private Profession profession;
    private Gender gender;
    private Race race;
    private SubRace subrace;
    private WeaponHand weaponHand;
    private Nationality nationality;
    private Environment environment;
    private SpecialTrait positiveTrait1;
    private SpecialTrait positiveTrait2;
    private SpecialTrait negativeTrait;
    private int posTrait1Level;
    private int PosTrait2Level;
    private int negTraitLevel;


    private int dbCharId;
    private String playerName;
    private String name;
    private int height;
    private int weight;
    private int age;
    private int combatPoints;
    private String background = null;
    private String Characteristics = null;
    private int raud;
    private int totalExp;
    private int unusedExp;
    private int movement;
    private String religion;


    public int getDbCharId() {
        return dbCharId;
    }

    public void setDbCharId(int dbCharId) {
        this.dbCharId = dbCharId;
    }

    public Skillset getSkillset() {
        return skillset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void constructHealth(int hp){this.health = new Health(hp);}

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public SubRace getSubrace() {
        return subrace;
    }

    public void setSubrace(SubRace subrace) {
        this.subrace = subrace;
    }

    public WeaponHand getWeaponHand() {
        return weaponHand;
    }

    public void setWeaponHand(WeaponHand weaponHand) {
        this.weaponHand = weaponHand;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCombatPoints() {
        return combatPoints;
    }

    public void setCombatPoints(int combatPoints) {
        this.combatPoints = combatPoints;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCharacteristics() {
        return Characteristics;
    }

    public void setCharacteristics(String characteristics) {
        Characteristics = characteristics;
    }

    public int getRaud() {
        return raud;
    }

    public void setRaud(int raud) {
        this.raud = raud;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public int getUnusedExp() {
        return unusedExp;
    }

    public void setUnusedExp(int unusedExp) {
        this.unusedExp = unusedExp;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public SpecialTrait getPositiveTrait1() {
        return positiveTrait1;
    }

    public void setPositiveTrait1(SpecialTrait positiveTrait1) {
        this.positiveTrait1 = positiveTrait1;
    }

    public SpecialTrait getPositiveTrait2() {
        return positiveTrait2;
    }

    public void setPositiveTrait2(SpecialTrait positiveTrait2) {
        this.positiveTrait2 = positiveTrait2;
    }

    public SpecialTrait getNegativeTrait() {
        return negativeTrait;
    }

    public void setNegativeTrait(SpecialTrait negativeTrait) {
        this.negativeTrait = negativeTrait;
    }

    public int getPosTrait1Level() {
        return posTrait1Level;
    }

    public void setPosTrait1Level(int posTrait1Level) {
        this.posTrait1Level = posTrait1Level;
    }

    public int getPosTrait2Level() {
        return PosTrait2Level;
    }

    public void setPosTrait2Level(int posTrait2Level) {
        PosTrait2Level = posTrait2Level;
    }

    public int getNegTraitLevel() {
        return negTraitLevel;
    }

    public void setNegTraitLevel(int negTraitLevel) {
        this.negTraitLevel = negTraitLevel;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String debug() {
        return "Character{" +
                "profession=" + profession +
                ", gender=" + gender +
                ", race=" + race +
                ", subrace=" + subrace +
                ", environment=" + environment +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", background='" + background + '\'' +
                ", region = " + region + "' Nationality = " + nationality +
                '}';
    }

    @Override
    public String toString() {
        return "" + name + " the " + race + " " + profession;
    }


    public String getTraitDescription(SpecialTrait specialTrait, int value){
        switch (specialTrait){
            case Strength:
                switch (value){
                    case -4:
                        return "Decrepit";
                    case -2:
                        return "Puny";
                    case -1:
                        return "Weak";
                    case 1:
                        return "Strong";
                    case 2:
                        return "Very Strong";
                    case 4:
                        return "Giantstrength";
                }
            case Physique:
                switch (value){
                    case -4:
                        return "Sickly";
                    case -2:
                        return "Fragile";
                    case -1:
                        return "Sensitive";
                    case 1:
                        return "Hardened";
                    case 2:
                        return "Tough";
                    case 4:
                        return "Resilient";
                }
            case Agility:
                switch (value){
                    case -4:
                        return "Immobile";
                    case -2:
                        return "Clumsy";
                    case -1:
                        return "Stiff";
                    case 1:
                        return "Nimble";
                    case 2:
                        return "Agile";
                    case 4:
                        return "Graceful";
                }
            case Charisma:
                switch (value){
                    case -4:
                        return "Despicable";
                    case -2:
                        return "Repulsive";
                    case -1:
                        return "Unpleasant";
                    case 1:
                        return "Pleasant";
                    case 2:
                        return "Charming";
                    case 4:
                        return "Glamorous";
                }
            case Intelligence:
                switch (value){
                    case -4:
                        return "Brainless";
                    case -2:
                        return "Stupid";
                    case -1:
                        return "Dimwitted";
                    case 1:
                        return "Clever";
                    case 2:
                        return "Smart";
                    case 4:
                        return "Brilliant";
                }
            case Psyche:
                switch (value){
                    case -4:
                        return "Spineless";
                    case -2:
                        return "Weak-willed";
                    case -1:
                        return "Indecissive";
                    case 1:
                        return "Determined";
                    case 2:
                        return "Steadfast";
                    case 4:
                        return "Resolute";
                }
            case Spirituality:
                switch (value){
                    case -4:
                        return "Heretic";
                    case -2:
                        return "Wicked";
                    case -1:
                        return "Doubter";
                    case 1:
                        return "Devout";
                    case 2:
                        return "Holy";
                    case 4:
                        return "Divine";
                }
        }
        return "Error";
    }
}
