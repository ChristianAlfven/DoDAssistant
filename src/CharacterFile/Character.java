package CharacterFile;

public class Character {

    public enum Profession {Warrior, Peasant, Mage, Rogue, Priest, Bard, Scholar}
    public enum Gender {Male, Female}
    public enum Race {Human, Elf, Dwarf, HalfBlood}
    public enum SubRace {Stormlander, Midlander, Virann, Illmalaina, Korpikalla, Buratja, Borjornikka, Zvorda, HalfOrc, HalfElf}
    public enum WeaponHand {Right, Left, Both}
    public enum Nationality {Human, Orc, Elf}
    public enum Environment{Nature, Country, City, Academic}
    public enum SpecialTrait{Strength, Physique, Agility, Spirituality, Intelligence, Psyche, Charisma}


    Health health;
    Armor armor;
    Skillset skillset;
    //Inventory inventory;

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

    private String name;
    private int height;
    private int weight;
    private int age;
    private int combatPoints;
    private String background;
    private String Characteristics;
    private int raud;
    private int totalExp;
    private int unusedExp;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(int hp) {
        Health health = new Health(hp);
    }

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

    @Override
    public String toString() {
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
                '}';
    }
}
