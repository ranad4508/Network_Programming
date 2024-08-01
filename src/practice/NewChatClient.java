package practice;

import java.io.*;
import java.net.Socket;

public class NewChatClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 2005);
            System.out.println("Connected to the chat server: "+socket);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage = reader.readLine();
            System.out.println("Server: "+serverMessage);

            String message;
            while(true){
                System.out.println("You: ");
                message = userInput.readLine();
                writer.write(message);
                writer.newLine();
                writer.flush();

                serverMessage = reader.readLine();
                System.out.println("Server: "+serverMessage);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
