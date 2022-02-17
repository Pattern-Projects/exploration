package util;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Paths {
    private static FileSystem fileSytem;
    private static Path path;
    public static void test() {
        System.out.println("utils Paths.test()");
    }

    public static void connect() throws IOException {
        System.out.println("Connecting to default file system:");
        fileSytem = FileSystems.getDefault();
    }

    public static void setPath(String location) throws IOException{
        try {
            if (fileSytem == null) {
                System.out.println("File System not initialised, calling connect()");
                connect();
            }

            path = fileSytem.getPath(location);
            System.out.println("Path Set");
            printPath();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeDirectories() throws IOException{
        Files.createDirectories(path);
    }

    public static boolean pathIsSet() {
        return path != null;
    }

    public static boolean pathExists() {
        if (pathIsSet()) return Files.exists(path);
        else return false;
    }

    public static void printPath() {
        System.out.println(path);
        System.out.println(path.toAbsolutePath().normalize());
    }
}
