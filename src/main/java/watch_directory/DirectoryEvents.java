package watch_directory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryEvents {


    public static void main(String[] args) throws IOException, InterruptedException {

        Path dir = Paths.get(URI.create("file:///tmp"));
        FileSystem fileSystem = dir.getFileSystem();

        WatchService watchService = fileSystem.newWatchService();

        WatchKey key = dir.register(watchService,
                ENTRY_CREATE,
                ENTRY_MODIFY,
                ENTRY_DELETE);

        while (key.isValid()) {
            WatchKey take = watchService.take();
            List<WatchEvent<?>> events = take.pollEvents();
            for (WatchEvent<?> event: events) {
                if (event.kind() == OVERFLOW) {
                    continue;
                } else if (event.kind() == ENTRY_CREATE) {
                    printEvent(event, "Creation");
                } else if (event.kind() == ENTRY_MODIFY) {
                    printEvent(event, "Modified");
                } else if (event.kind() == ENTRY_DELETE) {
                    printEvent(event, "Delete");
                }
            }
            take.reset();
        }
        System.out.println("Key is invalid");
    }

    private static void printEvent(WatchEvent<?> event, String s) throws IOException {
        Path path = (Path) event.context();
        System.out.printf("File %s: %s - %s\n", s, path, Files.probeContentType(path));
    }
}
