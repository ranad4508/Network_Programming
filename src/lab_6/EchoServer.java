package lab_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(2005)) {
            System.out.println("Server is ready for the client connection");

            while (true) {
                try (Socket conn = server.accept()) {
                    System.out.println("Connected to the client " + conn);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Data read from client: " + line);
                        writer.write("Server echoes: " + line);
                        writer.newLine();
                        writer.flush();
                        System.out.println("Data written back to the client");
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Could not start server: " + e.getMessage());
        }
    }
}