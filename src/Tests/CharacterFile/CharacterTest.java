package CharacterFile;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    Character character = new Character();

    @Test
    public void setName() {
        character.setName("Ben");
        Assert.assertEquals(character.getName(),"Ben");
    }

    @Test
    public void setHealth() {
        Health health = new Health(50);
        character.setHealth(health);
        Assert.assertEquals(character.getHealth(),health);
    }

    @Test
    public void setArmor() {
        Armor armor = new Armor();
        character.setArmor(armor);
        Assert.assertEquals(character.getArmor(),armor);
    }

    @Test
    public void setProfession() {
        character.setProfession(Character.Profession.Warrior);
        Assert.assertEquals(character.getProfession(), Character.Profession.Warrior);
    }

    @Test
    public void setGender() {
        character.setGender(Character.Gender.Male);
        Assert.assertEquals(character.getGender(), Character.Gender.Male);
    }

    @Test
    public void setRace() {
        character.setRace(Character.Race.Human);
        Assert.assertEquals(character.getRace(), Character.Race.Human);
    }

    @Test
    public void setSubrace() {
        character.setSubrace(Character.SubRace.Stormlander);
        Assert.assertEquals(character.getSubrace(), Character.SubRace.Stormlander);
    }

    @Test
    public void setWeaponHand() {
        character.setWeaponHand(Character.WeaponHand.Right);
        Assert.assertEquals(character.getWeaponHand(), Character.WeaponHand.Right);
    }

    @Test
    public void setNationality() {
        character.setNationality(Character.Nationality.Orc);
        Assert.assertEquals(character.getNationality(), Character.Nationality.Orc);
    }

    @Test
    public void setHeight() {
        character.setHeight(50);
        Assert.assertEquals(character.getHeight(),50);
    }

    @Test
    public void setWeight() {
        character.setWeight(500);
        Assert.assertEquals(character.getWeight(),500);
    }

    @Test
    public void setAge() {
        character.setAge(70);
        Assert.assertEquals(character.getAge(),70);
    }

    @Test
    public void setCombatPoints() {
        character.setCombatPoints(15);
        Assert.assertEquals(character.getCombatPoints(),15);
    }

    @Test
    public void setBackground() {
        character.setBackground("Background");
        Assert.assertEquals(character.getBackground(),"Background");
    }

    @Test
    public void setCharacteristics() {
        character.setCharacteristics("Scarred");
        Assert.assertEquals(character.getCharacteristics(),"Scarred");
    }

    @Test
    public void setRaud() {
        character.setRaud(15);
        Assert.assertEquals(character.getRaud(),15);
    }

    @Test
    public void setTotalExp() {
        character.setTotalExp(500);
        Assert.assertEquals(character.getTotalExp(),500);
    }

    @Test
    public void setUnusedExp() {
        character.setUnusedExp(200);
        Assert.assertEquals(character.getUnusedExp(),200);
    }

    @Test
    public void setEnvironment() {
        character.setEnvironment(Character.Environment.Nature);
        Assert.assertEquals(character.getEnvironment(), Character.Environment.Nature);
    }

    @Test
    public void setPositiveTrait1() {
        character.setPositiveTrait1(Character.SpecialTrait.Strength);
        Assert.assertEquals(character.getPositiveTrait1(), Character.SpecialTrait.Strength);
    }

    @Test
    public void setPositiveTrait2() {
        character.setPositiveTrait2(Character.SpecialTrait.Agility);
        Assert.assertEquals(character.getPositiveTrait2(), Character.SpecialTrait.Agility);
    }

    @Test
    public void setNegativeTrait() {
        character.setNegativeTrait(Character.SpecialTrait.Intelligence);
        Assert.assertEquals(character.getNegativeTrait(), Character.SpecialTrait.Intelligence);
    }
}