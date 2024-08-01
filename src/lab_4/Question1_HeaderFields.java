package lab_4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/*
 * 1. Read all the header fields from the Http response
 * 2. Wap to find out the following header fields:
 *       -ContentType
 *       -Content length
 *       -last modified
 *       -access date
 *       -expiry date
 * 3. wap to display the permission of the user
 * 4. wap to guess the MIME type of the following:
 *       -A URL
 *       -A locally Stored pdf image, text files
 * */
public class Question1_HeaderFields {
    public static void main(String[] args) {
        //loop and display
        try {
            URL url = new URL("https://deerwalk.edu.np/");
            URLConnection con = url.openConnection();
            //Method 1
            Map<String, List<String>> contents = con.getHeaderFields();
            for (String key : contents.keySet()) {
                System.out.println(key + " " + contents.get(key));
            }

            //Method 2
//            for(int i = 0;;i++){
//                String value = con.getHeaderField(i);
//                if(value == null)
//                    break;
//                System.out.println(con.getHeaderFieldKey(i)+" value "+value);
//            }
        } catch (MalformedURLException e) {
            System.out.println("Error: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
