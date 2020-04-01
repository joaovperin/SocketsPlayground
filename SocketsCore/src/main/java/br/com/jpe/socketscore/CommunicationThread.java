/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Communication Thread
 */
public class CommunicationThread {

    private final Socket socket;
    private final CommMethod commMethod;
    private Thread _thread;

    private CommunicationThread(Socket socket, CommMethod commMethod) {
        this.socket = socket;
        this.commMethod = commMethod;
    }

    public static void start(Socket socket, CommMethod commMethod) {
        new CommunicationThread(socket, commMethod).run();
    }

    public void run() {
        _thread = new Thread(() -> {
            // Check socket's connected
            if (socket == null || !socket.isConnected()) {
                throw new RuntimeException("Socket is not connected");
            }
            // Open streams
            try {
                commMethod.doCommunication(socket.getInputStream(), socket.getOutputStream());
            } catch (IOException ex) {
                System.err.println("Failed to open Streams!");
                ex.printStackTrace(System.err);
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(CommunicationThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        _thread.start();
    }

}
