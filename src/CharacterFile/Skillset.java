package CharacterFile;

import CharacterFile.Skills.*;
import CharacterFile.Skills.Crafting;
import CharacterFile.Skills.Geography;
import CharacterFile.Skills.Management;

import java.util.ArrayList;

public class Skillset {

    private Alchemy alchemy;
    private Combat combat = new Combat();
    private Crafting crafting;
    private Crime crime;
    private Culture culture;
    private Entertainment entertainment;
    private Geography geography;
    private Hunting hunting;
    private Jester jester;
    private Management management;
    private Medicine medicine;
    private Mobility mobility = new Mobility();
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
            this.alchemy = new Alchemy();
        }
        return alchemy;
    }

    public Combat getCombat() {
        if (combat == null){
            this.combat = new Combat();
        }
        return combat;
    }

    public Crafting getCrafting() {
        if (crafting == null){
            this.crafting = new Crafting();
        }
        return crafting;
    }

    public Crime getCrime() {
        if (crime == null){
            this.crime = new Crime();
        }
        return crime;
    }

    public Culture getCulture() {
        if (culture == null){
            this.culture = new Culture();
        }
        return culture;
    }

    public Entertainment getEntertainment() {
        if (entertainment == null){
            this.entertainment = new Entertainment();
        }
        return entertainment;
    }

    public Geography getGeography() {
        if (geography == null){
            this.geography = new Geography();
        }
        return geography;
    }

    public Hunting getHunting() {
        if (hunting == null){
            this.hunting = new Hunting();
        }
        return hunting;
    }

    public Jester getJester() {
        if (jester == null){
            this.jester = new Jester();
        }
        return jester;
    }

    public Management getManagement() {
        if (management == null){
            this.management = new Management();
        }
        return management;
    }

    public Medicine getMedicine() {
        if (medicine == null){
            this.medicine = new Medicine();
        }
        return medicine;
    }

    public Mobility getMobility() {
        if (mobility == null){
            this.mobility = new Mobility();
        }
        return mobility;
    }

    public Nature getNature() {
        if (nature == null){
            this.nature = new Nature();
        }
        return nature;
    }

    public Religion getReligion() {
        if (religion == null){
            this.religion = new Religion();
        }
        return religion;
    }

    public Riding getRiding() {
        if (riding == null){
            this.riding = new Riding();
        }
        return riding;
    }

    public Seafaring getSeafaring() {
        if (seafaring == null){
            this.seafaring = new Seafaring();
        }
        return seafaring;
    }

    public Speech getSpeech() {
        if (speech == null){
            this.speech = new Speech();
        }
        return speech;
    }

    public Spellcasting getSpellcasting() {
        if (spellcasting == null){
            this.spellcasting = new Spellcasting();
        }
        return spellcasting;
    }

    public Survival getSurvival() {
        if (survival == null){
            this.survival = new Survival();
        }
        return survival;
    }

    public Trade getTrade() {
        if (trade == null){
            this.trade = new Trade();
        }
        return trade;
    }
}
