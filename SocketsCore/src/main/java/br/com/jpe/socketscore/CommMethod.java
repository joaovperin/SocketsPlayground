/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Communication method
 */
@FunctionalInterface
public interface CommMethod {

    public void doCommunication(BufferedReader iStream, BufferedWriter oStream) throws IOException;

}
