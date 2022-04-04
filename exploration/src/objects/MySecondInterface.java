package objects;

public interface MySecondInterface {

    int x = 10;
    int myAbstractMethod();
    int mySecondAbstractMethod();
    default int myDefaultMethod(){ return myPrivateStaticMethod(); }

    static int myStaticMethod() { return myPrivateStaticMethod(); }
    private int myPrivateMethod() { return myAbstractMethod(); }
    private static int myPrivateStaticMethod() { return myStaticMethod(); }

}

