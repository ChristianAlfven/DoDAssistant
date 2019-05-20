package CharacterFile.Skills;

import CharacterFile.Character;

public class Culture extends Skill{

    //private int skillLevel;
    private int elvish;
    private int dwarfish;
    private int westlands;
    private int midlands;
    private int eastheim;
    private int orcish;

    public Culture(){
        elvish = 0;
        dwarfish = 0;
        westlands = 0;
        midlands = 0;
        eastheim = 0;
        orcish = 0;
    }

    public int getElvish() {
        return elvish;
    }

    public void addElvish(int elvish) {
        this.elvish += elvish;
    }

    public int getDwarfish() {
        return dwarfish;
    }

    public void addDwarfish(int dwarfish) {
        this.dwarfish += dwarfish;
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

    public int getOrcish() {
        return orcish;
    }

    public void addOrcish(int orcish) {
        this.orcish += orcish;
    }

    public void addHomeland(Character character, int value) {
        switch (character.getRace()) {
            case Human:
                if (character.getSubrace() == Character.SubRace.Stormlander) {
                    setEastheim(getEastheim() + value);
                } else if (character.getSubrace() == Character.SubRace.Midlander) {
                    setMidlands(getMidlands() + value);
                } else {
                    setWestlands(getWestlands() + value);
                }
                break;
            case Elf:
                setElvish(getElvish() + value);
                break;
            case Dwarf:
                setDwarfish(getDwarfish() + value);
                break;
            case HalfBlood:
                switch (character.getNationality()) {
                    case Human:
                    case Orc:
                        if (character.getRegion() == Character.Region.Eastheim) {
                            setEastheim(getEastheim() + value);
                        } else if (character.getRegion() == Character.Region.Westlands) {
                            setWestlands(getWestlands() + value);
                        } else {
                            setMidlands(getMidlands() + value);
                        }
                        break;
                    case Elf:
                        setElvish(getElvish() + value);
                        break;
                }
                break;

        }
        //skillLevel = value;
    }

    //public int getSkillLevel() {
    //    return skillLevel;
    //}

    public String getHomeland() {
        String homeland = null;
        if (elvish != 0) {
            homeland = "(Elvish):";
        } else if (dwarfish != 0) {
            homeland = "(Dwarfish):";
        } else if (westlands != 0) {
            homeland = "(Westlands):";
        } else if (midlands != 0) {
            homeland = "(Midlands):";
        } else if (eastheim != 0) {
            homeland = "(Eastheim):";
        } else if (orcish != 0) {
            homeland = "(Orcish):";
        }
        return homeland;
    }

    public void setElvish(int elvish) {
        this.elvish = elvish;
    }

    public void setDwarfish(int dwarfish) {
        this.dwarfish = dwarfish;
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

    public void setOrcish(int orcish) {
        this.orcish = orcish;
    }
}
