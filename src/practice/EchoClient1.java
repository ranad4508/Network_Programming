package practice;

import java.io.*;
import java.net.Socket;

public class EchoClient1 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 2010)){
            StringBuilder content = new StringBuilder("Hello Dinesh");
            socket.setSoTimeout(5000);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(content.toString());
            writer.newLine();
            writer.flush();
            System.out.println("Data sent to the server: "+content);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();
            System.out.println("Data from server: "+response);
            socket.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
