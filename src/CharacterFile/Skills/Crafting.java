package CharacterFile.Skills;

public class Crafting extends Skill{

    private int metal;
    private int soft;
    private int stone;
    private int wood;

    public Crafting(){
        metal = 0;
        soft = 0;
        stone = 0;
        wood = 0;
    }

    public int getMetal() {
        return metal;
    }

    public void addMetal(int metal) {
        this.metal += metal;
    }

    public int getSoft() {
        return soft;
    }

    public void addSoft(int soft) {
        this.soft += soft;
    }

    public int getStone() {
        return stone;
    }

    public void addStone(int stone) {
        this.stone += stone;
    }

    public int getWood() {
        return wood;
    }

    public void addWood(int wood) {
        this.wood += wood;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setSoft(int soft) {
        this.soft = soft;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }
}
