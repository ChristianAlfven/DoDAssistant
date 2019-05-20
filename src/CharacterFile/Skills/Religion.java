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

    public String getReligionName(){
        switch (mainReligion){
            case 1:
                return "Gerbanis";
            case 2:
                return "Ostroseden";
            case 3:
                return "Nidendomen";
            case 4:
                return "Hamingjes";
            case 5:
                return "Thuldom";
            default:
                return "Unfaithful";
        }

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
                addGerbanis(i);
            case 2:
                addOstroseden(i);
            case 3:
                addNidendomen(i);
            case 4:
                addHamingjes(i);
            case 5:
                addThuldom(i);
        }
    }

    public int getGerbanis() {
        return gerbanis;
    }

    public void addGerbanis(int gerbanis) {
        this.gerbanis += gerbanis;
    }

    public int getOstroseden() {
        return ostroseden;
    }

    public void addOstroseden(int ostroseden) {
        this.ostroseden += ostroseden;
    }

    public int getNidendomen() {
        return nidendomen;
    }

    public void addNidendomen(int nidendomen) {
        this.nidendomen += nidendomen;
    }

    public int getHamingjes() {
        return hamingjes;
    }

    public void addHamingjes(int hamingjes) {
        this.hamingjes += hamingjes;
    }

    public int getThuldom() {
        return thuldom;
    }

    public void addThuldom(int thuldom) {
        this.thuldom += thuldom;
    }

    public void setGerbanis(int gerbanis) {
        this.gerbanis = gerbanis;
    }

    public void setOstroseden(int ostroseden) {
        this.ostroseden = ostroseden;
    }

    public void setNidendomen(int nidendomen) {
        this.nidendomen = nidendomen;
    }

    public void setHamingjes(int hamingjes) {
        this.hamingjes = hamingjes;
    }

    public void setThuldom(int thuldom) {
        this.thuldom = thuldom;
    }
}
