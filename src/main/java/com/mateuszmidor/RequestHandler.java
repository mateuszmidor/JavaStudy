package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DebugWriter {
	private PrintWriter writer;
	public DebugWriter(PrintWriter raw_out) {
		writer = raw_out;
	}

	private void debug(String s) {
		System.err.println(s);
		System.err.flush();
	}
	
	
	public PrintWriter format(String format, Object... args) {
		debug(String.format(format, args));
		return writer.format(format, args);
	}

	
	public void print(String s) {
		debug(s);
		writer.print(s);
	}

	public void println() {
		debug("");
		writer.println();
	}


	public void println(String x) {
		debug(x);
		writer.println(x);
	}

	public void flush() {
		writer.flush();
	}

	
}
public class RequestHandler {
	private static final String HTTP_404_NOT_FOUND = "HTTP/1.0 404 Not Found";
	
	private static final Logger log = LoggerFactory
			.getLogger(RequestHandler.class);

	public void handleRequest(BufferedReader in, PrintWriter raw_out) {

		debugRequest(in);
		DebugWriter out = new DebugWriter(raw_out);
		
		reply404NotFound(out);
		// PrintStream out = System.out;
//		String HTML = "<html> <body> <h1>Happy New Millennium!</h1></body></html>";
//		out.println("HTTP/1.0 200 OK");
//		out.println("Date: " + new Date().toGMTString());
//		out.println("Content-Type: text/html");
//		out.format("Content-Length: %d", HTML.length() + 1);
//		out.println();
//		out.println(HTML);
		out.println();
		out.flush();
	}

	private void reply404NotFound(DebugWriter out) {
		out.println(HTTP_404_NOT_FOUND);
	}

	private void debugRequest(BufferedReader in) {
		String s;
		try {
			while ((s = in.readLine()).length() > 1) {
				//log.info(s);
				System.out.println(s);
				System.out.flush();
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
