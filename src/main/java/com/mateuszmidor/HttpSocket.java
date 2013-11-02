package com.mateuszmidor;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpSocket {

	public static ServerSocket open(int i) throws IOException {
		return new ServerSocket(8080);
	}

}
