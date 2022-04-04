package ui;


import annotations.MyAnnotation;
import fileSystem.TextFile;
import fileSystem.TestDirectory;
import objects.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static util.Paths.*;

public class Main {

    int a = 10;
    int b;

    public static void main(String... args) {
        System.out.println("Exploration Main");
        var main = new Main();
        checkMethodGeneric(new String("Hi"));
        checkMethodGeneric(new Integer(10));
        checkMethodGeneric(List.of(10, 20, 30));
//        checkMerge();
//        checkInterfaceMemberInteraction();
//        checkSelfIncrementingIdClass();
//        checkNullPointerEx();
//        checkOverLoadingAutoboxing();
//        checkAbstractAndConcreteClasses();
//        checkInnerClass(main);
//        checkDateTimeFormat();
//        checkPrimitiveStreamSummaryStatistics();
//        checkAnonymousClass();
//        checkFlatMap();
//        checkUnaryBooleanOperation();
//        checkMethods();
//        checkHiddenVariables();
//        checkSuperReference();
//        checkMethrefs();
//        checkLocalClass();
//        checkPaths();
//        checkTextFile();
//        checkTestDirectories();

    }

    @MyAnnotation(name = "Dan")
    @MyAnnotation(name = "Denise", age = 99)

    public static <T> void checkMethodGeneric(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
        list.add(t);
        list.add(t);
        list.forEach(System.out::println);
    }


    public static void checkMerge() {
        var sm = new HashMap<String, String>();

        BinaryOperator<String> mapper = (x, y) -> (x.length() > y.length() ? x : y );
        sm.put("John", "Jacob");
        sm.put("Jenny", "Jackson");

        sm.merge("John", "Joe", mapper);
        sm.merge("Jenny", "JohnJoeb", mapper);
        sm.merge("James", "JohnJoeb", mapper);

        System.out.println(sm);

        mapper = (x, y) -> (x.length() > y.length() ? x : null );
        sm.merge("John", "Joe", mapper);
        sm.merge("Jenny", "JohnJoeb", mapper);
        sm.merge("James", "JohnJoeb", mapper);
        System.out.println(sm);

    }

    public static void checkInterfaceMemberInteraction() {
        MySecondConcreteClass x = new MySecondConcreteClass();
        System.out.println(x.myAbstractMethod());
        System.out.println(x.myDefaultMethod());
        System.out.println(x.mySecondAbstractMethod());
    }

    public static void checkSelfIncrementingIdClass() {
        SelfIncrementingIdClass s1 = new SelfIncrementingIdClass();
        SelfIncrementingIdClass s2 = new SelfIncrementingIdClass();
        SelfIncrementingIdClass s3 = new SelfIncrementingIdClass();
        SelfIncrementingIdClass s4 = new SelfIncrementingIdClass();
        System.out.println(s1.getId());
        System.out.println(s2.getId());
        System.out.println(s3.getId());
        System.out.println(s4.getId());
    }

    public static void checkRepeatableAnnotation() {}

    public static void checkNullPointerEx() {
        String x = "hi";
        x.toString();
        x = null;
        x.toString();
    }

    public static void checkOverLoadingAutoboxing() {
        var con = new ConcreteClass();
        con.overloading(new Integer(10));
        con.overloading(10);
        con.overloading(10, 20);
    }

    public static void checkAnonymousClass() {
        AbstractClass as = new AbstractClass() {
            @Override
            public void isAbstract() {
                System.out.println("isAbstract in Anonymous class extends AbstractClass");
            }

        };

        as.notAbstract();
        as.isAbstract();
    }

    public static void checkAbstractAndConcreteClasses() {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.notAbstract();
        concreteClass.isAbstract();
//        AbstractClass abstractClass = new AbstractClass();
    }

    public static void checkInnerClass(Main main) {
        Inner inner = main.new Inner();
        inner.go();
    }

    class Inner {
        public int repeat = 3;
        public void go() {
            for (int i = 0 ; i < repeat ; i++) {
                System.out.println(a);
            }
        }
    }

    public Main() {
        b = 10;
    }

    public static void checkDateTimeFormat() {
        var dateTime = LocalDateTime.of(2020, Month.OCTOBER, 20, 6, 15, 30);
        var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");

        System.out.println(dateTime.format(formatter));
        System.out.println(formatter.format(dateTime));
    }

    public static void checkPrimitiveStreamSummaryStatistics() {
        String s = IntStream.of(1,2,3).summaryStatistics().toString();
        System.out.println(s);
    }


    public void checkAnonymousOverride() {
        final int x = 10;
        int y = 20;

        var anon = new Beetle() {
            @Override
            public void printData() {
                System.out.println("Anonymous Beetle overwrite");
                System.out.println(x + y);
                System.out.println(a + b);
                length++;
                System.out.println(age+length);
            }
        };

        //y must be final or effectively final
        //y++;

        anon.printData();
    }

    public static void checkUnaryBooleanOperation() {
        var bul = true;
        bul &= false;
        bul ^= false;
        bul |= false;
        System.out.println(bul);
    }

    public static void checkFlatMap() {
        var arr = new int[]{0, 1, 2};
        var arr2 = new int[]{3, 4, 5};

        Stream.of(arr,arr2)
                .flatMapToInt(IntStream::of)
                .forEach(System.out::println);
    }

    public static void checkMethods() {
        Main main = new Main();
        main.checkInstanceMethod();
        main.checkStaticMethod();
    }

    public static void checkStaticMethod() {
        System.out.println("Static method Ok");
    }

    public void checkInstanceMethod() {
        System.out.println("Instance method Ok");
    }

    public static void checkSuperReference() {
        new Beetle().printData();
    }

    public static void checkHiddenVariables() {
        Beetle beetle = new Beetle();
        Insect insect = beetle;
        System.out.println(beetle.hasFur);
        System.out.println(insect.hasFur);
    }

    /*
    * methrefs()
    * Method references exploration
    * Creates a list removes values if predicate is met
    * Prints list*/
    public static void checkMethrefs() {
        List<String> list = new ArrayList<>();
        list.add("Hey");
        list.add("Hi");
        list.add("Hello");
        list.add("Heya");
        list.add("Allo");

        String h = "Hello There";
        list.removeIf(h::contains);
        list.forEach(System.out::println);
        //        list.forEach((x) -> System.out.println(x));
    }




    public static void checkLocalClass() {
        LocalClass outer = new LocalClass();
        outer.calculate();
    }

    public static void checkTestDirectories() {
        try {
            var directory = TestDirectory.allDefault();
            directory.generateFromFile(Path.of("../files.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkTextFile() {
        var txt = new TextFile(Path.of("..\\test_folder\\output"));
        var existingtxt = new TextFile(Path.of("..\\test_folder\\output"), "test");

        try {
            txt.append("Hello there");
            existingtxt.append("Hello there");
            txt.read();
            existingtxt.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void checkPaths() {
        test();
        try {
            connect();
            setPath("..\\test_folder\\abc\\def\\ghi");
            makeDirectories();

            System.out.println(pathExists());
            walkPath();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
