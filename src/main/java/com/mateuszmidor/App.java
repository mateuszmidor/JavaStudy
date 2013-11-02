package com.mateuszmidor;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * SImple HTTP server, based on http://www.jmarshall.com/easy/http/
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	RequestListener listener = new RequestListener();
    	RequestHandler handler = new DebugRequestHandler();
    	ServerSocket socket = HttpSocket.open(8080); 
    	
    	while (true) {
    		System.out.println( "-------Server's waiting for a request");
    		listener.listen(socket, handler);
    	}
    }

}
