package boss;

import java.io.IOException;

import static utils.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("boss main");
        test();

        try {
            connect();
            setPath("..\\test_folder");
            System.out.println(path.toAbsolutePath());
            System.out.println(pathExists());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
