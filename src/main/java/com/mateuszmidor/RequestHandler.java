package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DebugWriter {
	private PrintWriter writer;
	public DebugWriter(PrintWriter raw_out) {
		writer = raw_out;
	}

	private void debug(String s) {
		System.out.println(s);
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
	private static final String HTTP_200_OK = "HTTP/1.0 200 OK";
	private static final String HTTP_404_NOT_FOUND = "HTTP/1.0 404 Not Found";
	
	private static final Logger log = LoggerFactory
			.getLogger(RequestHandler.class);

	public void handleRequest(BufferedReader in, PrintWriter raw_out) {
		String HTML = "Serwer mowi: dizen dobry!";
//		String HTML = "<html><body><h1>Happy New Millennium!</h1></body></html>";

		debugRequest(in);
		
		System.out.println("--------Server odpowiada");
		DebugWriter out = new DebugWriter(raw_out);
		reply200WithContent(out, HTML);
		//reply404NotFound(out);
	}

	private void reply200WithContent(DebugWriter out, String content) {
		// kolejność nagłówków MA ZNACZENIE!!!
		// zła kolejność zaskutkuje wyświetleniem pustej strony
		String currentGmtTime = getCurrentGmtDateTime();
		out.println(HTTP_200_OK);
		out.println("Server: MidorServer/0.1");
		out.println("Accept-Ranges: bytes");
		out.format("Content-Length: %d", content.length());
		out.println("Connection: close");
		out.println("Content-Type: text/html");
		
		out.println();
		out.println(content);
			
	}

	private String getCurrentGmtDateTime() {
		return DateFormat.getInstance().format(new Date());
	}

	private void reply404NotFound(DebugWriter out) {
		out.println(HTTP_404_NOT_FOUND);
		out.println();
	}

	private void debugRequest(BufferedReader in) {
		System.out.println("--------Nowy request");
		String s;
		try {
			while ((s = in.readLine()).length() > 1) {
				System.out.println(s);
				System.out.flush();
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

}
