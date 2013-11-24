package com.mateuszmidor;

import static org.easymock.EasyMock.expect;
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
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequestListenerTest {
	private static final String HTTP_REQUEST_STRING = "GET /path/to/file/index.html HTTP/1.0";
	private RequestListener listener;
	private ByteArrayOutputStream responseStorage;
	private IMocksControl mockControl;

	@Before
	public void setUp() throws Exception {
		listener = new RequestListener();
		mockControl = EasyMock.createControl();
	}

	@After
	public void tearDown() throws Exception {
		listener = null;
		mockControl = null;
	}

	private ServerSocket prepareSocketThrowingIOException() {
		ServerSocket serverSocket = mockControl.createMock(ServerSocket.class);
		try {

			expect(serverSocket.accept()).andThrow(new IOException());
		} catch (IOException e1) {
			fail();
		}
		mockControl.replay();
		return serverSocket;
	}

	private ServerSocket prepareSocketReturningRequest(String request) {
		ServerSocket serverSocket = null;
		try {
			responseStorage = new ByteArrayOutputStream();
			PrintStream outputStream = new PrintStream(responseStorage);

			InputStream inputStream = new ByteArrayInputStream(
					request.getBytes(Charset.defaultCharset()));

			Socket clientSocket = mockControl.createMock(Socket.class);
			expect(clientSocket.getOutputStream()).andReturn(outputStream);
			expect(clientSocket.getInputStream()).andReturn(inputStream);
			clientSocket.close();

			serverSocket = mockControl.createMock(ServerSocket.class);
			expect(serverSocket.accept()).andReturn(clientSocket);
			mockControl.replay();

		} catch (IOException e) {
			fail(e.getMessage());
		}
		return serverSocket;
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
		mockControl.verify();
	}

	@Test
	public void testListenerIOException() {
		// socket mock throwing IOException on accept()
		ServerSocket socket = prepareSocketThrowingIOException();

		// stubbed handler copies request to response
		RequestHandlerStub handler = new RequestHandlerStub("");

		// catch exception here
		listener.listen(socket, handler);
		mockControl.verify();
	}

}
