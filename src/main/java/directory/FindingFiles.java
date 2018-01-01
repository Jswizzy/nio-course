package directory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class FindingFiles {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(URI.create("file:////tmp"));

        boolean exists = Files.exists(path);
        System.out.println("Exists = " + exists);

        Stream<Path> pathStream1 = Files.find(path, Integer.MAX_VALUE, (p, attr) -> true);
        Stream<Path> pathStream2 = Files.find(path, Integer.MAX_VALUE, (p, attr) -> p.toString().endsWith(".jpg"));

        System.out.println("Count = " + pathStream1.count());
        System.out.println("Count = " + pathStream2.count());

        BasicFileAttributes attributes = null;
        FileTime creationTime = attributes.creationTime();
        creationTime.toMillis();

        Calendar c = GregorianCalendar.getInstance();
        c.set(2017, Calendar.JANUARY, 1, 0, 0);
        long timeInMillis = c.getTimeInMillis();

        Stream<Path> pathStream3 =
                Files.find(path, Integer.MAX_VALUE, (p, attr) -> attr.creationTime().toMillis() < timeInMillis);
        System.out.println("count = " + pathStream3.count());
    }
}
