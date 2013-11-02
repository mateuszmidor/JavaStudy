package com.mateuszmidor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;

import junit.framework.Assert;

import org.junit.Test;

public class HttpSocketTest {

	@Test
	public void testOpen() {
		ServerSocket socket = null;
		try {
			socket = HttpSocket.open(8888);
		} catch (IOException e) {
			fail(e.getMessage());
		}

		Assert.assertNotNull(socket);
		Assert.assertEquals(true, socket.isBound());
		
		try {
			socket.close();
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}
