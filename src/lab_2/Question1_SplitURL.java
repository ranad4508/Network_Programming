package lab_2;
/*
*  Write a program that splits the parts of a URL
* [ex: https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-]
*
* theory
* URL
* URI
* Encode Decoder
* */

import java.net.MalformedURLException;
import java.net.URL;

public class Question1_SplitURL {
    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-");
        System.out.println("The protocol: "+url1.getProtocol());
        System.out.println("The host: "+url1.getHost());
        System.out.println("The port number: "+url1.getPort());
        System.out.println("The authority: "+url1.getAuthority());
        System.out.println("The file name: "+url1.getFile());
        System.out.println("The query: "+url1.getQuery());
        System.out.println("The ref: "+url1.getRef());
        System.out.println("The path: "+url1.getPath());
        System.out.println("The userinfo: "+url1.getUserInfo());

    }
}
