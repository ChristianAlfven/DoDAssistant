package CharacterFile.Skills;

import CharacterFile.Character;
import CharacterFile.*;

public class Geography extends Skill {

    private int westland;
    private int midland;
    private int eastheim;
    private int soj;
    private int nhordland;
    private int underworld;

    public Geography() {
        westland = 0;
        midland = 0;
        eastheim = 0;
        nhordland = 0;
        soj = 0;
        underworld = 0;
    }

    public int getWestland() {
        return westland;
    }

    public void setWestland(int westland) {
        this.westland += westland;
    }

    public int getMidland() {
        return midland;
    }

    public void setMidland(int midland) {
        this.midland += midland;
    }

    public int getEastheim() {
        return eastheim;
    }

    public void setEastheim(int eastheim) {
        this.eastheim += eastheim;
    }

    public int getNhoordland() {
        return nhordland;
    }

    public void setNhoordland(int nhoordland) {
        this.nhordland += nhoordland;
    }

    public int getSoj() {
        return soj;
    }

    public void setSoj(int soj) {
        this.soj += soj;
    }

    public int getUnderworld() {
        return underworld;
    }

    public void setUnderworld(int underworld) {
        this.underworld += underworld;
    }

    public void addHomeland(Character character, int value) {
        switch (character.getRace()) {
            case Human:
                if (character.getSubrace() == Character.SubRace.Stormlander) {
                    setEastheim(getEastheim() + value);
                } else if (character.getSubrace() == Character.SubRace.Midlander) {
                    setMidland(getMidland() + value);
                } else {
                    setWestland(getWestland() + value);
                }
                break;
            case Elf:
                setSoj(getSoj() + value);
                break;
            case Dwarf:
                setUnderworld(getUnderworld() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()) {
                    case Human:
                    case Orc:
                        if (character.getRegion() == Character.Region.Eastheim) {
                            setEastheim(getEastheim() + value);
                        } else if (character.getRegion() == Character.Region.Westlands) {
                            setWestland(getWestland() + value);
                        } else {
                            setMidland(getMidland() + value);
                        }
                        break;
                    case Elf:
                        setSoj(getSoj() + value);
                        break;
                }
                break;

        }
    }
}

