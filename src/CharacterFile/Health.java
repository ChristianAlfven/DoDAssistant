package CharacterFile;

public class Health {

    private int total;
    private int head;
    private int rightArm;
    private int leftArm;
    private int chest;
    private int stomach;
    private int rightLeg;
    private int leftLeg;

    public Health(int health){
        total = health;
        head = (health + 1) / 2;
        rightArm = head;
        leftArm = head;
        chest = health;
        if (health % 3 == 0) {
            stomach = (health / 3) * 2;
        } else{
            stomach = (health / 3) + 1;
            }

    }

    public void setTotal(int total) { this.total = total; }

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

    public int getTotal() { return total; }

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
