package practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NewChatServer {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2005);
            System.out.println("Server is ready for client connection");

            while (true){
                Socket socket = server.accept();
                System.out.println("Server is connected to the client: "+socket.toString());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                out.write("Welcome to chat server!");
                out.newLine();
                out.flush();

                String message;
                while ((message = in.readLine())!=null){
                    System.out.println("Client: "+message);
                    System.out.println("Server: ");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String response = reader.readLine();
                    out.write(response);
                    out.newLine();
                    out.flush();

                }
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
