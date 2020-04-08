/*
 * SocketClient
 */
package br.com.jpe.socketclient;

import java.io.IOException;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        if (args.length > 0 && args[0] != null) {
            client.startCommunication(args[0]);
        } else {
            client.startCommunication();
        }
    }

}
