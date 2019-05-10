package CharacterFile.Skills;

public class Survival extends Skill{
    int skillLevel;

    public Survival(){
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
