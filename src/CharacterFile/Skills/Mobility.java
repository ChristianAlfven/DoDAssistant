package CharacterFile.Skills;

public class Mobility extends Skill{

    private int skillLevel;

    public Mobility(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void addSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
