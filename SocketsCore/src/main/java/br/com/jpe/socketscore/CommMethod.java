/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Communication method
 */
@FunctionalInterface
public interface CommMethod {

    public void doCommunication(InputStream iStream, OutputStream oStream) throws IOException;

}
