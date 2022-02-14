package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TextFile {
    Path path;

    public TextFile (Path location){
        path = location.resolve(
                LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("MM-dd-yy-hh-mm-ss"))
                        +".txt"
        );

        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append (List<String> list) throws IOException{
        try (var writer = Files.newBufferedWriter(path)) {
            for (var line : list) {
                writer.append(line);
            }
            writer.flush();
        }

        try (var reader = Files.newBufferedReader(path)) {
            System.out.println("Reading from file: ");
                String currentLine;
                while ((currentLine = reader.readLine()) != null)
                    System.out.println(currentLine);
        }
    }
}
