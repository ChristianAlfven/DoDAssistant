package CharacterFile.Skills;

public class Religion extends Skill{

    private int gerbanis;
    private int ostroseden;
    private int nidendomen;
    private int hamingjes;
    private int thuldom;
    private int mainReligion;


    public Religion(){
        gerbanis = 0;
        ostroseden = 0;
        nidendomen = 0;
        hamingjes = 0;
        thuldom = 0;
    }

    public void chooseMain(int i){
        mainReligion = i;
    }

    public int getMainReligion(){
        switch (mainReligion){
            case 1:
                return gerbanis;
            case 2:
                return ostroseden;
            case 3:
                return nidendomen;
            case 4:
                return hamingjes;
            case 5:
                return thuldom;
            default:
                return 0;
        }
    }

    public void setMainReligion(int i){
        switch (mainReligion){
            case 1:
                setGerbanis(i);
            case 2:
                setOstroseden(i);
            case 3:
                setNidendomen(i);
            case 4:
                setHamingjes(i);
            case 5:
                setThuldom(i);
        }
    }

    public int getGerbanis() {
        return gerbanis;
    }

    public void setGerbanis(int gerbanis) {
        this.gerbanis += gerbanis;
    }

    public int getOstroseden() {
        return ostroseden;
    }

    public void setOstroseden(int ostroseden) {
        this.ostroseden += ostroseden;
    }

    public int getNidendomen() {
        return nidendomen;
    }

    public void setNidendomen(int nidendomen) {
        this.nidendomen += nidendomen;
    }

    public int getHamingjes() {
        return hamingjes;
    }

    public void setHamingjes(int hamingjes) {
        this.hamingjes += hamingjes;
    }

    public int getThuldom() {
        return thuldom;
    }

    public void setThuldom(int thuldom) {
        this.thuldom += thuldom;
    }
}
