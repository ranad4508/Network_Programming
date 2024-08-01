package lab_1;
/*
 * WAP to demonstrate SPAM checking.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Question8_SpamCheck {
    public static final String black_hole = "www.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        // Create a list of arguments
        List<String> argumentList = new ArrayList<>();
        argumentList.add("example.com");
        argumentList.add("192.168.1.1");
        argumentList.add("127.0.0.2");

        for (String arg : argumentList) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is known spammer");
            } else {
                System.out.println(arg + " appears legitimate");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();

            String query = black_hole;

            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}