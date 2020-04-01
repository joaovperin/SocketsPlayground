/*
 * SocketsCore
 */
package br.com.jpe.socketscore;

/**
 * Input object for communications
 */
public class InputObject {

    private String code;
    private String message;

    public InputObject withCode(String code) {
        this.code = code;
        return this;
    }

    public InputObject withMessage(String message) {
        this.message = message;
        return this;
    }

    public String serialize() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "InputObject{" + "code=" + code + ", message=" + message + '}';
    }

}
