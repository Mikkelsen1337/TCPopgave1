import java.io.*;
import java.net.*;

public class TCPclient {


    static String host = "localhost";

    public static void main(String[] args) {


        String hostname = host;
        int port = 5000;


        try(Socket socket = new Socket(hostname, port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println("Goddag fætterguf");
            String response = reader.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

