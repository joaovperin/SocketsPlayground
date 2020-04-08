/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

/**
 * Callback for SocketInput
 */
@FunctionalInterface
public interface SocketInputCallback {

    public RetornoCalculo executa(DadosParaCalculo dados);

}
