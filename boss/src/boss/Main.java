package boss;

import utils.TextFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static utils.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("boss main");
        test();

        var txt = new TextFile(Path.of("..\\test_folder\\abc"));
        List<String> list = new ArrayList<>();
        list.add("text file sup");
        list.add("Well hello there");

        try {
            txt.append(list);
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
