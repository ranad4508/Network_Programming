package lab_1;
/*
*WAP to process the server log files.
* */

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Question9_ServerLog {
    public static void main(String[] args) {
        String log_path = "C:\\Users\\Dinesh\\IdeaProjects\\NetworkProgrammingLab\\src\\lab_1\\serverlog.log";
        try(
                FileInputStream fin = new FileInputStream(log_path);
                Reader in = new InputStreamReader(fin);
                BufferedReader bin = new BufferedReader(in)
        ){
            for(String entry = bin.readLine(); entry != null; entry = bin.readLine()){
                //separate out the ip address
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                System.out.println("Access by client "+ip);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}