package mateuszmidor.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class GetMethodExample {
    private static final String URL_ADDRESS = "http://www.mateuszmidor.com/media/";

    public GetMethodExample() {
        System.out.println("HTTP GET method example:");
        System.out.println(URL_ADDRESS);

        URL url;
        try {
            // create url
            url = new URL(URL_ADDRESS);

            // send GET request to server
            InputStream is = url.openStream();

            // read what the server sent back
            printStream(is);

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }

    private static void printStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
