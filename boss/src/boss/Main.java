package boss;

import java.io.IOException;

import static utils.Paths.*;

public class Main {
    public static void main(String... args) {
        System.out.println("boss main");
        test();

        try {
            connect();
            System.out.println(pathIsSet());
            System.out.println(pathExists());

            setPath("C:\\Users\\publi\\Documents\\Java-Practice\\test_folder");
            System.out.println(pathIsSet());
            System.out.println(pathExists());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
