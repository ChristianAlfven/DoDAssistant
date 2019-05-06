package CharacterFile.Skills;

public class Spellcasting extends Skill{

    private int skillLevel;

    public Spellcasting(){
        skillLevel = 0;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
