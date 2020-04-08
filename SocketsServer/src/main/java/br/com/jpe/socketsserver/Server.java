/*
 * SocketsServer
 */
package br.com.jpe.socketsserver;

import br.com.jpe.socketscore.CommunicationThread;
import br.com.jpe.socketscore.DadosParaCalculo;
import br.com.jpe.socketscore.RetornoCalculo;
import br.com.jpe.socketscore.SocketInputCallback;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.stream.Stream;

/**
 * Server
 */
public class Server {

    private static final int kPort = 8190;
    private ServerSocket serverSocket;
    private boolean running = false;

    private static final Gson gson = new Gson();

    public void listen(final SocketInputCallback callback) throws IOException {
        if (serverSocket != null) {
            throw new RuntimeException("Server socket already listening!");
        }
        System.out.printf("Listening to port %d...\n", kPort);
        serverSocket = new ServerSocket(kPort);
        running = true;
        while (true) {
            if (running) {
                CommunicationThread.start(serverSocket.accept(), (iStream, oStream) -> {
                    // Reads client request
                    StringBuilder sb = new StringBuilder();
                    try (Stream<String> lines = iStream.lines()) {
                        lines.forEach(line -> sb.append(line));
                    }
                    // Convert to calc data
                    DadosParaCalculo dados = gson.fromJson(sb.toString(), DadosParaCalculo.class);
                    System.out.println(dados.toString());

                    // Exec callback
                    RetornoCalculo retornoCalculo = callback.executa(dados);

                    // Send response to client
                    oStream.write(gson.toJson(retornoCalculo));
                    oStream.flush();
                });

            }
        }
    }

}
