package lab_1;

/*
*WAP to check whether the addresses oic.edu.np and 104.21.76.34 are same.
* */

import java.net.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Question5_OIC {
    public static void main(String[] args) throws UnknownHostException {
        //Defining the ip address in byte array

        byte[] oic = {104, 21, 76, 34};

        //
        //Defining the url
        String url = "www.oic.edu.np";

        //getting the ip address of string url
        InetAddress ip1 = InetAddress.getByAddress(oic);

        //getting the ip address byte array
        InetAddress address = InetAddress.getByName(url);

        System.out.println("IP address from byte array: " + ip1.getHostAddress());
        System.out.println("IP address of " + url + ": " + address.getHostAddress());

        if(ip1.equals(address)){
            System.out.println("The addresses same");
        }else{
            System.out.println("The addresses are not same");
        }
    }
}
