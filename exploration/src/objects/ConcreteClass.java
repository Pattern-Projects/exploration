package objects;

public class ConcreteClass extends AbstractClass{

    @Override
    public void isAbstract() {
        System.out.println("isAbstract");
    }

    public void notAbstract() {
        System.out.println("notAbstact");
    }

    public void overloading(Integer x) {
        System.out.println("Overloading: Integer");
    }

//    public void overloading(int x) {
//        System.out.println("Overloading: int");
//    }

    public void overloading(double x) {
        System.out.println("Overloading: double");
    }

    public void overloading(int... x) {
        System.out.println("Overloading: int varargs");
    }
}
