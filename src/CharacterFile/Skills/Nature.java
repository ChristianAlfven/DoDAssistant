package CharacterFile.Skills;

import CharacterFile.Character;

public class Nature extends Skill{

    private int skillLevel;
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

    public void addWestlands(int westlands) {
        this.westlands += westlands;
    }

    public int getMidlands() {
        return midlands;
    }

    public void addMidlands(int midlands) {
        this.midlands += midlands;
    }

    public int getEastheim() {
        return eastheim;
    }

    public void addEastheim(int eastheim) {
        this.eastheim += eastheim;
    }

    public int getSoj() {
        return soj;
    }

    public void addSoj(int soj) {
        this.soj += soj;
    }

    public int getNhordlands() {
        return nhordlands;
    }

    public void addNhordlands(int nhordlands) {
        this.nhordlands += nhordlands;
    }

    public int getUnderworld() {
        return underworld;
    }

    public void addUnderworld(int underworld) {
        this.underworld += underworld;
    }

    public void addHomeland(Character character, int value){
        value = skillLevel;
        switch (character.getRace()){
            case Human:
                if (character.getSubrace()== Character.SubRace.Stormlander){
                    addEastheim(getEastheim() + value);
                } else if (character.getSubrace()== Character.SubRace.Midlander) {
                    addMidlands(getMidlands() + value);
                } else {
                    addWestlands(getWestlands() + value);
                }
                break;
            case Elf:
                addSoj(getSoj() + value);
                break;
            case Dwarf:
                addUnderworld(getUnderworld() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()){
                    case Human:
                    case Orc:
                        if (character.getRegion() == Character.Region.Eastheim){
                            addEastheim(getEastheim()+value);
                        }else if (character.getRegion()== Character.Region.Westlands){
                            addWestlands(getWestlands()+value);
                        } else {
                            addMidlands(getMidlands() + value);
                        }
                        break;
                    case Elf:
                        addSoj(getSoj()+value);
                        break;
                }break;
        }
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getHomeland() {
        String homeland = null;
        if (westlands != 0) {
            homeland = "(Westland):";
        } else if (midlands != 0) {
            homeland = "(Midland):";
        } else if (eastheim != 0) {
            homeland = "(Eastheim):";
        } else if (nhordlands != 0) {
            homeland = "(Nhordland):";
        } else if (soj != 0) {
            homeland = "(Soj):";
        } else if (underworld != 0) {
            homeland = "(Underworld):";
        }
        return homeland;
    }

    public void setWestlands(int westlands) {
        this.westlands = westlands;
    }

    public void setMidlands(int midlands) {
        this.midlands = midlands;
    }

    public void setEastheim(int eastheim) {
        this.eastheim = eastheim;
    }

    public void setSoj(int soj) {
        this.soj = soj;
    }

    public void setNhordlands(int nhordlands) {
        this.nhordlands = nhordlands;
    }

    public void setUnderworld(int underworld) {
        this.underworld = underworld;
    }
}

