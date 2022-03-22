package objects;

import java.util.ArrayList;
import java.util.List;

public class Insect {
    public boolean hasFur = false;
    protected int numberOfLegs = 4;
    String label = "buggy";

    //A method to check covariant return types
    public List<String> myMethod() {
        return new ArrayList<>();
    }

    //A method to check covariant parameter types
    public void myParameterMethod(ArrayList<String> list) {
        System.out.println("Parent");
    }
}
