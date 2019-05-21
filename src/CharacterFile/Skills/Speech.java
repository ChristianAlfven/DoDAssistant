package CharacterFile.Skills;
import CharacterFile.Character;


public class Speech extends Skill{

    private int skillLevel;
    private int Vrok;
    private int Rona;
    private int Eika;
    private int Futhark;
    private int Orcish;
    private int mothertongue;

    public Speech(){
        Vrok = 0;
        Rona = 0;
        Eika = 0;
        Futhark = 0;
        Orcish = 0;
    }



    public int getVrok() {
        return Vrok;
    }

    public int getOrcish() {
        return Orcish;
    }

    public void addOrcish(int orcish) {
        this.Orcish += orcish;
    }

    public void addVrok(int vrok) {
        this.Vrok += vrok;
    }

    public int getRona() {
        return Rona;
    }

    public void addRona(int rona) {
        this.Rona += rona;
    }

    public int getEika() {
        return Eika;
    }

    public void addEika(int eika) {
        this.Eika += eika;
    }

    public int getFuthark() {
        return Futhark;
    }

    public void addFuthark(int futhark) {
        this.Futhark += futhark;
    }

    public void addMotherTongue(Character character, int value){
        switch (character.getRace()){
            case Human:
                if (character.getSubrace()== Character.SubRace.Stormlander){
                    addRona(getRona() + value);
                } else {
                    addVrok(getVrok() + value);
                }
                break;
            case Elf:
                addEika(getEika() + value);
                break;
            case Dwarf:
                addFuthark(getFuthark() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()){
                    case Human:
                        if (character.getRegion() == Character.Region.Eastheim){
                            addRona(getRona()+value);
                        }else {
                            addVrok(getVrok()+value);
                        }
                        break;
                    case Elf:
                        addEika(getEika()+value);
                        break;
                    case Orc:
                        addOrcish(getOrcish()+value);
                        break;
                }break;

        }
        skillLevel = value;
    }

    public String getMotherTongue(Character character){
        switch (character.getRace()){
            case Human:
                if (character.getSubrace()== Character.SubRace.Stormlander){
                    mothertongue = 1;
                    return "(Rona):";
                } else {
                    mothertongue = 2;
                    return "(Vrok):";
                }
            case Elf:
                mothertongue = 3;
                return "(Eika):";
            case Dwarf:
                mothertongue = 4;
                return "(Futhark):";
            case HalfBlood:
                switch (character.getNationality()){
                    case Human:
                        if (character.getRegion() == Character.Region.Eastheim){
                            mothertongue = 1;
                            return "(Rona):";
                        }else {
                            mothertongue = 2;
                            return "(Vrok):";
                        }
                    case Elf:
                        mothertongue = 3;
                        return "(Eika):";
                    case Orc:
                        mothertongue = 5;
                        return "(Orcish):";
                }

        }
        return null;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setVrok(int vrok) {
        Vrok = vrok;
    }

    public void setRona(int rona) {
        Rona = rona;
    }

    public void setEika(int eika) {
        Eika = eika;
    }

    public void setFuthark(int futhark) {
        Futhark = futhark;
    }

    public void setOrcish(int orcish) {
        Orcish = orcish;
    }

    public int getMothertongueValue(){
        switch(mothertongue) {
            case 1:
                return Rona;
            case 2:
                return Vrok;
            case 3:
                return Eika;
            case 4:
                return Futhark;
            case 5:
                return Orcish;
            default:
                return 0;
        }
    }
}
