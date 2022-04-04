package objects;

public class SelfIncrementingIdClass {
    private static long increment;
    private long id;

    //Each new object has incremented id
    {id = ++increment;}

    public long getId() {
        return id;
    }
}

