package lab_1;
import java.net.Inet4Address.*;
import java.net.InetAddress.*;
import java.net.*;
import java.util.Arrays;


/*
* WAP to find the address of tu.edu.np and check whether the address is IPv4 or IPv6.
*
* theory:
* inetaddress
*       -- factory method
* networkadapter
* span
* serverlog
*
* */
public class Question1_CheckIPAddress {
    public static void main(String[] args) throws UnknownHostException {
//        Defining URL
        String url = "tu.edu.np";

//        Creating object of InetAddress and calling getByName to use url
        InetAddress ip1 = InetAddress.getByName(url);
        byte[] addr = ip1.getAddress();//getting address of url and converting it to byte array of url

        System.out.println("Checking ip addres 1pv4/ipv6");
//        Checking ip addres if it is IPV4(4 byte) or IPV6(16 byte) by using byte
        if(addr.length == 4){
            System.out.println("IPV4 address");
        }
        else {
            System.out.println("IPV6 address");
        }

    }
}
