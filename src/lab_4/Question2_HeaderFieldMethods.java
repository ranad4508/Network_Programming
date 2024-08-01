package lab_4;
/*
* WAP to display the content type, content length, date of access,
*  last modified date and expiry date of the url oic.edu.np
* */

import java.net.URL;
import java.net.URLConnection;

public class Question2_HeaderFieldMethods {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.oic.edu.np/");
            URLConnection con = url.openConnection();
            System.out.println("Content type: "+con.getContentType());
            System.out.println("Content length: "+con.getContentLength());
            System.out.println("Access Date: "+con.getDate());
            System.out.println("Last modified: "+con.getLastModified());
            System.out.println("Expiry date: "+con.getExpiration());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
