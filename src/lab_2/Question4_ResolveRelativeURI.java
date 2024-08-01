package lab_2;
/*
Write a program for resolving relative URI
[www.oic.edu.np/contact-us] [gallery]
* */

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Question4_ResolveRelativeURI {
    public static void main(String[] args) throws URISyntaxException {
//        base uri
        String uribase = "www.oic.edu.np/contact-us/";
//        relative uri
        String uriRelative = "gallery";
        URI uriBase = new URI(uribase);
        URI uri = new URI(uriRelative);

        System.out.println("URI Relative: "+uri.toString());
//        resolving the relative uri
        URI uriresolve = uriBase.resolve(uri);
        System.out.println("URI Resolved: "+uriresolve.toString());

    }

}
