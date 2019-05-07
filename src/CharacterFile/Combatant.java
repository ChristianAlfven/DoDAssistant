package CharacterFile;

public class Combatant {
    private String name;
    private String race;
    private int totCombatPoints;
    private int remainingCombatPoints;
    private int damageBonus;
    private Health health;
    private Armor armor;
    private int initiative;
    private boolean isPlayer;
    private int playerIndex;


    public Combatant(String name, int totCombatPoints, int health, boolean isPlayer) {
        this.name = name;
        this.totCombatPoints = totCombatPoints;
        this.health = new Health(health);
        this.remainingCombatPoints = totCombatPoints;
        this.isPlayer = isPlayer;

        armor = new Armor();
        armor.setHead(4);
        armor.setChest(5);
        armor.setStomach(5);
        armor.setRightArm(3);
        armor.setLeftArm(3);
        armor.setRightLeg(2);
        armor.setLeftLeg(2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getTotCombatPoints() {
        return totCombatPoints;
    }

    public void setTotCombatPoints(int totCombatPoints) {
        this.totCombatPoints = totCombatPoints;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getRemainingCombatPoints() { return remainingCombatPoints; }

    public void setRemainingCombatPoints(int remainingCombatPoints) { this.remainingCombatPoints = remainingCombatPoints; }

    public boolean isPlayer() { return isPlayer; }

    public int getPlayerIndex() { return playerIndex; }

    public void setPlayerIndex(int playerIndex) { this.playerIndex = playerIndex; }
}
