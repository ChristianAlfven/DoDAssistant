package CharacterFile.Skills;

public class Riding extends Skill{

    private int skillLevel;

    public Riding(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

}
