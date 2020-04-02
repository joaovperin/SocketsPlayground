/*
 * SocketClient
 */
package br.com.jpe.socketclient;

import br.com.jpe.socketscore.CommunicationThread;
import br.com.jpe.socketscore.InputObject;
import br.com.jpe.socketscore.OutputObject;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.stream.Stream;

/**
 * Client class
 */
public class Client {

    private static final int kPort = 8190;

    public void startCommunication() throws IOException {
        final Socket socket = connect("localhost", kPort);
        CommunicationThread.start(socket, (iStream, oStream) -> {
            // Send a message to the server
            oStream.write(new InputObject().withMessage("[REQ]Hello, guy!").serialize());
            oStream.flush();
            socket.shutdownOutput();
            // Receive's server response
            StringBuilder sb = new StringBuilder();
            try (Stream<String> lines = iStream.lines()) {
                lines.forEach(line -> sb.append(line));
            }
            System.out.println(new OutputObject().withMessage(sb.toString()));
        });
    }

    private Socket connect(String host, int port) throws IOException {
        try {
            InetAddress.getByName(host);
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(2000);
            return socket;
        } catch (UnknownHostException ex) {
            throw new IOException("Host not found", ex);
        }
    }

}
