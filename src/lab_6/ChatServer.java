package lab_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2005);
            System.out.println("Chat Server is ready for client connection");

            while (true) {
                Socket conn = server.accept();
                System.out.println("Connected to client: " + conn);

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

                out.write("Welcome to the chat server!");
                out.newLine();
                out.flush();

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);

                    System.out.print("Server: ");
                    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                    String response = userInput.readLine();
                    out.write(response);
                    out.newLine();
                    out.flush();
                }

                System.out.println("Client disconnected");
                conn.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}