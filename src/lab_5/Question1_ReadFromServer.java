package lab_5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.*;
import java.io.*;
public class Question1_ReadFromServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("time.nist.gov", 13);
        socket.setSoTimeout(5000);
        InputStream in = socket.getInputStream();
        StringBuilder time = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(in, "ASCII");
        int i = -1;
        while((i = reader.read())!=-1){
            time.append((char)i);

        }
        System.out.println(time.toString());
        socket.close();

    }
}
