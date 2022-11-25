import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class SqClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(System.in);
           int un = in.nextInt();
            while (un < 10){
                outputStream.write(un);
                System.out.println("Отправлено " + un);
                outputStream.flush();
                int response = inputStream.read();
                System.out.println("Получено " + response);
                un = response +1;
            }



        }
    }
}
