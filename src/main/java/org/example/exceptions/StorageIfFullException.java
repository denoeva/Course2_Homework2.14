package org.example.exceptions;

public class StorageIfFullException extends RuntimeException {
    public StorageIfFullException() {
    }

    public StorageIfFullException(String message) {
        super(message);
    }

    public StorageIfFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageIfFullException(Throwable cause) {
        super(cause);
    }

    public StorageIfFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
