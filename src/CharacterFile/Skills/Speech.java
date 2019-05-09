package CharacterFile.Skills;

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
}
