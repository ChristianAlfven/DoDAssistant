package CharacterFile.Skills;

public class Trade extends Skill{
    int skillLevel;

    public Trade(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
