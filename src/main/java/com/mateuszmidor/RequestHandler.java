package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface RequestHandler {

	// parse the request and respond with a message
	void handleRequest(BufferedReader in, PrintWriter out) throws IOException;
}