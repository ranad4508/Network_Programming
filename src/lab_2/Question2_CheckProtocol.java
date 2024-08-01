package lab_2;
/*
* Write a program that checks the protocols the host ioc.edu.np support
* [ex: http, https, ftp, telnet]
*
*
* */

import java.net.MalformedURLException;
import java.net.URL;

public class Question2_CheckProtocol {
    public static void main(String args[]) {
        try {
            String[] protocols = {"http", "https", "ftp", "telnet", "smtp"};
            String host = "oic.edu.np";
            for (String protocol : protocols) {
                try {
                    URL url = new URL(protocol, host, "");
                    System.out.println("Protocol " + protocol + " is supported.");
                } catch (MalformedURLException e) {
                    System.out.println("Protocol " + protocol + " is not supported.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
