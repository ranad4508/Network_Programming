package lab_1;
/*
* WAP to find the canonical and host name of a given IP.
* */

import java.net.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Question3_CanonicalHostName {
    public static void main(String[] args) {
        try {
            // Defining byte array of address
//            byte[] addr = {104, 21, 76, 34};

            // Creating object of InetAddress and calling getByAddress which accepts byte array
            InetAddress ip1 = InetAddress.getByName("www.tu.edu.np");

            // Calling getCanonicalHostName() and getHostName()
            System.out.println("Canonical Host name: " + ip1.getCanonicalHostName());
            System.out.println("Host Name: " + ip1.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve host: " + e.getMessage());
        }
    }
}
