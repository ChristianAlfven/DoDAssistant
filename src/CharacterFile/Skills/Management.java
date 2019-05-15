package CharacterFile.Skills;

public class Management extends Skill{

    int farm = 0;
    int city = 0;
    int war = 0;

    public Management(){    }

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

