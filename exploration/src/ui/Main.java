package ui;


import fileSystem.TextFile;
import fileSystem.TestDirectory;
import objects.Beetle;
import objects.Insect;
import objects.LocalClass;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static util.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("Exploration Main");
        checkAnonymousClass();
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

    public static void checkAnonymousClass() {
        var anon = new Beetle() {
            @Override
            public void printData() {
                System.out.println("Anonymous Beetle overwrite");
                super.printData();
            }
        };
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
