package com.mateuszmidor.debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mateuszmidor.HttpRequest;
import com.mateuszmidor.HttpRequestParser;
import com.mateuszmidor.RequestHandler;

public class DebugRequestHandler implements RequestHandler {

	private static final String HEADER_CONTENT_TYPE_TEXT_HTML = "Content-Type: text/html; charset=utf-8";
	private static final String HEADER_CONTENT_LENGTH = "Content-Length: %d";
	private static final String HEADER_SERVER_MIDORSERVER = "Server: MidorServer/0.1";
	private static final String HEADER_HTTP_200_OK = "HTTP/1.0 200 OK";
	private static final String HEADER_HTTP_404_NOT_FOUND = "HTTP/1.0 404 Not Found";
	private static final String HTML_OK_RESPONSE_WITH_CONTENT = "<html><body><h1>Welcome to MidorServer 0.1</h1> <h2>The requested resource is %s</h2></body></html>";
	private static final String HTML_NOT_FOUND_RESPONSE = "<html><body><h1>Welcome to MidorServer 0.1</h1> <h2>Error 404: Not found</h2></body></html>";

	private static final Logger log = LoggerFactory
			.getLogger(DebugRequestHandler.class);

	// parse the request from 'in' and respond with a message to 'out'
	public void handleRequest(BufferedReader in, PrintWriter out)
			throws IOException {

		// print the request contents to the console
		debugRequest(in);

		// parse the http request
		HttpRequest request = HttpRequestParser.parse(in);

		// DebugWriter writes to supplied 'out' and also to the console for
		// debugging purposes
		DebugWriter debugOut = new DebugWriter(out);

		System.out.println("-------Server responds");

		// silulate 404 not found
		if (request.requestedResource.equals("/404")) {
			reply404NotFound(debugOut, HTML_NOT_FOUND_RESPONSE);
		} 
		else {

			String output = String.format(HTML_OK_RESPONSE_WITH_CONTENT,
					request.requestedResource);
			reply200OK(debugOut, output);
		}
	}

	private void reply200OK(DebugWriter out, String content) {
		// the headers order is CRUCIAL
		// wrong order results in displaying a blank page
		out.println(HEADER_HTTP_200_OK);
		out.println(HEADER_SERVER_MIDORSERVER);
		out.format(HEADER_CONTENT_LENGTH, content.length());
		out.println(HEADER_CONTENT_TYPE_TEXT_HTML);

		out.println();
		out.println(content);
	}

	private void reply404NotFound(DebugWriter out, String content) {
		// the headers order is CRUCIAL
		// wrong order results in displaying a blank page
		out.println(HEADER_HTTP_404_NOT_FOUND);
		out.println(HEADER_SERVER_MIDORSERVER);
		out.format(HEADER_CONTENT_LENGTH, content.length());
		out.println(HEADER_CONTENT_TYPE_TEXT_HTML);

		out.println();
		out.println(content);
	}

	// simply print out all the http request information
	private void debugRequest(BufferedReader in) throws IOException {
		in.mark(99999);
		System.out.println("-------New request incoming");
		String s;
		try {
			while ((s = in.readLine()).length() > 1) {
				System.out.println(s);
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		in.reset();
	}

}
