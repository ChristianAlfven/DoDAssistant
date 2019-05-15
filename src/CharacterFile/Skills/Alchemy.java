package CharacterFile.Skills;

public class Alchemy extends Skill{

    private int skillLevel;

    public Alchemy(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

}
