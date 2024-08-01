package lab_1;
/*
* WAP to list the names and display name of all network adapters in your machine.
* */

import java.net.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Question6_NetworkAdapter {
    public static void main(String[] args) throws UnknownHostException{
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Adapter Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
