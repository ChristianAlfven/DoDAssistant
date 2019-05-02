package CharacterFile;

public class Health {

    private int head;
    private int rightArm;
    private int leftArm;
    private int chest;
    private int body;
    private int rightLeg;
    private int leftLeg;

    public Health(int health){
        head = (health + 1) / 2;
        rightArm = head;
        leftArm = head;
        chest = health;
        if (health % 3 == 0) {
            body = (health / 3) * 2;
        } else{
            body = (health / 3) + 1;
            }

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

    public void setBody(int body) {
        this.body = body;
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

    public int getBody() {
        return body;
    }

    public int getRightLeg() {
        return rightLeg;
    }

    public int getLeftLeg() {
        return leftLeg;
    }
}
