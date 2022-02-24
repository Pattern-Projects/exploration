package objects;

public class LocalClass {
    private int length = 5;
    public void calculate() {
        final int width = 20;
        class MyLocalCLass {
            public static int value = 3;
            private int pri = 13;
            private static int prista = 23;
            public void multiply() {
                System.out.println(length*width);
            }
        }
        MyLocalCLass local = new MyLocalCLass();
        local.multiply();
        System.out.println(local.value);
        System.out.println(MyLocalCLass.value);

        System.out.println(local.pri);
        System.out.println(local.prista);

    }
}
