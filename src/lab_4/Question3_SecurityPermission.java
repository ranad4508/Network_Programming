package lab_4;

import java.net.URL;
import java.net.URLConnection;

public class Question3_SecurityPermission {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.tu.edu.np/");
            URLConnection con = url.openConnection();
            System.out.println("The permission for the domain "+url+ " are "+ con.getPermission());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
