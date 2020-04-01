/*
 * SocketsServer
 */
package br.com.jpe.socketsserver;

import java.io.IOException;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listen();
    }

}
