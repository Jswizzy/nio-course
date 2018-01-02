package basic_io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class WritingCharacters {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("some-text.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path, CREATE, WRITE, APPEND)) {
            PrintWriter pw = new PrintWriter(writer);
            pw.println("Hello World!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
