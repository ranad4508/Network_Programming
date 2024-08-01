package lab_1;
/*
* WAP to find the name and IP address of your local machine.
* */

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Question2_FindIPName {
    public static void main(String[] args) throws UnknownHostException {

//        Creating object of InetAddress and calling getLocalHost() method to get the local host detail
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("Host Name: "+ip1.getHostName());//display local host name
        System.out.println("Host IP: "+ip1.getHostAddress());//display local host ip

    }
}
