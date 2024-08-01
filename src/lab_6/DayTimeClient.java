package lab_6;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 2005);
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int i = -1;
            StringBuilder content = new StringBuilder();
            while ((i=reader.read())!=-1){
                content.append((char)i);
            }
            System.out.println("Server returned: "+content);
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
