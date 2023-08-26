package com.privat.privatbankstack.exceptions;

public class OperationError extends RuntimeException {
    public OperationError(Errors message) {
        super(message.getErrorMessage());
    }

    public OperationError(String message) {
        super(message);
    }
}
