package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class RequestHandlerStub extends DebugRequestHandler {
	private String response;

	public RequestHandlerStub(String response) {
		this.response = response;
	}

	@Override
	public void handleRequest(BufferedReader in, PrintWriter out) {
		out.print(response);
		out.flush();
	}
}
