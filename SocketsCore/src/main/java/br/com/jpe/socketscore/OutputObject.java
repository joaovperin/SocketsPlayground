/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

/**
 * Output object for communications
 */
public class OutputObject {

    private String code;
    private String message;

    public OutputObject withCode(String code) {
        this.code = code;
        return this;
    }

    public OutputObject withMessage(String message) {
        this.message = message;
        return this;
    }

    public String serialize() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "OutputObject{" + "code=" + code + ", message=" + message + '}';
    }

}
