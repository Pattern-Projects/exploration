package ui;


import fileSystem.TextFile;

import java.io.IOException;
import java.nio.file.Path;

import static util.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("Exploration Main");
        test();

        var txt = new TextFile(Path.of("..\\test_folder\\output"));
        var txte = new TextFile(Path.of("..\\test_folder\\output"), "test.txt");

        try {
            txt.append("Hello there");
            txte.append("Hello there");
            txt.read();
        } catch (IOException e) {
            e.printStackTrace();
        }



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
