package lab_6;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(2005);
            System.out.println("The socket is running on port: " + server.getLocalPort());
            while (true) {
                System.out.println("Waiting for the client");
                Socket socket = server.accept();
                System.out.println("Connected to the client: " + socket.toString());
                OutputStream out = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(out);
                Date date = new Date();
                writer.write(date.toString() + "\r\n");

                writer.flush();
                writer.close();

            }
        } catch (IOException e) {
            System.out.println("Exception occurs: " + e.getMessage());
        }
    }
}
