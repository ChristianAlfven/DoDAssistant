package CharacterFile.Skills;

public class Nature extends Skill{

    private int westlands;
    private int midlands;
    private int eastheim;
    private int soj;
    private int nhordlands;
    private int underworld;

    public Nature(){
        westlands = 0;
        midlands = 0;
        eastheim = 0;
        soj = 0;
        nhordlands = 0;
        underworld = 0;
    }

    public int getWestlands() {
        return westlands;
    }

    public void setWestlands(int westlands) {
        this.westlands = westlands;
    }

    public int getMidlands() {
        return midlands;
    }

    public void setMidlands(int midlands) {
        this.midlands = midlands;
    }

    public int getEastheim() {
        return eastheim;
    }

    public void setEastheim(int eastheim) {
        this.eastheim = eastheim;
    }

    public int getSoj() {
        return soj;
    }

    public void setSoj(int soj) {
        this.soj = soj;
    }

    public int getNhordlands() {
        return nhordlands;
    }

    public void setNhordlands(int nhordlands) {
        this.nhordlands = nhordlands;
    }

    public int getUnderworld() {
        return underworld;
    }

    public void setUnderworld(int underworld) {
        this.underworld = underworld;
    }
}
