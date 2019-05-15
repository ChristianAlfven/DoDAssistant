package CharacterFile.Skills;

public class Combat extends Skill{

    private int skillLevel;

    public Combat(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

}
