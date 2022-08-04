import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        int port = 8765;
        try (ServerSocket server = new ServerSocket(port)){
            System.out.println("Server started");
            while (true) {
                Socket client = server.accept();
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.printf("New connection, Port: %d%n", client.getPort());
                final String name = reader.readLine();
                writer.println(String.format("Hi %s, your port is %d", name, client.getPort()));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
