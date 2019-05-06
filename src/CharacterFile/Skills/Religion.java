package CharacterFile.Skills;

public class Religion extends Skill{

    private int gerbanis;
    private int ostroseden;
    private int nidendomen;
    private int hamingjes;
    private int thuldom;

    public Religion(){
        gerbanis = 0;
        ostroseden = 0;
        nidendomen = 0;
        hamingjes = 0;
        thuldom = 0;
    }

    public int getGerbanis() {
        return gerbanis;
    }

    public void setGerbanis(int gerbanis) {
        this.gerbanis = gerbanis;
    }

    public int getOstroseden() {
        return ostroseden;
    }

    public void setOstroseden(int ostroseden) {
        this.ostroseden = ostroseden;
    }

    public int getNidendomen() {
        return nidendomen;
    }

    public void setNidendomen(int nidendomen) {
        this.nidendomen = nidendomen;
    }

    public int getHamingjes() {
        return hamingjes;
    }

    public void setHamingjes(int hamingjes) {
        this.hamingjes = hamingjes;
    }

    public int getThuldom() {
        return thuldom;
    }

    public void setThuldom(int thuldom) {
        this.thuldom = thuldom;
    }
}
