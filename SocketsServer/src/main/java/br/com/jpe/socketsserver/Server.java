/*
 * SocketsServer
 */
package br.com.jpe.socketsserver;

import br.com.jpe.socketscore.CommunicationThread;
import br.com.jpe.socketscore.InputObject;
import br.com.jpe.socketscore.OutputObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.util.stream.Stream;

/**
 * Server
 */
public class Server {

    private static final int kPort = 8190;
    private ServerSocket serverSocket;
    private boolean running = false;

    public void listen() throws IOException {
        if (serverSocket != null) {
            throw new RuntimeException("Server socket already listening!");
        }
        System.out.println("Listening...");
        serverSocket = new ServerSocket(kPort);
        running = true;
        while (true) {
            if (running) {
                CommunicationThread.start(serverSocket.accept(), (iStream, oStream) -> {
                    // Open streams
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(iStream))) {
                        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(oStream))) {
                            // Reads client request
                            StringBuilder sb = new StringBuilder();
                            try (Stream<String> lines = in.lines()) {
                                lines.forEach(line -> sb.append(line));
                            }
                            System.out.println(new InputObject().withMessage(sb.toString()));
                            // Send response to client
                            out.write(new OutputObject().withMessage("[RES] Hello, from server!").serialize());
                            out.flush();
                        }
                    }

                });

            }
        }
    }

}