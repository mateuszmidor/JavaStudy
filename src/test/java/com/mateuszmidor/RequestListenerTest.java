package com.mateuszmidor;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequestListenerTest {
	private static final String HTTP_REQUEST_STRING = "GET /path/to/file/index.html HTTP/1.0";
	private RequestListener listener;
	private ByteArrayOutputStream responseStorage;

	@Before
	public void setUp() throws Exception {
		listener = new RequestListener();
	}

	private ServerSocket prepareSocketReturningRequest(String request) {
		ServerSocket serverSocket = null;
		try {
			responseStorage = new ByteArrayOutputStream();
			PrintStream outputStream = new PrintStream(responseStorage);

			InputStream inputStream = new ByteArrayInputStream(
					request.getBytes(Charset.defaultCharset()));

			Socket clientSocket = createNiceMock(Socket.class);
			expect(clientSocket.getInputStream()).andReturn(inputStream);
			expect(clientSocket.getOutputStream()).andReturn(outputStream);
			replay(clientSocket);

			serverSocket = createNiceMock(ServerSocket.class);
			expect(serverSocket.accept()).andReturn(clientSocket);
			replay(serverSocket);

		} catch (IOException e) {
			fail(e.getMessage());
		}
		return serverSocket;
	}

	@After
	public void tearDown() throws Exception {
		listener = null;
	}

	@Test
	public void testListener() {
		// socket mock simulates incoming request
		ServerSocket socket = prepareSocketReturningRequest(HTTP_REQUEST_STRING);

		// stubbed handler copies request to response
		RequestHandlerStub handler = new RequestHandlerStub(HTTP_REQUEST_STRING);

		listener.listen(socket, handler);

		// see if everything went ok
		Assert.assertEquals(HTTP_REQUEST_STRING, responseStorage.toString());
		EasyMock.verify(socket);
	}

}
