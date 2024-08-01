package lab_1;

/*
* WAP to find all the addresses of dns.google.com
* [check at your college and home as well]
* */

import java.net.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Question4_FindGoogleAddr {
    public static void main(String[] args) throws  UnknownHostException {
        String url = "dns.google.com";
        InetAddress ip1 = InetAddress.getByName(url);
        System.out.println("Host Name"+ip1.getHostName());
        System.out.println("IP Address: "+ip1.getHostAddress());


        InetAddress[] ip2 = InetAddress.getAllByName(url);
        for(InetAddress ip :ip2){
            System.out.println(ip);
        }
    }
}
