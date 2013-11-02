package com.mateuszmidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.DateFormat;
import java.util.Date;

/**
 * SImple HTTP server, based on http://www.jmarshall.com/easy/http/
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	RequestListener listener = new RequestListener();
    	RequestHandler handler = new RequestHandler();
    	ServerSocket socket = HttpSocket.open(8080); 
    	
   
    	while (true) {
    		System.out.println( "------ Server czeka na zapytaine! " + DateFormat.getInstance().format(new Date()) );
    		listener.listen(socket, handler);
    	}
    }

}
