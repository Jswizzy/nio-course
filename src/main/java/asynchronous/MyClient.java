package asynchronous;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class MyClient {

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 12345);
        SocketChannel socketChannel = SocketChannel.open(address);
        Socket socket = socketChannel.socket();

        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("REQUEST\n");
        socketChannel.write(StandardCharsets.UTF_8.encode(buffer));
        socket.close();
    }
}
