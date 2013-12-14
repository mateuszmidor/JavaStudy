package mateuszmidor.com;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;

class MyCookiePolicy implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        // print out incoming cookie
        System.out.printf("New cookie:%n");
        System.out.println(uri.toString());
        System.out.println(cookie.toString());
        return CookiePolicy.ACCEPT_ORIGINAL_SERVER.shouldAccept(uri, cookie);
    }

}

public class CookiesExample {
    private static final String URL_ADDRESS = "http://alexba.eu/";

    public CookiesExample() {
        System.out.println("HTTP cookie example");

        // default cookie handler implementation
        CookieManager cm = new CookieManager();

        // set custom cookie policy printing incoming cookies
        cm.setCookiePolicy(new MyCookiePolicy());

        // URL will use CookieHandler for cookies
        // by default, there is no any CookieHandler specified
        CookieHandler.setDefault(cm);

        URL url;
        try {
            // create url
            url = new URL(URL_ADDRESS);

            // send GET request to server
            InputStream is = url.openStream();

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
