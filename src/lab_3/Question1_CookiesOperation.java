package lab_3;
/*
*1. write a java program to store, retrive, delete the cookies in default cookie store
*2. write a java program to implement a cookiepolicy. your cookie policy should accept only
* the incoming cookies from a domains .edu.np and block all others
* */

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class Question1_CookiesOperation {
    public static void main(String[] args) {
        // Create a default CookieManager
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Define the URI to associate with the cookies
        URI uri = URI.create("http://www.oic.edu.np");

        // Create a new cookie
        HttpCookie cookie1 = new HttpCookie("username", "dinesh");

        // Add the cookies to the cookie store
        cookieStore.add(uri, cookie1);

        // Retrieve cookies from the cookie store
        List<HttpCookie> cookies = cookieStore.get(uri);
        System.out.println("Cookies for " + uri + ":");
        for (HttpCookie cookie : cookies) {
            System.out.println(" - " + cookie);
        }

        // Delete a specific cookie
        cookieStore.remove(uri, cookie1);

        // Verify the cookies after deletion
        cookies = cookieStore.get(uri);
        System.out.println("Cookies for " + uri + " after deletion:");
        for (HttpCookie cookie : cookies) {
            System.out.println(" - " + cookie);
        }
    }
}
