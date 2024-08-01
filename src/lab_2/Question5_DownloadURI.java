package lab_2;
/*
* Write a program to download an object  from the uri
* [https://www.oic.edu.np/wp-content/uploads/2020/05/logo.png]
* */

import java.io.*;
import java.net.URI;
import java.net.URL;

public class Question5_DownloadURI {
    public static void main(String[] args) {
        String uriString = "https://www.oic.edu.np/wp-content/uploads/2020/05/logo.png";
        String savePath = System.getProperty("java.io.tmpdir") + File.separator + "logo.png";

        try {
            // Create a URI object
            URI uri = new URI(uriString);

            // Convert URI to URL
            URL url = uri.toURL();

            // Open an InputStream from the URL
            try (InputStream in = new BufferedInputStream(url.openStream());
                 FileOutputStream out = new FileOutputStream(savePath)) {

                byte[] buffer = new byte[1024];
                int bytesRead;

                // Read data in chunks and write to the output file
                while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("File downloaded successfully to " + savePath);

            } catch (IOException e) {
                System.out.println("An error occurred during file download: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
