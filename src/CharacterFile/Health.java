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

    private int maxTotal;
    private int maxHead;
    private int maxRightArm;
    private int maxLeftArm;
    private int maxChest;
    private int maxStomach;
    private int maxRightLeg;
    private int maxLeftLeg;

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
        leftLeg = stomach;
        rightLeg = stomach;

        maxTotal = total;
        maxHead = head;
        maxRightArm = rightArm;
        maxLeftArm = leftArm;
        maxChest = chest;
        maxStomach = stomach;
        maxRightLeg = rightLeg;
        maxLeftLeg = leftLeg;
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

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxHead() {
        return maxHead;
    }

    public void setMaxHead(int maxHead) {
        this.maxHead = maxHead;
    }

    public int getMaxRightArm() {
        return maxRightArm;
    }

    public void setMaxRightArm(int maxRightArm) {
        this.maxRightArm = maxRightArm;
    }

    public int getMaxLeftArm() {
        return maxLeftArm;
    }

    public void setMaxLeftArm(int maxLeftArm) {
        this.maxLeftArm = maxLeftArm;
    }

    public int getMaxChest() {
        return maxChest;
    }

    public void setMaxChest(int maxChest) {
        this.maxChest = maxChest;
    }

    public int getMaxStomach() {
        return maxStomach;
    }

    public void setMaxStomach(int maxStomach) {
        this.maxStomach = maxStomach;
    }

    public int getMaxRightLeg() {
        return maxRightLeg;
    }

    public void setMaxRightLeg(int maxRightLeg) {
        this.maxRightLeg = maxRightLeg;
    }

    public int getMaxLeftLeg() {
        return maxLeftLeg;
    }

    public void setMaxLeftLeg(int maxLeftLeg) {
        this.maxLeftLeg = maxLeftLeg;
    }

    @Override
    public String toString() {
        return "" + total;
    }


}
