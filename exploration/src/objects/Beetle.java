package objects;

public class Beetle extends Insect {
    public boolean hasFur = true;
    protected int numberOfLegs = 6;
    protected short age = 3;
    protected short length;
    public void printData() {
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);
//        System.out.println(super.age);
        System.out.println(numberOfLegs);
        System.out.println(this.numberOfLegs);
        System.out.println(super.numberOfLegs);
    }

}
