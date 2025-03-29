import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8080)) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            Scanner sc = new Scanner(in);
            Scanner sc1 = new Scanner(System.in);
            Formatter formatter = new Formatter(out);
            while (true){
                String line = sc1.nextLine();
                formatter.format("%s\n", line);
                formatter.flush();
                System.out.println("message from client has been sent");
                if (sc.hasNextLine()){
                    String line1 = sc.nextLine();
                    System.out.println("Server Response: " + line1);
                }
            }
        }
    }
}
