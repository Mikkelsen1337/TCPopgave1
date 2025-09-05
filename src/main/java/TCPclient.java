import java.io.*;
import java.net.*;

public class TCPclient {


    static String host = "localhost";

    public static void main(String[] args) {


        String hostname = host;
        int port = 5000;


        try(Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            {
                socket.setSoTimeout(5000);
                writer.println("Goddag fætterguf");
                String response = reader.readLine();
                System.out.println("Server response: " + response);

            }
        } catch(ConnectException ce) {
            System.out.println("Forsøger at skabe forbindelse");

        } catch(SocketTimeoutException s) {
            System.out.println("Socket timed out....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

