package CharacterFile.Skills;

import CharacterFile.Character;

public class Geography extends Skill {

    private int skillLevel;
    private int westland;
    private int midlands;
    private int eastheim;
    private int soj;
    private int nhordland;
    private int underworld;

    public Geography() {
        westland = 0;
        midlands = 0;
        eastheim = 0;
        nhordland = 0;
        soj = 0;
        underworld = 0;
    }

    public int getWestland() {
        return westland;
    }

    public void addWestland(int westland) {
        this.westland += westland;
    }

    public int getMidlands() {
        return midlands;
    }

    public void addMidlands(int midland) {
        this.midlands += midland;
    }

    public int getEastheim() {
        return eastheim;
    }

    public void addEastheim(int eastheim) {
        this.eastheim += eastheim;
    }

    public int getNhoordland() {
        return nhordland;
    }

    public void addNhoordland(int nhoordland) {
        this.nhordland += nhoordland;
    }

    public int getSoj() {
        return soj;
    }

    public void addSoj(int soj) {
        this.soj += soj;
    }

    public int getUnderworld() {
        return underworld;
    }

    public void addUnderworld(int underworld) {
        this.underworld += underworld;
    }

    public void addHomeland(Character character, int value) {
        switch (character.getRace()) {
            case Human:
                if (character.getSubrace() == Character.SubRace.Stormlander) {
                    addEastheim(getEastheim() + value);
                } else if (character.getSubrace() == Character.SubRace.Midlander) {
                    addMidlands(getMidlands() + value);
                } else {
                    addWestland(getWestland() + value);
                }
                break;
            case Elf:
                addSoj(getSoj() + value);
                break;
            case Dwarf:
                addUnderworld(getUnderworld() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()) {
                    case Human:
                    case Orc:
                        if (character.getRegion() == Character.Region.Eastheim) {
                            addEastheim(getEastheim() + value);
                        } else if (character.getRegion() == Character.Region.Westlands) {
                            addWestland(getWestland() + value);
                        } else {
                            addMidlands(getMidlands() + value);
                        }
                        break;
                    case Elf:
                        addSoj(getSoj() + value);
                        break;
                }
                break;

        }
        skillLevel = value;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getHomeland() {
        String homeland = null;
        if (westland != 0) {
            homeland = "(Westland):";
        } else if (midlands != 0) {
            homeland = "(Midland):";
        } else if (eastheim != 0) {
            homeland = "(Eastheim):";
        } else if (nhordland != 0) {
            homeland = "(Nhordland):";
        } else if (soj != 0) {
            homeland = "(Soj):";
        } else if (underworld != 0) {
            homeland = "(Underworld):";
        }
        return homeland;
    }

    public void setWestland(int westland) {
        this.westland = westland;
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

    public void setNhordland(int nhordland) {
        this.nhordland = nhordland;
    }

    public void setUnderworld(int underworld) {
        this.underworld = underworld;
    }
}

