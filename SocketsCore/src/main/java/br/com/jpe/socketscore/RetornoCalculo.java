/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

/**
 * Calc return data
 */
public class RetornoCalculo {

    private String produto;
    private String cliente;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public RetornoCalculo withCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public RetornoCalculo withProduto(String produto) {
        this.produto = produto;
        return this;
    }

    @Override
    public String toString() {
        return "RetornoCalculo{" + "produto=" + produto + ", cliente=" + cliente + '}';
    }

}
