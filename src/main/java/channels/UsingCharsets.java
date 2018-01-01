package channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class UsingCharsets {

    public static void main(String[] args) throws IOException {

        Charset latin1 = StandardCharsets.ISO_8859_1;
        Charset utf8 = StandardCharsets.UTF_8;

        String hello = "Hello from Justin";
        System.out.println("Length = " + hello.length());

        CharBuffer charBuffer = CharBuffer.allocate(1024 * 1024);
        
        charBuffer.put(hello);
        charBuffer.flip();

        ByteBuffer buffer = utf8.encode(charBuffer);
        Path path = Paths.get("files/hello-utf8.txt");
        try (FileChannel channel = FileChannel.open(path, CREATE, WRITE)) {
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File size = " + Files.size(path));

        path = Paths.get("files/hello-utf8.txt");
        buffer.clear();

        try (FileChannel channel = FileChannel.open(path, READ)) {
            channel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer.flip();
        charBuffer = utf8.decode(buffer);

        String result = new String(charBuffer.array());

        System.out.println(result);


    }
}
