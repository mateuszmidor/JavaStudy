package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class HttpRequestParser {
	private HttpRequestParser() {
	}
	
	public static HttpRequest parse(BufferedReader in) throws IOException {
		String requestInitialLine = in.readLine();
		HttpRequest request = new HttpRequest();
		request.requestedResource = extractRequestedResource(requestInitialLine);
		return request;
	}

	private static String extractRequestedResource(String requestInitialLine) {
		// example:
		// GET /index.html HTTP/1.1
		return requestInitialLine.split(" ")[1];
	}

}
