package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try(ServerSocket server = new ServerSocket(7777);
            Socket client = server.accept();
            // Handle the SocketInputStream
            InputStream inputStream = client.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader fromClient = new BufferedReader(reader);
            // Handle the SocketOutputStream
            OutputStream outputStream= client.getOutputStream();
            PrintStream toClient = new PrintStream(outputStream)
            ;){

                while (true) {

                    String response = fromClient.readLine();
                    System.out.println("Client: " +response);
                    Scanner keyboardScanner = new Scanner(System.in);
                    String message = keyboardScanner.nextLine();
                    toClient.println(message);
                }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
