package CharacterFile.Skills;

public class Management extends Skill{

    int farm = 0;
    int city = 0;
    int war = 0;

    public Management(){    }

    public int getFarm() {
        return farm;
    }

    public void addFarm(int farm) {
        this.farm += farm;
    }

    public int getCity() {
        return city;
    }

    public void addCity(int city) {
        this.city += city;
    }

    public int getWar() {
        return war;
    }

    public void addWar(int war) {
        this.war += war;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setWar(int war) {
        this.war = war;
    }
}

