import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8765;
        try (Socket client = new Socket(host, port);
             PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))){

            writer.println("Mixasik");

            String result = reader.readLine();
            System.out.println(result);

        } catch (IOException ex){
            System.out.println(ex.getMessage()
            );
        }
    }
}
