package CharacterFile.Skills;

public class Entertainment extends Skill{

    private int skillLevel;

    public Entertainment(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

}
