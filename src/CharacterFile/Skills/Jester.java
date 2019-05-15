package CharacterFile.Skills;

public class Jester extends Skill{

    private int skillLevel;

    public Jester(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel += skillLevel;
    }

}
