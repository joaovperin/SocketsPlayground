/*
 * SocketsServer
 */
package br.com.jpe.socketsserver;

import br.com.jpe.socketscore.RetornoCalculo;
import java.io.IOException;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listen(dados -> new RetornoCalculo()
                .withCliente("DUMMY_CLIENT" + dados.getCodigoCliente())
                .withProduto("DUMMY_PRODUCT" + dados.getCodigoProduto()));
    }

}
