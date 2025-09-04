import java.net.*;
import java.io.*;

public class TCPserver {


    public static void main(String[] args) {
        //Definere hvilken port der skal benyttes
        int port = 5000;
        TCPclient client = new TCPclient();

        //Opretter en Socket ved opstart
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Socket listening to port: " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Socket connected to client");

            //Initialiser BufferedReader og Writer
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // Laver den kommende String som skal echoes
            String message = reader.readLine();
            System.out.println("Message received from: " + client.host + ": " + message);
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
