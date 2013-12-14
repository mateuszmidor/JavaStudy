package mateuszmidor.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UdpDatagramsExample {
    class Server extends Thread {
        private int serverPort;

        public Server(int port, String name) {
            // set thread name and remember the port number
            super(name);
            serverPort = port;
        }

        @Override
        public void run() {
            // open the server socket
            try (DatagramSocket socket = new DatagramSocket(serverPort)) {
                System.out.printf("server is running at port %d%n", serverPort);
                System.out.println("waiting for a client...");

                // prepare buffer
                byte[] buff = new byte[256];
                DatagramPacket packet = new DatagramPacket(buff, buff.length);

                // wait for request
                socket.receive(packet);
                System.out.println("server: a request from client has arrived");
                System.out.println("server: sending response...");

                // prepare answer
                Date date = new Date();
                buff = date.toString().getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buff, buff.length, address, port);

                // send the answer
                socket.send(packet);

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("server stopped");
        }
    }

    class Client extends Thread {
        private int port;

        public Client(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            DatagramSocket socket;
            try {
                socket = new DatagramSocket();

                // prepare buffer
                byte[] sendBuff = new byte[256];

                // prepare datagram packet
                InetAddress address = InetAddress.getLocalHost();
                DatagramPacket packet = new DatagramPacket(sendBuff, sendBuff.length, address, port);

                // send request
                System.out.println("client: sending request");
                socket.send(packet);

                // prepare buffer
                byte[] recBuff = new byte[256];

                // and receive response
                packet = new DatagramPacket(recBuff, recBuff.length);
                socket.receive(packet);

                // print the response contents out
                System.out.format("client: response received: %s%n", new String(recBuff));

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public UdpDatagramsExample() {
        System.out.println("Udp packets example");

        // start the server
        new Server(4444, "Udp server").start();
        
        // start client - ask for time
        new Client(4444).start();
        
        System.out.println();
    }
}
