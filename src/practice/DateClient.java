package practice;
import java.io.*;
import java.net.*;
import java.util.*;

public class DateClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 2005);
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int i = -1;
            StringBuilder content = new StringBuilder();
            while((i=reader.read())!=-1){
                content.append((char)i);
            }
            System.out.println("Content from server: "+content);
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
