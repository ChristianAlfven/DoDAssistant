package CharacterFile.Skills;

public class Management extends Skill{

    int farm;
    int city;
    int war;

    public Management(){
        farm = 0;
        city = 0;
        war = 0;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm += farm;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city += city;
    }

    public int getWar() {
        return war;
    }

    public void setWar(int war) {
        this.war += war;
    }
}

