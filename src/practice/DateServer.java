package practice;
import java.io.*;
import java.net.*;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(2005);
            System.out.println("Server running on port: "+server.getLocalPort());
            System.out.println("Waiting for client");
            Socket socket = server.accept();
            System.out.println("Connected to the client: "+socket.toString());
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out);
            Date date = new Date();
            writer.write(date.toString());
            writer.flush();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
