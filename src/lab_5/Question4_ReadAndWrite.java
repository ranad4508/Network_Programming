package lab_5;
/*
* WAp to write into the server time.nist.gov at port 13 and read it to display on console
* */

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Question4_ReadAndWrite {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(5000);

            // Write to the server
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer = new BufferedWriter(writer);
            writer.write("bye\r\n");
            writer.flush();
            System.out.println("Write on server successfully");

            // Read from the server
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
