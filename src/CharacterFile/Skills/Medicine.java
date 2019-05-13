package CharacterFile.Skills;

public class Medicine extends Skill{

    private int skillLevel;

    public Medicine(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void addSkillLevel(int value){
        this.skillLevel += value;
    }
}
