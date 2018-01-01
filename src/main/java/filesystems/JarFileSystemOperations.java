package filesystems;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class JarFileSystemOperations {

    public static void main(String[] args) throws IOException {

        URI zip = URI.create("jar:file:////tmp/archive.zip");

        Map<String, String> options = new HashMap<>();
        options.put("create", "true");


        try (FileSystem zipFS = FileSystems.newFileSystem(zip, options)) {
            Path dir = zipFS.getPath("files/");
            zipFS.provider().createDirectory(dir);

            Path a = Paths.get("files/ints.bin");
            Path b = zipFS.getPath("files/ints-compressed.bin");

            Files.copy(a, b);

            Path binDir = zipFS.getPath("bin/");
            Path binFile = zipFS.getPath("bin/ints.bin");

            zipFS.provider().createDirectory(binDir);

            OutputStream os =
                    zipFS.provider().newOutputStream(binFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(10);
            dos.writeInt(20);
            dos.writeInt(30);
            dos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
