package filesystems;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class DiskFileSystemOperations {

    public static void main(String[] args) throws IOException {

        List<FileSystemProvider> fileSystemProviders = FileSystemProvider.installedProviders();
        fileSystemProviders.forEach(System.out::println);

        FileSystemProvider linuxFSP = fileSystemProviders.get(0);

        FileSystem fileSystem = FileSystems.getDefault();

/*        URI rootURI = URI.create("file:///");
        FileSystem fileSystem = FileSystems.getFileSystem(rootURI);*/

/*        // all three are the same filesystem

        System.out.println(fileSystem1 == fileSystem2);

        //Path dir = Paths.get("tmp/tmp-dir");
        Path dir = Paths.get(URI.create("file:////tmp/tmp-dir2"));
        linuxFSP.createDirectory(dir);*/

        Iterable<Path> rootDirectories = fileSystem.getRootDirectories();

        rootDirectories.forEach(System.out::println); // /

        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        fileStores.forEach(fileStore -> System.out.println("type = " + fileStore.name() + "-" + fileStore.type()));

    }
}
