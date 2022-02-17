package ui;


import fileSystem.TextFile;

import java.io.IOException;
import java.nio.file.Path;

import static util.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("Exploration Main");
//        checkPaths();
        checkTextFile();
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

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
