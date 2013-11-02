package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestListener {
	public static final Logger logger = LoggerFactory.getLogger(RequestListener.class);
	
	public void listen(ServerSocket socket, RequestHandler handler) {
		try {
			Socket clientSocket = socket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			handler.handleRequest(in, out);
			
			clientSocket.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
