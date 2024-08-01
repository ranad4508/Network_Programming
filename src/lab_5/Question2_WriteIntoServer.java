package lab_5;
import java.net.*;
import java.io.*;
public class Question2_WriteIntoServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time.nist.gov", 13);
        socket.setSoTimeout(5000);
        //Method 1
        OutputStream out = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(out, "UTF-8");
        writer = new BufferedWriter(writer);
        //Method 2
        //        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("bye\r\n");
        writer.flush();
        System.out.println("Write to server");

    }
}
