package com.mateuszmidor;

import java.io.IOException;
import java.net.ServerSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mateuszmidor.debug.DebugRequestHandler;

/**
 * Simple HTTP server, based on http://www.jmarshall.com/easy/http/
 * 
 */
public class App {
	public static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	private App() {
	}

	public static void main(String[] args) throws IOException {
		RequestListener listener = new RequestListener();
		RequestHandler handler = new DebugRequestHandler();
		ServerSocket socket = HttpSocket.open(8080);

		while (true) {
			LOGGER.debug("-------Server is waiting for a request at localhost:8080");
			listener.listen(socket, handler);
		}
	}

}