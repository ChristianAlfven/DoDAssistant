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
    private int homeLandIndex;

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
                    homeLandIndex = 1;
                } else if (character.getSubrace() == Character.SubRace.Midlander) {
                    setMidlands(getMidlands() + value);
                    homeLandIndex = 2;
                } else {
                    setWestlands(getWestlands() + value);
                    homeLandIndex = 3;
                }
                break;
            case Elf:
                setElvish(getElvish() + value);
                homeLandIndex = 4;
                break;
            case Dwarf:
                setDwarfish(getDwarfish() + value);
                homeLandIndex = 5;
                break;
            case HalfBlood:
                switch (character.getNationality()) {
                    case Human:
                    case Orc:
                        if (character.getRegion() == Character.Region.Eastheim) {
                            setEastheim(getEastheim() + value);
                            homeLandIndex = 1;
                        } else if (character.getRegion() == Character.Region.Westlands) {
                            setWestlands(getWestlands() + value);
                            homeLandIndex = 2;
                        } else {
                            setMidlands(getMidlands() + value);
                            homeLandIndex = 3;
                        }
                        break;
                    case Elf:
                        setElvish(getElvish() + value);
                        homeLandIndex = 4;
                        break;
                }
                break;

        }
        //skillLevel = value;
    }

    //public int getSkillLevel() {
    //    return skillLevel;
    //}

    public String getHomeland(Character character) {
        switch (character.getRace()) {
            case Human:
                if (character.getSubrace() == Character.SubRace.Stormlander) {
                    homeLandIndex = 1;
                    return "(Eastheim):";
                } else if (character.getSubrace() == Character.SubRace.Midlander) {
                    homeLandIndex = 2;
                    return "(Midland):";
                } else {
                    homeLandIndex = 3;
                    return "(Westland):";
                }
            case Elf:
                homeLandIndex = 4;
                return "(Elvish):";
            case Dwarf:
                homeLandIndex = 5;
                return "(Dwarfish):";
            case HalfBlood:
                switch (character.getNationality()) {
                    case Human:
                        if (character.getRegion() == Character.Region.Eastheim) {
                            homeLandIndex = 1;
                            return "(Eastheim):";
                        } else if (character.getRegion() == Character.Region.Midlands) {
                            homeLandIndex = 2;
                            return "(Midlands):";
                        } else {
                            homeLandIndex = 3;
                            return "(Westlands):";
                        }
                    case Orc:
                        homeLandIndex = 6;
                        return "(Orcish):";
                    case Elf:
                        homeLandIndex = 4;
                        return "(Elvish):";
                }
            default:
                return "";
        }
    }

    public int getHomelandValue() {
        switch(homeLandIndex){
            case 1:
                return eastheim;
            case 2:
                return midlands;
            case 3:
                return westlands;
            case 4:
                return elvish;
            case 5:
                return dwarfish;
            case 6:
                return orcish;
            default:
                return 0;
        }
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
