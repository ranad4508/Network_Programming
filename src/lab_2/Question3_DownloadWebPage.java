package lab_2;
/*
* Write a program to download a web page of a given web address
* [ex: www.oic.edu.np]
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Question3_DownloadWebPage {
        public static void main(String[] args) {
            try {
                // Specify the URL of the web page you want to download
                String urlString = "https://www.oic.edu.np";

                // Create a URL object
                URL url = new URL(urlString);

                // Open a connection to the URL
                URLConnection conn = url.openConnection();

                // Create a BufferedReader to read the content of the web page
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                // Read each line of the web page and print it
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Close the BufferedReader
                reader.close();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
