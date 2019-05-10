package CharacterFile;

import CharacterFile.Skills.*;
import CharacterFile.Skills.Crafting;
import CharacterFile.Skills.Geography;
import CharacterFile.Skills.Management;

public class Skillset {

    private Alchemy alchemy;
    private Combat combat;
    private Crafting crafting;
    private Crime crime;
    private Culture culture;
    private Entertainment entertainment;
    private Geography geography;
    private Hunting hunting;
    private Jester jester;
    private Management management;
    private Medicine medicine;
    private Mobility mobility;
    private Nature nature;
    private Religion religion;
    private Riding riding;
    private Seafaring seafaring;
    private Speech speech;
    private Spellcasting spellcasting;
    private Survival survival;
    private Trade trade;



    public Alchemy getAlchemy() {
        if (alchemy == null){
            alchemy = new Alchemy();
        }
        return alchemy;
    }

    public Combat getCombat() {
        if (combat == null){
            combat = new Combat();
        }
        return combat;
    }

    public Crafting getCrafting() {
        if (crafting == null){
            crafting = new Crafting();
        }
        return crafting;
    }

    public Crime getCrime() {
        if (crime == null){
            crime = new Crime();
        }
        return crime;
    }

    public Culture getCulture() {
        if (culture == null){
            culture = new Culture();
        }
        return culture;
    }

    public Entertainment getEntertainment() {
        if (entertainment == null){
            entertainment = new Entertainment();
        }
        return entertainment;
    }

    public Geography getGeography() {
        if (geography == null){
            geography = new Geography();
        }
        return geography;
    }

    public Hunting getHunting() {
        if (hunting == null){
            hunting = new Hunting();
        }
        return hunting;
    }

    public Jester getJester() {
        if (jester == null){
            jester = new Jester();
        }
        return jester;
    }

    public Management getManagement() {
        if (management == null){
            management = new Management();
        }
        return management;
    }

    public Medicine getMedicine() {
        if (medicine == null){
            medicine = new Medicine();
        }
        return medicine;
    }

    public Mobility getMobility() {
        if (mobility == null){
            mobility = new Mobility();
        }
        return mobility;
    }

    public Nature getNature() {
        if (nature == null){
            nature = new Nature();
        }
        return nature;
    }

    public Religion getReligion() {
        if (religion == null){
            religion = new Religion();
        }
        return religion;
    }

    public Riding getRiding() {
        if (riding == null){
            riding = new Riding();
        }
        return riding;
    }

    public Seafaring getSeafaring() {
        if (seafaring == null){
            seafaring = new Seafaring();
        }
        return seafaring;
    }

    public Speech getSpeech() {
        if (speech == null){
            speech = new Speech();
        }
        return speech;
    }

    public Spellcasting getSpellcasting() {
        if (spellcasting == null){
            spellcasting = new Spellcasting();
        }
        return spellcasting;
    }

    public Survival getSurvival() {
        if (survival == null){
            survival = new Survival();
        }
        return survival;
    }

    public Trade getTrade() {
        if (trade == null){
            trade = new Trade();
        }
        return trade;
    }
}
