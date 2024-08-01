package lab_4;

import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

public class Question4_MIMEType {
    public static void main(String[] args) {
        // Online resources
        String urlPage = "https://www.oic.edu.np/";
        String urlPng = "https://www.oic.edu.np/wp-content/uploads/2020/05/logo.png";

        // Local files
        String urlPdf = "C:\\Users\\Dinesh\\Downloads\\sentiment analysis-3.pdf";
        String urlText = "C:\\Users\\Dinesh\\Downloads\\abstract.txt";

        // Get MIME type of online resources
        printMimeType(urlPage);
        printMimeType(urlPng);

        // Get MIME type of local files
        printMimeType(urlPdf);
        printMimeType(urlText);
    }

    public static void printMimeType(String urlString) {
        try {
            String mimeType = URLConnection.guessContentTypeFromName(urlString);
            System.out.println("The MIME type of " + urlString + " is: " + mimeType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
