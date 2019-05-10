package CharacterFile.Skills;
import CharacterFile.Character;


public class Speech extends Skill{

    private int vrok;
    private int rona;
    private int eika;
    private int futhark;
    private int orcish;

    public Speech(){
        orcish = 0;
        vrok = 0;
        rona = 0;
        eika = 0;
        futhark = 0;
    }

    public int getVrok() {
        return vrok;
    }

    public int getOrcish() {
        return orcish;
    }

    public void setOrcish(int orcish) {
        this.orcish = orcish;
    }

    public void setVrok(int vrok) {
        this.vrok = vrok;
    }

    public int getRona() {
        return rona;
    }

    public void setRona(int rona) {
        this.rona = rona;
    }

    public int getEika() {
        return eika;
    }

    public void setEika(int eika) {
        this.eika = eika;
    }

    public int getFuthark() {
        return futhark;
    }

    public void setFuthark(int futhark) {
        this.futhark = futhark;
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
}
