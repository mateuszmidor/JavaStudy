package com.mateuszmidor;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import junit.framework.Assert;

import org.junit.Test;

public class HttpRequestParserTest {

	@Test
	public void test() {
		// resource here is '/index.html'
		String requestLine = "GET /index.html HTTP/1.1";
		BufferedReader reader = getBufferReaderFromString(requestLine);

		HttpRequest request = null;
		try {
			request = HttpRequestParser.parse(reader);
		} catch (IOException e) {
			fail(e.getMessage());
		}

		Assert.assertEquals("/index.html", request.requestedResource);
	}

	private BufferedReader getBufferReaderFromString(String requestLine) {
		return new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(requestLine.getBytes(Charset
						.defaultCharset()))));
	}
}
