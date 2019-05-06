package CharacterFile;

public class Combatant {
    private String name;
    private String race;
    private int combatPoints;
    private int damageBonus;
    private Health health;
    private Armor armor;
    private int initiative;


    public Combatant(String name, int combatPoints, int health) {
        this.name = name;
        this.combatPoints = combatPoints;
        this.health = new Health(health);

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

    public int getCombatPoints() {
        return combatPoints;
    }

    public void setCombatPoints(int combatPoints) {
        this.combatPoints = combatPoints;
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
}
