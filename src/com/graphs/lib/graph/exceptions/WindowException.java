package com.graphs.lib.graph.exceptions;

public class WindowException extends RuntimeException {

    private String message;

    public WindowException() {
        message = "Window error";
    }

    public WindowException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
