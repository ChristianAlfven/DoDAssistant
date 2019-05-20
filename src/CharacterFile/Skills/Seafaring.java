package CharacterFile.Skills;

public class Seafaring extends Skill{

    private int skillLevel;

    public Seafaring(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void addSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
