package basic_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInAction {

    public static void main(String[] args) {

        //File file = new File("files/hello-utf8.txt");

        /*System.out.println(file.getName());
        System.out.println(file.exists());

        File nope = new File("files/nope.txt");
        System.out.println(nope.getName());
        System.out.println(nope.exists());
        nope.createNewFile();*/

        Path path = Paths.get("files/hello-utf8.txt");
        //try (Reader reader = new FileReader(file)) {
        try (Stream<String> lines = Files.newBufferedReader(path).lines()) {
            //BufferedReader bufferedReader = new BufferedReader(reader);

            //BufferedReader bufferedReader = Files.newBufferedReader(path);

            lines.forEach(System.out::println);

//            String line = bufferedReader.readLine();
//
//            while(line != null) {
//                System.out.println(line);
//                line = bufferedReader.readLine();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
