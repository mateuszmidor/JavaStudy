package mateuszmidor.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class PostMethodeExample {
    private static final String URL_ADDRESS = "http://www.mateuszmidor.com/media/";

    public PostMethodeExample() {
        System.out.println("HTTP POST method example:");
        System.out.println(URL_ADDRESS);

        URL url;
        try {
            // create url
            url = new URL(URL_ADDRESS);

            // open connection
            URLConnection conn = url.openConnection();

            // tell the connection to use POST instead of GET
            conn.setDoOutput(true);

            // write some data to stream
            OutputStream os = conn.getOutputStream();
            writeToStream("Some message to contact form.", os);
            os.close();

            // send the data with HTTP POST  
            InputStream is = conn.getInputStream();
            
            // read server response
            printStream(is);
            
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }

    private static void writeToStream(String s, OutputStream os) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
        pw.println(s);
    }

    private static void printStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
