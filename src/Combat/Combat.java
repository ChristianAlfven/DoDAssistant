package Combat;
import CharacterFile.Character;
import CharacterFile.Armor;
import CharacterFile.Health;
//2019-04-30 time spent: 3h
//2019-05-01 time spent: 14:17-17:15
//2019-05.02 time spent: 12:00-

import java.util.Scanner;

public class Combat {

    Scanner input = new Scanner(System.in);

    Character player;
    Character enemy;
    int playerPoints;
    int enemyPoints;

    public Combat(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void initiative() {
        System.out.println("Enter player initiative (D10):");
        int playerInitiative = input.nextInt();
        System.out.println("Enter enemy initiative (D10):");
        int enemyInitiative = input.nextInt();

        combatRound(playerInitiative, enemyInitiative);
    }

    public void combatRound(int pInit, int eInit) {
        boolean playerTurn;
        playerPoints = player.getCombatPoints();
        enemyPoints = enemy.getCombatPoints();

        if (pInit <= eInit) {
            System.out.print("Players choice! \n");
        } else {
            System.out.print("Enemies choice! \n");
        }
        System.out.println("Will player attack first? (true/false)");

        playerTurn = booleanInput();

        if (playerTurn) {
            playerAttack();
            enemyAttack();
        } else {
            enemyAttack();
            playerAttack();
        }
    }

    public void playerAttack() {
        boolean active = true;
        int activePoints;
        int diceValue;

        while (active) {
            System.out.print("\nPlayer combatpoints: " + playerPoints + "\n");
            System.out.print("How many points for player attack? \n");
            activePoints = input.nextInt();
            playerPoints = playerPoints - activePoints;
            System.out.print("Enter value of dice (D20): \n");
            diceValue = input.nextInt();

            if (diceValue <= activePoints) {
                System.out.print("Attack is successful. \n\n"
                        + "Enemy combatpoints: " + enemyPoints + "\n"
                        + "How many points for enemy parry? \n");
                activePoints = input.nextInt();
                if (activePoints != 0) {
                    enemyPoints = enemyPoints - activePoints;
                    System.out.print("Enter value of dice (D20): \n");
                    diceValue = input.nextInt();
                    if (diceValue <= activePoints) {
                        System.out.print("Enemy parry attack! \n\n");
                    } else {
                        damage(true);
                    }
                } else {
                    System.out.print("Attack missed! \n\n");
                }
            } else {
                System.out.print("Attack missed! \n\n");
            }
            System.out.print("\nContinue attacking? (true/false) \n");
            active = booleanInput();
        }

    }

    public void enemyAttack() {
        boolean active = true;
        int activePoints;
        int diceValue;

        while (active) {
            System.out.print("\nEnemy combatpoints: " + enemyPoints + "\n");
            System.out.print("How many points for enemy attack? \n");
            activePoints = input.nextInt();
            enemyPoints = enemyPoints - activePoints;
            System.out.print("Enter value of dice (D20): \n");
            diceValue = input.nextInt();

            if (diceValue <= activePoints) {
                System.out.print("Attack is successful! \n\n"
                        + "Player combatpoints: " + playerPoints + "\n"
                        + "How many points for player parry? \n");
                activePoints = input.nextInt();
                if (activePoints != 0) {
                    playerPoints = playerPoints - activePoints;
                    System.out.print("Enter value of dice (D20): \n");
                    diceValue = input.nextInt();
                    if (diceValue <= activePoints) {
                        System.out.println("Player parry attack! \n\n");
                    } else {
                        damage(false);
                    }
                } else {
                    System.out.print("Attack missed! \n\n");
                }
            } else {
                System.out.print("Attack missed! \n\n");
            }
            System.out.print("\nContinue attacking? (true/false \n");
            active = booleanInput();
        }
    }

    public void damage(boolean playerAttack) {
        int part;
        int dmg;
        Health hp;
        Armor armor;

        if(playerAttack){
            hp = enemy.getHealth();
            armor = enemy.getArmor();
        }else{
            hp = player.getHealth();
            armor = player.getArmor();
        }

        System.out.print("\nEnter value for bodypart hit (D20): \n");
        part = input.nextInt();
        part = hitTable(part);
        System.out.print("\nEnter value for damage done (D20): \n");
        dmg = input.nextInt();

        switch (part) {
            case 1: //Head
                dmg = dmg - armor.getHead();
                if (dmg > 0) {
                    hp.setHead(hp.getHead() - dmg);
                }
                break;
            case 2: //Right arm
                dmg = dmg - armor.getRightArm();
                if (dmg > 0) {
                    hp.setRightArm(hp.getRightArm() - dmg);
                }
                break;
            case 3: //Left arm
                dmg = dmg - armor.getLeftArm();
                if (dmg > 0) {
                    hp.setLeftArm(hp.getLeftArm() - dmg);
                }
                break;
            case 4: //Chest
                dmg = dmg - armor.getChest();
                if (dmg > 0) {
                    hp.setChest(hp.getChest() - dmg);
                }
                break;
            case 5: //Stomach
                dmg = dmg - armor.getStomach();
                if (dmg > 0) {
                    hp.setStomach(hp.getStomach() - dmg);
                }
                break;
            case 6: //Right leg
                dmg = dmg - armor.getRightLeg();
                if (dmg > 0) {
                    hp.setRightLeg(hp.getRightLeg() - dmg);
                }
                break;
            case 7: //Left leg
                dmg = dmg - armor.getLeftLeg();
                if (dmg > 0) {
                    hp.setLeftLeg(hp.getLeftLeg() - dmg);
                }
                break;
        }
        if (dmg > 0) {
            hp.setTotal(hp.getTotal() - dmg);
            enemy.setHealth(hp);
        }
        System.out.print(""
                + "Head:\t          " +hp.getHead()
                + "\nRight arm:\t   " +hp.getRightArm()
                + "\nLeft arm:\t    " +hp.getLeftArm()
                + "\nChest:\t       " +hp.getChest()
                + "\nStomach:\t     " +hp.getStomach()
                + "\nRight leg:\t   " +hp.getRightLeg()
                + "\nLeft leg:\t    " +hp.getLeftLeg()
                + "\nTotal:\t       " +hp.getTotal()
                +"\n\n");

    }

    public int hitTable(int diceValue) {
        switch (diceValue) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 3;
            case 7:
                return 4;
            case 8:
                return 4;
            case 9:
                return 4;
            case 10:
                return 4;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 5;
            case 14:
                return 5;
            case 15:
                return 6;
            case 16:
                return 6;
            case 17:
                return 6;
            case 18:
                return 7;
            case 19:
                return 7;
            case 20:
                return 7;
            default:
                return 0;
        }
    }

    public boolean booleanInput() {
        boolean inputVal;
        inputVal = input.nextBoolean();
        return inputVal;
    }
}
