/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

/**
 * Calc data
 */
public class DadosParaCalculo {

    private long codigoCliente;
    private long codigoProduto;

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public void setCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public DadosParaCalculo withCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
        return this;
    }

    public DadosParaCalculo withCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
        return this;
    }

    @Override
    public String toString() {
        return "DadosParaCalculo{" + "codigoCliente=" + codigoCliente + ", codigoProduto=" + codigoProduto + '}';
    }

}
