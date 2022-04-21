package com.chat.exception;

public class CustomAuthorizationFilterException extends Exception {

    public CustomAuthorizationFilterException() {
        super("Authorization invalide, veuillez réessayez");
    }

    public CustomAuthorizationFilterException(String message, Throwable exception) {
        super(message, exception);
    }

    public CustomAuthorizationFilterException(String message) {
        super(message);
    }
}
