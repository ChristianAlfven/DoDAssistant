package CharacterFile;

public class NPC {
    private String name;
    private String race;
    private int combatPoints;
    private int danageBonus;
    private Health health;
    private Armor armor = new Armor();


    public NPC(String name, String race, int combatPoints, int danageBonus, int health) {
        this.name = name;
        this.race = race;
        this.combatPoints = combatPoints;
        this.danageBonus = danageBonus;
        this.health = new Health(health);

        armor.setHead(4);
        armor.setChest(5);
        armor.setStomach(5);
        armor.setRightArm(3);
        armor.setLeftArm(3);
        armor.setRightLeg(2);
        armor.setLeftLeg(2);



    }
}
