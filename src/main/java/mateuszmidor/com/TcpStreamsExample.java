package mateuszmidor.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpStreamsExample {
    class Server extends Thread {

        // some contents for sending to clients, ending with end guard
        private static final String STRINGS = "Przygód\n" + "kilka\n" + "wróbla\n" + "Cwirka\n" + "END_GUARD";
        private int port;

        public Server(int port, String name) {
            super(name);
            this.port = port;
        }

        @Override
        public void run() {
            System.out.format("server is running at port %d%n", port);

            // prepare contents for sending to client
            String[] strings = STRINGS.split("\n");

            try {
                // start listening at port...
                ServerSocket serverSocket = new ServerSocket(port);

                // accept as many requests as many strings we have to send out
                for (String s : strings) {
                    
                    
                    // wait for client's request
                    System.out.println("waiting for a client...");
                    Socket clientSocket = serverSocket.accept();
                    
                    // client connected
                    System.out.println("server: new client connected. Sending response...");
                    
                    // send response to client
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
                    pw.println(s);

                    // disconnect from client
                    clientSocket.close();
                }
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    class Client extends Thread {
        private int port;

        public Client(int port, String name) {
            super(name);
            this.port = port;
        }

        @Override
        public void run() {
            System.out.println("client is running");

            // prepare string for receiving server's responses
            String response = null;
            try {

                // connect and fetch strings until end guard arrives
                do {
                    System.out.println("client: connecting to server...");

                    // wait a while - why to hurry :)
                    Thread.sleep(1500);

                    // connect to server at port...
                    Socket socket = new Socket("localhost", port);

                    // read servers response
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    response = br.readLine();
                    System.out.println("client: response received : " + response);
                    System.out.println();
                    // disconnect from server
                    socket.close();

                } while (!response.equals("END_GUARD"));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public TcpStreamsExample() {
        System.out.println("Tcp streams example:");

        Thread server = new Server(3333, "Server");
        Thread client = new Client(3333, "Client");

        try {
            server.start();
            client.start();
            server.join();
            client.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
