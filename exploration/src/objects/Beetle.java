package objects;

import java.util.ArrayList;
import java.util.List;

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

    //A method to check covariant return types
    public List<String> myMethod() {
        List<String> m = new ArrayList<>();
        m.add("1");
        return m;
    }

//    @Override
    //This is an overloaded class because the parameter has changed
    public void myParameterMethod(List<String> list) {
        System.out.println("Child");
    }
}
