package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("192.168.1.5", 7777);
            // Handle inputStream
            InputStream inputStream = socket.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader fromServer = new BufferedReader(reader);
            // Handle outputStream
            OutputStream outputStream = socket.getOutputStream();
            PrintStream toServer = new PrintStream(outputStream);
        ){

            while (true) {

                Scanner keyboardScanner = new Scanner(System.in);
                String message = keyboardScanner.nextLine();
                toServer.println(message);

                String response = fromServer.readLine();
                System.out.println("Server: " + response);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
