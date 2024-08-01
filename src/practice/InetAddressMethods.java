package practice;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMethods {
    public static void main(String[] args) throws UnknownHostException {
        String url = "www.google.com";

        InetAddress address = InetAddress.getByName(url);
        System.out.println("Address getByName: "+address);
        String canAddress = address.getCanonicalHostName();
        System.out.println("Address getCanonicalHostName: "+canAddress);

        byte[] getaddress = address.getAddress();
        System.out.println("getAddress");
        for(byte b: getaddress){
            System.out.print((b & 0xFF) + ".");
        }

        String hostname = address.getHostAddress();
        System.out.println("\nhostname getHostAddress: "+hostname);


    }

}
