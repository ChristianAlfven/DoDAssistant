package CharacterFile.Skills;

public class Crime extends Skill{

    private int skillLevel;

    public Crime(){
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
