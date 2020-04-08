/*
 * SocketClient
 */
package br.com.jpe.socketclient;

import br.com.jpe.socketscore.CommunicationThread;
import br.com.jpe.socketscore.DadosParaCalculo;
import br.com.jpe.socketscore.RetornoCalculo;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.stream.Stream;

/**
 * Client class
 */
public class Client {

    private static final Gson gson = new Gson();

    private static final int kPort = 8190;

    public void startCommunication() throws IOException {
        startCommunication("localhost");
    }

    public void startCommunication(String host) throws IOException {
        final Socket socket = connect(host, kPort);
        CommunicationThread.start(socket, (iStream, oStream) -> {
            String dadosCalculo = gson.toJson(new DadosParaCalculo()
                    .withCodigoCliente(3)
                    .withCodigoProduto(8700));

            // Send a message to the server
            oStream.write(dadosCalculo);
            oStream.flush();
            socket.shutdownOutput();
            // Receive's server response
            StringBuilder sb = new StringBuilder();
            try (Stream<String> lines = iStream.lines()) {
                lines.forEach(line -> sb.append(line));
            }

            RetornoCalculo retornoCalculo = gson.fromJson(sb.toString(), RetornoCalculo.class);
            System.out.println(retornoCalculo);
        });
    }

    private Socket connect(String host, int port) throws IOException {
        try {
            System.out.printf("Connecting on host %s:%d...", host, port);
            InetAddress.getByName(host);
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(5000);
            return socket;
        } catch (UnknownHostException ex) {
            throw new IOException("Host not found", ex);
        }
    }

}
