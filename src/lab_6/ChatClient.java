package lab_6;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2005);
            System.out.println("Connected to the chat server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage = in.readLine();
            System.out.println("Server: " + serverMessage);

            String message;
            while (true) {
                System.out.print("You: ");
                message = userInput.readLine();
                out.write(message);
                out.newLine();
                out.flush();

                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}