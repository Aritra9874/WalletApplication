package com.example.wallet.exception;

public class NoBalanceException extends Exception {
    public NoBalanceException(String message) {
        super(message);
    }
}
