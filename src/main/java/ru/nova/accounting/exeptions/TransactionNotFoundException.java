package ru.nova.accounting.exeptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
