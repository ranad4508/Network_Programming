package lab_1;
import java.io.IOException;
import java.net.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/*
* WAP to check if a host is reachable or not.
* */
public class Question7_CheckHost {
    public static void main(String[] args) throws UnknownHostException {
        String host = "www.oic.edu.np";
        int timeOut = 5000;

        InetAddress ip1 = InetAddress.getByName(host);
        System.out.println("Checking host: " + host);

        try {
            if (ip1.isReachable(timeOut)) {
                System.out.println("Host is reachable.") ;
            } else {
                System.out.println("Host is not reachable.");
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
