package CharacterFile.Skills;
import CharacterFile.Character;


public class Speech extends Skill{

    private int Vrok;
    private int Rona;
    private int Eika;
    private int Futhark;
    private int Orcish;

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

    public void setOrcish(int orcish) {
        this.Orcish = orcish;
    }

    public void setVrok(int vrok) {
        this.Vrok = vrok;
    }

    public int getRona() {
        return Rona;
    }

    public void setRona(int rona) {
        this.Rona = rona;
    }

    public int getEika() {
        return Eika;
    }

    public void setEika(int eika) {
        this.Eika = eika;
    }

    public int getFuthark() {
        return Futhark;
    }

    public void setFuthark(int futhark) {
        this.Futhark = futhark;
    }

    public void addMotherTongue(Character character, int value){
        switch (character.getRace()){
            case Human:
                if (character.getSubrace()== Character.SubRace.Stormlander){
                    setRona(getRona() + value);
                } else {
                    setVrok(getVrok() + value);
                }
                break;
            case Elf:
                setEika(getEika() + value);
                break;
            case Dwarf:
                setFuthark(getFuthark() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()){
                    case Human:
                        if (character.getRegion() == Character.Region.Eastheim){
                            setRona(getRona()+value);
                        }else {
                            setVrok(getVrok()+value);
                        }
                        break;
                    case Elf:
                        setEika(getEika()+value);
                        break;
                    case Orc:
                        setOrcish(getOrcish()+value);
                        break;
                }break;

        }
    }

    public String getMotherTongue(Character character){
        switch (character.getRace()){
            case Human:
                if (character.getSubrace()== Character.SubRace.Stormlander){
                    return "Rona";
                } else {
                    return "Vrok";
                }
            case Elf:
                return "Eika";
            case Dwarf:
                return "Futhark";
            case HalfBlood:
                switch (character.getNationality()){
                    case Human:
                        if (character.getRegion() == Character.Region.Eastheim){
                            return "Rona";
                        }else {
                            return "Vrok";
                        }
                    case Elf:
                        return "Eika";
                    case Orc:
                        return "Orcish";
                }

        }
        return null;
    }
}
