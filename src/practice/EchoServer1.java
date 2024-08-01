package practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer1 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(2010);) {
            System.out.println("Server is ready for client connection");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Connected to the client: " + socket.toString());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Data read from client: " + line.toString());
                        System.out.println("Server echoes: " + line);
                        writer.newLine();
                        writer.flush();
                        System.out.println("Data written back to the client");


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
