import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Formatter formatter = new Formatter(outputStream);
        Scanner scannerin = new Scanner(System.in);
        Scanner scanner = new Scanner(inputStream);

        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Received: " + line);
            }
            String line = scannerin.nextLine();
            formatter.format("%s\n", line);
            formatter.flush();
        }
    }
}
