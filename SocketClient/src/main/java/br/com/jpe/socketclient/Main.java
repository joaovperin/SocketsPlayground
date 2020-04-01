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
        client.startCommunication();
    }

}
