import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;


@SuppressWarnings("InfiniteLoopStatement")
public class SqServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }
    private static void serverClient(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("Serving client" + socket.getInetAddress());
        int request;
        do {
            request = inputStream.read();
            System.out.println("Request: " + request);
            request = request + 1;
            System.out.println("Response: " + request);
            outputStream.write(request);
            outputStream.flush();
        }
        while (request <= 10);



    }
}
