package lab_6;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server at localhost on port 2005
            Socket socket = new Socket("localhost", 2005);

            // Create a StringBuilder with the content to be sent to the server
            StringBuilder content = new StringBuilder("Hello Dinesh");

            // Set a timeout of 5000 milliseconds (5 seconds) for the socket
            socket.setSoTimeout(5000);

            // Get the output stream to send data to the server
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Write the content to the server followed by a newline character
            writer.write(content.toString());
            writer.newLine();
            writer.flush();

            // Print a confirmation message indicating that data was sent to the server
            System.out.println("Data sent to server: " + content);

            // Get the input stream to read data from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the response from the server
            String response = reader.readLine();

            // Print the content received from the server
            System.out.println("Content from the server: " + response);

            // Close the socket
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}