package lab_3;
/*
 * write a java program to implement a cookiepolicy. your cookie policy should accept only
 * the incoming cookies from a domains .edu.np and block all others
 * */

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2_CookiePolicy {
    public static void main(String[] args) {
        // Create a custom CookiePolicy that blocks cookies from .edu.np domains
        CookiePolicy customPolicy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                // Get the host from the URI
                String host = uri.getHost();

                // Block cookies from .edu.np domains
                if (host != null && host.endsWith(".edu.np")) {
                    return false;
                }

                // Allow all other cookies
                return true;
            }
        };

        // Create a CookieManager with the custom policy
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(customPolicy);
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Define URIs to associate with the cookies
        URI uriEduNp = URI.create("https://tu.edu.np/");
        URI uriCom = URI.create("https://example.com/");

        // Create new cookies
        HttpCookie cookieEduNp = new HttpCookie("session", "1234");
        HttpCookie cookieCom = new HttpCookie("session", "dinesh");

        // Map to store the cookies and their acceptance status
        Map<HttpCookie, Boolean> cookieMap = new HashMap<>();

        // Attempt to add cookies to the cookie store and record acceptance status
        boolean isEduNpAccepted = customPolicy.shouldAccept(uriEduNp, cookieEduNp);
        cookieMap.put(cookieEduNp, isEduNpAccepted);
        if (isEduNpAccepted) {
            cookieStore.add(uriEduNp, cookieEduNp);
        }


        boolean isComAccepted = customPolicy.shouldAccept(uriCom, cookieCom);
        cookieMap.put(cookieCom, isComAccepted);
        if (isComAccepted) {
            cookieStore.add(uriCom, cookieCom);
        }

        // Display the acceptance status of the cookies
        for (Map.Entry<HttpCookie, Boolean> entry : cookieMap.entrySet()) {
            HttpCookie cookie = entry.getKey();
            Boolean isAccepted = entry.getValue();
            System.out.println("Cookie: " + cookie + " - Accepted: " + isAccepted);
        }

//        // Retrieve cookies from the cookie store for .edu.np domain
//        List<HttpCookie> cookiesEduNp = cookieStore.get(uriEduNp);
//        System.out.println("Cookies for edu.np: ");
//        for (HttpCookie cookie : cookiesEduNp) {
//            System.out.println(" - " + cookie);
//        }
//
//        // Retrieve cookies from the cookie store for .com domain
//        List<HttpCookie> cookiesCom = cookieStore.get(uriCom);
//        System.out.println("Cookies for " + uriCom + ":");
//        for (HttpCookie cookie : cookiesCom) {
//            System.out.println(" - " + cookie);
//        }
    }
}
