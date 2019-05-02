package CharacterFile;

public class Armor {

    private int head;
    private int rightArm;
    private int leftArm;
    private int chest;
    private int stomach;
    private int rightLeg;
    private int leftLeg;

    public Armor(){
        head = 0;
        rightArm = 0;
        leftArm = 0;
        chest = 0;
        stomach = 0;
        rightLeg = 0;
        leftLeg = 0;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setRightArm(int rightArm) {
        this.rightArm = rightArm;
    }

    public void setLeftArm(int leftArm) {
        this.leftArm = leftArm;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public void setStomach(int stomach) {
        this.stomach = stomach;
    }

    public void setRightLeg(int rightLeg) {
        this.rightLeg = rightLeg;
    }

    public void setLeftLeg(int leftLeg) {
        this.leftLeg = leftLeg;
    }

    public int getHead() {
        return head;
    }

    public int getRightArm() {
        return rightArm;
    }

    public int getLeftArm() {
        return leftArm;
    }

    public int getChest() {
        return chest;
    }

    public int getStomach() {
        return stomach;
    }

    public int getRightLeg() {
        return rightLeg;
    }

    public int getLeftLeg() {
        return leftLeg;
    }
}

